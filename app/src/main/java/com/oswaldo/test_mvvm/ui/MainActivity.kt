package com.oswaldo.test_mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oswaldo.test_mvvm.R
import com.oswaldo.test_mvvm.adapters.rooms.RoomsAdapter
import com.oswaldo.test_mvvm.data.Restroom
import com.oswaldo.test_mvvm.viewmodel.rooms.RoomsViewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    var rvRooms: RecyclerView? = null
    var roomsAdapter: RoomsAdapter? = null
    var roomList: ArrayList<Restroom> = ArrayList()
    var roomsViewModel: RoomsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        roomsViewModel = ViewModelProviders.of(this).get<RoomsViewModel>(RoomsViewModel::class.java)
        roomsViewModel!!.init()
        roomsViewModel!!.roomsRepository!!.observe(this, Observer { data ->
            roomList.addAll(data)
            roomsAdapter!!.notifyDataSetChanged()
        })
    }

    private fun setupRecyclerView() {
        if (roomsAdapter == null) {
            roomsAdapter = RoomsAdapter( this, roomList)
            rvRooms = findViewById(R.id.rvRooms);
            rvRooms!!.layoutManager = LinearLayoutManager(this)
            rvRooms!!.adapter = roomsAdapter
        } else {
            roomsAdapter!!.notifyDataSetChanged()
        }
    }

}
