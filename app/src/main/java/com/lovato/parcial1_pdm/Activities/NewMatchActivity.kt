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

        var date = "${et_dia.text}/${et_mes}/${et_anio}"
        var time = "${et_hora.text.toString()}:${et_minutos.text.toString()}"

        bt_iniciar.setOnClickListener{
            match = MatchEntity(
                    et_nameA.text.toString(),
                    0,
                    et_nameB.text.toString(),
                    0,
                    date,
                    time
            )
            matchViewModel.insertMatch(match)

            val extras = Bundle()
            extras.putLong("id_match",match.id_match)
            startActivity(Intent(this, ScoreActivity::class.java).putExtra("id",match.id_match))
        }
    }


}
