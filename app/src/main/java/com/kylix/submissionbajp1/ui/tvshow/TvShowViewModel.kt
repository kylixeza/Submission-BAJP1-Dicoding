package com.kylix.submissionbajp1.ui.tvshow

import androidx.lifecycle.ViewModel
import com.kylix.submissionbajp1.model.Catalogue
import com.kylix.submissionbajp1.utils.Dummy

class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<Catalogue> = Dummy.getTvShow()
    fun detailTvShow(id: Int): Catalogue? = Dummy.tvShowDetail(id)
}