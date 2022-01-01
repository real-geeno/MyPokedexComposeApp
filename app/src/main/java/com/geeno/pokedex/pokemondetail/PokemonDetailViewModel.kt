package com.geeno.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.geeno.pokedex.data.remote.responses.Pokemon
import com.geeno.pokedex.repository.PokemonRepository
import com.geeno.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String) : Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }

}