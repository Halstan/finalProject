package com.example.finalproject.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Adaptadores.AdaptadorElementos;
import com.example.finalproject.Clases.Elementos;
import com.example.finalproject.R;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    ArrayList<Elementos> listaElementos;
    RecyclerView recyclerElementos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        listaElementos =new ArrayList<>();
        recyclerElementos = (RecyclerView) root.findViewById(R.id.RecycleElementos);
        recyclerElementos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdaptadorElementos adaptadorElementos = new AdaptadorElementos(listaElementos);
        recyclerElementos.setAdapter(adaptadorElementos);

        return root;
    }

    private void llenarLista() {
        listaElementos.add(new Elementos("Android Studio", "Lenguaje", R.drawable.android_studio));
        listaElementos.add(new Elementos("Java", "Lenguaje", R.drawable.java));
        listaElementos.add(new Elementos("Python", "Lenguaje", R.drawable.python));
        listaElementos.add(new Elementos("Visual Basic", "Lenguaje", R.drawable.visual_basic));
        listaElementos.add(new Elementos("MySql", "Lenguaje", R.drawable.mysql));
        listaElementos.add(new Elementos("Spring", "Lenguaje", R.drawable.spring));
    }

}
