package be.technifutur.and14_exo4.room

import android.content.Context
import androidx.lifecycle.LiveData
import be.technifutur.and14_exo4.room.model.Book
import be.technifutur.and14_exo4.room.model.User
import be.technifutur.and14_exo4.room.model.UserBook
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {
    companion object {

    var bookDB: BookDatabase? = null

    fun initDB(context: Context): BookDatabase {
        return BookDatabase.getSharedInstance(context)
    }

    fun insertUser(context: Context, name: String) {
        if (bookDB == null) {
            bookDB = initDB(context)
        }
        bookDB?.let { db ->
            CoroutineScope(IO).launch {
                val user = User(name = name)
                val userId = db.userDao().insert(user)
            }
        }
    }

    fun getUsersWithBooks(context: Context): LiveData<List<UserBook>> {
        if (bookDB == null) {
            bookDB = initDB(context)
        }
        return bookDB!!.userDao().getAllWithBook()
    }

    fun getBooks(context: Context): LiveData<List<Book>> {
        if (bookDB == null) {
            bookDB = initDB(context)
        }
        return bookDB!!.bookDao().getAll()
    }

    fun insertUserWithBooks(context: Context, name: String, books: Array<String>) {
        if (bookDB == null) {
            bookDB = initDB(context)
        }
        bookDB?.let { db ->
            CoroutineScope(IO).launch {
                val user = User(name = name)
                val userId = db.userDao().insert(user)
                books.forEach { bookName ->
                    val book = Book(name = bookName, ownerId = userId)
                    db.bookDao().insert(book)
                }
            }
        }
    }
}
}