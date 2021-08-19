package com.ubaya.adv160418027week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_result.*
import kotlin.random.Random


class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val score = ResultFragmentArgs.fromBundle(requireArguments()).score
            txtScore.text = "$score"
        }
        btnBackMain.setOnClickListener {
            val action = ResultFragmentDirections.actionEndToStart()
            Navigation.findNavController(it).navigate(action)
        }
    }
}