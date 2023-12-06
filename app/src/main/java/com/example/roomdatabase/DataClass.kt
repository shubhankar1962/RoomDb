package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users_table")
data class DataClass(
    @PrimaryKey(autoGenerate = true) val uid : Int,
    @ColumnInfo(name = "first_name") val fname:String,
    @ColumnInfo(name="last_name") val Lname:String ,
    @ColumnInfo(name="phone_number") val pnumber:String )