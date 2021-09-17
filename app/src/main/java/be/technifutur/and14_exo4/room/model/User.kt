package be.technifutur.and14_exo4.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String
    )
