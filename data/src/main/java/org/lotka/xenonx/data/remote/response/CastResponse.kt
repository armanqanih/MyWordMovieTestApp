package org.lotka.xenonx.data.remote.response


import com.google.gson.annotations.SerializedName
import org.lotka.xenonx.data.remote.Dto.models.CastDto
import org.lotka.xenonx.data.remote.Dto.models.toCast
import org.lotka.xenonx.domain.model.Cast
import org.lotka.xenonx.domain.model.response.CastResponse

data class CastResponseDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val castResult: List<CastDto>
)

fun CastResponseDto.toCastResponse(): CastResponse {
    return CastResponse(
        id = id,
        castResult = castResult.map { it.toCast() }
    )

}