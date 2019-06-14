package com.examples.retrofit.programadores.adaptadores;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.examples.retrofit.R;

import java.util.List;

/**
 * Adaptador para mostrar las comidas más pedidas en la sección "Inicio"
 */
public class AdaptadorInicio
        extends RecyclerView.Adapter<AdaptadorInicio.ViewHolder> {
//    private List<Comida> listaDato;
    private List<String> listData;
    public AdaptadorInicio(List<String> listData) {
        this.listData=listData;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;

        public ViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.nombre_comida);
            precio = (TextView) v.findViewById(R.id.precio_comida);
            imagen = (ImageView) v.findViewById(R.id.miniatura_comida);
        }
    }


    @Override
    public int getItemCount() {
//        return Comida.COMIDAS_POPULARES.size();
        return listData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_inicio, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
//        Comida item = Comida.COMIDAS_POPULARES.get(i);
//
//        Glide.with(viewHolder.itemView.getContext())
//                .load(item.getImageurl())
//                .centerCrop()
//                .into(viewHolder.imagen);
//        viewHolder.nombre.setText(item.getNombre());
//        viewHolder.precio.setText("$" + item.getPrecio());

    }


}