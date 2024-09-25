package org.lotka.xenonx.data.remote.response


import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.SearchDto

class MultiSearchResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<SearchDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
