package com.example.roomdatabase


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [DataClass:: class], version = 2)
abstract  class UserDatabase : RoomDatabase(){
    abstract fun UserDao():UserDao

    companion object{
        // Singleton prevents multiple instances of database opening at the
        // same time.

        @Volatile
        private var INSTANCE:UserDatabase?= null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context) : UserDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database

            return INSTANCE ?: synchronized(this)
            {
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database_new"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return  instance
            }

        }

    }

}

