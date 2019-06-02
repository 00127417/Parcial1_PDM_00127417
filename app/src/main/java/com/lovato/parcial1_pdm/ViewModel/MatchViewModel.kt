package com.lovato.parcial1_pdm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.lovato.parcial1_pdm.Repository.MatchRepository
import com.lovato.parcial1_pdm.RoomDatabase.Entities.MatchEntity
import com.lovato.parcial1_pdm.RoomDatabase.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchViewModel(application: Application): AndroidViewModel(application){
    private val repository: MatchRepository

    init {
        val matchDao = RoomDB.getInstance(application).matchDao()
        repository = MatchRepository(matchDao)
    }

    fun allMatches() = repository.allMatch()

    fun getMatchById(id: Long) =repository.getMatchById(id)

    fun nuke() = repository.nuke()

    fun insertMatch(match: MatchEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertMatch(match)
    }
}