package com.elenilson.mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.elenilson.mobile.R;
import com.elenilson.mobile.adapter.LivroAdapterArray;
import com.elenilson.mobile.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static Integer id = 0;
    private static List<Livro> livros = new ArrayList<>();

    private ListView listView;
    private Button buttonCadastrar;
    private EditText editBusca;
    private Button buttonEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView        = findViewById(R.id.listLivros);
        buttonCadastrar = findViewById(R.id.buttonAdicionar);
        buttonEditar    = findViewById(R.id.buttonEditar);
        editBusca       = findViewById(R.id.editId);

        //Recebendo dados do intent
        Bundle dados = getIntent().getExtras();


        if( dados != null ) {
            String acaoRetorno = dados.getString("acaoRetorno");

            Livro livro = (Livro) dados.getSerializable("livro");
            if( acaoRetorno.equals("edição") )
                editarLivroLista(livro);

            if (acaoRetorno.equals("cadastro"))
                adicionarLivroLista(livro);
        }

        // Configurar adapter
        LivroAdapterArray livroAdapterArray = new LivroAdapterArray(getApplicationContext(), livros);
        listView.setAdapter(livroAdapterArray);

        //Adiconando evento de click no botão de cadastro
        cadastrarLivro();

        //Adiconando evento de click no botão de edição
        editarLivro();

    }

    private void adicionarLivroLista(Livro livro) {
        //Adicionando livros a lista
        livros.add(livro);
        id++;
    }

    private void editarLivroLista(Livro livro) {
        //Editar Livro na Lista
        for (Livro livroEditar : livros) {
            if (livroEditar.getId().equals(livro.getId())) {
                livroEditar.setTitulo(livro.getTitulo());
                livroEditar.setAutor(livro.getAutor());
                livroEditar.setEditora(livro.getEditora());
                livroEditar.setIsbn(livro.getIsbn());
                livroEditar.setAnoLancamento(livro.getAnoLancamento());
            }
        }
    }

    public void cadastrarLivro() {
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                //Passando os dados para a activity2
                intent.putExtra("acaoDoBotao", "Cadastrar");
                intent.putExtra("identificador", id);

                startActivity(intent);
                finish();
            }
        });
    }


    public void editarLivro(){
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editBusca.getText().toString().equals("")) {
                    Integer idBusca = Integer.parseInt(editBusca.getText().toString());

                    if ((livros.size() - idBusca) > 0) {
                        Livro livroBusca = livros.get(idBusca);

                        if (livroBusca != null) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                            //Passando os dados para a activity2
                            intent.putExtra("acaoDoBotao", "Editar");
                            intent.putExtra("identificador", livroBusca.getId());
                            intent.putExtra("livro", livroBusca);

                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Livro não encontrado.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Campo de busca vazio.",
                            Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}

