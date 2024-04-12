package com.example.recyclerview.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.data.DataSource
import com.example.recyclerview.databinding.ActivityFlowerDetailBinding
import com.example.recyclerview.extension.extraNotNull

class FlowerDetailActivity : AppCompatActivity() {
    companion object {
        //const val -> compile 시점 할당
        const val EXTRA_FLOWER: String = "extra_flower"
    }

    private val binding: ActivityFlowerDetailBinding by lazy {
        ActivityFlowerDetailBinding.inflate(layoutInflater)
    }
    //case 2
    private val flowerId by extraNotNull<Long>(EXTRA_FLOWER)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //case 1
        val intent = intent
        val flowerId = intent.extras?.getLong(EXTRA_FLOWER) ?: 0
        //데이터 값 받아오기
        val flowerData = DataSource.getDataSource().getFlowerForId(flowerId)

        binding.flowerDetailName.text = flowerData.name
        binding.flowerDetailImage.setImageResource(flowerData.image)
        binding.flowerDetailDescription.text = flowerData.description
    }
}