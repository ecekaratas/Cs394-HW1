package com.example.recyclerviewexinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewexinclass.databinding.ActivityUserDetailBinding
import com.example.recyclerviewexinclass.data.model.User

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_user_detail)
        val binding : ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        val selectedUser = intent.getSerializableExtra("USER") as User
        binding.user = selectedUser
    }
}