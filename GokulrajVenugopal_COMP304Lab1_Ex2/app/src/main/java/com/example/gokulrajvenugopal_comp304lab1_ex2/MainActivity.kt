package com.example.gokulrajvenugopal_comp304lab1_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.ActivityFragmentCommunicationBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.FragmentTopBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.viewModel.FragmentCommunicationActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentCommunicationBinding
    private lateinit var viewModel : FragmentCommunicationActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProviders.of(this).get(FragmentCommunicationActivityViewModel::class.java)
        viewModel.updateLifecycleEvent(getString(R.string.activity_onCreate))
        binding=ActivityFragmentCommunicationBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        viewModel.updateLifecycleEvent(getString(R.string.activity_onStart))

    }

    override fun onPause() {
        super.onPause()
        viewModel.updateLifecycleEvent(getString(R.string.on_pause_executed))

    }

    override fun onStop() {
        super.onStop()
        viewModel.updateLifecycleEvent(getString(R.string.on_stop_executed))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Destroy Main Activity", "Main Activity onDestroy Executed")
    }


}