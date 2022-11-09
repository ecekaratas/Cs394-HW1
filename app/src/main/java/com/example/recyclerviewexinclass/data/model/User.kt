package com.example.recyclerviewexinclass.data.model

import android.media.Image

data class User (val name : String, val address : String,
                 val age : String, val hobby : String, val mail : String,
                 val image : String,
                 val profileDesc : String): java.io.Serializable {
}