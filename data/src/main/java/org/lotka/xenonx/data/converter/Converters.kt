package org.lotka.xenonx.data.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.lotka.xenonx.domain.model.Genre
@ProvidedTypeConverter
class Converters(private val gson: Gson) {


        @TypeConverter
        fun fromGenreList(genres: List<Genre>?): String? {
            return gson.toJson(genres)
        }

        @TypeConverter
        fun toGenreList(genresString: String?): List<Genre>? {
            val listType = object : TypeToken<List<Genre>>() {}.type
            return gson.fromJson(genresString, listType)
        }
    }



    @TypeConverter
    fun fromGenreList(value: List<Genre>?): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toGenreList(value: String): List<Genre> {
        val listType = object : TypeToken<List<Genre>>() {}.type
        return Gson().fromJson(value, listType)
    }
