package com.metehanbolat.data.repository

import com.metehanbolat.data.api.RickAndMortyApi
import com.metehanbolat.data.extension.toCharacterItem
import com.metehanbolat.domain.model.CharacterItem
import com.metehanbolat.domain.repository.RickAndMortyRepository
import com.metehanbolat.domain.state.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : RickAndMortyRepository {

    override suspend fun getSingleCharacter(id: String): Flow<NetworkResponse<CharacterItem>> =
        flow {
            try {
                val response = api.getSingleCharacter(id = id).toCharacterItem()
                emit(NetworkResponse.Success(result = response))
            } catch (e: Exception) {
                emit(NetworkResponse.Error(exception = e))
            }
        }

}

