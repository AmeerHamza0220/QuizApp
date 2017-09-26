package com.example.lablnet.quizapp;

/**
 * Model Class
 */

public class Question_Data {

    public String mQuestion, opt1, opt2, opt3, mAnswer;

    public Question_Data(String mQuestion, String opt1, String opt2, String opt3, String mAnswer) {
        this.mQuestion = mQuestion;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.mAnswer = mAnswer;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String getOpt1() {
        return opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public String getAnswer() {
        return mAnswer;
    }
}
