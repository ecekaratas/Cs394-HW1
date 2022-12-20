package com.example.recyclerviewexinclass

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewexinclass.databinding.FragmentLoginpageBinding

class BlankActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_layout)}
    ///override fun onCreate(savedInstanceState: Bundle?) {


       /// super.onCreate(savedInstanceState)
        //val binding = DataBindingUtil.inflate<FragmentLoginpageBinding>(inflater, R.layout.item_layout, container, false)

        //setContentView(R.layout.item_layout)

    fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentLoginpageBinding>(inflater, R.layout.item_layout, container, false)

        return binding.root

        // Inflate the layout for this fragment
        /* val binding = DataBindingUtil.inflate<FragmentLoginpageBinding>(inflater, R.layout.item_layout, container, false)
         return binding.root*/
        //return inflater.inflate(R.layout.item_layout, container, false)
    }
}