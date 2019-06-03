package com.lovato.parcial1_pdm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.lovato.parcial1_pdm.Adapters.MatchAdapter
import com.lovato.parcial1_pdm.R
import com.lovato.parcial1_pdm.RoomDatabase.Entities.MatchEntity
import com.lovato.parcial1_pdm.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var matchViewModel: MatchViewModel
    private lateinit var viewAdapter: MatchAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("**********************************************************")


        action_new_match.setOnClickListener {
            val intent = Intent(this@MainActivity, NewMatchActivity::class.java)
            startActivity(intent)
        }

        initRecycle(emptyList())



        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        matchViewModel.allMatches().observe(this, Observer {
            viewAdapter.dataChange(it)
        })


    }

    fun initRecycle(books: List<MatchEntity>) {
        viewManager = LinearLayoutManager(this)


        viewAdapter = MatchAdapter(books, { bookitem: MatchEntity -> bookItemClicked(bookitem) })

        match_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun bookItemClicked(item: MatchEntity) {

        val extras = Bundle()
        extras.putLong("id_match", item.id_match)
        startActivity(Intent(this, MatchInfo::class.java).putExtras(extras))

    }

}
