package com.miguelcr.a04_loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView welcome, playerTurn;
    String p1Name, p2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcome = (TextView) findViewById(R.id.textViewWelcome);
        playerTurn = (TextView) findViewById(R.id.textViewPlayer);

        // get the extra values
        Bundle data = getIntent().getExtras();
        p1Name = data.getString("player1");
        p2Name = data.getString("player2");

        // Set the email value into the textViewWelocome
        welcome.setText(p1Name+" VS "+p2Name);

        playerTurn.setText("Now is playing "+p1Name);

    }
}
