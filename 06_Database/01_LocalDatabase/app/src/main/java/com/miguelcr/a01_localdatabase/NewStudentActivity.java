package com.miguelcr.a01_localdatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.miguelcr.a01_localdatabase.database.DaoSession;
import com.miguelcr.a01_localdatabase.database.Student;
import com.miguelcr.a01_localdatabase.database.StudentDao;

public class NewStudentActivity extends AppCompatActivity {
    StudentDao studentDao;
    EditText editTextName, editTextAge;
    RadioGroup radioGroupSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextAge = (EditText) findViewById(R.id.edit_text_age);
        radioGroupSex = (RadioGroup) findViewById(R.id.radio_group_sex);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student newStudent = new Student();
                newStudent.setName(editTextName.getText().toString());
                newStudent.setAge(Integer.parseInt(editTextAge.getText().toString()));
                int idRadioButtonSelected = radioGroupSex.getCheckedRadioButtonId();
                if(idRadioButtonSelected==R.id.radio_button_male) {
                    newStudent.setSex("m");
                } else {
                    newStudent.setSex("f");
                }
                // INSERT INTO
                studentDao.insert(newStudent);

                //Destroy
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DaoSession connection = DatabaseConnection.getConnection(this);
        studentDao = connection.getStudentDao();
    }

}
