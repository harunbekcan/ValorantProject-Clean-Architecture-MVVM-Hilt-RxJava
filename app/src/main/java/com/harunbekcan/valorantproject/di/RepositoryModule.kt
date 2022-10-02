package com.harunbekcan.valorantproject.di

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.repository.agents.AgentsRepository
import com.harunbekcan.valorantproject.data.repository.agents.AgentsRepositoryImpl
import com.harunbekcan.valorantproject.data.repository.maps.MapsRepository
import com.harunbekcan.valorantproject.data.repository.maps.MapsRepositoryImpl
import com.harunbekcan.valorantproject.data.repository.weapons.WeaponsRepository
import com.harunbekcan.valorantproject.data.repository.weapons.WeaponsRepositoryImpl
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
    fun provideAgentsRepository(serviceInterface: ServiceInterface): AgentsRepository {
        return AgentsRepositoryImpl(serviceInterface)
    }

    @Provides
    @Singleton
    fun provideMapsRepository(serviceInterface: ServiceInterface): MapsRepository {
        return MapsRepositoryImpl(serviceInterface)
    }

    @Provides
    @Singleton
    fun provideWeaponsRepository(serviceInterface: ServiceInterface): WeaponsRepository {
        return WeaponsRepositoryImpl(serviceInterface)
    }
}