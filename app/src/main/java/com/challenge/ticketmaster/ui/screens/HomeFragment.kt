package com.challenge.ticketmaster.ui.screens

import android.annotation.SuppressLint
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Rect
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challenge.core.domain.models.Event
import com.challenge.ticketmaster.R
import com.challenge.ticketmaster.databinding.FragmentHomeBinding
import com.challenge.ticketmaster.helpers.viewBinding
import com.challenge.ticketmaster.ui.data.UIState
import com.challenge.ticketmaster.ui.viewmodels.EventsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val eventsViewModel: EventsViewModel by viewModels()
    private val adapter = EventListAdapter()

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupViewModel()
    }

    private fun setupUI() {
        setupRecycler()
        binding.searchField.apply {
            addTextChangedListener(object : TextWatcher {
                var delay : Long = 1000 // 1
                var timer = Timer()

                override fun afterTextChanged(searchEventName: Editable?) {
                    timer = Timer()
                    timer.schedule(object : TimerTask() {
                        override fun run() {
                            eventsViewModel.searchEvent(searchEventName.toString())
                        }
                    }, delay)
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)  = Unit

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    timer.cancel()
                    timer.purge()
                }
            })
            setOnEditorActionListener { textView, actionId, keyEvent ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE ||
                    keyEvent == null ||
                    keyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                    eventsViewModel.searchEvent(textView.text.toString())
                }
                false
            }
        }
    }

    private fun hideKeyboard() {
        val inputMethodManager = requireContext().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.view?.windowToken, 0)
    }

    private fun hideLoading() {
        binding.progressLoading.visibility = GONE
    }

    private fun setupRecycler() {
        binding.eventsRecycler.setHasFixedSize(true)
        binding.eventsRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.eventsRecycler.adapter = adapter
        binding.eventsRecycler.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.dimen_8))
        )
    }

    private fun displayError(message: String) {
        binding.genericError.text = message
        binding.genericError.visibility = VISIBLE
    }

    private fun hideError() {
        binding.genericError.visibility = GONE
    }

    private fun displayEvents(values: List<Event>) {
        adapter.submitList(values)
    }

    private fun setupViewModel() {
        lifecycleScope.launch {
            eventsViewModel.state.collect { uiState ->
                hideKeyboard()
                when (uiState) {
                    is UIState.Error -> {
                        hideError()
                        hideLoading()
                        displayError(uiState.message)
                    }

                    is UIState.Info -> {
                        hideError()
                        hideLoading()
                        displayEvents(uiState.values)
                    }

                    UIState.Init -> Unit
                    UIState.Loading -> binding.progressLoading.visibility = VISIBLE
                }
            }
        }
    }

    class MarginItemDecoration(private val spaceSize: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceSize
                }
                left = spaceSize
                right = spaceSize
                bottom = spaceSize
            }
        }
    }
}