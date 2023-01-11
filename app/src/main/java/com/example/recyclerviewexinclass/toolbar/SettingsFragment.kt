package com.example.recyclerviewexinclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewexinclass.databinding.FragmentMainScreenBinding


class SettingsFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  binding : FragmentMainScreenBinding
                = DataBindingUtil.inflate(
            inflater, R.layout.settings, container, false)

        binding.
        seeListBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
        }

        return binding.root
    }
}