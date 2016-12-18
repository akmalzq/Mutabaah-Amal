package com.crespro.myamaltutor.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nikmuhammadamin on 03/12/2016.
 */

public class Amal extends RealmObject {
    @PrimaryKey
    private int week;
    private float score;
    private int level;

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}




