package com.example.gokulrajvenugopal_comp304lab1_ex2.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gokulrajvenugopal_comp304lab1_ex2.R

class FragmentRecyclerTextViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
    fun bind(value: String){
        val textView=itemView.findViewById<TextView>(R.id.recycler_view_item_text_view)
        textView.text=value
    }
}