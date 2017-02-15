package com.conexxionbusiness.whichanimalareyou;

/**
 * Created by IRVING on 15/02/2017.
 */

public class Question {
    private String mQuestion;
    private Option mOption1;
    private Option mOption2;
    private Option mOption3;
    private Option mOption4;
    private Option mOption5;

    public Question(String question, Option option1, Option option2, Option option3, Option option4, Option option5) {
        mQuestion = question;
        mOption1 = option1;
        mOption2 = option2;
        mOption3 = option3;
        mOption4 = option4;
        mOption5 = option5;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public Option getOption1() {
        return mOption1;
    }

    public void setOption1(Option option1) {
        mOption1 = option1;
    }

    public Option getOption2() {
        return mOption2;
    }

    public void setOption2(Option option2) {
        mOption2 = option2;
    }

    public Option getOption3() {
        return mOption3;
    }

    public void setOption3(Option option3) {
        mOption3 = option3;
    }

    public Option getOption4() {
        return mOption4;
    }

    public void setOption4(Option option4) {
        mOption4 = option4;
    }

    public Option getOption5() {
        return mOption5;
    }

    public void setOption5(Option option5) {
        mOption5 = option5;
    }


}
