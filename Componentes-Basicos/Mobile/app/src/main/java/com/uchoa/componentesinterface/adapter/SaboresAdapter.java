package com.uchoa.componentesinterface.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uchoa.componentesinterface.R;
import com.uchoa.componentesinterface.model.Sabor;

import java.util.List;

public class SaboresAdapter extends RecyclerView.Adapter<SaboresAdapter.MyViewHolder> {

    private List<Sabor> sabores;

    public SaboresAdapter(List<Sabor> sabores) {
        this.sabores = sabores;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_sabor, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sabor sabor = sabores.get(position);
        holder.imagem.setImageResource(sabor.getImagem());
    }

    @Override
    public int getItemCount() {
        return sabores.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imagem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagem = itemView.findViewById(R.id.imageSabor);
        }
    }
}
