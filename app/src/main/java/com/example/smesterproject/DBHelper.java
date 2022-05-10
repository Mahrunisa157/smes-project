package com.example.smesterproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    public DBHelper(@Nullable Context context) {
        super(context, "userDatabase1.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table userTable1(Name Text primary key,Password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists userTable1");

    }
    public boolean insertData(String name,String password){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ContentValues value=new ContentValues();
        value.put("Name",name);
        value.put("Password",password);
        Long query=sqLiteDatabase.insert("userTable1",null,value);
        if(query==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean updateData(String name,String password){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put("Password",password);
        Cursor findData=sqLiteDatabase.rawQuery("select * from userTable1 where Name=?",new String[]{name});
        if (findData.getCount()>0){
            int query=sqLiteDatabase.update("userTable1",value,"Name=?",new String[]{name});
            if(query==-1){
                return false;
            }
            else{
                return true;
            }
        }
        else {
            return false;
        }
    }

    public Boolean checkname(String name ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from userTable1 where Name=?",new String[]{name});
        if (cursor.getCount()>0)
            return true;
        else
            return  false;

    }

    public Boolean checkpassword  (String name , String password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from userTable1 where Name=? and Password=?",new String[]{name , password});
        if (cursor.getCount()>0)
            return true;
        else
            return  false;
    }

    public boolean deleteData(String name){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues value=new ContentValues();
        Cursor findDataa=sqLiteDatabase.rawQuery("select * from userTable1 where Name=? ",new String[]{name});
        if (findDataa.getCount()>0){
            int query=sqLiteDatabase.update("userTable1",value,"Name=?",new String[]{name});
            if(query==-1){
                return false;
            }
            else{
                return true;
            }
        }
        else {
            return false;
        }
    }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        Cursor findDataaa=sqLiteDatabase.rawQuery("select * from userTable1",null);
        return findDataaa;
    }
}
