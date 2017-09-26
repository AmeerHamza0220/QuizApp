package com.example.lablnet.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
RatingBar ratingBar;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        int Score=intent.getIntExtra("Score",0);
        int noOfQuestions=intent.getIntExtra("NoOfQuestions",5);
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        txt=(TextView)findViewById(R.id.txtResult);
        int percentage= (int) (((float)Score/noOfQuestions)*5);// For percentage we need float or double data type
        ratingBar.setMax(noOfQuestions);// set the maximum value of rating bar
        ratingBar.setProgress(Score);
        setScore(Score,gerResult(percentage),noOfQuestions);
    }
    public String gerResult(int percentage){
        String result;
        if(percentage>4.0&&percentage<=5.0){
            result="You are legend";
        }
        else if(percentage>3.0&&percentage<=4.0){
            result="You have good knowledge ";
        }
        else if(percentage>2.0&&percentage<=3.0){
            result="You need to improve your knowledge";
        }
        else if(percentage>1.0&&percentage<=2.0){
            result="Go read some books then take quiz again";
        }
        else{
            result="You are alien! This quiz is not for you ";
        }
        return result;
    }
     public void setScore(int score,String result,int noOfQuestions){
         txt.setText(result+"\nYou got "+ score+" out of "+noOfQuestions);
    }
}
