package com.kylix.submissionbajp1.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kylix.submissionbajp1.R
import com.kylix.submissionbajp1.model.Catalogue
import com.kylix.submissionbajp1.ui.activities.DetailActivity
import com.kylix.submissionbajp1.ui.activities.DetailActivity.Companion.CLICK
import com.kylix.submissionbajp1.ui.activities.DetailActivity.Companion.ID
import com.kylix.submissionbajp1.ui.activities.DetailActivity.Companion.TITLE
import kotlinx.android.synthetic.main.item_list.view.*

class CatalogueAdapter(private val adapterId: Int): RecyclerView.Adapter<CatalogueAdapter.ListViewHolder>() {

    private var catalogue = ArrayList<Catalogue>()

    fun setAll(data: List<Catalogue>){
        catalogue.clear()
        catalogue.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = catalogue.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val catalogue = catalogue[position]
        holder.bind(catalogue)
    }

    inner class ListViewHolder(view: View):RecyclerView.ViewHolder(view) {
        fun bind(catalogue: Catalogue){
            itemView.apply{
                Glide.with(itemView)
                        .load(catalogue.poster)
                        .into(iv_poster_list)
                tv_title.text = catalogue.title
                tv_genre.text = catalogue.genre
                itemView.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(ID, catalogue.id)
                        putExtra(TITLE, catalogue.title)
                        putExtra(CLICK, adapterId)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}