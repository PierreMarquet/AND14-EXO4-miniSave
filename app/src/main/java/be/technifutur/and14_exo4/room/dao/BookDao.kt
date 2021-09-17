package be.technifutur.and14_exo4.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import be.technifutur.and14_exo4.room.model.Book

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun getAll(): LiveData<List<Book>>
    @Insert
    suspend fun insert(book: Book): Long
    @Delete
    fun delete(book: Book)
    @Query("SELECT * FROM book WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): LiveData<Book>
}