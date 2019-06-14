package com.examples.retrofit.personas.Adaptador;

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
import com.examples.retrofit.personas.modelo.Datum;
import com.examples.retrofit.personas.modelo.Persona;
import com.examples.retrofit.programadores.actividad.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.ViewHolder>  {

    private List<Datum> personas;
    private Context context;

    public  AdaptadorPersona (Context context, List<Datum> personas){
            this.context = context;
            this.personas = personas;
    }

    @NonNull
    @Override
    public AdaptadorPersona.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_personas, viewGroup, false);
        return new AdaptadorPersona.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersona.ViewHolder viewHolder, int i) {

        viewHolder.first_name.setText(personas.get(i).getLastName());
        viewHolder.last_name.setText(personas.get(i).getLastName());

        Picasso.get()
                .load(personas.get(i).getAvatar())
                .placeholder(R.drawable.load)
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView first_name, last_name;
        private ImageView imageView;

        public ViewHolder(@NonNull View view) {
            super(view);

            first_name = (TextView) view.findViewById(R.id.first_name);
            last_name = (TextView) view.findViewById(R.id.last_name);
            imageView = (ImageView) view.findViewById(R.id.cover);

            //on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Datum clickedDataItem = personas.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("login", personas.get(pos).getFirstName());
                        intent.putExtra("html_url", personas.get(pos).getLastName());
                        intent.putExtra("avatar_url", personas.get(pos).getAvatar());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getFirstName(), Toast.LENGTH_SHORT).show();
                    }
                }

            });

        }
    }
}
