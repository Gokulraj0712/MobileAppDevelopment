package com.example.gokulrajvenugopal_comp304lab1_ex2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.gokulrajvenugopal_comp304lab1_ex2.adapter.FragmentRecyclerViewAdapter
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.ActivityAiArBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.ActivityFragmentCommunicationBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.ActivityFragmentCommunicationForActivityBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.viewModel.FragmentCommunicationActivityViewModel
import kotlin.math.log

class ARActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentCommunicationForActivityBinding
    private lateinit var viewModel : FragmentCommunicationActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProviders.of(this).get(FragmentCommunicationActivityViewModel::class.java)
        viewModel.updateLifecycleEvent(getString(R.string.ar_activity_header)+ "\n"+
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
        Log.i("Stop AR Activity", "AR Activity onStop Executed")
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Destroy AR Activity", "AR Activity onDestroy Executed")
        viewModel.updateLifecycleEvent(getString(R.string.on_destroy_executed))
    }

    }
