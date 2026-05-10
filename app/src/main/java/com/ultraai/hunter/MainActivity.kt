package com.ultraai.hunter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvStatus: TextView
    private lateinit var btnGenerate: Button
    private var adView: AdView? = null
    private var pyModule: PyObject? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startPythonSafely()
        setContentView(R.layout.activity_main)

        bindViews()
        setupAdsSafely()
        loadPythonModuleSafely()
        setupGenerateButton()
    }

    private fun startPythonSafely() {
        try {
            if (!Python.isStarted()) {
                Python.start(AndroidPlatform(this))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun bindViews() {
        tvResult = findViewById(R.id.tvResult)
        tvStatus = findViewById(R.id.tvStatus)
        btnGenerate = findViewById(R.id.btnGenerate)

        // AdView exists only in builds where ads are enabled.
        adView = try {
            findViewById(R.id.adView)
        } catch (e: Exception) {
            null
        }
    }

    private fun setupAdsSafely() {
        try {
            adView?.let {
                MobileAds.initialize(this) {}
                val adRequest = AdRequest.Builder().build()
                it.loadAd(adRequest)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // Ads must never crash the app.
        }
    }

    private fun loadPythonModuleSafely() {
        try {
            pyModule = Python.getInstance().getModule("generator")
            val health = pyModule?.callAttr("health_check")?.toString() ?: "Python loaded"
            tvStatus.text = "✅ $health"
        } catch (e: Exception) {
            e.printStackTrace()
            tvStatus.text = "❌ Python Error: ${e.message}"
            pyModule = null
        }
    }

    private fun setupGenerateButton() {
        btnGenerate.setOnClickListener {
            try {
                val module = pyModule
                if (module == null) {
                    tvResult.text = "Python module is not loaded"
                    return@setOnClickListener
                }

                val result = module.callAttr("generate_many", "Gaming", 5).toString()
                tvResult.text = "$result\n\n(Processed locally by Python)"
            } catch (e: Exception) {
                e.printStackTrace()
                tvResult.text = "خطأ أثناء توليد الاسم:\n${e.message}"
            }
        }
    }
}
