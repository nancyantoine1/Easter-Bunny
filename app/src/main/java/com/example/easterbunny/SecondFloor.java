package com.example.easterbunny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class SecondFloor extends AppCompatActivity {
    private ImageView imageView;

    private String location;
    private String[] key;
    private String[] value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_floor);

        location = getIntent().getStringExtra("location");
        imageView = findViewById(R.id.bunny_imageView);
        gardenGate();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Log.i("SecondFloor","Position X:" + imageView.getX());
        Log.i("SecondFloor","Position Y:" + imageView.getY());
    }

    public void gardenGate() {
        location = "Garden Gate";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(location)
                .setMessage("You are now in " + location + ".\nSearch or move?")
                .setPositiveButton("Flowering Forest", (dialog, id) -> floweringForest())
                .setNeutralButton("Rose Garden", (dialog, id) -> roseGarden())
                .setNegativeButton("Butterfly Garden", (dialog, id) -> butterflyGarden())
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void floweringForest() {
        location = "Flowering Forest";

        key   = this.getResources().getStringArray(R.array.floweringforest_items);
        value = this.getResources().getStringArray(R.array.floweringforest_outcome);

        imageView.setX(692);
        imageView.setY(616);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(location)
                .setMessage("You are now in " + location + ".\nSearch or move?")
                .setPositiveButton("Search", (dialog, id) -> search(key, value))
                .setNeutralButton("Move", (dialog, id) -> festiveFalls())
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void festiveFalls() {
        location = "Festive Falls";

        key   = this.getResources().getStringArray(R.array.festivefalls_items);
        value = this.getResources().getStringArray(R.array.festivefalls_outcome);

        imageView.setX(813);
        imageView.setY(250);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(location)
                .setMessage("You are now in " + location + ".")
                .setPositiveButton("Next", (dialog, id) -> search(key, value))
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void roseGarden() {
        location = "Rose Garden";

        key   = this.getResources().getStringArray(R.array.rosegarden_items);
        value = this.getResources().getStringArray(R.array.rosegarden_outcome);

        imageView.setX(239);
        imageView.setY(1026);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(location)
                .setMessage("You are now in " + location + ".\nSearch or move?")
                .setPositiveButton("Search", (dialog, id) -> search(key, value))
                .setNeutralButton("Move", (dialog, id) -> bunnyBridge())
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void bunnyBridge() {
        location = "Bunny Bridge";

        key   = this.getResources().getStringArray(R.array.bunnybridge_item);
        value = this.getResources().getStringArray(R.array.bunnybridge_outcome);

        imageView.setX(510);
        imageView.setY(1296);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(location)
                .setMessage("You are now at the " + location + ".")
                .setPositiveButton("Next", (dialog, id) -> search(key, value))
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }

    public void butterflyGarden() {
        location = "Butterfly Garden";

        key   = this.getResources().getStringArray(R.array.butterflygarden_items);
        value = this.getResources().getStringArray(R.array.butterflygarden_outcome);

        imageView.setX(744);
        imageView.setY(994);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(location)
                .setMessage("You are now in " + location + ".\nSearch or move?")
                .setPositiveButton("Search", (dialog, id) -> search(key, value))

                .setNeutralButton("Move", (dialog, id) -> bunnyBridge())
                .create();

        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_white);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
        }

        alertDialog.show();
    }


    public void search(@org.jetbrains.annotations.NotNull String[] key, final String[] value) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final AlertDialog.Builder outcome = new AlertDialog.Builder(this);
        outcome.setTitle("Outcome");

        builder.setTitle("Search")
                .setMessage("Select an item to search:")
                .setPositiveButton(key[0], (dialogInterface, i) -> {
                    outcome.setMessage(value[0])
                            .setPositiveButton("Ok", (dialogInterface1, i1) -> setLocation())
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
                            .setPositiveButton("Ok", (dialogInterface12, i12) -> setLocation())
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