package com.elenilson.mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.elenilson.mobile.R;
import com.elenilson.mobile.adapter.LivroAdapterArray;
import com.elenilson.mobile.banco.Banco;
import com.elenilson.mobile.model.Livro;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button buttonCadastrar;
    private Button buttonEditar;
    private Button buttonDeletar;
    private EditText editBusca;

    private Banco bancoDeDados;
    private Livro livro = null;

    private LivroAdapterArray livroAdapterArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bancoDeDados = new Banco(getApplicationContext());

        listView        = findViewById(R.id.listLivros);
        buttonCadastrar = findViewById(R.id.buttonAdicionar);
        buttonEditar    = findViewById(R.id.buttonEditar);
        buttonDeletar   = findViewById(R.id.buttonDeletar);
        editBusca       = findViewById(R.id.editId);

        //Listando livros cadastrados e Configurando adapter
        if( bancoDeDados.listar().size() > 0 ) {
            livroAdapterArray = new LivroAdapterArray(getApplicationContext(), bancoDeDados.listar());
            listView.setAdapter(livroAdapterArray);
        }

        //Recuperando os dados enviados da activity1
        Bundle dados = getIntent().getExtras();

        //Mensagens
        if( dados != null && !dados.get("mensagem").toString().equals("") ) Toast.makeText( getApplicationContext(), dados.get("mensagem").toString(), Toast.LENGTH_LONG).show();

        //Adiconando evento de click no botão de cadastro
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                //Passando os dados para a activity2
                intent.putExtra("acaoDoBotao", "Cadastrar");
                intent.putExtra("identificador", bancoDeDados.getProximoId());

                startActivity(intent);
            }
        });

        //Adiconando evento de click no botão de edicao
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                if(!editBusca.getText().toString().equals("")) {
                    Integer idBusca = Integer.parseInt(editBusca.getText().toString());

                    //Buscando o livro no banco
                    livro = bancoDeDados.buscarPorId(idBusca);

                    if( livro != null ){
                        //Passando os dados para a activity2
                        intent.putExtra("acaoDoBotao", "Editar");
                        intent.putExtra("livro", livro);

                        startActivity(intent);
                    } else {
                        Toast.makeText( getApplicationContext(),"Livro não encontrado!", Toast.LENGTH_LONG).show();
                    }

                }else
                    Toast.makeText( getApplicationContext(),"Campo busca vazio!", Toast.LENGTH_LONG).show();
            }
        });

        //Adiconando evento de click no botão de remover
        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                if(!editBusca.getText().toString().equals("")) {
                    Integer idBusca = Integer.parseInt(editBusca.getText().toString());

                    //Buscando o livro no banco
                    livro = bancoDeDados.buscarPorId(idBusca);

                    if( livro != null ){
                        //Passando os dados para a activity2
                        intent.putExtra("acaoDoBotao", "Remover");
                        intent.putExtra("livro", livro);

                        startActivity(intent);
                    } else {
                        Toast.makeText( getApplicationContext(),"Livro não encontrado!", Toast.LENGTH_LONG).show();
                    }

                }else
                    Toast.makeText( getApplicationContext(),"Campo busca vazio!", Toast.LENGTH_LONG).show();
            }
        });
    }
}

