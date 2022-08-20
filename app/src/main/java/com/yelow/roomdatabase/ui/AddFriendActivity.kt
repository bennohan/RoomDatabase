package com.yelow.roomdatabase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.yelow.roomdatabase.R
import com.yelow.roomdatabase.data.Friend
import com.yelow.roomdatabase.data.MyDatabase
import com.yelow.roomdatabase.databinding.ActivityAddFriendBinding
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AddFriendActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddFriendBinding

    var name = ""
    var school = ""
    var hobby = ""

    private lateinit var myDatabase: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_friend)
        binding.activity = this
        myDatabase = MyDatabase.getDatabase(this)
    }

    fun save() {
        if(name.isNotEmpty() && school.isNotEmpty() && hobby.isNotEmpty()) {
            val newFriend = Friend(name, school, hobby)

            Executors.newSingleThreadExecutor().execute {
                myDatabase.friendDao().insert(newFriend)
            }

            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Data belum diisi semua", Toast.LENGTH_SHORT).show()
        }
    }
}