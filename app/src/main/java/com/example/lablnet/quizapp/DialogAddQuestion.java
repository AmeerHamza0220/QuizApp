package com.example.lablnet.quizapp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/* This is a dialog
   which allow user to add more questions
 */

public class DialogAddQuestion extends DialogFragment implements View.OnClickListener {
   Button btnSubmit;
    EditText edtQuestion,edtOption1,edtOption2,edtOption3,edtAnswer;
    public DialogAddQuestion() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog= super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//hide the title
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_add_question, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        edtQuestion=(EditText)getDialog().findViewById(R.id.edtQuestion);
        edtOption1=(EditText)getDialog().findViewById(R.id.edtOption1);
        edtOption2=(EditText)getDialog().findViewById(R.id.edtOption2);
        edtOption3=(EditText)getDialog().findViewById(R.id.edtOption3);
        edtAnswer=(EditText)getDialog().findViewById(R.id.edtAnswer);
        btnSubmit=(Button)getDialog().findViewById(R.id.btnSubmitQuestion);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String question=edtQuestion.getText().toString();
        String option1=edtOption1.getText().toString();
        String option2=edtOption2.getText().toString();
        String option3=edtOption3.getText().toString();
        String answer=edtAnswer.getText().toString();
        //Check whether user fill all field
        if(question.equals("")||option1.equals("")||option2.equals("")||option3.equals("")||answer.equals("")){
            Toast.makeText(getActivity(), "Please fill all given field", Toast.LENGTH_SHORT).show();
        }
        else {
            Question_Data data=new Question_Data(question,option1,option2,option3,answer);
            DatabaseHelper database=new DatabaseHelper(getActivity());
            database.saveData(data);
            dismiss();
            Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
        }

    }
}
