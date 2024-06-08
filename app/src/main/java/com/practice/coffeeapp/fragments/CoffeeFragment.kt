package com.practice.coffeeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practice.coffeeapp.R
import com.practice.coffeeapp.databinding.FragmentCoffeeBinding

class CoffeeFragment : Fragment(R.layout.fragment_coffee) {

    private val binding : FragmentCoffeeBinding by lazy {
      FragmentCoffeeBinding.inflate(layoutInflater)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding.mtvBuyNow.setOnClickListener {
            findNavController().navigate(R.id.action_coffeeFragment_to_coffeeSearchFragment)
        }
        return binding.root
    }
}