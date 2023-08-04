package net.estemon.studio.plazes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

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

}
