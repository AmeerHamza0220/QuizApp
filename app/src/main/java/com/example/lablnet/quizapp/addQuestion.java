package com.example.lablnet.quizapp;

import android.content.Context;

/**
 * Created by lablnet on 9/23/2017.
 */

public class addQuestion {
    Context context;

    public addQuestion(Context context) {
        this.context = context;
    }

    public void WriteData() {
        DatabaseHelper databaseHelper;
        Question_Data data;
        databaseHelper = new DatabaseHelper(context);
        data = new Question_Data("Which element is represented by symbol Au", "Titanium", "Gold", "Silver", "Gold");
        databaseHelper.saveData(data);
        data = new Question_Data("What is an example of a viral infection", "Polio", "Polio", "Cancer", "Polio");
        databaseHelper.saveData(data);
        data = new Question_Data("Which country sold Alaska to the USA in 1867", "Russia", "Canada", "Mexico", "Russia");
        databaseHelper.saveData(data);
        data = new Question_Data("Computer network is a collection of ___ connected togather", "Computers", "Machines", "Servers", "Computers");
        databaseHelper.saveData(data);
        data = new Question_Data("Android is an/a", "Operating system", "Programming language", "Vir" +
                "" +
                "tual machine", "Operating system");
        databaseHelper.saveData(data);
        data = new Question_Data("Which gas is highly flammable", "phosgene", "Carbon dioxide", "Hydrogen", "Hydrogen");
        databaseHelper.saveData(data);
        data = new Question_Data("Which US president was NOT assassinated", "James A.Garfield", "Hubert Hover", "Abraham Linoln", "Hubert Hover");
        databaseHelper.saveData(data);
        data = new Question_Data("What is the Largest living fish", "Whale shark", "Sunfiah", "Blue Whale", "Blue Whale");
        databaseHelper.saveData(data);
        data = new Question_Data("Who is the European inventor of movable type printing", "Friedrich Sciller", "Leoanrdo da Vinci", "Johannes Gutenberg", "Johannes Gutenberg");
        databaseHelper.saveData(data);
        data = new Question_Data("Google parent company is", "Google Inc", "Alphabet Inc", "Yahoo", "Alphabet Inc");
        databaseHelper.saveData(data);
    }
}
