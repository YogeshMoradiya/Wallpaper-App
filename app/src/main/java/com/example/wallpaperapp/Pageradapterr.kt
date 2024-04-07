package com.example.wallpaperapp

import android.app.AlertDialog
import android.app.ProgressDialog
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.media.MediaScannerConnection
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class Pageradapterr(var mainActivity3: MainActivity3) : PagerAdapter() {
    override fun getCount(): Int {
        return MainActivity2.array.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view2 = LayoutInflater.from(mainActivity3).inflate(R.layout.pager, container, false)
        val view_pager: ImageView = view2.findViewById(R.id.view_pager)
        val set: TextView = view2.findViewById(R.id.set)
        val downloadbtn: ImageView = view2.findViewById(R.id.downloadbtn)
        view_pager.setBackgroundResource(MainActivity2.array[position])

        set.setOnClickListener {
            showSetWallpaperDialog(position)
        }

        downloadbtn.setOnClickListener {
            val drawableId = MainActivity2.array[position]
            val drawable = ContextCompat.getDrawable(mainActivity3, drawableId) 
            val bitmap = (drawable as BitmapDrawable).bitmap
            saveImageToGallery(bitmap, "wallpaper_$position")
        }


        container.addView(view2)
        return view2
    }

    private fun saveImageToGallery(bitmap: Bitmap, title: String) {
        val filename = "$title.jpg"
        val filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val file = File(filepath, filename)

        try {
            val fos = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos.flush()
            fos.close()

            // Update gallery
            MediaScannerConnection.scanFile(
                mainActivity3, arrayOf(file.absolutePath), null) { _, _ ->
                Toast.makeText(mainActivity3, "Image saved to gallery", Toast.LENGTH_SHORT).show()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(mainActivity3, "Failed to save image", Toast.LENGTH_SHORT).show()

        }
    }

    private fun showSetWallpaperDialog(position: Int) {
        val options = arrayOf("Home Screen", "Lock Screen", "Both")
        val builder = AlertDialog.Builder(mainActivity3)
        builder.setTitle("Set Wallpaper")
        builder.setItems(options) { dialog, which ->
            val progressDialog = ProgressDialog(mainActivity3)
            progressDialog.setMessage("Setting wallpaper...")
            progressDialog.setCancelable(false)
            progressDialog.show()

            val wallpaperManager = WallpaperManager.getInstance(mainActivity3)
            val bitmap = BitmapFactory.decodeResource(mainActivity3.resources, MainActivity2.array[position])
            val flag = when (which) {
                0 -> WallpaperManager.FLAG_SYSTEM
                1 -> WallpaperManager.FLAG_LOCK
                else -> WallpaperManager.FLAG_SYSTEM or WallpaperManager.FLAG_LOCK
            }
            Thread {
                try {
                    wallpaperManager.setBitmap(bitmap, null, true, flag)
                    mainActivity3.runOnUiThread {
                        progressDialog.dismiss()
                        Toast.makeText(mainActivity3, "Wallpaper set successfully", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                    mainActivity3.runOnUiThread {
                        progressDialog.dismiss()
                        Toast.makeText(mainActivity3, "Failed to set wallpaper", Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        }

        builder.show()
    }



    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}


