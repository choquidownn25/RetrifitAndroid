package com.examples.retrofit.programadores.modelo;

import com.examples.retrofit.R;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de datos estático para alimentar la aplicación
 */
public class Comida {
    @SerializedName("imageurl")
    private String imageurl;
    private float precio;
    private String nombre;
    private int idDrawable;

    public Comida(float precio, String nombre, int idDrawable, String imageurl) {
        this.precio = precio;
        this.nombre = nombre;
        this.idDrawable = idDrawable;
        this.imageurl = imageurl;
    }

    public static final List<Comida> COMIDAS_POPULARES = new ArrayList<Comida>();
    public static final List<Comida> BEBIDAS = new ArrayList<>();
    public static final List<Comida> POSTRES = new ArrayList<>();
    public static final List<Comida> PLATILLOS = new ArrayList<>();

    {
        COMIDAS_POPULARES.add(new Comida(5, "Camarones Tismados", R.drawable.camarones, Comida.this.getImageurl()));
        COMIDAS_POPULARES.add(new Comida(3.2f, "Rosca Herbárea", R.drawable.rosca, Comida.this.getImageurl()));
        COMIDAS_POPULARES.add(new Comida(12f, "Sushi Extremo", R.drawable.sushi, Comida.this.getImageurl()));
        COMIDAS_POPULARES.add(new Comida(9, "Sandwich Deli", R.drawable.sandwich, Comida.this.getImageurl()));
        COMIDAS_POPULARES.add(new Comida(34f, "Lomo De Cerdo Austral", R.drawable.lomo_cerdo, Comida.this.getImageurl()));

        PLATILLOS.add(new Comida(5, "Camarones Tismados", R.drawable.camarones, Comida.this.getImageurl()));
        PLATILLOS.add(new Comida(3.2f, "Rosca Herbárea", R.drawable.rosca, Comida.this.getImageurl()));
        PLATILLOS.add(new Comida(12f, "Sushi Extremo", R.drawable.sushi, Comida.this.getImageurl()));
        PLATILLOS.add(new Comida(9, "Sandwich Deli", R.drawable.sandwich, Comida.this.getImageurl()));
        PLATILLOS.add(new Comida(34f, "Lomo De Cerdo Austral", R.drawable.lomo_cerdo, Comida.this.getImageurl()));

        BEBIDAS.add(new Comida(3, "Taza de Café", R.drawable.cafe, Comida.this.getImageurl()));
        BEBIDAS.add(new Comida(12, "Coctel Tronchatoro", R.drawable.coctel, Comida.this.getImageurl()));
        BEBIDAS.add(new Comida(5, "Jugo Natural", R.drawable.jugo_natural, Comida.this.getImageurl()));
        BEBIDAS.add(new Comida(24, "Coctel Jordano", R.drawable.coctel_jordano, Comida.this.getImageurl()));
        BEBIDAS.add(new Comida(30, "Botella Vino Tinto Darius", R.drawable.vino_tinto, Comida.this.getImageurl()));

        POSTRES.add(new Comida(2, "Postre De Vainilla", R.drawable.postre_vainilla, Comida.this.getImageurl()));
        POSTRES.add(new Comida(3, "Flan Celestial", R.drawable.flan_celestial, Comida.this.getImageurl()));
        POSTRES.add(new Comida(2.5f, "Cupcake Festival", R.drawable.cupcakes_festival, Comida.this.getImageurl()));
        POSTRES.add(new Comida(4, "Pastel De Fresa", R.drawable.pastel_fresa, Comida.this.getImageurl()));
        POSTRES.add(new Comida(5, "Muffin Amoroso", R.drawable.muffin_amoroso, Comida.this.getImageurl()));
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

    public Comida (String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }



}
