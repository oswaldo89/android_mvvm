package com.oswaldo.test_mvvm.viewmodel.rooms

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oswaldo.test_mvvm.data.Restroom
import com.oswaldo.test_mvvm.network.room.RoomsRepository
import java.util.*

class RoomsViewModel : ViewModel() {
    var roomsRepository: MutableLiveData<ArrayList<Restroom>>? = null
        private set

    fun init() {
        if (roomsRepository != null) {
            return
        }
        val roomsRepository = RoomsRepository.getInstance()
        this.roomsRepository = roomsRepository.data
    }

}