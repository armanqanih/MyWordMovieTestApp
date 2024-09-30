package org.lotka.xenonx.data.remote.Dto.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import org.lotka.xenonx.domain.model.Cast


@Parcelize
data class CastDto(
    @SerializedName("known_for_department")
    val department: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String?
): Parcelable

fun CastDto.toCast(): Cast {
    return Cast(
        department = department,
        name = name,
        profilePath = profilePath
    )
}