package com.example.recyclerviewexinclass

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.recyclerviewexinclass.database.Comment

@BindingAdapter("restoranImage")
fun ImageView.setPlantImage(item: Comment){
    setImageResource(
        when (item.uid.toInt() % 8) {
            0 -> R.drawable.r4
            1 -> R.drawable.r2
            2 -> R.drawable.hv
            3 -> R.drawable.r1
            4 -> R.drawable.r3
            5 -> R.drawable.r5
            6 -> R.drawable.r6

            else -> R.drawable.r7
        })
}