package com.miguelcr.a02_customlistview;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by miguelcampos on 3/2/17.
 */

public class MyAndroidVersionAdapter extends ArrayAdapter {
    public MyAndroidVersionAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }
}
