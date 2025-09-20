package com.jacks_lan.thetodolistapp.di

import android.app.Application
import androidx.room.Room
import com.jacks_lan.thetodolistapp.data.local.AppDataBase
import com.jacks_lan.thetodolistapp.data.local.dao.TaskDao
import com.jacks_lan.thetodolistapp.data.repository.TaskRepository
import com.jacks_lan.thetodolistapp.domain.repository.TaskRepositoryImpl
import com.jacks_lan.thetodolistapp.domain.use_case.CreateTaskUseCase
import com.jacks_lan.thetodolistapp.domain.use_case.DeleteTaskUseCase
import com.jacks_lan.thetodolistapp.domain.use_case.GetAllTasksUseCase
import com.jacks_lan.thetodolistapp.domain.use_case.GetTaskByIdUseCase
import com.jacks_lan.thetodolistapp.domain.use_case.UpdateTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTaskRepository(db: AppDataBase): TaskRepository {
        return TaskRepositoryImpl(db.taskDao())
    }

    @Provides
    @Singleton
    fun provideTaskDatabase(app: Application): AppDataBase {
        return Room.databaseBuilder(
            app,
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(db: AppDataBase): TaskDao {
        return db.taskDao()
    }

    @Provides
    @Singleton
    fun provideGetAllTasksUseCase(
        taskRepository: TaskRepository
    ): GetAllTasksUseCase {
        return GetAllTasksUseCase(taskRepository)
    }

    @Provides
    @Singleton
    fun provideCreateTaskUseCase(
        taskRepository: TaskRepository
    ): CreateTaskUseCase {
        return CreateTaskUseCase(taskRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateTaskUseCase(
        taskRepository: TaskRepository
    ): UpdateTaskUseCase {
        return UpdateTaskUseCase(taskRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteTaskUseCase(
        taskRepository: TaskRepository
    ): DeleteTaskUseCase {
        return DeleteTaskUseCase(taskRepository)
    }

    @Provides
    @Singleton
    fun provideGetTaskByIdUseCase(
        taskRepository: TaskRepository
    ): GetTaskByIdUseCase {
        return GetTaskByIdUseCase(taskRepository)
    }

}