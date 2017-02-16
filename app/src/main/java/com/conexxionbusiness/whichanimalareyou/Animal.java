package com.conexxionbusiness.whichanimalareyou;

import java.io.Serializable;

/**
 * Created by IRVING on 15/02/2017.
 */

public class Animal implements Serializable {
    private String mName;
    private int mScore = 0;

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
