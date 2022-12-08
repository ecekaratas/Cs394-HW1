package com.example.recyclerviewexinclass.data

import android.content.Context
import com.example.recyclerviewexinclass.R
import com.example.recyclerviewexinclass.data.model.Company

class DataSource (val context: Context ) {
    fun getUserrestaurants(): Array<String> {
        return context.resources.getStringArray(R.array.restaurants_array)
    }
    fun getUserMenuu(): Array<String>{
        return context.resources.getStringArray(R.array.menuu_array)

    }
    fun getUserPrice(): Array<String>{
        return context.resources.getStringArray(R.array.price_array)

    }

    fun getUserImages(): IntArray {
        return context.resources.getIntArray(R.array.image_array)

    }


    fun loadCompanys() : List<Company>{
        val restaurantsList = getUserrestaurants()
        val menuuList = getUserMenuu()
        val priceList = getUserPrice()
        val imageList = getUserImages()

        val arrayname = arrayOf(R.drawable.snob, R.drawable.snob, R.drawable.snob, R.drawable.snob, R.drawable.snob, R.drawable.snob, R.drawable.snob, R.drawable.harvest)

        var companies = mutableListOf<Company>()

        for (i in 0..7){
           
            val company = Company(restaurantsList[i], menuuList[i], priceList[i], arrayname[i])
            println("sa" + getUserImages() + "as" + arrayname[i])
            companies.add(company)
        }
        return companies
    }
}


