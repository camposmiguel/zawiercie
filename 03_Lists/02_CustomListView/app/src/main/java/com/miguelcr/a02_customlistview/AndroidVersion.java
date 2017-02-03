package com.miguelcr.a02_customlistview;

/**
 * Created by miguelcampos on 3/2/17.
 */

public class AndroidVersion {
    String name;
    int icon;

    // Constructor
    public AndroidVersion(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
