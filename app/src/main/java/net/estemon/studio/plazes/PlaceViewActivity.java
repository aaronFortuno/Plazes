package net.estemon.studio.plazes;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.DateFormat;
import java.util.Date;

public class PlaceViewActivity extends AppCompatActivity {

    private long id;
    private Place place;
    final static int EDIT_RESULT = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_view);

        Bundle extras = getIntent().getExtras();

        assert extras != null;
        id = extras.getLong("id", -1);

        updateViews();
    }

    public void updateViews() {
        place = MainActivity.places.place((int) id);

        Toolbar toolbar = findViewById(R.id.place_view_toolbar);
        toolbar.setTitle(place.getName());
        setSupportActionBar(toolbar);

        ImageView type_logo = findViewById(R.id.logo_type);
        type_logo.setImageResource(place.getType().getResource());

        TextView type = findViewById(R.id.view_type);
        type.setText(place.getType().getText());

        TextView address = findViewById(R.id.view_address);
        address.setText(place.getAddress());

        TextView phone = findViewById(R.id.view_phone);
        if (place.getPhone() == 0) {
            phone.setVisibility(View.GONE);
        } else {
            phone.setVisibility(View.VISIBLE);
            phone.setText(Integer.toString(place.getPhone()));
        }

        TextView url = findViewById(R.id.view_url);
        if (place.getUrl().isEmpty()) {
            url.setVisibility(View.GONE);
        } else {
            url.setVisibility(View.VISIBLE);
            url.setText(place.getUrl());
        }

        TextView notes = findViewById(R.id.view_notes);
        if (place.getNotes().isEmpty()) {
            notes.setVisibility(View.GONE);
        } else {
            notes.setVisibility(View.VISIBLE);
            notes.setText(place.getNotes());
        }

        TextView date = findViewById(R.id.view_date);
        date.setText(DateFormat.getDateInstance().format(
                new Date(place.getDate())
        ));

        RatingBar rating = findViewById(R.id.view_rating);
        rating.setRating(place.getRating());
        rating.setOnRatingBarChangeListener((ratingBar, v, b) -> place.setRating(v));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.place_view_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.view_menu_share) {
            return true;
        } else if (item.getItemId() == R.id.view_menu_navigate) {
            return true;
        } else if (item.getItemId() == R.id.view_menu_edit) {
            startPlaceEditActivity(id);
            return true;
        } else if (item.getItemId() == R.id.view_menu_delete) {
            confirmDelete((int) id);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void startPlaceEditActivity(long id) {
        long edit_id = Long.parseLong(String.valueOf(id));
        Intent intent = new Intent(PlaceViewActivity.this, PlaceEditActivity.class);
        intent.putExtra("id", id);
        startActivityForResult(intent, EDIT_RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_RESULT) {
            updateViews();
            findViewById(R.id.scrollView1).invalidate();
        }
    }

    public void confirmDelete(final int id) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm deletion")
                .setMessage("You're about to delete a place\nThis can't be undone!")
                .setPositiveButton(
                        "DELETE",
                        ((dialogInterface, i) -> {
                            MainActivity.places.deletePlace((int) id);
                            finish();
                        }))
                .setNegativeButton("CANCEL", null)
                .show();
    }

}
