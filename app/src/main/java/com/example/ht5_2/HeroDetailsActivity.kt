package com.example.ht5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.ht5_2.databinding.ActivityHeroDetailsBinding
import com.squareup.picasso.Picasso

private lateinit var binding: ActivityHeroDetailsBinding

class HeroDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        Picasso.get()
            .load(intent.getStringExtra("img"))
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.heroDetailsImage)
        binding.detailsName.text = intent.getStringExtra("name")
        binding.detailsPlaceOfBirth.text = "From " + intent.getStringExtra("placeOfBirth")
        binding.detailsHeight.text = "Height: " + intent.getStringExtra("height")
        binding.detailsWeight.text = "Weight: " + intent.getStringExtra("weight")
        binding.detailsFirstAppearance.text = "First Appearance: " + intent.getStringExtra("firstAppearance")
        binding.detailsPublisher.text = intent.getStringExtra("publisher")
//        if(intent.getStringExtra("alignment")=="good")
//            binding.detailsLayout.background = ContextCompat.getColor(this, R.color.good)
//        else
//            binding.detailsLayout.background = ContextCompat.getColor(this, R.drawable.bad_back)
    }
}