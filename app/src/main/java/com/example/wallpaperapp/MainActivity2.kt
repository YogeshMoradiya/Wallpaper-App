package com.example.wallpaperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var click: GridView

    var Car= arrayOf(
        R.drawable.car1,
        R.drawable.car2,
        R.drawable.car3,
        R.drawable.car4,
        R.drawable.car5,
        R.drawable.car6,
        R.drawable.car7,
    )

    var Bike= arrayOf(
        R.drawable.b1,
        R.drawable.b2,
        R.drawable.b3,
        R.drawable.b4,
        R.drawable.b5,
        R.drawable.b6,
    )

    var Nature= arrayOf(
        R.drawable.na1,
        R.drawable.na2,
        R.drawable.na3,
        R.drawable.na4,
        R.drawable.na5,
        R.drawable.na6,
        R.drawable.na7,
    )

    var Animal= arrayOf(
        R.drawable.ani1,
        R.drawable.ani2,
        R.drawable.ani3,
        R.drawable.ani4,
        R.drawable.ani5,
        R.drawable.ani7,
    )

    var Bird= arrayOf(
        R.drawable.bird1,
        R.drawable.bird2,
        R.drawable.bird3,
        R.drawable.bird4,
        R.drawable.bird5,
        R.drawable.bird6,
        R.drawable.bird7,
    )

    var Cool= arrayOf(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5,
        R.drawable.c6,
    )

    var Creative= arrayOf(
        R.drawable.cr1,
        R.drawable.cr2,
        R.drawable.cr3,
        R.drawable.cr4,
        R.drawable.cr5,
        R.drawable.cr6,
        R.drawable.cr7,
    )

    var Colorful= arrayOf(
        R.drawable.co1,
        R.drawable.co2,
        R.drawable.co3,
        R.drawable.co4,
        R.drawable.co5,
        R.drawable.co6,
        R.drawable.co7,
    )

lateinit var walltxt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        walltxt=findViewById(R.id.walltxt)

        var position = intent.getStringExtra("mainlist")

        walltxt.setText(position)

        if(position.equals("Car")) {
            array = Car
        }else if(position.equals("Bike")){
            array=Bike
        }else if(position.equals("Nature")){
            array=Nature
        }else if(position.equals("Animal")){
            array=Animal
        }else if(position.equals("Bird")){
            array=Bird
        }else if(position.equals("Cool")){
            array=Cool
        }else if(position.equals("Creative")){
            array=Creative
        }else if(position.equals("Colorful")){
            array=Colorful
        }

        click = findViewById(R.id.click)

        var adapter = Class2(this, array)

        click.adapter = adapter

        click.setOnItemClickListener { parent, view, pos, id ->
            var click = Intent(this@MainActivity2, MainActivity3::class.java)
            startActivity(click. putExtra("pos", pos))
        }
    }

    companion object {

        var array = arrayOf<Int>()
    }


}