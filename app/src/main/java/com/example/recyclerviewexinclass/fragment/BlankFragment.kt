package com.example.recyclerviewexinclass.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexinclass.adapter.ItemAdapter
import com.example.recyclerviewexinclass.data.DataSource
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewexinclass.R
import com.example.recyclerviewexinclass.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val  binding : FragmentBlankBinding
                = DataBindingUtil.inflate(
            inflater, R.layout.fragment_blank, container, false)

        binding.buttonComment.setOnClickListener {
            this.findNavController().navigate(R.id.action_itemLayoutFragment_to_listFragment)
        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val companys = DataSource(view.context).loadCompanys()
        val rv: RecyclerView = view.findViewById(R.id.recyclerView)
        rv.adapter = ItemAdapter(companys)
        rv.setHasFixedSize(true)
    }
}
