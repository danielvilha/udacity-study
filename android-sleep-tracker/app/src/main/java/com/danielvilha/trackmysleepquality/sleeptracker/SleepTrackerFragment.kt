package com.danielvilha.trackmysleepquality.sleeptracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.danielvilha.trackmysleepquality.R
import com.danielvilha.trackmysleepquality.database.SleepDatabase
import com.danielvilha.trackmysleepquality.databinding.FragmentSleepTrackerBinding
import com.danielvilha.trackmysleepquality.sleeptracker.adapter.SleepNightAdapter
import com.danielvilha.trackmysleepquality.sleeptracker.adapter.SleepNightListener
import com.google.android.material.snackbar.Snackbar

/**
 * A [Fragment] subclass.
 * A fragment with buttons to record start and end times for sleep, which are saved in
 * a database. Cumulative data is displayed in a simple scrollable TextView.
 * (Because we have not learned about RecyclerView yet.)
 */
class SleepTrackerFragment : Fragment() {

    private lateinit var binding: FragmentSleepTrackerBinding

    /**
     * Called when the Fragment is ready to display content to the screen.
     *
     * This function uses DataBindingUtil to inflate R.layout.fragment_sleep_quality.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Get a reference to the binding object and inflate the fragment views.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sleep_tracker, container, false)

        val application = requireNotNull(this.activity).application

        // I created this instance of the ViewModel Factory.
        val dataSource = SleepDatabase.getInstance(application).sleepDatabaseDao
        val viewModelFactory = SleepTrackerViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SleepTrackerViewModel::class.java)

        binding.viewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding.
        // This is the necessary so that the binding can observe LiveData updates.
        binding.lifecycleOwner = this

        // Add an Observer on the state variable for Navigating when STOP button is pressed.
        viewModel.navigateToSleepQuality.observe(viewLifecycleOwner, { night ->
            night?.let {
                // We need to get the navController from this, because button is not ready, and it
                // just has to be a view. For some reason, this only matters if we hit stop again
                // after using the back button, not if we hit stop and choose a quality.
                // Also, in the Navigation Editor, for Quality -> Tracker, check "Inclusive" for
                // popping the stack to get the correct behavior if we press stop multiple times
                // followed by back.
                // Also: https://stackoverflow.com/questions/28929637/difference-and-uses-of-oncreate-oncreateview-and-onactivitycreated-in-fra
                this.findNavController().navigate(
                    SleepTrackerFragmentDirections
                        .actionSleepTrackerFragmentToSleepQualityFragment(night.nightId))
                // Reset state to make sure we only navigate once, even if the device
                // has a configuration change.
                viewModel.doneNavigating()
            }
        })

        // Add an Observer on the state variable for showing a Snackbar message
        // when the CLEAR button is pressed.
        viewModel.showSnackbarEvent.observe(viewLifecycleOwner, {
            if (it == true) { // Observed state is true.
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(R.string.cleared_message),
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()

                // Reset state to make sure the snackbar is only shown once, even if the device
                // has a configuration change.
                viewModel.doneShowingSnackBar()
            }
        })

        val manager = GridLayoutManager(activity, 3)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int) = when(position) {
                0 -> 3
                else -> 1
            }
        }
        binding.sleepList.layoutManager = manager

        val adapter = SleepNightAdapter(SleepNightListener {
                nightId -> viewModel.onSleepNightClicked(nightId)
        })
        binding.sleepList.adapter = adapter

        viewModel.navigateToSleepDataQuality.observe(viewLifecycleOwner, {night ->
            night?.let {
                this.findNavController().navigate(SleepTrackerFragmentDirections
                    .actionSleepTrackerFragmentToSleepDetailFragment(night))
                viewModel.onSleepDataQualityNavigated()
            }
        })

        viewModel.nights.observe(viewLifecycleOwner, {
            it?.let {
                adapter.addHeaderAndSubmitList(it)
            }
        })

        return binding.root
    }
}