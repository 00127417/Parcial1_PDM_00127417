package com.lovato.parcial1_pdm.RoomDatabase.Daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lovato.parcial1_pdm.RoomDatabase.Entities.MatchEntity

@Dao
interface MatchDao {

    @Query("SELECT * FROM  MatchTable")
    fun getAll(): LiveData<List<MatchEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(match: MatchEntity)

    @Query("SELECT * FROM MatchTable WHERE id_match = :id")
    fun getMatchById(id: Long): LiveData<MatchEntity>

    @Query("DELETE FROM MatchTable")
    fun nukeTable()
}