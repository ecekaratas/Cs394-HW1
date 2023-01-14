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
import com.example.recyclerviewexinclass.databinding.CustomRowBinding
import com.example.recyclerviewexinclass.databinding.FragmentListBinding
import com.example.recyclerviewexinclass.databinding.FragmentListBindingImpl
import kotlinx.android.synthetic.main.custom_row.view.*


class ListAdapter: ListAdapter<Comment, ListAdapter.MyViewHolder>(MyListDiffCallBack()){

    class MyViewHolder(val binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root) {

        val commentUID: TextView = binding.commentUID

        companion object{
            fun from(parent: ViewGroup): MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CustomRowBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
        fun bind(comment: Comment){
            commentUID.text = comment.uid.toString()
            binding.comment = comment
        }}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
            return MyViewHolder.from(parent)
        }
        override fun onCreateViewHolder(holder: MyViewHolder, position: Int){
            val currentItem = getItem(position)
            holder.bind(currentItem)
        }
    }

    class MyListDiffCallBack : DiffUtil.ItemCallback<Comment>(){
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }
    }
}
/*
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
}*/