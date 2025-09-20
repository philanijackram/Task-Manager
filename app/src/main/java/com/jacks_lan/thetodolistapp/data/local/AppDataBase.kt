package com.jacks_lan.thetodolistapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jacks_lan.thetodolistapp.data.local.dao.TaskDao
import com.jacks_lan.thetodolistapp.data.local.entity.TaskItemEntity

@Database(
    entities = [TaskItemEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        const val DATABASE_NAME = "the_todo_list_app_db"
    }
}

