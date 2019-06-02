package com.lovato.parcial1_pdm.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.lovato.parcial1_pdm.RoomDatabase.Daos.MatchDao
import com.lovato.parcial1_pdm.RoomDatabase.Entities.MatchEntity

class MatchRepository (private val matchDao: MatchDao){

    fun allMatch(): LiveData<List<MatchEntity>> = matchDao.getAll()

    fun getMatchById(id: Long) = matchDao.getMatchById(id)

    fun nuke() = matchDao.nukeTable()

    @WorkerThread
    suspend fun insertMatch(matchEntity: MatchEntity){
        matchDao.insert(matchEntity)
    }
}