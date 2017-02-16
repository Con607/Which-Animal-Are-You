package com.conexxionbusiness.whichanimalareyou;

/**
 * Created by IRVING on 15/02/2017.
 */

public class Animal {
    private String mName;
    private int mScore;

    public Animal(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }
}
