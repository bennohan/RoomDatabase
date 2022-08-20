package com.yelow.roomdatabase.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yelow.roomdatabase.R
import com.yelow.roomdatabase.data.MyDatabase
import com.yelow.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myDatabase: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        myDatabase = MyDatabase.getDatabase(this)

        myDatabase.friendDao().getAll().observe(this) {
            binding.rvFriend.adapter = FriendAdapter(it)
        }
    }

    fun addFriend() {
        startActivity(Intent(this, AddFriendActivity::class.java))
    }
}