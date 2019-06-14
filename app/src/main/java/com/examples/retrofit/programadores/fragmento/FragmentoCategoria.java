package com.examples.retrofit.programadores.fragmento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.examples.retrofit.R;
import com.examples.retrofit.programadores.adaptadores.AdaptadorCategorias;
import com.examples.retrofit.programadores.adaptadores.AdaptadorInicio;
import com.examples.retrofit.programadores.modelo.Comida;

import java.util.List;

public class FragmentoCategoria  extends Fragment {

    private static final String INDICE_SECCION
            = "com.restaurantericoparico.FragmentoCategoriasTab.extra.INDICE_SECCION";

    private RecyclerView reciclador;
    private GridLayoutManager layoutManager;
    private AdaptadorCategorias adaptador;
//    private List<Comida> listData;
    private List<String> listData;
//    private ApiInterface apiInterface;
//    private AdaptadorCategoriass adaptadorCategoriass;
    private AdaptadorInicio adaptadorInicio;
    private RecyclerView recyclerView;

    public static FragmentoCategoria nuevaInstancia(int indiceSeccion) {
        FragmentoCategoria fragment = new FragmentoCategoria();
        Bundle args = new Bundle();
        args.putInt(INDICE_SECCION, indiceSeccion);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_grupo_items, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        reciclador.setLayoutManager(layoutManager);

        int indiceSeccion = getArguments().getInt(INDICE_SECCION);

        switch (indiceSeccion) {
            case 0:

                adaptador = new AdaptadorCategorias();

                break;
            case 1:
                adaptador = new AdaptadorCategorias();
//                reciclador.setAdapter(adaptador);
                break;
            case 2:
                adaptador = new AdaptadorCategorias();
//                reciclador.setAdapter(adaptador);
                break;
        }



        return view;
    }
}
