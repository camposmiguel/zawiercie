package com.miguelcr.a01_localdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.miguelcr.a01_localdatabase.database.DaoSession;
import com.miguelcr.a01_localdatabase.database.Student;
import com.miguelcr.a01_localdatabase.database.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView lista;
    List<Student> studentList;
    MyStudentAdapter adapter;
    StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lista = (GridView) findViewById(R.id.listView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewStudentActivity.class);
                startActivity(i);
            }
        });

        studentList = new ArrayList<>();

        // Get a local database connection object
        DaoSession connection = DatabaseConnection.getConnection(this);

        // Get an object to manage the 'Student' entity
        studentDao = connection.getStudentDao();

        // SELECT * FROM Student
        studentList = studentDao.loadAll();



        // Adapter
        adapter = new MyStudentAdapter(
                this,
                R.layout.student_item,
                studentList
        );

        lista.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        studentList.clear();
        // studentList > SELECT * FROM Student
        studentList.addAll(studentDao.loadAll());
        adapter.notifyDataSetChanged();
    }
}
