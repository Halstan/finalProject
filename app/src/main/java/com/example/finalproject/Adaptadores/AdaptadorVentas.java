package com.example.finalproject.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalproject.Clases.Ventas;
import com.example.finalproject.R;

import java.util.List;

public class AdaptadorVentas extends RecyclerView.Adapter<AdaptadorVentas.ViewHolder> {

    public List<Ventas> ventasList;

    public AdaptadorVentas(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @NonNull
    @Override
    public AdaptadorVentas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.layout_items_ventas,parent,false );
        ViewHolder viewHolder = new ViewHolder( view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorVentas.ViewHolder holder, int position) {
        holder.idVenta.setText( ventasList.get(position).getIdVenta() );
        holder.idUsuario.setText( ventasList.get( position ).getIdUsuario() );
        holder.producto.setText( ventasList.get( position ).getProducto() );
        holder.importePagar.setText( ventasList.get( position ).getImportePagar());
    }

    @Override
    public int getItemCount() {
            return ventasList.size();
            }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idVenta, idUsuario, producto, importePagar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idVenta = (TextView) itemView.findViewById(R.id.txtIdVenta);
            idUsuario = (TextView) itemView.findViewById(R.id.txtIdUsuario);
            producto = (TextView) itemView.findViewById(R.id.txtProducto);
            importePagar = (TextView) itemView.findViewById(R.id.txtImportePagar);
        }
    }
}
