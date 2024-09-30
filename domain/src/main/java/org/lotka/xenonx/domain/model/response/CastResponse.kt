package org.lotka.xenonx.domain.model.response


import org.lotka.xenonx.domain.model.Cast

data class CastResponse(
    val id: Int,
    val castResult: List<Cast>
)
