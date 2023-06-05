package com.metehanbolat.rickandmortycompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.domain.model.CharacterItem
import com.metehanbolat.domain.repository.RickAndMortyRepository
import com.metehanbolat.domain.state.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {

    private val _characterState = MutableStateFlow(CharacterItem())
    val characterState: StateFlow<CharacterItem> = _characterState.asStateFlow()

    fun getSingleCharacter(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            rickAndMortyRepository.getSingleCharacter(id = id)
                .onStart { println("onStart") }
                .onCompletion { println("onCompletion") }
                .collectLatest { response ->
                    when(response) {
                        NetworkResponse.Loading -> println("Loading")
                        is NetworkResponse.Error -> println("Error ${response.exception}")
                        is NetworkResponse.Success -> {
                            _characterState.emit(response.result)
                        }
                    }
                }
        }
    }
}