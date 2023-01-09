package com.example.recyclerviewexinclass

//import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val companys = DataSource(this).loadCompanys()

        val rv: RecyclerView = findViewById(R.id.recyclerView)

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


        //rv.adapter = ItemAdapter(users)
        rv.setHasFixedSize(true)//

    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setActionBar(toolbar)
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
}