package com.miguelcr.a01_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloWorldActivity extends AppCompatActivity {
    Button btn1;
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

        //btn1 = (Button)findViewById(R.id.button1);
        screen = (TextView) findViewById(R.id.textViewScreen);

        screen.setText("0");
    }

    public void buttonClicked(View view) {
        int id = view.getId();

        // OPTION 1
        /*
        if(id==R.id.button1) {
            screen.setText("1");
        } else if(id==R.id.button2) {
            screen.setText("2");
        } ...
        */

        // OPTION 2
        /*
        switch (id) {
            case R.id.button1: screen.setText("1"); break;
            case R.id.button2: screen.setText("2"); break;
            case R.id.button3: screen.setText("3"); break;
        }
        */

        Button btnClicked = (Button) view;
        screen.setText(btnClicked.getText());
    }
}
