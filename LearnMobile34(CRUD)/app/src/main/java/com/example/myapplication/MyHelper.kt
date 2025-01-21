package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(contex: Context) : SQLiteOpenHelper(contex, "LearnMobile", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        //Create table, colum
        db?.execSQL("CREATE TABLE LEARN(_id INTEGER PRIMARY KEY AUTOINCREMENT, USER TEXT, EMAIL TEXT )")
        // Add data into database
        db?.execSQL("INSERT INTO LEARN(USER,EMAIL) VALUES('first','first@gmail.com')")
        db?.execSQL("INSERT INTO LEARN(USER,EMAIL) VALUES('second','second@gmail.com')")
        db?.execSQL("INSERT INTO LEARN(USER,EMAIL) VALUES('third','third@gmail.com')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}