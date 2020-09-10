package com.example.bnccacademy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_look_up.rvLookUp
import kotlinx.android.synthetic.main.another_layout.*

class SecondActivity : AppCompatActivity() {

    private val mockLookUpList = mutableListOf(
        LookUpData("DKI Jakarta", 455, 3662, 2497),
        LookUpData("Sumatera", 4419, 4104,3250),
        LookUpData("Papua", 4080, 1175, 2919),
        LookUpData("Kalimantan", 1477, 1231, 1656),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.another_layout)

        val lookUpAdapter = LookUpAdapter(mockLookUpList)
        rvLookUp.layoutManager = LinearLayoutManager(this)
        rvLookUp.adapter = lookUpAdapter
        val value = intent.getStringExtra(MainActivity.TESTING)
        title_activity.text = value

        back_button.setOnClickListener {
            onBackPressed()
        }

        search_delete_btn.setOnClickListener {

        }
    }
}
