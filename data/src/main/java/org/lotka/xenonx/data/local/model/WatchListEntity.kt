package org.lotka.xenonx.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.lotka.xenonx.domain.model.WatchListModel

@Entity(tableName = "watch_list_table")
data class WatchListEntity(
    @PrimaryKey val mediaId: Int,
    val imagePath: String?,
    val title: String,
    val releaseDate: String,
    val rating: Double,
    val addedOn: String
)

fun WatchListModel.toWatchListEntity(): WatchListEntity {
    return WatchListEntity(
        mediaId = mediaId,
        imagePath = imagePath,
        title = title,
        releaseDate = releaseDate,
        addedOn = addedOn,
        rating = rating
    )
}


fun WatchListEntity.toWatchListModel(): WatchListModel {
    return WatchListModel(
        mediaId = mediaId,
        imagePath = imagePath,
        title = title,
        releaseDate = releaseDate,
        addedOn = addedOn,
        rating = rating
        )
}