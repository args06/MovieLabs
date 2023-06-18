package com.example.movielabs.ui.search

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielabs.R
import com.example.movielabs.data.model.MovieItem
import com.example.movielabs.data.model.SearchItem
import com.example.movielabs.databinding.FragmentSearchBinding
import com.example.movielabs.ui.home.ComingSoonAdapter

class SearchFragment : Fragment(), View.OnCreateContextMenuListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val searchViewModel by viewModels<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel.searchItem.observe(this) { searchItem ->
            setSearchData(searchItem.results)
        }

        searchViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        binding.svSearchMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchViewModel.getSearchMovie(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchViewModel.getSearchMovie(newText)
                return false
            }
        })
    }

    private fun setSearchData(searchList: List<SearchItem>) {
        val adapter = SearchAdapter(searchList)
        binding.rvSearch.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        binding.rvSearch.layoutManager = layoutManager
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}