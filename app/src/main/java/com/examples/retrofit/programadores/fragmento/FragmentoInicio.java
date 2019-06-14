package com.examples.retrofit.programadores.fragmento;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.examples.retrofit.R;
import com.examples.retrofit.api.ConexionPeliculas;
import com.examples.retrofit.api.ConexionPersonas;
import com.examples.retrofit.peliculas.adaptador.AdaptadorPelicula;
import com.examples.retrofit.peliculas.modelo.Pelicula;
import com.examples.retrofit.peliculas.modelo.PeliculaResponse;
import com.examples.retrofit.personas.Adaptador.AdaptadorPersona;
import com.examples.retrofit.personas.modelo.Datum;
import com.examples.retrofit.personas.modelo.Persona;
import com.examples.retrofit.programadores.adaptadores.AdaptadorCategorias;
import com.examples.retrofit.programadores.adaptadores.AdaptadorInicio;
import com.examples.retrofit.programadores.adaptadores.AdaptadorItem;
import com.examples.retrofit.api.Client;
import com.examples.retrofit.api.Service;
import com.examples.retrofit.programadores.modelo.Item;
import com.examples.retrofit.programadores.modelo.ItemResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentoInicio  extends Fragment {


    private static final String INDICE_SECCION
            = "com.restaurantericoparico.FragmentoCategoriasTab.extra.INDICE_SECCION";

    private RecyclerView reciclador;
    private GridLayoutManager layoutManager;
    private AdaptadorCategorias adaptador;
    //    private List<Comida> listData;
    private List<String> listData;
    //    private ApiInterface apiInterface;

    private AdaptadorInicio adaptadorInicio;
    private RecyclerView recyclerView;
    TextView Disconnected;
    private Item item;
    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;
    private Context context;
    List<Pelicula> peliculas = new ArrayList<>();
    public static FragmentoInicio nuevaInstancia(int indiceSeccion) {
        FragmentoInicio fragment = new FragmentoInicio();
        Bundle args = new Bundle();
        args.putInt(INDICE_SECCION, indiceSeccion);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_grupo_items, container, false);

        context = getActivity();

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador);
        layoutManager = new GridLayoutManager(getContext(), 2);
        reciclador.setLayoutManager(layoutManager);


        int indiceSeccion = getArguments().getInt(INDICE_SECCION);

        switch (indiceSeccion) {
            case 0:

                initViews(view);

                break;
            case 1:
                initViewsPersonas (view);
//                adaptador = new AdaptadorCategorias();
//                reciclador.setAdapter(adaptador);
                break;
            case 2:
                initViewsPeliculas(view);
//                adaptador = new AdaptadorCategorias();
//                reciclador.setAdapter(adaptador);
                break;
        }


        return view;
    }


    private void initViews(View view){

        pd = new ProgressDialog(getContext());
        pd.setMessage("Fetching Github Users...");
        pd.setCancelable(false);
        pd.show();

        loadJSON(view);
//        swipeContainer.setRefreshing(false);
        pd.hide();
    }

    private void loadJSON(View view){
        Disconnected = (TextView) view.findViewById(R.id.disconnected);
        try{
            Client Client = new Client();
            Service apiService =
                    Client.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.getItems();
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    List<Item> items = response.body().getItems();
                    reciclador.setAdapter(new AdaptadorItem(context, items));

                    /**
                     Simple GridLayoutManager that spans two columns
                     **/
                    GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                    reciclador.setLayoutManager(manager);

                    reciclador.smoothScrollToPosition(0);

                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(getContext(), "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                    Disconnected.setVisibility(View.VISIBLE);
                    pd.hide();

                }
            });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void initViewsPersonas (View view){
        pd = new ProgressDialog(getContext());
        pd.setMessage("Fetching Github Users...");
        pd.setCancelable(false);
        pd.show();

        loadJSONPersonas(view);

        pd.hide();
    }

    private void loadJSONPersonas(View view){
        Disconnected = (TextView) view.findViewById(R.id.disconnected);
        try {
        ConexionPersonas Client = new ConexionPersonas();
        Service apiService =
                Client.getClient().create(Service.class);
        Call<Persona> call = apiService.getPersonas();
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                List<Datum> items = response.body().getData();
                reciclador.setAdapter(new AdaptadorPersona(context, items));

                /**
                 Simple GridLayoutManager that spans two columns
                 **/
                GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                reciclador.setLayoutManager(manager);

                reciclador.smoothScrollToPosition(0);

            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(getContext(), "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                Disconnected.setVisibility(View.VISIBLE);
                pd.hide();

            }
        });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private  void  initViewsPeliculas(View view){
        pd = new ProgressDialog(getContext());
        pd.setMessage("Fetching Github Users...");
        pd.setCancelable(false);
        pd.show();

        loadJSONPeliculas(view);

        pd.hide();
    }

    private  void  loadJSONPeliculas(View view){
        Disconnected = (TextView) view.findViewById(R.id.disconnected);

        try {
            ConexionPeliculas Client = new ConexionPeliculas();
            Service apiService =
                    Client.getClient().create(Service.class);
            Call<List<Pelicula>>  call = apiService.getPeliculas();
            call.enqueue(new Callback<List<Pelicula>>() {
                @Override
                public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                    peliculas= response.body();
                    reciclador.setAdapter(new AdaptadorPelicula(context, peliculas));
                    /**
                     Simple GridLayoutManager that spans two columns
                     **/
                    GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                    reciclador.setLayoutManager(manager);

                    reciclador.smoothScrollToPosition(0);
                }

                @Override
                public void onFailure(Call<List<Pelicula>> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(getContext(), "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                    Disconnected.setVisibility(View.VISIBLE);
                    pd.hide();
                }


//                @Override
//                public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
//                    peliculas= response.body();
////                  reciclador.setAdapter(new AdaptadorPelicula(context, peliculas));
//
//                    /**
//                     Simple GridLayoutManager that spans two columns
//                     **/
//                    GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
//                    reciclador.setLayoutManager(manager);
//
//                    reciclador.smoothScrollToPosition(0);
//
//                }
//
//                @Override
//                public void onFailure(Call<Pelicula> call, Throwable t) {
//                    Log.d("Error", t.getMessage());
//                    Toast.makeText(getContext(), "Error Fetching Data!", Toast.LENGTH_SHORT).show();
//                    Disconnected.setVisibility(View.VISIBLE);
//                    pd.hide();
//
//                }

            });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
