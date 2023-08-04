package net.estemon.studio.plazes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        final EditText id_input = new EditText(this);
        id_input.setText("0");
        new AlertDialog.Builder(this)
                .setTitle("Place selection")
                .setMessage("Write place id:")
                .setView(id_input)
                .setPositiveButton(
                        "OK",
                        (dialogInterface, i) -> {
                            long id = Long.parseLong(id_input.getText().toString());
                            Intent intent = new Intent(MainActivity.this, PlaceViewActivity.class);
                            intent.putExtra("id", id);
                            startActivity(intent);
                        })
                .setNegativeButton("CANCEL", null)
                .show();
    }
}