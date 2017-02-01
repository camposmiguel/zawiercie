package com.miguelcr.a04_loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcome = (TextView) findViewById(R.id.textViewWelcome);

        // get the extra value for "user"
        Bundle data = getIntent().getExtras();
        String userEmail = data.getString("user");
        
        // Set the email value into the textViewWelocome
        welcome.setText("Welcome "+userEmail);
    }
}
