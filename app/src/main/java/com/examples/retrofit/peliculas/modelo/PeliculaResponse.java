package com.examples.retrofit.peliculas.modelo;

import com.examples.retrofit.programadores.modelo.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculaResponse {
    @SerializedName("peliculas")
    @Expose
    private List<Pelicula> peliculas;

    public List<Pelicula> getPeliculas(){
        return peliculas;
    }


    public void setItems(List<Pelicula>peliculas){
        this.peliculas = peliculas;
    }
}
