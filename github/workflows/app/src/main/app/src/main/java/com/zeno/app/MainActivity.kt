package com.zeno.app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.zeno.app.core.SystemCore
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var statusStrip: TextView
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusStrip = findViewById(R.id.statusStrip)
        viewPager = findViewById(R.id.viewPager)

        lifecycleScope.launch {
            while (true) {
                val appCount = SystemCore.connectedApps.size
                statusStrip.text = if (appCount == 0)
                    "ZENO — no apps connected"
                else
                    "ZENO — $appCount app(s) connected | Master: ${if (SystemCore.masterSwitch) "ON" else "OFF"}"
                delay(2000)
            }
        }
    }
}
