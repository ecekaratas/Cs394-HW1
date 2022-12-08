package com.example.recyclerviewexinclass

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexinclass.adapter.ItemAdapter
import com.example.recyclerviewexinclass.data.DataSource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val companys = DataSource(this).loadCompanys()

        val rv :RecyclerView = findViewById(R.id.recyclerView)

        rv.adapter = ItemAdapter(companys)
        rv.setHasFixedSize(true)
        val actionBar: ActionBar?
        actionBar = supportActionBar

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        val colorDrawable = ColorDrawable(Color.parseColor("#FFA30050"))

        // Set BackgroundDrawable

        // Set BackgroundDrawable
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable)
        }

        rv.adapter = ItemAdapter(users)
        rv.setHasFixedSize(true)//

    }

}