package com.sairam.mypythonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editTextView: EditText
    lateinit var button: Button

    lateinit var py: Python
    lateinit var pyf: PyObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(! Python.isStarted())
            Python.start(AndroidPlatform(this))
        py  = Python.getInstance()
        pyf = py.getModule("pythonFile")

        textView = findViewById<TextView>(R.id.textview)
        editTextView = findViewById<EditText>(R.id.edittext)
        button = findViewById<Button>(R.id.button)

        var text = editTextView.text
        button.setOnClickListener { pyfun(text.toString()) }

    }

    private fun pyfun(text: String){
        val obj: PyObject = pyf.callAttr("myfun",text)
        textView.text = obj.toString()
    }
}

