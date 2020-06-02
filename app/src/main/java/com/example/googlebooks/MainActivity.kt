package com.example.googlebooks

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.a)
        val queue = Volley.newRequestQueue(this)
        //val queue = Volley.newRequestQueue(activity as Context)

        val url = "https://www.googleapis.com/books/v1/volumes?q=search+terms"

        val stringRequest = object:StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: " + response
            },
            Response.ErrorListener { textView.text = "That didn't work!" }){
            override fun getHeaders(): MutableMap<String, String> {
                val headers=HashMap<String,String>()
                headers["Content-type"]="application/json"
                return headers
            }
        }

        queue.add(stringRequest)
    }
}