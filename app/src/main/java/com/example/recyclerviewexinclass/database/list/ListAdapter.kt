package com.example.recyclerviewexinclass.database.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexinclass.R
import com.example.recyclerviewexinclass.database.Comment
import kotlinx.android.synthetic.main.custom_row.view.*


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var commentList = emptyList<Comment>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = commentList[position]
        holder.itemView.uid_txt.text = currentItem.uid.toString()
        holder.itemView.firstName_txt.text = currentItem.firstName
        holder.itemView.lastName_txt.text = currentItem.lastName

    }

    fun setData(comment: List<Comment>){
        this.commentList = comment
        notifyDataSetChanged()
    }
}