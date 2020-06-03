package com.example.googlebooks

public class Model{
    lateinit var id:String
    lateinit var selfLink:String
    lateinit var title:String
    var subtitle:String? = null
    var authors:ArrayList<String>?=null
    var smallThumbnail:String?=null

    constructor(id:String,selfLink:String,title:String,subtitle:String,
                authors:ArrayList<String>,smallThumbnail:String) {
        this.id = id
        this.selfLink = selfLink
        this.title = title
        this.subtitle = subtitle
        this.authors = authors
        this.smallThumbnail = smallThumbnail
    }

    constructor()
}