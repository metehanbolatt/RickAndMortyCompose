package com.metehanbolat.domain.repository

import com.metehanbolat.domain.model.CharacterItem
import com.metehanbolat.domain.state.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {

    suspend fun getSingleCharacter(id: String): Flow<NetworkResponse<CharacterItem>>
}