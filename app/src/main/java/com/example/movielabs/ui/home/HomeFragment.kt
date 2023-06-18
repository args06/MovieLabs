package com.example.movielabs.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielabs.data.model.BoxOfficeItem
import com.example.movielabs.data.model.MovieItem
import com.example.movielabs.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.theaterMovieItem.observe(this) { theaterMovieItem ->
            setCarouselItem(theaterMovieItem.items)
        }

        mainViewModel.comingSoonMovieItem.observe(this) { comingSoonMovieItem ->
            setComingSoonData(comingSoonMovieItem.items)
        }

        mainViewModel.boxOfficeMovieItem.observe(this) { boxOfficeMovieItem ->
            setBoxOfficeData(boxOfficeMovieItem.items)
        }

        mainViewModel.isLoading.observe(this) { isLoading ->
            showLoading(isLoading)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setCarouselItem(movieList: List<MovieItem>) {
        val adapter = CarouselAdapter(movieList)

        binding.apply {
            crvInTheaterMovie.adapter = adapter
            crvInTheaterMovie.set3DItem(true)
            crvInTheaterMovie.setAlpha(true)
            crvInTheaterMovie.setInfinite(true)
        }
    }

    private fun setComingSoonData(movieList: List<MovieItem>) {
        val adapter = ComingSoonAdapter(movieList)
        binding.comingSoonSection.rvComingSoon.adapter = adapter
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.comingSoonSection.rvComingSoon.layoutManager = layoutManager
    }

    private fun setBoxOfficeData(movieList: List<BoxOfficeItem>) {
        val adapter = BoxOfficeAdapter(movieList)
        binding.boxOfficeSection.rvBoxOffice.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        binding.boxOfficeSection.rvBoxOffice.layoutManager = layoutManager
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}