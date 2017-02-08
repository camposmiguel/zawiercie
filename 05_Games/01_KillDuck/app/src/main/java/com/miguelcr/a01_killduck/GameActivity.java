package com.miguelcr.a01_killduck;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView textViewPlayer, textViewCounter, textViewTimer;
    int duckCounter = 0;
    Random randomNumber;
    ImageView duck;
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        randomNumber = new Random();

        Bundle extras = getIntent().getExtras();
        String nick = extras.getString("nick");

        textViewPlayer = (TextView) findViewById(R.id.textViewPlayer);
        textViewCounter = (TextView) findViewById(R.id.textViewDuckCount);
        textViewTimer = (TextView) findViewById(R.id.textViewTimer);
        duck = (ImageView) findViewById(R.id.imageViewDuck);

        textViewPlayer.setText(nick);

        Typeface type = Typeface.createFromAsset(getAssets(),"pixel.otf");
        textViewPlayer.setTypeface(type);

        getSupportActionBar().hide();

        moveRandom();

        // 1 minute = 60s = 60.000 ms
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                textViewTimer.setText("Game over!");
                gameOver = true;
            }
        }.start();


    }

    public void duckClicked(View view) {
        if(!gameOver) {
            // Increase the counter to show the ducks hunted
            duckCounter++;
            textViewCounter.setText(String.valueOf(duckCounter));

            // Generate a random position for the duck
            moveRandom();
        }

    }

    private void moveRandom() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenHeight = displaymetrics.heightPixels;
        int screenWidth = displaymetrics.widthPixels;

        // Get the duck Image width and height
        int duckWith = duck.getMeasuredWidth();
        int duckHeight = duck.getMeasuredHeight();

        // Random width and height
        int xRandom = randomNumber.nextInt(screenWidth-duckWith - 0 + 1) + 0;
        int yRandom = randomNumber.nextInt(screenHeight-duckHeight - 0 + 1) + 0;

        // Apply the new random coordinates to the ImageView duck
        duck.setX(xRandom);
        duck.setY(yRandom);
    }
}
