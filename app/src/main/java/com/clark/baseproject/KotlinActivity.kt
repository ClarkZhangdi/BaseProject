package com.clark.baseproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException

class KotlinActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = OkHttpClient()
        val request = Request.Builder().url("https://api.github.com/users/octocat/repos").build()
        println("KotlinActivity thread name: " + Thread().name)

        val responseCallback = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("onFailure thread name: " + Thread().name)
            }

            override fun onResponse(call: Call, response: Response) {
                println("onResponse thread name: " + Thread().name)

            }

        }
        client.newCall(request).enqueue(responseCallback)
        val arrayOf = arrayOf("a","b")
        val filter = arrayOf.filter {
            it == "b"
        }
        println(filter[0])


    }
}
