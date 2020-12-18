package com.kylix.submissionbajp1.ui.movie

import androidx.lifecycle.ViewModel
import com.kylix.submissionbajp1.model.Catalogue
import com.kylix.submissionbajp1.utils.Dummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<Catalogue> = Dummy.getMovie()
    fun detailMovie(id: Int): Catalogue? = Dummy.movieDetail(id)
}