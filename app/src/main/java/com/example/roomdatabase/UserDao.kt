package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert

@Dao
interface UserDao {


    @Query("Select * From users_table")
    fun getUsers(): List<DataClass>

    @Insert
    suspend fun insert(user: DataClass)

    @Query("DELETE FROM users_table")
    fun deleteTable()

    @Query("Select * from users_table where first_name =:fname")
    fun getUserByFname(fname: String):DataClass


    // @Update(onConflict = OnConflictStrategy.REPLACE)

    //fun updateTable(user: DataClass)

    @Query("UPDATE users_table SET first_name=:fname,last_name=:lname WHERE phone_number = :pno")
    fun updateByNumber(fname:String,lname:String,pno:String);


}