package com.example.bnccacademy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.info_dialog_activity.*

class InfoDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_dialog_activity)

        imgClose.setOnClickListener{
            finish()
        }
    }
}