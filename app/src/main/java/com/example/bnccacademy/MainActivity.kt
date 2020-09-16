package com.example.bnccacademy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TESTING = "passingVariable"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            openActivity2()
        }

        imageButton.setOnClickListener {
            infoDialog()
        }
    }

    private fun openActivity2(){
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(TESTING, "Indonesia")
        }
        startActivity(intent)
    }

    private fun infoDialog() {
        val intent = Intent(this, InfoDialogActivity::class.java)
        startActivity(intent)

    }
}