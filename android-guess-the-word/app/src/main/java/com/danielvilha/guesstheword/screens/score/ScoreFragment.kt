package com.danielvilha.guesstheword.screens.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.danielvilha.guesstheword.R
import com.danielvilha.guesstheword.databinding.FragmentScoreBinding

/**
 * Created by danielvilha on 13/04/21
 * https://github.com/danielvilha
 * A [Fragment] subclass.
 * Fragment where the final score is shown, after the game is over
 */
class ScoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    private lateinit var binding: FragmentScoreBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)

        // Get args using by navArgs property delegate
        val scoreFragmentArgs by navArgs<ScoreFragmentArgs>()

        viewModelFactory = ScoreViewModelFactory(scoreFragmentArgs.score)

        // Get the viewmodel
        viewModel = ViewModelProvider(this, viewModelFactory).get(ScoreViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        binding.scoreViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Navigates back to title when button is pressed
        viewModel.eventPlayAgain.observe(viewLifecycleOwner, { playAgain ->
            if (playAgain) {
                findNavController().navigate(ScoreFragmentDirections.actionRestart())
                viewModel.onPlayAgainComplete()
            }
        })

        return binding.root
    }
}