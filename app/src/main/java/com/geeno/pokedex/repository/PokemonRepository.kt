package com.geeno.pokedex.repository

import com.geeno.pokedex.data.remote.PokeApi
import com.geeno.pokedex.data.remote.responses.Pokemon
import com.geeno.pokedex.data.remote.responses.PokemonList
import com.geeno.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit,offset)
        } catch (e: Exception){
            return Resource.Error("An unknown error occurred.", null)
        }
        return Resource.Success(response)
    }


    suspend fun getPokemonInfo(name: String) : Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name)
        } catch (e: Exception){
            return Resource.Error("An unknown error occurred.", null)
        }
        return Resource.Success(response)
    }
}