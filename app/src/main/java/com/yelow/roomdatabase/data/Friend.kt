package com.yelow.roomdatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Friend(
    val name: String,
    val school: String,
    val hobby: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}