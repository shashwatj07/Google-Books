package com.example.googlebooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONObject


class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        val bookString:String? = getIntent().getStringExtra("JSONString")
//        val book:JSONObject=JSONObject(getIntent().getStringExtra("JSONString"))
        val textView: TextView = findViewById(R.id.textView)
        textView.text = ""+bookString
    }
}