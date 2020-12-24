package com.ermilov.loanappmvpclean.infoSlider.data.recycleradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ermilov.loanappmvpclean.R
import com.ermilov.loanappmvpclean.infoSlider.data.model.InfoSliderModel

class InfoSliderAdapter(private  val listslider: ArrayList<InfoSliderModel>) : RecyclerView.Adapter<InfoSliderAdapter.InfoSliderViewHolder>() {


    inner class InfoSliderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.titleTextView)
        private val textDescription = view.findViewById<TextView>(R.id.textDescription)
        private val imageSlideIcon = view.findViewById<ImageView>(R.id.imageSlideIcon)

        fun bind(infoSlider: InfoSliderModel) {
            textTitle.text = infoSlider.title
            textDescription.text = infoSlider.description
            imageSlideIcon.setImageResource(infoSlider.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoSliderViewHolder {
        return InfoSliderViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.slider_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InfoSliderViewHolder, position: Int) {
        holder.bind(listslider[position])
    }

    override fun getItemCount(): Int {
        return listslider.size
    }
}