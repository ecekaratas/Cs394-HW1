package com.example.recyclerviewexinclass

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexinclass.adapter.ItemAdapter
import com.example.recyclerviewexinclass.data.DataSource
import com.example.recyclerviewexinclass.data.model.Users
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BlankFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val companys = DataSource(view.context).loadCompanys()
        val rv: RecyclerView = view.findViewById(R.id.recyclerView)
        rv.adapter = ItemAdapter(companys)
        rv.setHasFixedSize(true)
    }
}
