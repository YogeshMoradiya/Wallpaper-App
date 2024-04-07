package com.example.wallpaperapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class Class2(var mainActivity2: MainActivity2,var array: Array<Int>) : BaseAdapter() {
    override fun getCount(): Int {
        return array.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var image_cardview2: ImageView

        var view2= LayoutInflater.from(mainActivity2).inflate(R.layout.cardview2,parent,false)
        image_cardview2=view2.findViewById(R.id.image_cardview2)

        image_cardview2.setBackgroundResource(array[position])

        return view2
    }
}
