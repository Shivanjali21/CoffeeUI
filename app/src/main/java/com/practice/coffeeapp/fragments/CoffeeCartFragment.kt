package com.practice.coffeeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practice.coffeeapp.R
import com.practice.coffeeapp.databinding.FragmentCoffeeCartBinding

class CoffeeCartFragment : Fragment(R.layout.fragment_coffee_cart) {

    private val binding :FragmentCoffeeCartBinding by lazy {
       FragmentCoffeeCartBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            mBtnContinue.setOnClickListener {
              findNavController().navigate(R.id.action_coffeeCartFragment_to_coffeePaymentFragment)
            }
        }
        return binding.root
    }
}