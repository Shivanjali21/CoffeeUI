package com.practice.coffeeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.practice.coffeeapp.R
import com.practice.coffeeapp.model.CoffeeData

class CoffeeSearchAdapter (private val coffeeList:List<CoffeeData>) : RecyclerView.Adapter<CoffeeSearchAdapter.ViewHolder>() {

    var onItemClick: ((CoffeeData) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val coffeeCard : MaterialCardView = itemView.findViewById(R.id.mcvCoffee)
       val coffeeImg : ImageView = itemView.findViewById(R.id.ivCoffeeImg)
       val coffeeName : MaterialTextView = itemView.findViewById(R.id.mtvCoffeeName)
       val coffeePrice : MaterialTextView = itemView.findViewById(R.id.mtvCoffeePrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeSearchAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_coffee, parent,false)
       return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeSearchAdapter.ViewHolder, position: Int) {
       holder.coffeeImg.setImageResource(coffeeList[position].coffeeImg)
       holder.coffeeName.text = coffeeList[position].coffeeName
       holder.coffeePrice.text = coffeeList[position].coffeePrice
       holder.coffeeCard.setOnClickListener {
         onItemClick?.invoke(coffeeList[position])
       }
    }

    override fun getItemCount(): Int {
      return coffeeList.size
    }
}