package com.example.googlebooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        val bookString:String? = getIntent().getStringExtra("JSONString")
        val book:JSONObject=JSONObject(bookString)
        val volumeInfo:JSONObject = book.getJSONObject("volumeInfo")
        setTitle(volumeInfo.getString("title"))
        val title:TextView = findViewById(R.id.title)
        val subtitle:TextView = findViewById(R.id.subtitle)
        val authors:TextView = findViewById(R.id.authors)
        val description:TextView = findViewById(R.id.description)
        val pages:TextView = findViewById(R.id.pages)
        val publisher:TextView = findViewById(R.id.publisher)
        val publishDate:TextView = findViewById(R.id.publishDate)
        val averageRating:TextView = findViewById(R.id.averageRating)
        title.text=volumeInfo.getString("title")
        try {
            subtitle.text=volumeInfo.getString("subtitle")
        }
        catch (e:JSONException){
        }
        try {
            val authorsArray:JSONArray=volumeInfo.getJSONArray("authors")
            var authorsList:String=""
            for(i in 0..authorsArray.length()-1){
                authorsList+=authorsArray[i].toString()+", "
            }
            authorsList=authorsList.substring(0,authorsList.length-2)
            authors.text=authorsList
        }
        catch (e:JSONException){
        }
        try {
            description.text= Html.fromHtml(volumeInfo.getString("description"))
//            description.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }
        catch (e:JSONException){
        }
        try {
            pages.text="Number of Pages: "+volumeInfo.getString("pageCount").toString()
        }
        catch (e:JSONException){
        }
        try {
            publisher.text="Publisher: "+volumeInfo.getString("publisher")
        }
        catch (e:JSONException){
        }
        try {
            publishDate.text="Date of Publishing: "+volumeInfo.getString("publishedDate")
        }
        catch (e:JSONException){
        }
        try {
            averageRating.text="Average Rating: "+volumeInfo.getString("averageRating")
        }
        catch (e:JSONException){
        }
    }
}