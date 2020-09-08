package com.example.nestedrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

class ParentAdapter(var context: Context, var items: ArrayList<String>) : RecyclerView.Adapter<ParentAdapter.CustomAdapterViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapterViewHolder {
        return CustomAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_parent, parent, false)
        )
    }


    override fun onBindViewHolder(holder: CustomAdapterViewHolder, position: Int) {
       holder.parentTextView.text=items[position]
        val childList= arrayListOf("ahhhdhs", "jkhjkh", "hjghjgjhghj","hgjhghjg")
       holder.parentView.setOnClickListener {
           holder.childRecyclerView.visibility=View.VISIBLE
           val adapter = ChildAdapter(context, childList)
           val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
           holder.childRecyclerView.layoutManager = layoutManager
           holder.childRecyclerView.adapter = adapter

       }
    }


    override fun getItemCount(): Int = items.size




    class CustomAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parentView: LinearLayout by Delegates.notNull()
        var childRecyclerView: RecyclerView by Delegates.notNull()
        var parentTextView: TextView by Delegates.notNull()


        init {
            parentView = itemView.findViewById(R.id.parentView)
            childRecyclerView = itemView.findViewById(R.id.childRecyclerView)
            parentTextView = itemView.findViewById(R.id.parentTextView)


        }
    }
}
