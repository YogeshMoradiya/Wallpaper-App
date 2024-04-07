package com.example.wallpaperapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Class1(var mainActivity: MainActivity,var wallpaper: Array<String>,var color: Array<Int>) : BaseAdapter() {
    override fun getCount(): Int {
        return wallpaper.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view_inflater = LayoutInflater.from(mainActivity).inflate(R.layout.cardview, p2, false)
        var card : TextView
        var text_cardview: TextView
        card=view_inflater.findViewById(R.id.card)
        card.setBackgroundResource(color[p0])

        text_cardview=view_inflater.findViewById(R.id.taxt_cardview)
        text_cardview.setText(wallpaper[p0])
        return view_inflater
    }

}
