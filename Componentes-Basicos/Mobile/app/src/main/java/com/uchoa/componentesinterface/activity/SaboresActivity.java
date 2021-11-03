package com.uchoa.componentesinterface.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.uchoa.componentesinterface.R;
import com.uchoa.componentesinterface.adapter.SaboresAdapter;
import com.uchoa.componentesinterface.model.Sabor;

import java.util.ArrayList;
import java.util.List;

public class SaboresActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Sabor> sabores = new ArrayList<Sabor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabores);

        //RecylerView GridView
        recyclerView = findViewById(R.id.recyclerSabores);

        //Definde layout
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        //Define Adapter
        this.preencherSabores();
        SaboresAdapter adapter = new SaboresAdapter(sabores);
        recyclerView.setAdapter(adapter);
    }

    private void preencherSabores() {
        sabores.add(new Sabor(R.drawable.picole1));
        sabores.add(new Sabor(R.drawable.picole2));
        sabores.add(new Sabor(R.drawable.picole3));
        sabores.add(new Sabor(R.drawable.picole5));
        sabores.add(new Sabor(R.drawable.picole6));
        sabores.add(new Sabor(R.drawable.picole1));
        sabores.add(new Sabor(R.drawable.picole2));
        sabores.add(new Sabor(R.drawable.picole3));
        sabores.add(new Sabor(R.drawable.picole5));
        sabores.add(new Sabor(R.drawable.picole6));
        sabores.add(new Sabor(R.drawable.picole1));
        sabores.add(new Sabor(R.drawable.picole2));
        sabores.add(new Sabor(R.drawable.picole3));
        sabores.add(new Sabor(R.drawable.picole5));
        sabores.add(new Sabor(R.drawable.picole6));
    }
}