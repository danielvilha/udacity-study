package com.danielvilha.gdgfinder.ui.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielvilha.gdgfinder.R

/**
 * Created by danielvilha on 31/05/21
 * https://github.com/danielvilha
 */
class GdgListFragment : Fragment() {

    companion object {
        fun newInstance() = GdgListFragment()
    }

    private lateinit var viewModel: GdgListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gdg_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GdgListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}