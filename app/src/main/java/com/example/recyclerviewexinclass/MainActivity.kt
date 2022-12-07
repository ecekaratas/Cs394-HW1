package com.example.recyclerviewexinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

}