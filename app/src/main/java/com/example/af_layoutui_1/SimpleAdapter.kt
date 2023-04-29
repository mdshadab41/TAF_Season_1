package com.example.af_layoutui_1

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<String>()
    private var headerText: String? = null

    //----------------
    // Header
    //Elements 0-n
    //Footer
    //-----------

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> R.layout.view_holder_header
            data.size+1 -> R.layout.view_holder_footer
            else -> R.layout.view_holder_textview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.view_holder_header -> simpleHeaderViewHolder(parent)
            R.layout.view_holder_footer -> simpleFooterViewHolder(parent)
            else-> simpleViewHolder(parent)

        }
    }

    override fun getItemCount(): Int {
        return data.size + 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is simpleViewHolder -> holder.onBind(data[position-1], position)
            is simpleHeaderViewHolder -> holder.onBind(headerText)
            is simpleFooterViewHolder -> holder.onBind()

        }
    }

    fun setData(data: List<String>, headerText: String) {
        this.data.clear()
        this.data.addAll(data)
        this.headerText = headerText
    }

    inner class simpleViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_textview, parent, false)
    ) {
        private val textView: TextView = itemView.findViewById(R.id.viewHolderTv)

        fun onBind(textToDisplay: String, position: Int) {
            val color = if (position % 2 == 0) {
                itemView.context.getColor(R.color.light_backgorund)
            } else {
                itemView.context.getColor(R.color.white)
            }

            textView.text = textToDisplay
            itemView.setBackgroundColor(color)
        }
    }

    inner class simpleHeaderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_header, parent, false)
    ) {
        private val textView: TextView = itemView.findViewById(R.id.tvHeader)

        fun onBind(headerText: String?) {
            val textToDisplay = headerText?: "no text to you"
            textView.text = textToDisplay
        }

    }

    inner class simpleFooterViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_footer, parent, false)
    ){
        private val leftButton: Button = itemView.findViewById(R.id.leftButton)
        private val rightButton: Button = itemView.findViewById(R.id.rightButton)

        fun onBind(){
            leftButton.setOnClickListener {
                Log.i("left", "Button Clicked")
            }
            rightButton.setOnClickListener {
                Log.i("right", "Button Clicked")
            }
        }
    }
}