package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    lateinit var adapter: SimpleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var helper = MyHelper(applicationContext)
        db = helper.readableDatabase
        rs = db.rawQuery("Select * From LEARN limit 10", null)
        // sql: String chuỗi câu lệnh SQL
        // String[] selectionArgs: Chọn lọc dữ liệu với điều kiện mảng

        //1. Đưa thử dữ liệu của dòng đầu tiên trong db lên edtUser và edtEmail

//        if (rs.moveToLast()) {
//            binding.edtUser.setText(rs.getString(1))
//            binding.edtEmail.setText(rs.getString(2))
//        }

        binding.btnFirst.setOnClickListener {
            if (rs.moveToFirst()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            } else
                Toast.makeText(applicationContext, "No data found", Toast.LENGTH_SHORT).show()
        }

        binding.btnNext.setOnClickListener {
            if (rs.moveToNext()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            } else if (rs.moveToFirst()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            } else
                Toast.makeText(applicationContext, "No data found", Toast.LENGTH_SHORT).show()
        }

        binding.btnPrev.setOnClickListener {
            if (rs.moveToPrevious()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            } else if (rs.moveToLast()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            } else
                Toast.makeText(applicationContext, "No data found", Toast.LENGTH_SHORT).show()
        }
        binding.btnLast.setOnClickListener {
            if (rs.moveToLast()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            } else
                Toast.makeText(applicationContext, "No data found", Toast.LENGTH_SHORT).show()
        }
        if (rs != null && rs.count > 0) {
            // Tạo danh sách để lưu dữ liệu
            val dataList = mutableListOf<Map<String, String>>()

            // Duyệt qua Cursor và thêm dữ liệu vào danh sách
            rs.moveToFirst()
            do {
                val map = mutableMapOf<String, String>()
                map["_id"] = rs.getString(rs.getColumnIndexOrThrow("_id"))
                map["USER"] = rs.getString(rs.getColumnIndexOrThrow("USER"))
                map["EMAIL"] = rs.getString(rs.getColumnIndexOrThrow("EMAIL"))
                dataList.add(map)
            } while (rs.moveToNext())

            // Tạo SimpleAdapter
            adapter = SimpleAdapter(
                applicationContext,
                dataList,
                android.R.layout.simple_expandable_list_item_2, // Layout
                arrayOf("USER", "EMAIL"), // Tên các khóa trong Map
                intArrayOf(android.R.id.text1, android.R.id.text2) // ID của các TextView
            )

            // Gán adapter cho ListView
            binding.listView.adapter = adapter
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
        }
        binding.btnViewAll.setOnClickListener {
            // Hiển thị SearchView và ListView
            binding.searchView.visibility = View.VISIBLE
            binding.listView.visibility = View.VISIBLE

            // Chạy lại truy vấn để lấy dữ liệu mới nhất
            rs = db.rawQuery("SELECT * FROM LEARN", null)

            // Tạo danh sách mới từ Cursor
            val dataList = mutableListOf<Map<String, String>>()
            if (rs != null && rs.count > 0) {
                rs.moveToFirst()
                do {
                    val map = mutableMapOf<String, String>()
                    map["_id"] = rs.getString(rs.getColumnIndexOrThrow("_id"))
                    map["USER"] = rs.getString(rs.getColumnIndexOrThrow("USER"))
                    map["EMAIL"] = rs.getString(rs.getColumnIndexOrThrow("EMAIL"))
                    dataList.add(map)
                } while (rs.moveToNext())
            }

            // Cập nhật adapter với danh sách mới
            adapter = SimpleAdapter(
                applicationContext,
                dataList,
                android.R.layout.simple_expandable_list_item_2,
                arrayOf("USER", "EMAIL"),
                intArrayOf(android.R.id.text1, android.R.id.text2)
            )

            // Gán adapter mới vào ListView
            binding.listView.adapter = adapter

            // Hiển thị tổng số người dùng
            binding.searchView.queryHint = "Search in ${rs.count} user"
        }


        //search view by content
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Chạy truy vấn
                rs = db.rawQuery(
                    "SELECT * FROM LEARN WHERE USER LIKE '%${newText}%' OR EMAIL LIKE '%${newText}%'",
                    null
                )

                // Chuyển dữ liệu từ Cursor sang List<Map<String, String>>
                val dataList = mutableListOf<Map<String, String>>()
                if (rs != null && rs.count > 0) {
                    rs.moveToFirst()
                    do {
                        val map = mutableMapOf<String, String>()
                        map["USER"] = rs.getString(rs.getColumnIndexOrThrow("USER"))
                        map["EMAIL"] = rs.getString(rs.getColumnIndexOrThrow("EMAIL"))
                        dataList.add(map)
                    } while (rs.moveToNext())
                }

                // Tạo lại SimpleAdapter với dữ liệu mới
                adapter = SimpleAdapter(
                    applicationContext,
                    dataList,
                    android.R.layout.simple_expandable_list_item_2,
                    arrayOf("USER", "EMAIL"),
                    intArrayOf(android.R.id.text1, android.R.id.text2)
                )

                // Cập nhật adapter cho ListView
                binding.listView.adapter = adapter
                return true
            }

        })

        // insert
        binding.btnInsert.setOnClickListener {
            val cv = ContentValues()
            cv.put("USER", binding.edtUser.text.toString())
            cv.put("EMAIL", binding.edtEmail.text.toString())
            db.insert("LEARN", null, cv)

            // Lấy danh sách mới từ cơ sở dữ liệu và cập nhật adapter
            val updatedData = getUpdatedData()
            val from = arrayOf("USER", "EMAIL")
            val to = intArrayOf(R.id.edtUser, R.id.edtEmail)

            val newAdapter = SimpleAdapter(this, updatedData, android.R.layout.simple_expandable_list_item_2, from, to)
            binding.listView.adapter = newAdapter

            val ad = AlertDialog.Builder(this)
            ad.setTitle("Add new user")
            ad.setMessage("Add success")
            ad.setPositiveButton("OK") { dialog, which ->
                binding.edtUser.setText("")
                binding.edtEmail.setText("")
                binding.edtUser.requestFocus()
            }
            ad.show()
        }

        //update
        binding.btnUpdate.setOnClickListener {
            val cv = ContentValues()
            cv.put("USER", binding.edtUser.text.toString())
            cv.put("EMAIL", binding.edtEmail.text.toString())
            db.update("LEARN",  cv,"_id = ?", arrayOf(rs.getString(0)))

            // Lấy danh sách mới từ cơ sở dữ liệu và cập nhật adapter
            val updatedData = getUpdatedData()
            val from = arrayOf("USER", "EMAIL")
            val to = intArrayOf(R.id.edtUser, R.id.edtEmail)

            val newAdapter = SimpleAdapter(this, updatedData, android.R.layout.simple_expandable_list_item_2, from, to)
            binding.listView.adapter = newAdapter

            val ad = AlertDialog.Builder(this)
            ad.setTitle("Update user")
            ad.setMessage("Update success")
            ad.setPositiveButton("OK") { dialog, which ->
                binding.edtUser.setText("")
                binding.edtEmail.setText("")
                binding.edtUser.requestFocus()
            }
            ad.show()
        }

        //clear
        binding.btnClear.setOnClickListener {
            binding.edtUser.setText("")
            binding.edtEmail.setText("")
            binding.edtUser.requestFocus()
        }
        //delete
        binding.btnDelete.setOnClickListener {
            db.delete("LEARN","_id = ?", arrayOf(rs.getString(0)))
            rs.requery()
            //Thong bao
            var ad = AlertDialog.Builder(this)
            ad.setTitle("Delete user")
            ad.setMessage("Delete Success")
            ad.setPositiveButton("OK",{diaglog,which ->
                if(rs.moveToFirst()){
                binding.edtUser.setText("")
                binding.edtEmail.setText("")
                binding.edtUser.requestFocus()}
                else
                {
                binding.edtUser.setText("No data found")
                binding.edtEmail.setText("No data found")

                }
            })
            ad.show()
        }
        registerForContextMenu(binding.listView)


    }

    @SuppressLint("Range")
    fun getUpdatedData(): List<Map<String, String>> {
        val dataList = mutableListOf<Map<String, String>>()
        val cursor = db.rawQuery("SELECT * FROM LEARN", null)
        if (cursor.moveToFirst()) {
            do {
                val map = mapOf(
                    "USER" to cursor.getString(cursor.getColumnIndex("USER")),
                    "EMAIL" to cursor.getString(cursor.getColumnIndex("EMAIL"))
                )
                dataList.add(map)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return dataList
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(100, 11, 1, "Delete")
        menu?.setHeaderTitle("Remove data")
        Toast.makeText(applicationContext, "Context menu created", Toast.LENGTH_SHORT).show() // Thêm log
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val position = info.position // Vị trí của mục được chọn
        val selectedItem = adapter.getItem(position) as Map<String, String> // Lấy dữ liệu của mục được chọn

        // Lấy _id từ selectedItem, đảm bảo rằng bạn sử dụng đúng tên khóa
        val id = selectedItem["_id"] // Sử dụng "USER" nếu "_id" không có sẵn, bạn cần xác định chính xác dữ liệu

        when (item.itemId) {
            11 -> {
                // Xử lý xóa dữ liệu
                if (id != null) {
                    db.delete("LEARN", "_id = ?", arrayOf(id))

                    // Truy vấn lại dữ liệu mới từ cơ sở dữ liệu
                    rs = db.rawQuery("SELECT * FROM LEARN", null) // Cập nhật lại dữ liệu sau khi xóa
                    // Cập nhật lại adapter với dữ liệu mới
                    val updatedData = getUpdatedData()
                    adapter = SimpleAdapter(
                        applicationContext,
                        updatedData,
                        android.R.layout.simple_expandable_list_item_2,
                        arrayOf("USER", "EMAIL"),
                        intArrayOf(android.R.id.text1, android.R.id.text2)
                    )
                    binding.listView.adapter = adapter

                    // Cập nhật SearchView
                    binding.searchView.queryHint = "Search in ${rs.count} user"

                    Toast.makeText(applicationContext, "Data deleted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Invalid item id", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return super.onContextItemSelected(item)
    }



}