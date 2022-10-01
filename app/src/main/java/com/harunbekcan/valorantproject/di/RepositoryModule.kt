package com.harunbekcan.valorantproject.di

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.repository.agents.AgentRepository
import com.harunbekcan.valorantproject.data.repository.agents.AgentRepositoryImpl
import com.harunbekcan.valorantproject.data.repository.maps.MapRepository
import com.harunbekcan.valorantproject.data.repository.maps.MapRepositoryImpl
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

    @Provides
    @Singleton
    fun provideMapRepository(serviceInterface: ServiceInterface): MapRepository {
        return MapRepositoryImpl(serviceInterface)
    }
}