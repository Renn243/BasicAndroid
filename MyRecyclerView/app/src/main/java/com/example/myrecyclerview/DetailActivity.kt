package com.example.myrecyclerview

import Hero
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val key_hero = "key_hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(key_hero)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(key_hero)
        }

        if (dataHero != null) {
            val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
            val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
            val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

            tvDetailName.text = dataHero.name
            tvDetailDescription.text = dataHero.description

            // Load gambar menggunakan Glide
            Glide.with(this)
                .load(dataHero.photo)
                .into(ivDetailPhoto)
        }
    }
}