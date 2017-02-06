package com.miguelcr.a01_killduck;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView textViewPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();
        String nick = extras.getString("nick");

        textViewPlayer = (TextView) findViewById(R.id.textViewPlayer);
        textViewPlayer.setText(nick);

        Typeface type = Typeface.createFromAsset(getAssets(),"pixel.otf");
        textViewPlayer.setTypeface(type);

        getSupportActionBar().hide();

    }
}
