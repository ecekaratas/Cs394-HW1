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
    fun getUserFav(): Array<String>{
        return context.resources.getStringArray(R.array.fav_array)

    }

    fun getUserImages(): IntArray {
        return context.resources.getIntArray(R.array.image_array)

    }
    fun getUserImages2(): Array<Int> {
        val images = arrayOf<Int> (R.drawable.snob, R.drawable.hotslice, R.drawable.manakin, R.drawable.lokal,
        R.drawable.hv, R.drawable.subway, R.drawable.dane, R.drawable.rumeli)
        return images;

    }


    fun loadCompanys() : List<Company>{
        val restaurantsList = getUserrestaurants()
        val menuuList = getUserMenuu()
        val priceList = getUserPrice()
        val favList = getUserFav()
        val imageList = getUserImages()




        var companies = mutableListOf<Company>()

        for (i in 0..7){

            val company = Company(restaurantsList[i], menuuList[i], priceList[i], getUserImages2()[i], getUserFav()[i])
            companies.add(company)
        }
        return companies
    }
}



