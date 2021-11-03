package com.uchoa.componentesinterface.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.uchoa.componentesinterface.R;


public class MainActivity extends AppCompatActivity {

    private Button buttonBeep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBeep = findViewById(R.id.buttonBeep);
        buttonBeep.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.beep);
                mediaPlayer.start();

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sabores) {
            Intent intent = new Intent(getApplicationContext(), SaboresActivity.class);
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.usuario) {
            Intent intent = new Intent(getApplicationContext(), UsuarioActivity.class);
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.cardapio){
            Intent intent = new Intent(getApplicationContext(), CardapioActivity.class);
            startActivity(intent);
            return true;
        }else if (item.getItemId() == R.id.chat){
            Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
            startActivity(intent);
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}