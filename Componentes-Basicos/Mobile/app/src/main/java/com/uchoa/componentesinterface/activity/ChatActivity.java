package com.uchoa.componentesinterface.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uchoa.componentesinterface.R;
import com.uchoa.componentesinterface.fragment.ContatosFragment;
import com.uchoa.componentesinterface.fragment.ConversasFragment;

public class ChatActivity extends AppCompatActivity {

    private Button buttonConversa, buttonContato;
    private ContatosFragment fragmentContato;
    private ConversasFragment fragmentConversa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        buttonConversa = findViewById(R.id.buttonConversas);
        buttonContato = findViewById(R.id.buttonContatos);

        //Remover sombra da ActionBar
        getSupportActionBar().setElevation(0);

        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentContato = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameFragment, fragmentContato);
                transaction.commit();
            }
        });

        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentConversa = new ConversasFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameFragment, fragmentConversa);
                transaction.commit();
            }
        });
    }
}