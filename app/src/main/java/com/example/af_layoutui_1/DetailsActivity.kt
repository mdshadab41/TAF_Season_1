package com.example.af_layoutui_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val textView: TextView = findViewById(R.id.textView)
        val titleFromOtherActivity = intent.getStringExtra("title") ?: "No Title"
        textView.text = titleFromOtherActivity



    }
}