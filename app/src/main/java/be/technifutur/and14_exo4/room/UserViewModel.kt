package be.technifutur.and14_exo4.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import be.technifutur.and14_exo4.room.model.Book
import be.technifutur.and14_exo4.room.model.UserBook

class UserViewModel: ViewModel() {
    var liveDataUserBook: LiveData<UserBook>? = null
    fun insertUser(context: Context, name: String, books: Array<String>): Long {
        UserRepository.insertUserWithBooks(context, name, books)
        return 1
    }

    fun getUserWithBooks(context: Context): LiveData<List<UserBook>> {
        return UserRepository.getUsersWithBooks(context)
    }

    fun getBooks(context: Context): LiveData<List<Book>>{
        return UserRepository.getBooks(context)
    }
}