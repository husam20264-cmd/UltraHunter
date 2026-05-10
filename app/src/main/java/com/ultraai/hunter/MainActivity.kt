package com.ultraai.hunter
import com.chaquo.python.android.AndroidPlatform

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvStatus: TextView
    private lateinit var btnGenerate: Button
    private lateinit var adView: AdView
    private var pyModule: PyObject? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        tvStatus = findViewById(R.id.tvStatus)
        btnGenerate = findViewById(R.id.btnGenerate)
        adView = findViewById(R.id.adView)

        MobileAds.initialize(this) {}
        adView.loadAd(AdRequest.Builder().build())

        try {
            pyModule = Python.getInstance().getModule("generator")
            tvStatus.text = "✅ Python Chaquopy is running"
        } catch (e: Exception) {
            tvStatus.text = "❌ Python Error: ${e.message}"
        }

        btnGenerate.setOnClickListener {
            if (pyModule != null) {
                val result = pyModule!!.callAttr("generate_username", "Gaming")
                tvResult.text = "$result\n(Processed locally by Python)"
            }
        }
    }
}