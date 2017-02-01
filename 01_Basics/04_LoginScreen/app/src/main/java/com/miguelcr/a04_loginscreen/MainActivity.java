package com.miguelcr.a04_loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // https://images.seeklogo.net/2011/08/facebook-logo-vector-400x400.png

        logo = (ImageView) findViewById(R.id.imageViewLogo);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);


        Picasso.with(this)
                .load("https://images.seeklogo.net/2011/08/facebook-logo-vector-400x400.png")
                .into(logo);

        Toast.makeText(this, "Image loaded", Toast.LENGTH_LONG).show();
    }

    public void doLogin(View view) {
        String emailText = email.getText().toString();
        String passText = pass.getText().toString();

        if(emailText.equals("admin@admin.com") &&
                passText.equals("1234")) {
            Toast.makeText(this, "Login ok", Toast.LENGTH_SHORT).show();

            // Launch the HomeActivity screen
            Intent i = new Intent(this,HomeActivity.class);
            i.putExtra("user",emailText);
            startActivity(i);

        } else {
            Toast.makeText(this, "Login wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
