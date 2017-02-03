package com.miguelcr.a02_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<AndroidVersion> androidVersionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference for the ListView Component
        lista = (ListView) findViewById(R.id.listView);

        // List of Elements
        androidVersionList = new ArrayList<>();

        androidVersionList.add(new AndroidVersion("Donut",R.drawable.ic_doughnut));
        androidVersionList.add(new AndroidVersion("Cupcake",R.drawable.ic_cupcake));
        androidVersionList.add(new AndroidVersion("Ice Cream",R.drawable.ic_ice_cream));
        androidVersionList.add(new AndroidVersion("Gingerbread",R.drawable.ic_gingerbread));


    }
}
