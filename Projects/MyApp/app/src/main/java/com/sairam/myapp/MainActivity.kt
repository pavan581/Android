package com.sairam.myapp

import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.DataPointInterface
import com.jjoe64.graphview.series.LineGraphSeries

class MainActivity : AppCompatActivity() {

    lateinit var series: LineGraphSeries<DataPoint>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val graph: GraphView = findViewById<GraphView>(R.id.graph)
        series = LineGraphSeries(arrayOf(
            DataPoint(0.0,1.0),
            DataPoint(1.0,5.0),
            DataPoint(2.0,3.0),
            DataPoint(3.0,2.0),
            DataPoint(4.0,6.0)
        ))

        graph.addSeries(series)


    }

}

