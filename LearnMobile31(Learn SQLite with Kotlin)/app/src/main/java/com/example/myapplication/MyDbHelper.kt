package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable

/* ctrl + P để xem hướng dẫn các constructors
name: Chuỗi? : tên của db
factory SQLiteDatabase.CursorFactory?: để sử dụng để tạo ra các đối tượng con trỏ, hoặc null cho mặc định
version Int: số của cơ sở dữ liệu (bắt đầu từ 1);
nếu cơ sở dữ liệu cũ hơn, onUpgrades được sử dụng để nâng cấp cơ sở dữ liệu;
nếu cơ sở dữ liệu mới hơn , onDowngrades được sử dụng để hạ cấp cơ sở dữ liệu
*/
class MyDbHelper(context: Context) : SQLiteOpenHelper(context, "SQLite", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        // Create table
        db?.execSQL(
            "CREATE TABLE USERS_1(USERID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "USERNAME TEXT, PWD TEXT)"
        )
        // Add data
        db?.execSQL("INSERT INTO USERS_1(USERNAME, PWD) VALUES('LONGLE@GMAIL.COM', '123')")
        db?.execSQL("INSERT INTO USERS_1(USERNAME, PWD) VALUES('LONGLE1@GMAIL.COM', '123')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Để trống hoặc thêm logic nâng cấp nếu cần
        // Ví dụ: db?.execSQL("DROP TABLE IF EXISTS USERS_1")
        // Hoặc là thực hiện thay đổi khác với cơ sở dữ liệu
    }
}
