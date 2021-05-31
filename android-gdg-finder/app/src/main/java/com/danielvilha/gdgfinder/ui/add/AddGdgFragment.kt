package com.danielvilha.gdgfinder.ui.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielvilha.gdgfinder.R
import com.danielvilha.gdgfinder.databinding.FragmentAddGdgBinding

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

        return inflater.inflate(R.layout.fragment_add_gdg, container, false)
    }

}