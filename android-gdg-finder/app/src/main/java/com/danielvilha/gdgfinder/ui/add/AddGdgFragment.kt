package com.danielvilha.gdgfinder.ui.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.danielvilha.gdgfinder.R
import com.danielvilha.gdgfinder.databinding.FragmentAddGdgBinding
import com.google.android.material.snackbar.Snackbar

/**
 * Created by danielvilha on 29/05/21
 * https://github.com/danielvilha
 */
class AddGdgFragment : Fragment() {

    private lateinit var binding: FragmentAddGdgBinding
    private val viewModel: AddGdgViewModel by lazy {
        ViewModelProvider(this).get(AddGdgViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_gdg, container, false)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.showSnackBarEvent.observe(viewLifecycleOwner, {
            if (it == true) { // Observed state is true.
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    getString(R.string.application_submitted),
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
                viewModel.doneShowingSnackBar()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

}