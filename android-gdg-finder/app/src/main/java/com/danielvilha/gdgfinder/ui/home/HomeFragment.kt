package com.danielvilha.gdgfinder.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.danielvilha.gdgfinder.R
import com.danielvilha.gdgfinder.databinding.FragmentHomeBinding

/**
 * Created by danielvilha on 29/05/21
 * https://github.com/danielvilha
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.navigateToSearch.observe(viewLifecycleOwner, { navigate ->
            if (navigate) {
                val navController = findNavController()
                navController.navigate(R.id.action_home_to_gdg_search)
                viewModel.onNavigatedToSearch()
            }
        })

        return binding.root
    }
}