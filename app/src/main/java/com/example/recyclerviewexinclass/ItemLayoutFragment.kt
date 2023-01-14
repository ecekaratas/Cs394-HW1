package com.example.recyclerviewexinclass

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewexinclass.R
import com.example.recyclerviewexinclass.databinding.FragmentBlankBinding
import com.example.recyclerviewexinclass.databinding.FragmentLoginpageBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ItemLayoutFragment : Fragment() {
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  binding : FragmentBlankBinding
                = DataBindingUtil.inflate(
            inflater, R.layout.item_layout, container, false)

        binding.button_comment.setOnClickListener {
            this.findNavController().navigate(R.id.action_itemLayoutFragment_to_listFragment)
        }
        return binding.root
    }



}
