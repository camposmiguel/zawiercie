package com.miguelcr.a04_loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText p1, p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // https://images.seeklogo.net/2011/08/facebook-logo-vector-400x400.png

        p1 = (EditText) findViewById(R.id.player1);
        p2 = (EditText) findViewById(R.id.player2);


    }

    public void startGame(View view) {
        String player1 = p1.getText().toString();
        String player2 = p2.getText().toString();

        if(!player1.equals("") && !player2.equals("")) {
            Toast.makeText(this, "Start Game ok", Toast.LENGTH_SHORT).show();

            // Launch the HomeActivity screen
            Intent i = new Intent(this,GameActivity.class);
            i.putExtra("player1",player1);
            i.putExtra("player2",player2);
            startActivity(i);

        } else {
            Toast.makeText(this, "Login wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
