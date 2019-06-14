package com.examples.retrofit.programadores.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Programadores {


    @SerializedName("imageurl")
    private String imageurl;
    private float precio;
    private String nombre;
    private int idDrawable;

    public Programadores(float precio, String nombre, int idDrawable, String imageurl) {
        this.precio = precio;
        this.nombre = nombre;
        this.idDrawable = idDrawable;
        this.imageurl = imageurl;
    }



    public float getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public Programadores (String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }
}
