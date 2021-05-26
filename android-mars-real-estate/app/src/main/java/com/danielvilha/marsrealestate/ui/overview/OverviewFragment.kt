package com.danielvilha.marsrealestate.ui.overview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.danielvilha.marsrealestate.R
import com.danielvilha.marsrealestate.databinding.FragmentOverviewBinding
import com.danielvilha.marsrealestate.databinding.ItemGridViewBinding

/**
 * Created by danielvilha on 24/05/21
 * https://github.com/danielvilha
 *
 * This [Fragment] will show the status of the Mars real-estate web services transactions.
 */
class OverviewFragment : Fragment() {

//    private lateinit var binding: FragmentOverviewBinding

    /**
     * Lazily initialize our [OverviewViewModel]
     */
    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Get a reference to the binding object and inflate the fragment views.
        val binding = ItemGridViewBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        setHasOptionsMenu(true)
        return binding.root
    }

    /**
     * Inflates the overflow menu that contains filtering options.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}