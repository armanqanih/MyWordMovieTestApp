package org.lotka.xenonx.domain.model

import android.os.Parcelable



data class ProductionCompany(

    val id: Int,

    val logoPath: String?,

    val name: String,

    val originCountry: String
)
