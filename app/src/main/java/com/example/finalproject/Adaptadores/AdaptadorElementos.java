package com.example.finalproject.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Clases.Elementos;
import com.example.finalproject.R;

import java.util.ArrayList;

public class AdaptadorElementos extends RecyclerView.Adapter<AdaptadorElementos.ViewHolderElementos> {

    ArrayList<Elementos> listaElementos;

    public AdaptadorElementos(ArrayList<Elementos> listaElementos) {
        this.listaElementos = listaElementos;
    }

    @Override
    public ViewHolderElementos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_lista_elementos, null, false);
        return new ViewHolderElementos(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorElementos.ViewHolderElementos holder, int position) {
        holder.nombre.setText(listaElementos.get(position).getNombre());
        holder.info.setText(listaElementos.get(position).getInformacion());
        holder.imagen.setImageResource(listaElementos.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return listaElementos.size();
    }

    public class ViewHolderElementos extends RecyclerView.ViewHolder {
        TextView nombre, info;
        ImageView imagen;

        public ViewHolderElementos(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.Nombre);
            info = (TextView) itemView.findViewById(R.id.Info);
            imagen = (ImageView) itemView.findViewById(R.id.Imagen);
        }
    }
}