package com.lovato.parcial1_pdm.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lovato.parcial1_pdm.R
import com.lovato.parcial1_pdm.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_score_match.*

class ScoreActivity : AppCompatActivity(){

    lateinit var matchViewModel: MatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_match)

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)


        matchViewModel.getMatchById(intent.getLongExtra("id_match",0)).observe(this, Observer { match->

            displayScore(tv_score_team_a,match.scoreTeamA)
            displayScore(tv_score_team_b,match.scoreTeamB)
            tv_nameA.text = match.nameTeamA
            tv_nameB.text = match.nameTeamB
        })

    }


    fun addOneTeamA(v: View) {
        displayScore(
                tv_score_team_a,
                ++scoreViewModel.scoreTeamA
        )
    }

    fun addOneTeamB(v: View) {
        displayScore(
                tv_score_team_b,
                ++scoreViewModel.scoreTeamB
        )
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        displayScore(
                tv_score_team_a,
                scoreViewModel.scoreTeamA
        )
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        displayScore(
                tv_score_team_b,
                scoreViewModel.scoreTeamB
        )
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        displayScore(
                tv_score_team_a,
                scoreViewModel.scoreTeamA
        )
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        displayScore(
                tv_score_team_b,
                scoreViewModel.scoreTeamB
        )
    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamA = 0
        scoreViewModel.scoreTeamB = 0

        displayScore(
                tv_score_team_a,
                scoreViewModel.scoreTeamA
        )

        displayScore(
                tv_score_team_b,
                scoreViewModel.scoreTeamB
        )
    } // TODO: Limpiando datos

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }
}