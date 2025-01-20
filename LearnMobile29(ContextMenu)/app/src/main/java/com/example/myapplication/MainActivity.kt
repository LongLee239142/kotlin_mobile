package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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

        //Đăng ký menu ngữ cảnh
        registerForContextMenu(binding.txtContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // add(int groupId, int itemTd, int order, CharSequence title)
        menu?.add(1, 1, 3, "Red")
        menu?.add(1, 2, 2, "Green")
        menu?.add(1, 3, 1, "Black")
        /*
        1. group: id của group menu
        2. itemId: id của item trong menu
        3. order: thứ tự của item trong menu
        4. CharSequence: tiêu đề của item trong menu
         */

        //sub menu
        var subMenu = menu?.addSubMenu("Gender")
        subMenu?.add(2, 21, 1, "Male")/*?.setChecked(true)*/
        subMenu?.add(2, 22, 2, "Female")

        /* setGroupCheckable(int group, boolean checkable, boolean exclusive)
        1. group : id của group muốn có nút check
        2. boolean: true để cho phép dấu kiểm,
        fasle thành không cho phép. Mặc định sẽ là false
        3. chọn true chỉ được chọn 1 item trong group
        Chọn false tích chọn được nhiều lựa chọn

         */
        subMenu?.setGroupCheckable(2, true, true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 ->{binding.txtOption.setTextColor(Color.RED)}
            2 ->{binding.txtOption.setTextColor(Color.GREEN)}
            3 ->{binding.txtOption.setTextColor(Color.BLACK)}
            //Tương tác với sub menu
            21->{binding.txtOption.setText("Male")}
            22->{binding.txtOption.setText("Female")}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu?.add(3,31,1,"Red")
        menu?.add(3,32,2,"Green")
        menu?.add(3,33,3,"Black")
        menu?.setHeaderTitle("Please choose color")
        super.onCreateContextMenu(menu, v, menuInfo)
    }
    // xử lý sự kiện context menu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            31 ->{binding.txtContext.setTextColor(Color.RED)}
            32 ->{binding.txtContext.setTextColor(Color.GREEN)}
            33 ->{binding.txtContext.setTextColor(Color.BLACK)}
        }
        return super.onContextItemSelected(item)
    }
}