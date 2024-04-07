package com.example.wallpaperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {


    lateinit var mainlist: ListView

    var wallpaper= arrayOf("Car","Bike","Nature","Animal","Bird","Cool","Creative","Colorful")

    var arrayBackground= arrayOf(R.drawable.car,R.drawable.bike,R.drawable.naturel,R.drawable.animal,
        R.drawable.bird,R.drawable.cool1,R.drawable.creative,R.drawable.colourful)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainlist=findViewById(R.id.mainlist)

        var adapter=Class1(this,wallpaper,arrayBackground)
        mainlist.adapter=adapter

        mainlist.setOnItemClickListener { parent, view, position, id ->
            var intent= Intent(this@MainActivity,MainActivity2::class.java).putExtra("mainlist",wallpaper[position])
            startActivity(intent)

        }
    }
}