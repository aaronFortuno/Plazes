package net.estemon.studio.plazes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;

public class PlaceViewActivity extends AppCompatActivity {

    private long id;
    private Place place;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_view);

        Bundle extras = getIntent().getExtras();

        assert extras != null;
        id = extras.getLong("id", -1);
        place = MainActivity.places.place((int) id);

        // Initialize elements and place its values
        TextView name = findViewById(R.id.view_name);
        name.setText(place.getName());

        ImageView type_logo = findViewById(R.id.logo_type);
        type_logo.setImageResource(place.getType().getResource());

        TextView type = findViewById(R.id.view_type);
        type.setText(place.getType().getText());

        TextView address = findViewById(R.id.view_address);
        address.setText(place.getAddress());

        TextView phone = findViewById(R.id.view_phone);
        phone.setText(place.getPhone());

        TextView url = findViewById(R.id.view_url);
        url.setText(place.getUrl());

        TextView notes = findViewById(R.id.view_notes);
        notes.setText(place.getNotes());

        TextView date = findViewById(R.id.view_date);
        date.setText(DateFormat.getDateInstance().format(
                new Date(place.getDate())
        ));

        RatingBar rating = findViewById(R.id.view_rating);
        rating.setRating(place.getRating());
        rating.setOnRatingBarChangeListener((ratingBar, v, b) -> place.setRating(v));
    }
}
