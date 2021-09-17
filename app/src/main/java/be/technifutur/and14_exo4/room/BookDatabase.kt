package be.technifutur.and14_exo4.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import be.technifutur.and14_exo4.room.dao.BookDao
import be.technifutur.and14_exo4.room.dao.UserDao
import be.technifutur.and14_exo4.room.model.Book
import be.technifutur.and14_exo4.room.model.User

@Database(entities = arrayOf(Book::class, User::class), version = 2)
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun userDao(): UserDao

    companion object {
        fun getSharedInstance(context: Context): BookDatabase{
            sharedInstance?.let{
                return it
            }
            synchronized(this){
                sharedInstance = Room.databaseBuilder(context, BookDatabase::class.java, "Book.db")
                    .fallbackToDestructiveMigration()
                    .build()
                return sharedInstance!!
            }
        }

        @Volatile
        private var sharedInstance: BookDatabase? = null
    }
}