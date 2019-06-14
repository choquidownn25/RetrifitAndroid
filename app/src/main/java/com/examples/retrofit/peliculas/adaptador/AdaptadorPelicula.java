package com.examples.retrofit.peliculas.adaptador;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.examples.retrofit.R;
import com.examples.retrofit.peliculas.modelo.Pelicula;
import com.examples.retrofit.programadores.actividad.DetailActivity;
import com.squareup.picasso.Picasso;


import java.util.List;

public class AdaptadorPelicula extends RecyclerView.Adapter<AdaptadorPelicula.ViewHolder>  {


    private List<Pelicula> peliculas;
    private Context context;

    public AdaptadorPelicula(Context context, List<Pelicula> peliculas){
        this.context = context;
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public AdaptadorPelicula.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_personas, viewGroup, false);
        return new AdaptadorPelicula.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPelicula.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(peliculas.get(i).getTitle());
//        viewHolder.genre.setText( peliculas.get(i).getReleaseYear());

        Picasso.get()
                .load(peliculas.get(i).getImage())
                .placeholder(R.drawable.load)
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, genre;
        private ImageView imageView;

        public ViewHolder(@NonNull View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.first_name);
            genre = (TextView) view.findViewById(R.id.last_name);
            imageView = (ImageView) view.findViewById(R.id.cover);

            //on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Pelicula clickedDataItem = peliculas.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("login", peliculas.get(pos).getTitle());
//                        intent.putExtra("html_url",  peliculas.get(pos).getReleaseYear());
                        intent.putExtra("avatar_url", peliculas.get(pos).getImage());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }

            });

        }
    }
}
