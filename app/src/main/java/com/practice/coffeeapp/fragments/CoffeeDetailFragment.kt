package com.practice.coffeeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.practice.coffeeapp.R
import com.practice.coffeeapp.databinding.FragmentCoffeeDetailBinding

class CoffeeDetailFragment : Fragment(R.layout.fragment_coffee_detail) {

    private val binding : FragmentCoffeeDetailBinding by lazy {
       FragmentCoffeeDetailBinding.inflate(layoutInflater)
    }

    private val argsReceive : CoffeeDetailFragmentArgs by navArgs()
    private var count: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
          ivBackArrowCD.setOnClickListener {
            findNavController().navigateUp()
          }
          ivPCoffeeImg.setImageResource(argsReceive.coffeeData.coffeeImg)
          mtvPCoffeeName.text = argsReceive.coffeeData.coffeeName
          mtvPCoffeePrice.text = argsReceive.coffeeData.coffeePrice
          mtvAddQty.setOnClickListener {
             if(mtvAddQty.visibility == View.VISIBLE){
                mtvAddQty.visibility = View.GONE
                count++
                mtvCount.text = count.toString()
                mcvCoffeeQty.visibility = View.VISIBLE
             }else {
                 mcvCoffeeQty.visibility = View.GONE
                 mtvAddQty.visibility = View.VISIBLE
             }
          }
          mtvSub.setOnClickListener {
            if (count == 0) {
              mtvCount.text = "0"
              mcvCoffeeQty.visibility = View.GONE
              mtvAddQty.visibility = View.VISIBLE
            }else{
              count--
              mtvCount.text = count.toString()
            }
          }
          mtvAdd.setOnClickListener {
            count++
            mtvCount.text = count.toString()
          }
          ivPCoffeeCart.setOnClickListener {
            findNavController().navigate(R.id.action_coffeeDetailFragment_to_coffeeCartFragment)
          }
        }
        return binding.root
    }
}