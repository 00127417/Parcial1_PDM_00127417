package com.lovato.parcial1_pdm.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lovato.parcial1_pdm.R
import com.lovato.parcial1_pdm.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_match.*


class MatchInfo : AppCompatActivity(){

    lateinit var matchViewModel: MatchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        matchViewModel.getMatchById(intent.getLongExtra("id_match",0)).observe(this, Observer {match->
            tv_nameA_am.text = match.nameTeamA
            tv_nameB_am.text = match.nameTeamB
            tv_scoreA_am.text = match.scoreTeamA.toString()
            tv_scoreB_am.text = match.scoreTeamB.toString()
            tv_date_am.text = match.date
            tv_time_am.text = match.time
            tv_winner.text = when{
                match.scoreTeamA>match.scoreTeamB -> match.nameTeamA
                match.scoreTeamB>match.scoreTeamA -> match.nameTeamB
                else -> "Empate"
            }

        })

    }
}
