package com.example.lablnet.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lablnet on 9/23/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String dbName="My_Quiz_Database";
    public String tableName="My_Quiz";
    SQLiteDatabase db=getWritableDatabase();
    public DatabaseHelper(Context context) {
        super(context, dbName, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tableName+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,QUESTIONS TEXT,OPTION1 TEXT,OPTION2 TEXT,OPTION3 TEXT, ANSWER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean saveData(Question_Data data){
        ContentValues contentValues=new ContentValues();
        if(this.returnIfExist(data.getQuestion())) {
            // if data already exist do nothing
        }
        else {
            contentValues.put("QUESTIONS", data.getQuestion());
            contentValues.put("OPTION1", data.getOpt1());
            contentValues.put("OPTION2", data.getOpt2());
            contentValues.put("OPTION3", data.getOpt3());
            contentValues.put("ANSWER", data.getAnswer());
        }
        long l= db.insert(tableName,null,contentValues);
        if(l==-1){
            return true;
        }
        else {
            return false;
        }
    }
    /*get list of save data*/
    public List<Question_Data> ReturnList(){
        List<Question_Data> list=new ArrayList();
        String query="SELECT * FROM "+tableName;
        Cursor cursor=db.rawQuery(query,null);
        while (cursor.moveToNext()){
            Question_Data data=new Question_Data(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
            list.add(data);
        }
        Collections.shuffle(list);
        return list;
    }
    /* COUNT ROW IN DATABASE*/
    public int rowCount(){
        String query="SELECT * FROM "+tableName;
        Cursor cursor=db.rawQuery(query,null);
        int row=cursor.getCount();
        return row;
    }

    /* This method return true if data already exist in database*/
    public boolean returnIfExist(String question){
        String query="SELECT * FROM "+tableName+" WHERE QUESTIONS=?";
        Cursor cursor=db.rawQuery(query,new String[]{question});
        if(cursor.getCount()==0){
        return false;
        }
        else{
            return true;
        }
    }
}
