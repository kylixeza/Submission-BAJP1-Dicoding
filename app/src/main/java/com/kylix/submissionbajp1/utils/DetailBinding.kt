package com.kylix.submissionbajp1.utils

import android.widget.ImageView
import com.kylix.submissionbajp1.model.Catalogue

interface DetailBinding {

    fun setBinding(catalogue: Catalogue)
    fun multipleGlide(firstImage: ImageView, secondImage: ImageView, catalogue: Catalogue)
}