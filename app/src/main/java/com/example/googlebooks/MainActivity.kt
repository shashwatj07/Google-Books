package com.example.googlebooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    lateinit var searchButton : Button
    lateinit var searchQuery : EditText
    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.a)
        searchQuery = findViewById(R.id.search_query)
        searchButton = findViewById(R.id.search_button)
        var query : String = ""
        val queue = Volley.newRequestQueue(this)
        searchButton.setOnClickListener{
            query = getQuery()
            searchRequest(query, queue)
        }
    }

    fun searchRequest(query : String, queue : RequestQueue) {
        val url = "https://www.googleapis.com/books/v1/volumes?q=" + query
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

    fun getQuery(): String {
        val query : String = searchQuery.getText().toString()
        query.replace(' ', '+')
        return query
    }
}