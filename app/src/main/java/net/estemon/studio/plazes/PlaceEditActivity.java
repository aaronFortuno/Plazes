package net.estemon.studio.plazes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PlaceEditActivity extends AppCompatActivity {

    private long id;
    private Place place;

    private EditText name;
    private Spinner type;
    private EditText address;
    private EditText phone;
    private EditText url;
    private EditText notes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_edit);

        Bundle extras = getIntent().getExtras();

        assert extras != null;
        id = extras.getLong("id", -1);
        place = MainActivity.places.place((int) id);

        Toolbar toolbar = findViewById(R.id.place_edit_toolbar);
        setSupportActionBar(toolbar);

        // Initialize elements and place its values
        name = findViewById(R.id.in_text_name);
        name.setText(place.getName());

        type = findViewById(R.id.in_type_spinner);
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                PlaceType.getNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);
        type.setSelection(place.getType().ordinal());

        address = findViewById(R.id.in_text_address);
        address.setText(place.getAddress());

        phone = findViewById(R.id.in_text_phone);
        phone.setText(Integer.toString(place.getPhone()));

        url = findViewById(R.id.in_text_url);
        url.setText(place.getUrl());

        notes = findViewById(R.id.in_text_notes);
        notes.setText(place.getNotes());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("PlaceEditActivity.onCreateOptionsMenu", "Creating menu");
        getMenuInflater().inflate(R.menu.place_edit_menu, menu);
        Log.i("PlaceEditActivity.onCreateOptionsMenu", "Menu created");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.edit_menu_cancel) {
            finish();
        } else if (item.getItemId() == R.id.edit_menu_save) {
            place.setName(name.getText().toString());
            place.setType(PlaceType.values()[type.getSelectedItemPosition()]);
            place.setAddress(address.getText().toString());
            place.setPhone(Integer.parseInt(phone.getText().toString()));
            place.setUrl(url.getText().toString());
            place.setNotes(notes.getText().toString());
            MainActivity.places.updatePlace((int) id, place);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
