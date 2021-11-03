package com.uchoa.componentesinterface.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;

import com.uchoa.componentesinterface.R;

public class UsuarioActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteFormas;
    private Spinner spinnerBandeiras;
    private ImageButton menupopup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        String strFormasPagamento[] = { "Crédito", "Débito", "Á vista", "Depósito"};

        autoCompleteFormas = findViewById(R.id.autoCompleteFormas);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, strFormasPagamento);
        autoCompleteFormas.setThreshold(1);
        autoCompleteFormas.setAdapter(adapter);

        String strBandeiras[] = { "Visa", "Mastecard", "Elo"};
        spinnerBandeiras = findViewById(R.id.spinnerBandeiras);
        ArrayAdapter<String> adpaterBandeiras = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, strBandeiras);
        spinnerBandeiras.setAdapter(adpaterBandeiras);

        menupopup = findViewById(R.id.imageButton);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_popup, popup.getMenu());
        popup.show();
    }
}