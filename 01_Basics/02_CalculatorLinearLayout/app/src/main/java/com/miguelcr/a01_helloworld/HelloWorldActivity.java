package com.miguelcr.a01_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloWorldActivity extends AppCompatActivity {
    Button btn1;
    TextView screen;
    int operand1, operand2;

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

        String screenText = "";
        switch (id) {
            case R.id.button1: screenText="1"; break;
            case R.id.button2: screenText="2"; break;
            case R.id.button3: screenText="3"; break;
        }

        String previousScreenText = screen.getText().toString(); // "12" > String


        if(previousScreenText.equals("0")) {
            screen.setText(screenText);
        } else {
            screen.setText(previousScreenText + screenText);
        }


        // OPTION 3
        //Button btnClicked = (Button) view;
        //screen.setText(btnClicked.getText());
    }

    public void addButtonClicked(View view) {
        // Save the current number in the screen (1st operand)
        String previousScreenText = screen.getText().toString(); // "12" > String
        operand1 = Integer.parseInt(previousScreenText); // 12 > integer

        // Clear the screen
        screen.setText("0");
    }

    public void equalButtonClicked(View view) {
        String previousScreenText = screen.getText().toString(); // "12" > String
        operand2 = Integer.parseInt(previousScreenText); // 12 > integer

        int result = operand1 + operand2;
        screen.setText(String.valueOf(result));
    }
}
