package com.practice.coffeeapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.practice.coffeeapp.R
import com.practice.coffeeapp.activities.MainActivity
import com.practice.coffeeapp.databinding.FragmentCoffeePaymentBinding

class CoffeePaymentFragment : Fragment(R.layout.fragment_coffee_payment) {

    private val binding : FragmentCoffeePaymentBinding by lazy {
      FragmentCoffeePaymentBinding.inflate(layoutInflater)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            mBtnPTPayment.setOnClickListener {
              openDialog()
            }
        }

        return binding.root
    }
    private fun openDialog() {
        val builder: MaterialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Payment Successful")
            .setMessage("Payment Completed.Thank You, Enjoy Your Sip.")
            .setPositiveButton("OK") { _, _ ->
                val homeIntent = Intent(requireActivity(), MainActivity::class.java)
                startActivity(homeIntent)
                requireActivity().finish()
            }
            .setNegativeButton("Cancel") { _, _ -> }
            .setIcon(R.drawable.coffee_checked_checkbox)

        builder.show()
    }
}