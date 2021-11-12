package com.elenilson.mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.elenilson.mobile.R;
import com.elenilson.mobile.model.Livro;

public class MainActivity2 extends AppCompatActivity {

    private Livro livro = null;
    private Button buttonAcao;
    private Button buttonCancelar;
    private TextView textId;
    private EditText editTitulo;
    private EditText editAutor;
    private EditText editIsbn;
    private EditText editAno;
    private EditText editEditora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
        this.cancelar();
    }

    public void cadastrarLivro(Bundle dados){
        //Cadastrar livro
        buttonAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                //Criando o objeto livro para realizar cadastro
                livro = new Livro(
                        Integer.parseInt(textId.getText().toString()),
                        editAutor.getText().toString(),
                        editTitulo.getText().toString(),
                        editIsbn.getText().toString(),
                        editEditora.getText().toString(),
                        editAno.getText().toString());

                //Passando os dados para a activity
                intent.putExtra("acaoRetorno", "cadastro");
                intent.putExtra("livro", livro);

                startActivity(intent);
                finish();
            }
        });
    }

    public void editarLivro(Bundle dados){
        //Recuperando objeto livro do bundle
        livro = (Livro) dados.getSerializable("livro");

        //Passando os dados para os campos
        editAutor.setText(livro.getAutor());
        editTitulo.setText(livro.getTitulo());
        editEditora.setText(livro.getEditora());
        editAno.setText(livro.getAnoLancamento());
        editIsbn.setText(livro.getIsbn());

        //Editar livro
        buttonAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                //Criando o objeto livro com os novos dados para realizar a edição
                livro = new Livro(
                        Integer.parseInt(textId.getText().toString()),
                        editAutor.getText().toString(),
                        editTitulo.getText().toString(),
                        editIsbn.getText().toString(),
                        editEditora.getText().toString(),
                        editAno.getText().toString());

                //Passando os dados para a activity
                intent.putExtra("acaoRetorno", "edição");
                intent.putExtra("livro", livro);

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

}