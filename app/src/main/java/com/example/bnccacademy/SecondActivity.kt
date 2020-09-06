package com.example.bnccacademy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.another_layout.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.another_layout)

        val value = intent.getStringExtra(MainActivity.TESTING)
        title_activity.text = value

        back_button.setOnClickListener {
            onBackPressed()
        }

        search_delete_btn.setOnClickListener {

        }
    }
}