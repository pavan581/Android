package com.sairam.myapp

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BatteryGraphFragment : Fragment() {

    companion object {
        fun newInstance() = BatteryGraphFragment()
    }

    private lateinit var viewModel: BatteryGraphViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.battery_graph_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BatteryGraphViewModel::class.java)
        // TODO: Use the ViewModel
    }

}