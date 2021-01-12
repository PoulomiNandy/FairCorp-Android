package com.poulomi.faircorpapp

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poulomi.faircorpapp.model.OnWindowSelectedListener
import com.poulomi.faircorpapp.service.WindowService
import com.poulomi.faircorpapp.model.WindowsAdapterView

class WindowsList : BasicActivity (), OnWindowSelectedListener{

    val windowService = WindowService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_windows_list)
        val recyclerView = findViewById<RecyclerView>(R.id.list_windows) // (2)
        val adapter = WindowsAdapterView.WindowAdapter(this) // (3)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        adapter.update(windowService.findAll()) // (4)
    }
    override fun onWindowSelected(id: Long) {
        System.out.println("!ID: "+id)
        val intent = Intent(this, WindowActivity::class.java).apply {
            putExtra(WINDOW_NAME_PARAM, id)
        }

        val ids = intent.getLongExtra(WINDOW_NAME_PARAM, 0)
        System.out.println("!ID: "+ids)
        startActivity(intent)

    }
}
