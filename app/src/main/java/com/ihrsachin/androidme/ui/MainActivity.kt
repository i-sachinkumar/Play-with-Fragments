package com.ihrsachin.androidme.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ihrsachin.androidme.R
import com.ihrsachin.androidme.ui.MasterListFragment.*

class MainActivity : AppCompatActivity(), OnImageClickListener{
    var head_index = 0
    var body_index = 0
    var leg_index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next_button : Button = findViewById(R.id.next_button)
        next_button.setOnClickListener{
            val intent = Intent(this,AndroidMeActivity::class.java)
            val  bundle = Bundle()
            bundle.putInt("head_index",head_index)
            bundle.putInt("body_index",body_index)
            bundle.putInt("leg_index",leg_index)
            intent.putExtra("indexes",bundle)
            startActivity(intent)
        }

    }

    override fun onImageSelected(position: Int) {
        when {
            position <= 11 -> {
                head_index = position % 12
            }
            position <= 23 -> {
                body_index = (position-12)%12
            }
            else -> {
                leg_index = (position-24)%12
            }
        }
    }
}