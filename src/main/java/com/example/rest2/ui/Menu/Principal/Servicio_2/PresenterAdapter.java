package com.example.rest2.ui.Menu.Principal.Servicio_2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rest2.R;
import com.example.rest2.model.ModelService2;

import java.util.List;


public class PresenterAdapter extends RecyclerView.Adapter<PresenterAdapter.UsersViewHolder> {

    Context context;
    List<ModelService2> modelData;

    public PresenterAdapter(Context context, List<ModelService2> modelData) {
        this.modelData = modelData;
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.lista, null);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, final int position) {
        // set the data
        holder.id.setText("Informe: " + modelData.get(position).getId());
        holder.fecha.setText("Fecha: " + modelData.get(position).getFecha());
        holder.hora.setText("Hora: " + modelData.get(position).getHora());
        holder.v1.setText("Valor 1: " + modelData.get(position).getValor1());
        holder.v2.setText("Valor 2: " + modelData.get(position).getValor2());
        holder.v3.setText("Valor 3: " + modelData.get(position).getValor3());
        /*Glide.with(context)
                .load(modelData.getMessage().get(position))
                .error(R.drawable.error)
                .placeholder(R.drawable.placeholder)
                .into(holder.imagen);*/
        // implement setONCLickListtener on itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with user name
               // Toast.makeText(context, modelAbonosData.get(position).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelData.size(); // size of the list items
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView id, fecha, hora, v1, v2, v3;
        //ImageView imagen;

        public UsersViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            id = (TextView) itemView.findViewById(R.id.Id);
            fecha = (TextView) itemView.findViewById(R.id.fecha);
            hora = (TextView) itemView.findViewById(R.id.hora);
            v1 = (TextView) itemView.findViewById(R.id.v1);
            v2 = (TextView) itemView.findViewById(R.id.v2);
            v3 = (TextView) itemView.findViewById(R.id.v3);
            //imagen = (ImageView) itemView.findViewById(R.id.imagen);

        }
    }
}
