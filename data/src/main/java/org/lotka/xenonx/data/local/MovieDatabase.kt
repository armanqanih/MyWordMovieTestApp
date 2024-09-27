package org.lotka.xenonx.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import org.lotka.xenonx.data.local.model.MoviesEntity
import org.lotka.xenonx.data.local.model.WatchListEntity

@AutoMigration(from = 1, to = 2)
@Database(version = 1, entities = [MoviesEntity::class,WatchListEntity::class],
    exportSchema = false)
abstract class MovieDatabase():RoomDatabase() {
    abstract fun movieDao(): MovieDao
}