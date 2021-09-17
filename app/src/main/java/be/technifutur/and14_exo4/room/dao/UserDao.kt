package be.technifutur.and14_exo4.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import be.technifutur.and14_exo4.room.model.User
import be.technifutur.and14_exo4.room.model.UserBook

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>
    @Insert
    suspend fun insert(user: User): Long
    @Delete
    fun delete(user: User)
    @Query("SELECT * FROM user WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): LiveData<User>

    @Transaction
    @Query("SELECT * FROM user")
    fun getAllWithBook(): LiveData<List<UserBook>>
}