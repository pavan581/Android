package com.sairam.myapp

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BatteryDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = BatteryDetailsFragment()
    }

    private lateinit var viewModel: BatteryDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.battery_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BatteryDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}