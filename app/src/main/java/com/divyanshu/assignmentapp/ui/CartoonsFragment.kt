package com.divyanshu.assignmentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.divyanshu.assignmentapp.MainActivityViewModel
import com.divyanshu.assignmentapp.adapter.CartoonAdapter
import com.divyanshu.assignmentapp.databinding.FragmentCartoonsBinding
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CartoonsFragment : Fragment() {

    private var _binding: FragmentCartoonsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CartoonAdapter
    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCartoonsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadRecyclerViewData()
    }

    private fun loadRecyclerViewData() {
        lifecycleScope.launch {
            viewModel.cartoonListData.collect {
                adapter.submitData(it)
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = CartoonAdapter()
        binding.rlvCartoon.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = this@CartoonsFragment.adapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}