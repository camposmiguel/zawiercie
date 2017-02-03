package com.miguelcr.a02_customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miguelcampos on 3/2/17.
 */

public class MyAndroidVersionAdapter extends ArrayAdapter {
    Context ctx;
    int layoutTemplate;
    List<AndroidVersion> values;


    public MyAndroidVersionAdapter(Context context, int resource, List<AndroidVersion> objects) {
        super(context, resource, objects);

        ctx = context;
        layoutTemplate = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // parent > is the ListView where we're going to draw the elements
        // position > current element from the List<AndroidVersion> that now we're
        // drawing

        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        // Get the current Android version
        AndroidVersion current = values.get(position);


        // Get the view components from the template
        ImageView icon = (ImageView) v.findViewById(R.id.imageViewIcon);
        TextView name = (TextView) v.findViewById(R.id.textViewName);

        // Set the current element info into the view components
        icon.setImageResource(current.getIcon());
        name.setText(current.getName());


        return v;
    }
}
