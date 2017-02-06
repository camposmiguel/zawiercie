package com.miguelcr.a02_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<FootballPlayer> footballPlayerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference for the ListView Component
        lista = (ListView) findViewById(R.id.listView);

        // List of Elements (FootballPlayer)
        footballPlayerList = new ArrayList<>();

        footballPlayerList.add(new FootballPlayer("Ronaldo","http://www.cabroworld.com/wp-content/uploads/2016/06/2FB0141F00000578-0-Cristiano_Ronaldo_has_said_that_he_does_not_expect_to_remain_in_-a-31_1451953551282.jpg",5,100));
        footballPlayerList.add(new FootballPlayer("Messi","http://despertardeoaxaca.com/wp-content/uploads/2016/06/messi.jpg",0,0));
        footballPlayerList.add(new FootballPlayer("Neymar","http://www.carlosfocus.info/wp-content/uploads/2016/11/neymar.jpg",2,3));
        footballPlayerList.add(new FootballPlayer("Hiniesta","http://www.solodeportemx.com/wp-content/uploads/2016/10/Andres-Iniesta-HD-Photos.jpg",5,30));

        // Adapter
        MyFootballPlayerAdapter adapter = new MyFootballPlayerAdapter(
                this,
                R.layout.football_player_item,
                footballPlayerList
        );

        lista.setAdapter(adapter);


    }
}
