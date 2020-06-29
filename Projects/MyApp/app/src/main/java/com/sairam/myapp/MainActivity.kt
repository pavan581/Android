package com.sairam.myapp

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class MainActivity : AppCompatActivity() {

    lateinit var series: LineGraphSeries<DataPoint>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)


        textView.text = "BatteryPercentage:${getBatteryPer()}"

        val graph: GraphView = findViewById(R.id.graph)
        graph.gridLabelRenderer.verticalAxisTitle   = "Percentage"
        graph.gridLabelRenderer.horizontalAxisTitle = "Time"
        series = LineGraphSeries(arrayOf(
            DataPoint(0.0,1.0),
            DataPoint(1.0,5.0),
            DataPoint(2.0,3.0),
            DataPoint(3.0,2.0),
            DataPoint(4.0,6.0)
        ))

        graph.addSeries(series)


    }

    private fun getBatteryPer(): Float? {
        val iFilter: IntentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus: Intent? = registerReceiver(null,iFilter)
        val batteryPer: Float? = batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        }
        return batteryPer
    }

}

