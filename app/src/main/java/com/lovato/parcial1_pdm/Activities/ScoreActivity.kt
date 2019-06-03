package com.lovato.parcial1_pdm.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lovato.parcial1_pdm.R
import com.lovato.parcial1_pdm.RoomDatabase.Entities.MatchEntity
import com.lovato.parcial1_pdm.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_new_match.*
import kotlinx.android.synthetic.main.activity_score_match.*

class ScoreActivity : AppCompatActivity(){

    lateinit var matchViewModel: MatchViewModel
    var idMatch: Long = 0
    lateinit var nameA: String
    lateinit var nameB: String
    var scoreA: Int = 0
    var scoreB: Int = 0
    lateinit var dateI: String
    lateinit var timeI: String
    lateinit var match: MatchEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_match)

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        nameA = intent.getStringExtra("nameA")
        nameB = intent.getStringExtra("nameB")
        scoreA = intent.getIntExtra("scoreA",0)
        scoreB = intent.getIntExtra("scoreB",0)
        dateI = intent.getStringExtra("date")
        timeI = intent.getStringExtra("time")

        tv_nameA.text = nameA
        tv_nameB.text = nameB

        displayScore(tv_score_team_a,scoreA)
        displayScore(tv_score_team_b,scoreB)


        bt_finish.setOnClickListener{
            match = MatchEntity(
                   nameA,
                    scoreA,
                    nameB,
                    scoreB,
                    dateI,
                    timeI
            )
            matchViewModel.insertMatch(match)

            startActivity(Intent(this, MainActivity::class.java))
        }


    }

    fun addOneTeamA(v: View) {
        displayScore(
                tv_score_team_a,
                ++scoreA
        )
    }

    fun addOneTeamB(v: View) {
        displayScore(
                tv_score_team_b,
                ++scoreB
        )
    }

    fun addTwoTeamA(v: View) {
        scoreA += 2
        displayScore(
                tv_score_team_a,
                scoreA
        )
    }

    fun addTwoTeamB(v: View) {
        scoreB += 2
        displayScore(
                tv_score_team_b,
                scoreB
        )
    }

    fun addThreeTeamA(v: View) {
        scoreA += 3
        displayScore(
                tv_score_team_a,
                scoreA
        )
    }

    fun addThreeTeamB(v: View) {
        scoreB += 3
        displayScore(
                tv_score_team_b,
                scoreB
        )
    }

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }
}