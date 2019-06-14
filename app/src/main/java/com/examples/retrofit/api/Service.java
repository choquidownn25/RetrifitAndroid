package com.examples.retrofit.api;

import com.examples.retrofit.peliculas.modelo.Pelicula;
import com.examples.retrofit.peliculas.modelo.PeliculaResponse;
import com.examples.retrofit.personas.modelo.Persona;
import com.examples.retrofit.programadores.modelo.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by delaroy on 3/22/17.
 */
public interface Service {
    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
//    https://reqres.in/api/users
    @GET("/api/users")
    Call<Persona> getPersonas();
    //   https://api.androidhive.info/json/movies.json

    @GET("/json/movies.json")
    // Call<Pelicula> getPeliculas();
    Call<List<Pelicula>> getPeliculas();

}
