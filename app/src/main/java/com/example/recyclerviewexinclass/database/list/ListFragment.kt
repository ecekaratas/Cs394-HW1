package com.example.recyclerviewexinclass.database.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexinclass.R
import com.example.recyclerviewexinclass.database.CommentViewModel
import com.example.recyclerviewexinclass.databinding.FragmentBlankBinding
import com.example.recyclerviewexinclass.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.view.*

//import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var mCommentViewModel: CommentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  binding : FragmentListBinding
                = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false)
        //val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        mCommentViewModel = ViewModelProvider(this).get(CommentViewModel::class.java)
        mCommentViewModel.readAllData.observe(viewLifecycleOwner, Observer {it?.let {
            adapter.submitList(it)
        }})
        binding.lifecycleOwner = this


        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root
    }

}