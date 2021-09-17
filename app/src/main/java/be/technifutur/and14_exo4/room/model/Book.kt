package be.technifutur.and14_exo4.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val name: String,
    val ownerId: Long
)