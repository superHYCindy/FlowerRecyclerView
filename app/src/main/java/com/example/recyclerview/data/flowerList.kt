package com.example.recyclerview.data

import android.content.res.Resources
import android.os.Bundle
import com.example.recyclerview.R

fun flowerList(): List<Flower> {
    return listOf(
        Flower(
            id = 1,
            name = "장미",
            image = R.drawable.rose,
            "This is Rose"
        ),
        Flower(
            id = 2,
            name = "dahila",
            image = R.drawable.dahlia,
            "This is dahila"
        ),
        Flower(
            id = 3,
            name = "장미",
            image = R.drawable.daisy,
            "This is daisy"
        )
    )
}
