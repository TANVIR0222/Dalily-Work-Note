package com.example.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.databinding.ItemRvBinding

class ContactAdapter (val contactList: List<User>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    
    class ContactViewHolder( var binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root)
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        
        return ContactViewHolder(
            ItemRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        
    }
    
    override fun getItemCount(): Int {
        return contactList.size
        
    }
    
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        contactList[position].let { contact->
        
        holder.binding.apply {
            name.text=contact.name
            email.text=contact.email
            phone.text=contact.phone
        }
        
        }
        
    }
    
}