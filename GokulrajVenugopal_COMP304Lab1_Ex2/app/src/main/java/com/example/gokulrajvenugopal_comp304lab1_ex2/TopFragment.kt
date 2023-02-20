package com.example.gokulrajvenugopal_comp304lab1_ex2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.FragmentTopBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.viewModel.FragmentCommunicationActivityViewModel

class TopFragment: Fragment()  {

    private lateinit var binding: FragmentTopBinding
    private val viewModel by activityViewModels<FragmentCommunicationActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTopBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.radioButtonAIActivity.setOnClickListener{
            val intent = Intent(context, AIActivity::class.java)
            startActivity(intent)

        }

        binding.radioButtonARActivity.setOnClickListener{
            val intent = Intent(context, ARActivity::class.java)
            startActivity(intent)
        }

    }
}