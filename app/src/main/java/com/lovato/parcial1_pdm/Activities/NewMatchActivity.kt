package com.lovato.parcial1_pdm.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.lovato.parcial1_pdm.R
import com.lovato.parcial1_pdm.RoomDatabase.Entities.MatchEntity
import com.lovato.parcial1_pdm.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_new_match.*


class NewMatchActivity : AppCompatActivity() {

    lateinit var matchViewModel: MatchViewModel
    lateinit var match: MatchEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_match)

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        bt_iniciar.setOnClickListener{

            var date = "${et_dia.text}/${et_mes.text}/${et_anio.text}"
            var time = "${et_hora.text}:${et_minutos.text}"

            match = MatchEntity(
                    et_nameA.text.toString(),
                    0,
                    et_nameB.text.toString(),
                    0,
                    date,
                    time
            )

            startActivity(Intent(this, ScoreActivity::class.java)
                    .putExtra("nameA",match.nameTeamA)
                    .putExtra("nameB",match.nameTeamB)
                    .putExtra("scoreA",match.scoreTeamA)
                    .putExtra("scoreB",match.scoreTeamB)
                    .putExtra("date",match.date)
                    .putExtra("time",match.time))
        }
    }


}
