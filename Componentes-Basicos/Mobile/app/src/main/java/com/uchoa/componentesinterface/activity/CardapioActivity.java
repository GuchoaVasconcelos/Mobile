package com.uchoa.componentesinterface.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.uchoa.componentesinterface.R;

import java.util.ArrayList;
import java.util.List;

public class CardapioActivity extends AppCompatActivity {

    private ListView listPicoles;
    private ListView listCasquinhas;
    private List<String> sabores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        listPicoles = findViewById(R.id.listPicoles);
        listCasquinhas = findViewById(R.id.listCasquinhas);

        //preencher listas
        sabores = new ArrayList<>();
        this.preencherSabores();

        //Adaptador para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                sabores
        );

        // Adicionar adptador
        listPicoles.setAdapter(adaptador);
        listCasquinhas.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_google, menu);
        return true;
    }

    private void preencherSabores() {
        this.sabores.add("Chocolate");
        this.sabores.add("Morango");
        this.sabores.add("Baunilia");
        this.sabores.add("Uva");
        this.sabores.add("Chiclete");
        this.sabores.add("Ovo Maltine");
        this.sabores.add("Biscoite");
        this.sabores.add("Oreo");
        this.sabores.add("Sonho de Valsa");
    }


}