package com.lovato.parcial1_pdm.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lovato.parcial1_pdm.RoomDatabase.Daos.MatchDao
import com.lovato.parcial1_pdm.RoomDatabase.Entities.MatchEntity

@Database(entities = [MatchEntity::class],version = 1, exportSchema = false)
public abstract class RoomDB: RoomDatabase(){

    abstract fun matchDao(): MatchDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Matches_Database")
                    .build()
                INSTANCE=instance
                return instance
            }

        }

    }
}