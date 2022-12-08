package com.example.recyclerviewexinclass.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexinclass.R
import com.example.recyclerviewexinclass.CompanyDetailActivity
import com.example.recyclerviewexinclass.data.model.Company

class ItemAdapter ( private val dataset : List<Company>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val restaurantsView = view.findViewById<TextView>(R.id.restaurantsView)
        val menuuView = view.findViewById<TextView>(R.id.menuuView)
        val priceView = view.findViewById<TextView>(R.id.priceView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        lateinit var company: Company

        init {
            view.setOnClickListener{
                //
                val showDetailIntent = Intent(itemView.context, CompanyDetailActivity::class.java)
                showDetailIntent.putExtra(COMPANY_KEY, company)
                itemView.context.startActivity(showDetailIntent)
            }
        }

        companion object{
            private val COMPANY_KEY = "COMPANY"
        }
        fun bind(company: Company){
            this.company = company
            restaurantsView.text = company.restaurant
            menuuView.text = company.menuu
            priceView.text = company.price

            imageView.setImageResource(company.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemAdapter.ItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val company = dataset[position]
       holder.restaurantsView.text = company.restaurant

        holder.bind(company)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}