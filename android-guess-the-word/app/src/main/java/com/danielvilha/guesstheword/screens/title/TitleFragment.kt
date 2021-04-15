package com.danielvilha.guesstheword.screens.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.danielvilha.guesstheword.R
import com.danielvilha.guesstheword.databinding.FragmentTitleBinding

/**
 * Created by danielvilha on 13/04/21
 * https://github.com/danielvilha
 * A simple [Fragment] subclass.
 * Fragment for the starting or title screen of the app
 */
class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        binding.playGameButton.setOnClickListener {
            findNavController().navigate(TitleFragmentDirections.actionTitleToGame())
        }

        return binding.root
    }
}