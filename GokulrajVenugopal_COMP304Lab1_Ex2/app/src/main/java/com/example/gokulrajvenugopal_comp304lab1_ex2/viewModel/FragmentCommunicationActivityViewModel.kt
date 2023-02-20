package com.example.gokulrajvenugopal_comp304lab1_ex2.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentCommunicationActivityViewModel: ViewModel() {

    val activityLifecycleEventLiveData = MutableLiveData<String>()

    fun updateLifecycleEvent(event: String)
    {
        activityLifecycleEventLiveData.value=event
    }

}