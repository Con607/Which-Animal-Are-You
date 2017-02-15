package com.conexxionbusiness.whichanimalareyou;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IRVING on 15/02/2017.
 */

public class QuestionBank {
    private String[] mQuestions = {
            "Question 1",
            "Question 2",
            "Question 3",
            "Question 4",
            "Question 5",
            "Question 6",
    };

    private String[] mOptions = {
            "Option 1", "Option 2", "Option 3", "Option 4", "Option 5",
            "Option 6", "Option 7", "Option 8", "Option 9", "Option 10",
            "Option 11", "Option 12", "Option 13", "Option 14", "Option 15",
            "Option 16", "Option 17", "Option 18", "Option 19", "Option 20",
            "Option 21", "Option 22", "Option 23", "Option 24", "Option 25"
    };

    private String[] mAnimals = {
            "Animal 1",
            "Animal 2",
            "Animal 3",
            "Animal 4",
            "Animal 5"
    };
    private List<Animal> mAnimalList = new ArrayList<Animal>();
    private List<Option> mOptionList = new ArrayList<Option>();
    private List<Question> mQuestionList = new ArrayList<Question>();


    public List<Question> loadQuestions() {
        mQuestionList.clear();

        loadAnimals();
        loadOptions();

        for (String questionString : mQuestions) {
            Question question;
            for (int i=0; i < mOptionList.size(); i = i+5) {
                question = new Question(
                        questionString,
                        mOptionList.get(i),
                        mOptionList.get(i+1),
                        mOptionList.get(i+2),
                        mOptionList.get(i+3),
                        mOptionList.get(i+4));
                mQuestionList.add(question);
            }
        }

        return mQuestionList;
    }

    private void loadAnimals() {
        mAnimalList.clear();
        for (String animal : mAnimals) {
            Animal newAnimal = new Animal(animal);
            mAnimalList.add(newAnimal);
        }
    }

    private void loadOptions() {
        mOptionList.clear();
        int animalCounter = 0;
        for (String option : mOptions) {
            if (animalCounter > mAnimalList.size()) {
                animalCounter = 0;
            }
            Option newOption = new Option(option, mAnimalList.get(animalCounter));
            mOptionList.add(newOption);
        }
    }

}
