package com.example.lablnet.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    List<Question_Data> list;
    Question_Data data;
    DatabaseHelper databaseHelper;
    RadioGroup radioGroup;
    Button nextButton;
    RadioButton radioButton;
    int question_ID, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        question_ID = 0;
        score = 0;
        addDataToList();
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        nextButton = (Button) findViewById(R.id.nextButton);
        setQuestion();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                if (radioButton == null) {
                    Toast.makeText(QuizActivity.this, "Please select an option!", Toast.LENGTH_SHORT).show();
                } else {
                    String userAnswer = radioButton.getText().toString().replace(" ", "").toLowerCase();
                    data = list.get(question_ID);
                    radioGroup.clearCheck();
                    if (userAnswer.equals(data.getAnswer().replace(" ", "").toLowerCase())) {
                        score++;
                    }
                    if (question_ID < 9) {
                        /* this run program 10 time because i incremented question id here*/
                        question_ID++;
                        setQuestion();
                    } else {
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        intent.putExtra("Score", score);
                        intent.putExtra("NoOfQuestions", question_ID + 1);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void setQuestion() {
        data = list.get(question_ID);
        TextView questionView = (TextView) findViewById(R.id.questionView);
        RadioButton opt1 = (RadioButton) findViewById(R.id.opt1);
        RadioButton opt2 = (RadioButton) findViewById(R.id.opt2);
        RadioButton opt3 = (RadioButton) findViewById(R.id.opt3);
        questionView.setText(question_ID + 1 + ") " + data.getQuestion());
        opt1.setText(data.getOpt1());
        opt2.setText(data.getOpt2());
        opt3.setText(data.getOpt3());
    }

    public void addDataToList() {
        databaseHelper = new DatabaseHelper(this);
        list=new ArrayList<>();
        list.clear();
        list = databaseHelper.ReturnList();
    }


}
