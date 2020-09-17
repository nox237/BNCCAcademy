package com.example.bnccacademy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val okHttpClient = OkHttpClient()
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

        button2.setOnClickListener {
            openActivity3()
        }

        Layout_numberOfCases.visibility = View.GONE
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

    private fun openActivity3(){
        val bottomSheetsActivity = BottomSheetsHotlineActivity()
        bottomSheetsActivity.show(supportFragmentManager, "add_hotline_fragment")
    }
    private fun getCallback(): Callback {
        return object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                this@MainActivity.runOnUiThread {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    // ngeparsing object json yang dalam bentuk URL tdi
                    val jsonString = response.body?.string()
                    val jsonArray = JSONArray(jsonString)
                    var positive = ""
                    var recovered = ""
                    var died = ""
                    var cases = ""

                    for (i in 0 until jsonArray.length()){
                        cases = jsonArray.getJSONObject(i).getString("positif")
                        positive = jsonArray.getJSONObject(i).getString("dirawat")
                        recovered = jsonArray.getJSONObject(i).getString("sembuh")
                        died = jsonArray.getJSONObject(i).getString("meninggal")
                    }

                    this@MainActivity.runOnUiThread{
                        Layout_numberOfCases.visibility = View.VISIBLE

                        progressBar_numberOfCases.visibility = View.GONE
                        progressBar_numberOfDeathCases.visibility = View.GONE
                        progressBar_numberOfRecoveredCases.visibility = View.GONE
                        progressBar_numberOfPositiveCases.visibility = View.GONE

                        numberofCases.text = cases
                        numberOfPositiveCases.text = positive
                        numberOfRecoveredCases.text = recovered
                        numberOfDeathCases.text = died
                    }

                } catch (e: Exception) {
                    this@MainActivity.runOnUiThread {
                        Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}