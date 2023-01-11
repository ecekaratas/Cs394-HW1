package com.example.recyclerviewexinclass

//import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewexinclass.authentication.CreateAccountFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        selectDrawerItem(item)
        return true
    }

    fun selectDrawerItem(menuItem: MenuItem) {
        var fragment: Fragment
        when (menuItem.itemId) {
            R.id.settings -> {
                fragment = SettingsFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.settings, fragment)
                    .commit()
            }
            R.id.sign_out -> {
                fragment = SettingsFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.settings, fragment)
                    .commit()
            }
            R.id.profile -> {
                fragment = SettingsFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.settings, fragment)
                    .commit()

            }
            else -> {
                fragment = CreateAccountFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.settings, fragment)
                    .commit()
            }
        }
    }*/
}



