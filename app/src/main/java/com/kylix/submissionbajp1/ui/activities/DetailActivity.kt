package com.kylix.submissionbajp1.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.kylix.submissionbajp1.R
import com.kylix.submissionbajp1.model.Catalogue
import com.kylix.submissionbajp1.ui.movie.MovieFragment.Companion.CLICK_MOVIE
import com.kylix.submissionbajp1.ui.tvshow.TvShowFragment.Companion.CLICK_TV_SHOW
import com.kylix.submissionbajp1.ui.movie.MovieViewModel
import com.kylix.submissionbajp1.ui.tvshow.TvShowViewModel
import com.kylix.submissionbajp1.utils.DetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailBinding {
    companion object{
        const val ID = "id"
        const val CLICK = "click"
        const val TITLE = "title"
    }

    private lateinit var collapsingToolbar: CollapsingToolbarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        collapseToolbarConfiguration()

        val movieViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
        val tvShowViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]

        when(intent.getIntExtra(CLICK, 0)){
            CLICK_MOVIE -> setBinding(movieViewModel.detailMovie(intent.getIntExtra(ID, 0))!!)
            CLICK_TV_SHOW -> setBinding(tvShowViewModel.detailTvShow(intent.getIntExtra(ID, 0))!!)
        }
    }

    private fun collapseToolbarConfiguration() {
        collapsingToolbar = findViewById(R.id.collapseToolbar)
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (collapseToolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsingToolbar)){
                collapseToolbar.setCollapsedTitleTextColor(Color.BLACK)
                toolbar.apply {
                    setBackgroundColor(Color.WHITE)
                    title = intent.getStringExtra(TITLE)
                    visibility = View.VISIBLE
                }
            } else {
                collapseToolbar.setExpandedTitleColor(Color.BLACK)
                toolbar.setBackgroundColor(Color.TRANSPARENT)
                toolbar.visibility = View.GONE
            }
        })
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun setBinding(catalogue: Catalogue) {
        multipleGlide(iv_big_poster, iv_small_poster, catalogue)
        tv_title.text = catalogue.title
        tv_release.text = catalogue.release
        tv_duration.text = catalogue.duration
        tv_genre.text = catalogue.genre
        tv_score.text = catalogue.score
        tv_overview.text = catalogue.overview
    }

    override fun multipleGlide(firstImage: ImageView, secondImage: ImageView, catalogue: Catalogue) {
        Glide.with(this).load(catalogue.poster).into(firstImage)
        Glide.with(this).load(catalogue.poster).into(secondImage)
    }
}