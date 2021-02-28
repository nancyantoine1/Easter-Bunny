package com.example.easterbunny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView gameOver, easterEgg;
    private TextView textView, endingTextView, playAgain;
    private Button yesButton, noButton;

    private String location = "";

    private final int validLocation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInvisibleViews();

        final AlertDialog.Builder builder1, builder2;
        final EditText editText;

        editText = new EditText(this);
        builder1 = new AlertDialog.Builder(this);
        builder2 = new AlertDialog.Builder(this);

        builder1.setTitle("Welcome")
                .setMessage("Welcome to the Maze Game!\nWhat is your name?\n\n")
                .setView(editText)
                .setPositiveButton("Next", (dialog, id) -> {
                    final String name = editText.getText().toString();

                    final ImageView parkEntrance;

                    parkEntrance = new ImageView(getApplicationContext());
                    parkEntrance.setImageResource(R.drawable.parkentrance);

                    builder2.setTitle("Greeting")
                            .setMessage("Welcome, " + name + "!\n\nYour journey begins at the Park Entrance!\n")
                            .setView(parkEntrance)
                            .setPositiveButton("Ok", (dialog12, id1) -> {

                                Intent intent = new Intent(getApplicationContext(), FirstFloor.class);
                                intent.putExtra("location", location);
                                startActivityForResult(intent, validLocation);
                            })
                            .create();

                    AlertDialog dialog2 = builder2.create();
                    dialog2.setCancelable(false);
                    dialog2.setCanceledOnTouchOutside(false);
                    dialog2.show();
                }).create();

        AlertDialog dialog1 = builder1.create();
        dialog1.setCancelable(false);
        dialog1.setCanceledOnTouchOutside(false);
        dialog1.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == validLocation) {
            if (data != null) {
                location = data.getStringExtra("newLocation");
            }
        }

        gameOver();
    }

    public void gameOver() {
        gameOver.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);

        String endingLocation;

        if (location.isEmpty()) {
            endingLocation = "No moves made.";
        } else {
            endingLocation = "You finished in " + location + ".";
        }

        endingTextView.setText(endingLocation);
        endingTextView.setVisibility(View.VISIBLE);

        easterEgg.setVisibility(View.VISIBLE);
        playAgain.setVisibility(View.VISIBLE);
        yesButton.setVisibility(View.VISIBLE);
        noButton.setVisibility(View.VISIBLE);

        yesButton.setOnClickListener(view -> {
            Activity activity = MainActivity.this;
            activity.recreate();
        });

        // Exit on No
        noButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Thank you for playing!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void setInvisibleViews() {
        gameOver = findViewById(R.id.game_over);
        gameOver.setVisibility(View.INVISIBLE);

        textView = findViewById(R.id.game_over_text);
        textView.setVisibility(View.INVISIBLE);

        endingTextView = findViewById(R.id.ending_location);
        endingTextView.setVisibility(View.INVISIBLE);

        easterEgg = findViewById(R.id.easteregg);
        easterEgg.setVisibility(View.INVISIBLE);

        playAgain = findViewById(R.id.playAgain_activity_main);
        playAgain.setVisibility(View.INVISIBLE);

        yesButton = findViewById(R.id.yesButton_activity_main);
        yesButton.setVisibility(View.INVISIBLE);

        noButton = findViewById(R.id.noButton_activity_main);
        noButton.setVisibility(View.INVISIBLE);
    }
}