package be.technifutur.and14_exo4.room.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserBook (
    @Embedded
    var user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "ownerId"
    )
    var book:List<Book>
        )
