package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class CopyDbHelper(private val context: Context) {
    companion object

    val db_name = "LearnDataBase.db"
    fun openDataBase(): SQLiteDatabase {
        // val dbFile = context.getDatabasePath("LearnDataBase.db") or
        val dbFile = context.getDatabasePath(db_name)
        val file = File(dbFile.toString())
        if (file.exists()) {
            Log.wtf("DB", dbFile.toString())
            //Do not anything
            Log.e("Learn", "File is existed")

        } else {
            coppyDataBase(dbFile)
        }
        return SQLiteDatabase.openDatabase(dbFile.path, null, SQLiteDatabase.OPEN_READWRITE)
    }

    private fun coppyDataBase(dbFile: File?) {
        val openDb = context.assets.open(db_name)
        val outputStream = FileOutputStream(dbFile)
        val buffer = ByteArray(1024)
        while (openDb.read(buffer) > 0) {
            outputStream.write(buffer)
            Log.wtf("DB", "Writing")
        }
        outputStream.flush()
        outputStream.close()
        openDb.close()
        Log.wtf("DB", "Copy is complete")
    }
}