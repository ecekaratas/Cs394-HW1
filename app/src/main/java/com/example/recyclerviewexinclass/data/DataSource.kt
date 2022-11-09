package com.example.recyclerviewexinclass.data

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import com.example.recyclerviewexinclass.R
import com.example.recyclerviewexinclass.data.model.User

class DataSource (val context: Context ) {
    fun getUserName(): Array<String> {
        return context.resources.getStringArray(R.array.name_array)
    }
    fun getUserAddress(): Array<String>{
        return context.resources.getStringArray(R.array.address_array)

    }
    fun getUserAge(): Array<String>{
        return context.resources.getStringArray(R.array.age_array)

    }
    fun getUserHobby(): Array<String>{
        return context.resources.getStringArray(R.array.hobby_array)

    }
    fun getUserMail(): Array<String>{
        return context.resources.getStringArray(R.array.mail_array)

    }
    fun getUserImage(): Array<String>{
        return context.resources.getStringArray(R.array.image_array)
        //r.drawable.isim

    }

    fun getProfileDesc(): Array<String>{
        return context.resources.getStringArray(R.array.profiledesc_array)

    }

    fun loadUsers() : List<User>{
        val nameList = getUserName()
        val addrList = getUserAddress()
        val ageList = getUserAge()
        val hobbyList = getUserHobby()
        val mailList = getUserMail()
        val imageList = getUserImage()
        val profileDescList = getProfileDesc()
        var users = mutableListOf<User>()

        for (i in 0..9){
            val user = User(nameList[i], addrList[i], ageList[i], hobbyList[i], mailList[i], imageList[i], profileDescList[i])
            users.add(user)
        }
        return users
    }
}