package com.example.recyclerviewexinclass.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexinclass.R
import com.example.recyclerviewexinclass.UserDetailActivity
import com.example.recyclerviewexinclass.data.model.User

class ItemAdapter ( private val dataset : List<User>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val nameView= view.findViewById<TextView>(R.id.nameView)
        val addrView= view.findViewById<TextView>(R.id.addressView)
        val ageView= view.findViewById<TextView>(R.id.ageView)
        val hobbyView= view.findViewById<TextView>(R.id.hobbyView)
        val mailView= view.findViewById<TextView>(R.id.mailView)
        //val imageView= view.findViewById<TextView>(R.id.imageView)

        lateinit var user: User

        init {
            view.setOnClickListener{
                //
                val showDetailIntent = Intent(itemView.context, UserDetailActivity::class.java)
                showDetailIntent.putExtra(USER_KEY, user)
                itemView.context.startActivity(showDetailIntent)
            }
        }

        companion object{
            private val USER_KEY = "USER"
        }
        fun bind(user: User){
            this.user = user
            nameView.text = user.name
            addrView.text = user.address
            ageView.text = user.age
            hobbyView.text = user.hobby
            //imageView.text = user.image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemAdapter.ItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val user = dataset[position]
        //holder.imageView.setImageResource(item.imageResourceId)
//        holder.nameView.text = user.name
//        holder.addrView.text = user.address

        holder.bind(user)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}