package com.example.gokulrajvenugopal_comp304lab1_ex2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gokulrajvenugopal_comp304lab1_ex2.adapter.FragmentRecyclerViewAdapter
import com.example.gokulrajvenugopal_comp304lab1_ex2.databinding.FragmentBottomBinding
import com.example.gokulrajvenugopal_comp304lab1_ex2.viewModel.FragmentCommunicationActivityViewModel

class BottomFragment:Fragment() {
    private lateinit var binding: FragmentBottomBinding
    private val viewModel by activityViewModels<FragmentCommunicationActivityViewModel>()
    private val adapter= FragmentRecyclerViewAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter.addAdapterItem(getString(R.string.lifecycle_start))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentBottomBinding.inflate(inflater, container,false)
        binding.recyclerViewBottomFragment.layoutManager=LinearLayoutManager(requireActivity())
        binding.recyclerViewBottomFragment.adapter=adapter
        adapter.addAdapterItem(getString(R.string.bottom_fragment_onCreateView))
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        adapter.addAdapterItem(getString(R.string.bottom_fragment_start))

    }

    override fun onResume() {
        super.onResume()
        adapter.addAdapterItem(getString(R.string.bottom_fragment_onResume))
    }

    override fun onPause() {
        super.onPause()
        adapter.addAdapterItem(getString(R.string.bottom_fragment_onpause))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.addAdapterItem(getString(R.string.bottom_fragment_onViewCreated))
        viewModel.activityLifecycleEventLiveData.observe(viewLifecycleOwner){activityvalue ->
            adapter.addAdapterItem(activityvalue)
        }
    }
}