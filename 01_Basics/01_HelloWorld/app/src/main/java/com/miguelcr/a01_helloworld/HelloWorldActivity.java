package com.miguelcr.a01_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HelloWorldActivity extends AppCompatActivity {
    Button btn1;
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

        btn1 = (Button)findViewById(R.id.button1);
        screen = (TextView) findViewById(R.id.textViewScreen);

        screen.setText("HELLO");
    }
}
