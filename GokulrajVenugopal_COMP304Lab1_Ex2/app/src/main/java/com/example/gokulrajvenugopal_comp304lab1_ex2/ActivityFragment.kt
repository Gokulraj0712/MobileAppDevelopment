package com.example.gokulrajvenugopal_comp304lab1_ex2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gokulrajvenugopal_comp304lab1_ex2.adapter.FragmentRecyclerViewAdapter
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.ActivityAiArBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.viewModel.FragmentCommunicationActivityViewModel

class ActivityFragment: Fragment() {
    private lateinit var binding: ActivityAiArBinding
    private val viewModel by activityViewModels<FragmentCommunicationActivityViewModel>()
    private val adapter= FragmentRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=ActivityAiArBinding.inflate(inflater, container,false)
        binding.recyclerViewActivityAr.layoutManager= LinearLayoutManager(requireActivity())
        binding.recyclerViewActivityAr.adapter=adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.activityLifecycleEventLiveData.observe(viewLifecycleOwner){activityvalue ->
            adapter.addAdapterItem(activityvalue)
        }
    }
}