package com.lovato.parcial1_pdm.RoomDatabase.Entities

import androidx.room.*

@Entity(tableName = "MatchTable")
data class MatchEntity(
    @ColumnInfo(name = "m_name_teama")
    val nameTeamA: String,
    @ColumnInfo(name = "m_score_teama")
    var scoreTeamA: Int,
    @ColumnInfo(name = "m_name_teamb")
    val nameTeamB: String,
    @ColumnInfo(name = "m_score_teamb")
    var scoreTeamB: Int,
    @ColumnInfo(name = "m_date")
    val date: String,
    @ColumnInfo(name = "m_time")
    val time: String
){

    @PrimaryKey(autoGenerate = true)
    var id_match: Long = 0
}