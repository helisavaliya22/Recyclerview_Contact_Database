package com.example.recyclerview_contact_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class My_Database extends SQLiteOpenHelper {
    public My_Database(Context context) {
        super(context, "Contacts_DB", null, 1);
        Log.d("AAA", "My_Database: Create Database");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table ContactData(ID integer primary key autoincrement,NAME text,SURNAME text,NUMBER text, IMGURI text)";
        db.execSQL(query);
        Log.d("AAA", "onCreate: Create table");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor showdata() {
        String query = "select * from ContactData";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public void addContacts(String name, String surname, String number, Uri imageUri) {
        String query = "insert into ContactData(NAME,SURNAME,NUMBER,IMGURI)values('" + name + "','" + surname + "','" + number + "','"+imageUri+"')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }

    public void updateContact(int id, String name, String surname, String number) {
        String query = "update ContactData set NAME='"+name+"',SURNAME='"+surname+"',NUMBER='"+number+"'where ID="+id+"";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }

    public void deleteData(int id) {
        String query = "delete from ContactData where ID="+id+"";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }
}
