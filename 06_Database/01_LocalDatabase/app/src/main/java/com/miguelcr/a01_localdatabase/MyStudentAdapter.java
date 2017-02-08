package com.miguelcr.a01_localdatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelcr.a01_localdatabase.database.Student;

import java.util.List;

/**
 * Created by miguelcampos on 8/2/17.
 */

public class MyStudentAdapter extends ArrayAdapter<Student> {
    Context ctx;
    int layout;
    List<Student> values;

    public MyStudentAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        ctx = context;
        layout = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layout, parent, false);

        // Get the current Android version
        Student current = values.get(position);


        // Get the view components from the template
        ImageView icon = (ImageView) v.findViewById(R.id.image_view_avatar);
        TextView name = (TextView) v.findViewById(R.id.text_view_name);
        TextView age = (TextView) v.findViewById(R.id.text_view_age);

        // Set the current element info into the view components
        if(current.getSex().equals("m")) {
            icon.setImageResource(R.drawable.ic_male);
        } else {
            icon.setImageResource(R.drawable.ic_female);
        }

        name.setText(current.getName());
        age.setText(String.valueOf(current.getAge()));

        return v;
    }
}
