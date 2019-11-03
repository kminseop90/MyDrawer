package com.minseop.mydrawer.model.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Content")
data class Content(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "url")
    var url: String = "",

    @ColumnInfo(name = "type")
    var type: Int = 0

) {
    constructor(): this(null,"", "","", 0)
}