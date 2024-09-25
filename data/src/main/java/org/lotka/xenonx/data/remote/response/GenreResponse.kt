package org.lotka.xenonx.data.remote.response

import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.GenreDto


data class GenreResponse(
    @SerializedName("genres")
    val genres: List<GenreDto>
)


