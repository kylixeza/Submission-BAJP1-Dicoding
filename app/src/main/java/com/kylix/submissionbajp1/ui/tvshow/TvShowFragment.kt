package com.kylix.submissionbajp1.ui.tvshow

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kylix.submissionbajp1.R
import com.kylix.submissionbajp1.ui.adapter.CatalogueAdapter
import kotlinx.android.synthetic.main.tv_show_fragment.*

class TvShowFragment : Fragment() {

    companion object {
        const val CLICK_TV_SHOW = 2
    }

    private lateinit var viewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tv_show_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)
        if (activity != null){
            val tvShowViewModel = ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvShow = tvShowViewModel.getTvShow()
            val adapter = CatalogueAdapter(CLICK_TV_SHOW)
            adapter.setAll(tvShow)

            rv_tvShow.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}