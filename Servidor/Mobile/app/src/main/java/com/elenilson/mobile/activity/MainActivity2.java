package com.elenilson.mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.elenilson.mobile.R;
import com.elenilson.mobile.banco.Banco;
import com.elenilson.mobile.model.Livro;

public class MainActivity2 extends AppCompatActivity {

    private Button buttonAcao;
    private Button buttonCancelar;
    private TextView textId;
    private EditText editTitulo;
    private EditText editAutor;
    private EditText editIsbn;
    private EditText editAno;
    private EditText editEditora;

    private Banco bancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bancoDeDados = new Banco(getApplicationContext());

        buttonAcao = findViewById(R.id.buttonAcao);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        textId      = findViewById(R.id.textId);
        editTitulo  = findViewById(R.id.editId);
        editAutor   = findViewById(R.id.editAutor);
        editIsbn    = findViewById(R.id.editIsbn);
        editAno     = findViewById(R.id.editAno);
        editEditora = findViewById(R.id.editEditora);

        //Recuperando os dados enviados da activity1
        Bundle dados = getIntent().getExtras();

        //Recuperando o valor do identificador
        Integer identificador = dados.getInt("identificador");
        textId.setText(String.valueOf(identificador));

        //Recuperando e passando o valor para o botão
        String acao = dados.getString("acaoDoBotao");
        buttonAcao.setText(acao);

        //Passando operação do botão
        if( acao.equals("Editar"))
            this.editarLivro(dados);
        if( acao.equals("Cadastrar"))
            this.cadastrarLivro(dados);
        if( acao.equals("Remover"))
            this.RemoverLivro(dados);
        this.cancelar();
    }

    public void cadastrarLivro(Bundle dados){
        //Cadastrar livro
        buttonAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                //inserir livro
                boolean resultadoOperacao = bancoDeDados.inserir(getLivro());

                //Passando os dados para a activity
                if ( resultadoOperacao ) intent.putExtra("mensagem", "Livro Cadastrado!");
                else intent.putExtra("mensagem", "Não foi possível realizar o cadastro.");

                startActivity(intent);
                finish();
            }
        });
    }

    public void editarLivro(Bundle dados){
        setLivro(dados);

        //Editar livro
        buttonAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                ///inserir livro
                boolean resultadoOperacao = bancoDeDados.editar(getLivro());

                //Passando os dados para a activity
                if ( resultadoOperacao ) intent.putExtra("mensagem", "Livro Editado!");
                else intent.putExtra("mensagem", "Não foi possível editar.");

                startActivity(intent);
                finish();
            }
        });
    }

    private void RemoverLivro(Bundle dados) {
        setLivro(dados);
        editAutor.setEnabled(false);
        editTitulo.setEnabled(false);
        editEditora.setEnabled(false);
        editAno.setEnabled(false);
        editIsbn.setEnabled(false);

        //Editar livro
        buttonAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                //inserir livro
                boolean resultadoOperacao = bancoDeDados.remover(getLivro());

                //Passando os dados para a activity
                if ( resultadoOperacao ) intent.putExtra("mensagem", "Livro Removido!");
                else intent.putExtra("mensagem", "Não foi possível remover.");

                startActivity(intent);
                finish();
            }
        });
    }

    public void cancelar(){
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public Livro getLivro(){
        Livro livro = new Livro(
                Integer.parseInt(textId.getText().toString()),
                editTitulo.getText().toString(),
                editAutor.getText().toString(),
                editIsbn.getText().toString(),
                editAno.getText().toString(),
                editEditora.getText().toString());

        return livro;
    }

    public void setLivro(Bundle dados){
        //Recuperando objeto livro do bundle
        Livro livro = (Livro) dados.getSerializable("livro");

        //Passando os dados para os campos
        textId.setText(String.valueOf(livro.getId()));
        editAutor.setText(livro.getAutor());
        editTitulo.setText(livro.getTitulo());
        editEditora.setText(livro.getEditora());
        editAno.setText(livro.getAnoLancamento());
        editIsbn.setText(livro.getIsbn());
    }

}