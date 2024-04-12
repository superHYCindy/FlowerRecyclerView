package com.example.recyclerview.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.data.DataSource
import com.example.recyclerview.data.Flower
import com.example.recyclerview.databinding.ActivityFlowersListBinding
import com.example.recyclerview.extension.launchActivity

class FlowersListActivity : AppCompatActivity() {
    //case 1 viewBinding
    //private lateinit var binding: ActivityFlowersListBinding

    //case 2 viewBinding lazy 사용
    private val binding: ActivityFlowersListBinding by lazy {
        ActivityFlowersListBinding.inflate(layoutInflater)
    }

    private val flowersAdapter : FlowersAdapter by lazy {
        FlowersAdapter { flower ->
            adapterOnClick(flower)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //case 1 viewbinding
        /*binding = ActivityFlowersListBinding.inflate(layoutInflater)
        setContentView(binding.root)*/

        //case 2 viewBinding
        setContentView(binding.root)

        // DataSource 클래스의 인스턴스를 얻음
        val dataSource = DataSource.getDataSource()
        flowersAdapter.flowerList = dataSource.getFlowerList()  // 꽃 목록을 가져와서 사용합니다.

        with(binding.recyclerView) {
            adapter = flowersAdapter
        }
    }

    private fun adapterOnClick(flower: Flower) {
        //case 1 startActivity
        val intent = Intent(this, FlowerDetailActivity()::class.java)
        intent.putExtra("FLOWER_ID", flower.id)
        startActivity(intent)
        //case 2
        launchActivity<FlowerDetailActivity>(
            FlowerDetailActivity.EXTRA_FLOWER to flower.id
        )
    }
}