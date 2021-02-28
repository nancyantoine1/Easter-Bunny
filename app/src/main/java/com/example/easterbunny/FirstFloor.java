package com.example.easterbunny;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

public class FirstFloor extends AppCompatActivity {
    private ImageView imageView;

    private String location;
    private String[] key;
    private String[] value;

    private final int validLocation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_floor);

        location = getIntent().getStringExtra("location");
        imageView = findViewById(R.id.bunny_imageView);
        parkEntrance();
    }

    public void parkEntrance() {
        location = "Park Entrance";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(location)
                .setMessage("Search or move?")
                .setPositiveButton("Spring Meadow", (dialog, id) -> springMeadow())
                .setNeutralButton("Aeryn's Overlook", (dialog, id) -> aerynsOverlook())
                .setNegativeButton("Garden Gate", (dialog, id) -> gardenGate())
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void springMeadow() {
        key   = this.getResources().getStringArray(R.array.springmeadow_items);
        value = this.getResources().getStringArray(R.array.springmeadow_outcome);

        imageView.setX(475);
        imageView.setY(400);

        location = "Spring Meadow";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(location)
                .setMessage("You are now in " + location + ".\nSearch or move?")
                .setPositiveButton("Search", (dialogInterface, i) -> search(key, value))
                .setNeutralButton("Move", (dialogInterface, id) -> readingNook())
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void readingNook() {
        key   = this.getResources().getStringArray(R.array.readingnook_items);
        value = this.getResources().getStringArray(R.array.readingnook_outcome);

        imageView.setY(700);

        location = "Reading Nook";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(location)
                .setMessage("You are now in " + location + ".")
                .setPositiveButton("Next", (dialogInterface, i) -> search(key, value))
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void aerynsOverlook() {
        key   = this.getResources().getStringArray(R.array.aerynsoverlook_items);
        value = this.getResources().getStringArray(R.array.aerynsoverlook_outcome);

        imageView.setX(800);
        imageView.setY(1000);

        location = "Aeryn's Overlook";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(location)
                .setMessage("You are now in " + location + ".\nSearch or move?")
                .setPositiveButton("Search", (dialogInterface, i) -> search(key, value))
                .setNeutralButton("Move", (dialogInterface, id) -> peacefulPond())
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void peacefulPond() {
        key   = this.getResources().getStringArray(R.array.peacefulpond_item);
        value = this.getResources().getStringArray(R.array.peacefulpond_outcome);

        imageView.setX(100);
        imageView.setY(1300);

        location = "Peaceful Pond";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(location)
                .setMessage("You are now in " + location + ".\nSearch or move?")
                .setPositiveButton("Search", (dialogInterface, i) -> search(key, value))
                .setNeutralButton("Move", (dialogInterface, id) -> ravensTower())
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void ravensTower() {
        key   = this.getResources().getStringArray(R.array.ravenstower_items);
        value = this.getResources().getStringArray(R.array.ravenstower_outcome);

        imageView.setY(1000);
        location = "Raven's Tower";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(location)
                .setMessage("You are now in " + location + ".")
                .setPositiveButton("Next", (dialogInterface, i) -> search(key, value))
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }
        alertDialog.show();
    }

    public void gardenGate() {
        imageView.setX(900);
        imageView.setY(250);

        location = "Garden Gate";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(location)
                .setMessage("Moving to Garden Gate...")
                .setPositiveButton("Ok", (dialogInterface, i) -> {
                    Intent intent = new Intent(FirstFloor.this, SecondFloor.class);
                    intent.putExtra("location", location);
                    startActivityForResult(intent, validLocation);
                })
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == validLocation) {
            if (data != null) {
                location = data.getStringExtra("newLocation");
            }
        }

        setLocation();
    }

    public void search(String @NotNull [] key, final String[] value) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final AlertDialog.Builder outcome = new AlertDialog.Builder(this);
        outcome.setTitle("Outcome");

        builder.setTitle("Search")
                .setMessage("Select an item to search:")
                .setPositiveButton(key[0], (dialogInterface, i) -> {
                    outcome.setMessage(value[0])
                            .setPositiveButton("Ok", (dialogInterface12, i12) -> setLocation())
                            .create();

                    AlertDialog alertDialog = outcome.create();

                    if (alertDialog.getWindow() != null) {
                        alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
                        alertDialog.setCancelable(false);
                        alertDialog.setCanceledOnTouchOutside(false);
                    }

                    alertDialog.show();
                })
                .setNeutralButton(key[1], (dialogInterface, i) -> {
                    outcome.setMessage(value[1])
                            .setPositiveButton("Ok", (dialogInterface1, i1) -> setLocation())
                            .create();

                    AlertDialog alertDialog = outcome.create();

                    if (alertDialog.getWindow() != null) {
                        alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
                        alertDialog.setCancelable(false);
                        alertDialog.setCanceledOnTouchOutside(false);
                    }

                    alertDialog.show();

                }).create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }
        alertDialog.show();

    }

    private void setLocation() {
        Intent intent = new Intent();
        intent.putExtra("newLocation", location);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        setResult(RESULT_OK, intent);
        finish();
    }

}