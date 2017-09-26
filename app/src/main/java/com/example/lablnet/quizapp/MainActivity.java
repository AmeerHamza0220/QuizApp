package com.example.lablnet.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart=(Button)findViewById(R.id.btnCS);
        Button btnAddQuestion=(Button)findViewById(R.id.btnAddQuestion);
        Button btnAbout=(Button)findViewById(R.id.btnAbout);
        addQuestion addQuestion=new addQuestion(this);
        addQuestion.WriteData();
        btnStart.setOnClickListener(this);
        btnAddQuestion.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCS:
                //Open quiz activity
                Intent intent=new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
                break;
            case R.id.btnAddQuestion:
                // Open Dialog to add question
                DialogFragment dialogFragment=new DialogAddQuestion();
                dialogFragment.show(getSupportFragmentManager(),"123");
                break;

            case R.id.btnAbout:
                aboutDialog();
                //About App
                break;
        }
    }

public void aboutDialog(){
    final AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setTitle("About");
    builder.setMessage("Created By Ameer Hamza\nThis is Simple quiz app, you can add more questions.\nQuestions appear randomly");
    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            builder.create().dismiss();
        }
    });
    builder.show();
}
}
