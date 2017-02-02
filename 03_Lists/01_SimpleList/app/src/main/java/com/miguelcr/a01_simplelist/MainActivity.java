package com.miguelcr.a01_simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    // String[] students = {"Dominik","Olga"};
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference to manage the listView component
        lista = (ListView) findViewById(R.id.listView);

        // Create the list of students and add elements
        students = new ArrayList<>();
        students.add("Przemek");
        students.add("Konrad");
        students.add("Dominik");
        students.add("Dawid");
        students.add("Olga");
        students.add("Artur");
        students.add("Szymon I");
        students.add("Sesbastian");
        students.add("Szymon II");
        students.add("Bartek I");
        students.add("Olaf");
        students.add("Piotr");
        students.add("Mikolaj");
        students.add("Bartek II");
        students.add("Mateusz");

        // Adapter
        // Param 1: context
        // Param 2: layout to draw one element of the list
        // Param 3: list of elements to draw
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        // Connect the listView (lista) and the adapter
        lista.setAdapter(adapter);

        // Event click handler
        lista.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            String nameStudentClicked = students.get(i);
            Toast.makeText(this, "Student: "+nameStudentClicked, Toast.LENGTH_SHORT).show();

            view.animate().alphaBy(0).setDuration(1000).start();


    }
}
