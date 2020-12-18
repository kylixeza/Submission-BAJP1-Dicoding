package com.kylix.submissionbajp1

import com.kylix.submissionbajp1.model.Catalogue
import com.kylix.submissionbajp1.ui.tvshow.TvShowViewModel
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var catalogue: Catalogue

    @Before
    fun setUp(){
        tvShowViewModel = TvShowViewModel()
        catalogue = Catalogue(
                0,
                "Dragon Ball",
                "02/26/1986",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "25 minutes / episode",
                "80%",
                "Long ago in the mountains, a fighting master known as Gohan discovered a " +
                        "strange boy whom he named Goku. Gohan raised him and trained Goku in martial " +
                        "arts until he died. The young and very strong boy was on his own, but easily" +
                        " managed. Then one day, Goku met a teenage girl named Bulma, whose search for" +
                        " the mystical Dragon Balls brought her to Gokus home. Together, they set off" +
                        " to find all seven and to grant her wish.",
                R.drawable.poster_dragon_ball
        )
    }

    @Test
    fun getTvShow(){
        assertNotNull(catalogue)
        assertEquals(10, tvShowViewModel.getTvShow().size)
    }

    @Test
    fun detailTvShow(){
        assertEquals(catalogue.id, tvShowViewModel.detailTvShow(0)?.id)
        assertEquals(catalogue.title, tvShowViewModel.detailTvShow(0)?.title)
        assertEquals(catalogue.release, tvShowViewModel.detailTvShow(0)?.release)
        assertEquals(catalogue.genre, tvShowViewModel.detailTvShow(0)?.genre)
        assertEquals(catalogue.duration, tvShowViewModel.detailTvShow(0)?.duration)
        assertEquals(catalogue.score, tvShowViewModel.detailTvShow(0)?.score)
        assertEquals(catalogue.overview, tvShowViewModel.detailTvShow(0)?.overview)
        assertEquals(catalogue.poster, tvShowViewModel.detailTvShow(0)?.poster)
    }
}