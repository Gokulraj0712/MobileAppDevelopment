package com.example.gokulrajvenugopal_comp304lab1_ex2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gokulrajvenugopal_comp304lab1_ex2.R

class FragmentRecyclerViewAdapter: RecyclerView.Adapter<FragmentRecyclerTextViewHolder>() {

    private val items= arrayListOf<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FragmentRecyclerTextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_bottom_recycler_view_text_item, parent, false)
        return FragmentRecyclerTextViewHolder(view)


    }

    override fun onBindViewHolder(holder: FragmentRecyclerTextViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount()=items.size


    fun addAdapterItem(value: String){

        notifyDataSetChanged()
        items.add(value)
        notifyItemInserted(items.size -1)

    }

}