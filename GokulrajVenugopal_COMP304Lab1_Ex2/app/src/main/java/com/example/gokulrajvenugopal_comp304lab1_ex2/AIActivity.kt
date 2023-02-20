package com.example.gokulrajvenugopal_comp304lab1_ex2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.gokulrajvenugopal_comp304lab1_ex2.adapter.FragmentRecyclerViewAdapter
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.ActivityFragmentCommunicationBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.ActivityFragmentCommunicationForActivityBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.ActivityMainBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.viewModel.FragmentCommunicationActivityViewModel

class AIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentCommunicationForActivityBinding
    private lateinit var viewModel : FragmentCommunicationActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProviders.of(this).get(FragmentCommunicationActivityViewModel::class.java)
        viewModel.updateLifecycleEvent(getString(R.string.ai_activity_header)+ "\n" +
                getString(R.string.on_create_executed))
        binding= ActivityFragmentCommunicationForActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        viewModel.updateLifecycleEvent(getString(R.string.on_start_executed))
    }

    override fun onStop() {
        super.onStop()
        viewModel.updateLifecycleEvent(getString(R.string.on_stop_executed))
        Log.i("Stop AI Activity", "AI Activity onStop Executed")
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.updateLifecycleEvent(getString(R.string.on_destroy_executed))
        Log.i("Destroy AI Activity", "AI Activity onDestroy Executed")

    }
}