package org.lotka.xenonx.data.remote.Dto.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import org.lotka.xenonx.domain.model.Genre


@Parcelize
data class GenreDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String
): Parcelable

fun Genre.toGenreDto(): GenreDto {
    return GenreDto(
        id = id,
        name = name
    )
}


fun GenreDto.toGenre(): Genre {
    return Genre(
        id = id,
        name = name
    )

}