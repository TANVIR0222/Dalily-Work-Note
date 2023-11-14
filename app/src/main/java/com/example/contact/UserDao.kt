package com.example.contact

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    fun insert( user: User)
    
    @Update
    fun update(user: User)
    
    @Insert
    fun insertAll(vararg users: User)
    
    @Delete
    fun delete(user: User)
    
    @Query("SELECT * FROM user")
    fun getAll(): List<User>
    
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>
    
    @Query("SELECT * FROM user WHERE name LIKE :first LIMIT 1")
    fun findByName(first: String): User
    
    
}
