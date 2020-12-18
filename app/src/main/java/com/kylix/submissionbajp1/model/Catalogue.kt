package com.kylix.submissionbajp1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Catalogue(
    var id: Int? = 0,
    var title: String? = null,
    var release: String? = null,
    var genre: String? = null,
    var duration: String? = null,
    var score: String? = null,
    var overview: String? = null,
    var poster: Int? = 0
): Parcelable