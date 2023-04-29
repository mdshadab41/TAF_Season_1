package com.example.af_layoutui_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val titleTextView: TextView = findViewById(R.id.tvTitle)
//        val learMoreButton: Button = findViewById(R.id.btnLearnMore)
//        learMoreButton.setOnClickListener{
//            val title = titleTextView.text
//            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
//            intent.putExtra("title", title)
//            startActivity(intent)
//        }

        val dataForAdapter = ArrayList<String>()
        repeat(150) {index ->
            dataForAdapter.add("Elements $index")
        }

        val recylerView: RecyclerView = findViewById(R.id.recyclerView)
        val simpleAdapter = SimpleAdapter()
        simpleAdapter.setData(dataForAdapter, "soccer stuff")
        //recylerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        recylerView.adapter = simpleAdapter
        simpleAdapter.notifyDataSetChanged()

        


    }
}