package com.crespro.myamaltutor.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nikmuhammadamin on 03/12/2016.
 */

public class Amal extends RealmObject {
    @PrimaryKey
    private int week;
    private int week2;
    private int week3;
    private float score;
    private float score2;
    private float score3;
    private int level;
    private int level2;
    private int level3;

    //private String level;



    public int getWeek() {return week; }

    public int getWeek2() {return week2;}

    public int getWeek3() {return week3;}

    public void setWeek(int week) {this.week = week;}

    public void setWeek2(int week2) {
        this.week2 = week2;
    }

    public void setWeek3(int week3) {
        this.week3 = week3;
    }

    public float getScore() {return score;}

    public float getScore2() {
        return score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore(float score) {this.score = score;}

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }

    public void setLevel(int level) {this.level = level;}

    public void setLevel2(int level2) {this.level2 = level2;}

    public void setLevel3(int level3) {this.level3 = level3;}



    //public String getLevel() {
    // return level;}

    //public void setLevel(float level) {
    //this.score = level;}


}




