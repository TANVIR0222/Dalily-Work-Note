package com.example.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.contact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityMainBinding
    lateinit var db:AppDatabase
    lateinit var adapter: ContactAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        
        binding=ActivityMainBinding.inflate(layoutInflater)
        
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
        
        setDataToUi()
        
        
        binding.button.setOnClickListener{
            val name= binding.name.text.toString().trim()
            val email= binding.email.text.toString().trim()
            val phone= binding.phone.text.toString().trim()
            
            
            var user=User(name = name , email = email, phone = phone)
            
            db.userDao().insert(user)
            setDataToUi()
        }
        
        
    
    }
    
    private fun setDataToUi(){
        
            adapter=ContactAdapter(db.userDao().getAll())
            binding.contactRcv.adapter =adapter
    
    }
}