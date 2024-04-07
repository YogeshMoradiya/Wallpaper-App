package com.example.wallpaperapp

import android.app.WallpaperManager
import android.content.ContentValues.TAG
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.wallpaperapp.MainActivity2.Companion.array

class MainActivity3 : AppCompatActivity() {

    lateinit var imageview3: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        imageview3 = findViewById(R.id.imageview3)


        var position = intent.getIntExtra("pos", 0)


        var mypager = Pageradapterr(this)
        imageview3.adapter = mypager
        imageview3.setCurrentItem(position)
    }

    }


