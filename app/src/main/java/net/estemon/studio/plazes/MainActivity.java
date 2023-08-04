package net.estemon.studio.plazes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static Places places = new PlacesList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AboutActivity aboutActivity = new AboutActivity();
        Button about = findViewById(R.id.btn_about);
        about.setOnClickListener(view -> startAboutActivity());

        PlaceViewActivity placeViewActivity = new PlaceViewActivity();
        Button view_place = findViewById(R.id.btn_show_places);
        view_place.setOnClickListener(view -> startPlaceViewActivity());
    }

    public void startAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

     public void startPlaceViewActivity() {
        Intent intent = new Intent(this, PlaceViewActivity.class);
        intent.putExtra("id", (long) 0);
        startActivity(intent);
    }
}