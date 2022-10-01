package com.harunbekcan.valorantproject.di

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.repository.agents.AgentRepository
import com.harunbekcan.valorantproject.data.repository.agents.AgentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAgentRepository(serviceInterface: ServiceInterface): AgentRepository {
        return AgentRepositoryImpl(serviceInterface)
    }
}