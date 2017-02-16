package com.conexxionbusiness.whichanimalareyou;

/**
 * Created by IRVING on 15/02/2017.
 */

public class Statement {
    private String mStatement;
    private String mOption = null;
    private Animal mAnimal;


    public Statement(String statement, String animal) {
        mStatement = statement;
        mAnimal = new Animal(animal);
    }

    public String getStatement() {
        return mStatement;
    }

    public Animal getAnimal() {
        return mAnimal;
    }

    public String getOption() {
        return mOption;
    }

    public void setOption(String option) {
        mOption = option;
    }
}
