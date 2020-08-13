package com.example.finalproject.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Clases.Usuarios;
import com.example.finalproject.R;

import java.util.List;

public class AdaptadorUsuarios extends RecyclerView.Adapter<AdaptadorUsuarios.ViewHolder> {

    public List<Usuarios> usuariosList;

    public AdaptadorUsuarios(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @NonNull
    @Override
    public AdaptadorUsuarios.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.layout_items_usuarios,parent,false );
        AdaptadorUsuarios.ViewHolder viewHolder = new AdaptadorUsuarios.ViewHolder( view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorUsuarios.ViewHolder holder, int position) {
        holder.nombre.setText( usuariosList.get(position).getNombre() );
        holder.idUsuario.setText( usuariosList.get( position ).getIdUsuario() );
        holder.mail.setText( usuariosList.get( position ).getMail() );
        holder.edad.setText( usuariosList.get( position ).getEdad());
    }

    @Override
    public int getItemCount() {
        return usuariosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, idUsuario, mail, edad;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.txtIdUsuario);
            idUsuario = (TextView) itemView.findViewById(R.id.txtIdUsuario);
            mail = (TextView) itemView.findViewById(R.id.txtMail);
            edad = (TextView) itemView.findViewById(R.id.txtEdad);
        }
    }
}
