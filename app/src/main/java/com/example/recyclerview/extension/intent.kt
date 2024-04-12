package com.example.recyclerview.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf
import com.example.recyclerview.data.Flower

//final step
inline fun <reified T : Any> Activity.extraNotNull(key: String, default: T? = null) = lazy {
    val value = intent?.extras?.getLong(key)
    requireNotNull(if (value is T) value else default) { key }
}

//1 step
//어떤 Activity가 들어 올수 있도록 generic type으로 어떤 값이든 올 수 있게 만듬
//context를 매개변수로 받아와 Intent를 생성함
inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)

//2 step
inline fun <reified T : Any> Context.launchActivity(
    vararg pairs: Pair<String, Any?>
) {
    val intent = newIntent<T>(this)
    intent.putExtras(bundleOf(*pairs))
    startActivity(intent)
}