package com.miguelcr.a02_customlistview;

/**
 * Created by miguelcampos on 6/2/17.
 */

public class FootballPlayer {
    String name, photoUrl;
    int rate, goals;

    public FootballPlayer(String name, String photoUrl, int rate, int goals) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.rate = rate;
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
