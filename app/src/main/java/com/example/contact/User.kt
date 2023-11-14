package com.example.contact

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity


data class User(
    
    @PrimaryKey(true)
    val uid:Int=0,
    
    var name:String,
    var phone:String,
    var email:String,
    
)
