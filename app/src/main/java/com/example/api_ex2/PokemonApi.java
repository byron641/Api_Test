package com.example.api_ex2;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {

    @GET("pokemon/{name}")
    call<Pokemon> getPokemon(@Path("name") String name);

}
