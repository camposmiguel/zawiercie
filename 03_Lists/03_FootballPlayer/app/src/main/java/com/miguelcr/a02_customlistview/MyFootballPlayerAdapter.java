package com.miguelcr.a02_customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by miguelcampos on 6/2/17.
 */

public class MyFootballPlayerAdapter extends ArrayAdapter<FootballPlayer> {

    Context ctx;
    int layoutTemplate;
    List<FootballPlayer> values;

    public MyFootballPlayerAdapter(Context context, int resource, List<FootballPlayer> objects) {
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
        FootballPlayer current = values.get(position);


        // Get the view components from the template
        CircleImageView photo = (CircleImageView) v.findViewById(R.id.imageViewPhoto);
        TextView name = (TextView) v.findViewById(R.id.textViewName);
        ImageView star1 = (ImageView) v.findViewById(R.id.imageViewStar1);
        ImageView star2 = (ImageView) v.findViewById(R.id.imageViewStar2);
        ImageView star3 = (ImageView) v.findViewById(R.id.imageViewStar3);
        ImageView star4 = (ImageView) v.findViewById(R.id.imageViewStar4);
        ImageView star5 = (ImageView) v.findViewById(R.id.imageViewStar5);
        TextView goals = (TextView) v.findViewById(R.id.textViewGoals);

        // Set the current element info into the view components

        Picasso.with(ctx)
                .load(current.getPhotoUrl())
                .placeholder(R.drawable.ic_user)
                .into(photo);
        name.setText(current.getName());

        switch (current.getRate()) {
            case 1:
                star1.setImageResource(R.drawable.ic_star_on); break;
            case 2:
                star1.setImageResource(R.drawable.ic_star_on);
                star2.setImageResource(R.drawable.ic_star_on);
                break;
            case 3:
                star1.setImageResource(R.drawable.ic_star_on);
                star2.setImageResource(R.drawable.ic_star_on);
                star3.setImageResource(R.drawable.ic_star_on);
                break;
            case 4:
                star1.setImageResource(R.drawable.ic_star_on);
                star2.setImageResource(R.drawable.ic_star_on);
                star3.setImageResource(R.drawable.ic_star_on);
                star4.setImageResource(R.drawable.ic_star_on);
                break;
            case 5:
                star1.setImageResource(R.drawable.ic_star_on);
                star2.setImageResource(R.drawable.ic_star_on);
                star3.setImageResource(R.drawable.ic_star_on);
                star4.setImageResource(R.drawable.ic_star_on);
                star5.setImageResource(R.drawable.ic_star_on);
                break;
        }

        /*List<ImageView> stars = new ArrayList<>();
        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

        for(int i=0; i<current.getRate(); i++) {

        }*/

        goals.setText(String.valueOf(current.getGoals()));


        return v;
    }
}
