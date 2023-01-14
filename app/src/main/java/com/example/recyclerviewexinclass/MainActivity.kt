package com.example.recyclerviewexinclass

//import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import com.example.recyclerviewexinclass.authentication.CreateAccountFragment
import com.example.recyclerviewexinclass.databinding.ActivityCompanyDetailBinding
import com.example.recyclerviewexinclass.databinding.FragmentMainScreenBinding
import com.example.recyclerviewexinclass.databinding.FragmentMainScreenBindingImpl
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    //private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //navController = findNavController(R.id.navigation)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.settings -> {
                Toast.makeText(this,"Settings",Toast.LENGTH_LONG).show()
                setContentView(R.layout.settings)
                return true
            }
            R.id.sign_out -> {
                Toast.makeText(this,"You clicked me",Toast.LENGTH_LONG).show()
                setContentView(R.layout.fragment_main_screen)
                return true
            }
            R.id.profile -> {
                Toast.makeText(this,"Profile",Toast.LENGTH_LONG).show()
                setContentView(R.layout.profile)
                return true
            }
            else->super.onOptionsItemSelected(item)
        }

    }
    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                navController.navigate(R.id.settingsFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }*/

    //.setOnNavigationItemSelectedListener
    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                // Handle the settings button click
                findNavController().navigate(R.id.settingsFragment)
                // this.findNavController().navigate(action_mainFragment_to_settingsFragment)
                return true
            }
        }/*
            R.id.action_fragment_2 -> {
                val fragment2 = Fragment2()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .addToBackStack(null)
                    .commit()
                return true
            }*/
            else -> return super.onOptionsItemSelected(item)
        }
    }
*/
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



