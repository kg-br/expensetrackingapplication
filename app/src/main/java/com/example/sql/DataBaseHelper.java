package com.example.sql;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import static android.icu.text.MessagePattern.ArgType.SELECT;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final  String DATABASE_NAME = "Expenses.db";
    public static final  String TABLE_NAME = "exp_table";




    public static final  String COL_1 = "ID";
    public static final  String COL_2 = "DATE";
    public static final  String COL_3 = "DESCRIPTION";
    public static final  String COL_4 = "MARKS";
    public static final  String COL_5 = "MONTH";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,DESCRIPTION TEXT,MARKS INTEGER,MONTH TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean insertData(String date,String description,String marks,String month){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,description);
        contentValues.put(COL_4,marks);
        contentValues.put(COL_5,month);
        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();

        //To Check Whether Data is Inserted in DataBase
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }




  public boolean updateData(String id,String date,String description,int marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE",date);
        contentValues.put("DESCRIPTION",description);
        contentValues.put("MARKS",marks);
        int result =db.update(TABLE_NAME,contentValues,"ID = ?",new String[]{id});
        return true;
    }




  /* public int updateit(String olddescrip,String newdescrip){
       SQLiteDatabase db=this.getWritableDatabase();
       ContentValues contentValues=new ContentValues();
       contentValues.put(COL_3,newdescrip);
       String[] whereArgs={olddescrip};
       int count=db.update(TABLE_NAME,contentValues,COL_4+"=?",whereArgs);
       return count;

   }*/

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME,null);
        return  res;
    }

    public Cursor getAllDataforpdf()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME,null);
        return  res;
    }


    public Cursor fetchmonthwise() {
         SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = COL_5+"=7";

        //Cursor res = db.rawQuery("Select * from " + TABLE_NAME +  "where"  + whereClause  ,null);
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME+" ORDER BY "+ COL_5 ,null);
        return  res;

        //String[] columnNames = new String[] {COL_1,COL_2,COL_3,COL_4,COL_5};



        //return db.query(TABLE_NAME, columnNames, whereClause, null, null, null, null);
        // String query= "SELECT * FROM exp_table where COL_5=7";

        //String rawQuery = BASE_SELECT_JOIN_EXPENSES_CATEGORIES_QUERY + " WHERE " +
        //EXPENSES_TABLE_NAME + "." + Expenses.DATE + " BETWEEN ? AND ?";

        //Cursor cursor = db.rawQuery("select * from" + TABLE_NAME + "where" + COL_5 = "7", null);
        //return cursor;


        //return db.rawQuery(query, null);

        //SQLiteDatabase db = this.getWritableDatabase();


    }

   public void cleardata(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

        db.close();
   }

    public Cursor sumcol(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT SUM "+(COL_4)+" FROM "+ TABLE_NAME  , null);
        return res;
    }






    }
