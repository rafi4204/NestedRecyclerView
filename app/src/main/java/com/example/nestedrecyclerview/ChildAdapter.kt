package com.example.nestedrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

class ChildAdapter(val context: Context,val childList: ArrayList<String>) : RecyclerView.Adapter<ChildAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return ChildAdapter.CustomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_child, parent, false)
        )
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
       holder.childTextView.text = childList[position]
    }


    override fun getItemCount(): Int =childList.size

    class CustomViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
     var childTextView : TextView by Delegates.notNull()
        init {
            childTextView=itemView.findViewById(R.id.childTextView)
        }

    }
}
