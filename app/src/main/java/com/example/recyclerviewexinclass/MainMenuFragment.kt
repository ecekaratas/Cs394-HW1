package com.example.recyclerviewexinclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recyclerviewexinclass.databinding.FragmentMainmenuBinding

class MainMenuFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainmenuBinding>(inflater, R.layout.fragment_mainmenu, container, false)
        return binding.root
    }
}