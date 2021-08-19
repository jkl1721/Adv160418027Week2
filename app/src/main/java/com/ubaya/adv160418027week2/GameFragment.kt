package com.ubaya.adv160418027week2

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class GameFragment : Fragment() {
    var num1 = 0
    var num2 = 0
    var ans = 0
    var score = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    fun initialize(){
        num1 = Random.nextInt(0, 20)
        txtNum1.text = num1.toString()
        num2 = Random.nextInt(0, 20)
        txtNum2.text = num2.toString()
        ans = num1 + num2
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's turn"
        }
        btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
        initialize()
        btnSubmit.setOnClickListener {
            if(txtAnswer.text.toString() != ans.toString()){
                val action = GameFragmentDirections.actionToEnd(score)
                Navigation.findNavController(it).navigate(action)
                Toast.makeText(activity, "Game Over! Your Score : " + score.toString(), Toast.LENGTH_SHORT)
            }else{
                score += 1
                initialize()
                Toast.makeText(activity, "Correct!",Toast.LENGTH_SHORT)
            }
        }
    }

}