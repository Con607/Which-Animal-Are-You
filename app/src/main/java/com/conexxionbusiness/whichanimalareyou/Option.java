package com.conexxionbusiness.whichanimalareyou;

/**
 * Created by IRVING on 15/02/2017.
 */

public class Option {
    private String mOption;
    private Animal mAnimal;

    public Option(String option, Animal animal) {
        this.mOption = option;
        this.mAnimal = animal;
    }

    public String getOption() {
        return mOption;
    }

    public void setOption(String option) {
        this.mOption = option;
    }

    public Animal getAnimal() {
        return mAnimal;
    }

    public void setAnimal(Animal animal) {
        this.mAnimal = animal;
    }

}
