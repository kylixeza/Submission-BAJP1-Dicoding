package com.kylix.submissionbajp1

import com.kylix.submissionbajp1.model.Catalogue
import com.kylix.submissionbajp1.ui.movie.MovieViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var catalogue: Catalogue

    @Before
    fun setUp(){
        movieViewModel = MovieViewModel()
        catalogue = Catalogue(
            0,
            "Alita: Battle Angle",
            "14/02/2019",
            "Action, Science Fiction, Adventure",
            "2 hours 2 minutes",
            "71%",
            "When Alita awakens with no memory of who she is in a future world she does " +
                    "not recognize, she is taken in by Ido, a compassionate doctor who realizes " +
                    "that somewhere in this abandoned cyborg shell is the heart and soul of a " +
                    "young woman with an extraordinary past.",
                R.drawable.poster_alita
        )
    }

    @Test
    fun getMovies(){
        assertNotNull(catalogue)
        assertEquals(10, movieViewModel.getMovies().size)
    }

    @Test
    fun detailMovie(){
        assertEquals(catalogue.id, movieViewModel.detailMovie(0)?.id)
        assertEquals(catalogue.title, movieViewModel.detailMovie(0)?.title)
        assertEquals(catalogue.release, movieViewModel.detailMovie(0)?.release)
        assertEquals(catalogue.genre, movieViewModel.detailMovie(0)?.genre)
        assertEquals(catalogue.duration, movieViewModel.detailMovie(0)?.duration)
        assertEquals(catalogue.score, movieViewModel.detailMovie(0)?.score)
        assertEquals(catalogue.overview, movieViewModel.detailMovie(0)?.overview)
        assertEquals(catalogue.poster, movieViewModel.detailMovie(0)?.poster)
    }
}

