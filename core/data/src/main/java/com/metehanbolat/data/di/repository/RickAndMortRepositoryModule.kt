package com.metehanbolat.data.di.repository

import com.metehanbolat.data.repository.RickAndMortyRepositoryImpl
import com.metehanbolat.domain.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RickAndMortRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyRepository(rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl): RickAndMortyRepository
}