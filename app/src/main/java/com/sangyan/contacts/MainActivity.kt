package com.sangyan.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangyan.contacts.databinding.ActivityCreateContactBinding
import com.sangyan.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel : ContactViewModel  by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this , CreateContact::class.java)
            startActivity(intent)
        }
        viewModel.getAllContacts().observe(this , Observer {  list->
         binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
         binding.recyclerView.adapter = ContactsAdapter(this,list)
        })
    }
}