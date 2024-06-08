package com.practice.coffeeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.practice.coffeeapp.R
import com.practice.coffeeapp.adapter.CoffeeSearchAdapter
import com.practice.coffeeapp.databinding.FragmentCoffeeSearchBinding
import com.practice.coffeeapp.model.CoffeeData

class CoffeeSearchFragment : Fragment(R.layout.fragment_coffee_search) {

    private val binding : FragmentCoffeeSearchBinding by lazy {
       FragmentCoffeeSearchBinding.inflate(layoutInflater)
    }
    private lateinit var coffeeAdapter: CoffeeSearchAdapter
    private lateinit var coffeeData: ArrayList<CoffeeData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        coffeeData = ArrayList()

        binding.apply {
           ivBackArrow.setOnClickListener {
              findNavController().navigateUp()
           }

           val layoutManager = GridLayoutManager(requireContext(), 2)
           rvCoffee.layoutManager = layoutManager
           coffeeAdapter = CoffeeSearchAdapter(coffeeData)
           rvCoffee.adapter = coffeeAdapter
           coffeeAdapter.onItemClick = {
               val cd = CoffeeData(it.coffeeImg, it.coffeeName, it.coffeePrice)
               val cdAction = CoffeeSearchFragmentDirections.actionCoffeeSearchFragmentToCoffeeDetailFragment(cd)
               findNavController().navigate(cdAction)
           }
        }
        coffeeData.add(CoffeeData(R.drawable.coffee_img_one, "Lite Black Coffee Special Beans (500gm)","\u20B9 500/-"))
        coffeeData.add(CoffeeData(R.drawable.coffee_img_two, "Black Coffee","\u20B9 400"))
        coffeeData.add(CoffeeData(R.drawable.coffee_img_three, "Mid Black Coffee Special","\u20B9 800/-"))
        coffeeData.add(CoffeeData(R.drawable.coffee_img_four, "Dark Latte Black Coffee","\u20B9 1000/-"))
        coffeeData.add(CoffeeData(R.drawable.coffee_img_five, "Strong Coffee Special","\u20B9 600/-"))

        return binding.root
    }

}