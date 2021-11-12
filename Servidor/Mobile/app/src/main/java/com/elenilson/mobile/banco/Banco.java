package com.elenilson.mobile.banco;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.elenilson.mobile.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Banco extends SQLiteOpenHelper {

    //Nome do Banco de Dados
    private static final String NOME_BANCO = "livrariaFutura.db";
    private static final String TABELA = "livros";

    //Colunas da tabela
    private static final String ID = "_id";
    private static final String TITULO = "titulo";
    private static final String AUTOR = "autor";
    private static final String ISBN = "isbn";
    private static final String ANO = "ano";
    private static final String EDITORA = "editora";

    //Versão do Banco de Dados
    private static final int VERSAO = 1;

    private static Banco banco = null;

    public Banco(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABELA +" (" + ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + TITULO +" VARCHAR, "+ AUTOR + " VARCHAR, "+ ISBN +" VARCHAR, "+ ANO +" INT(4), " + EDITORA +" VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

    public boolean inserir(Livro livro){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + TABELA + " ( " + TITULO + ", " + AUTOR + ", " + ISBN + ", " + ANO + ", " + EDITORA + ") " +
                    "VALUES ( '" + livro.getTitulo() + "', '" + livro.getAutor() + "', '"
                    + livro.getIsbn() + "', " + Integer.parseInt(livro.getAnoLancamento()) + ", '"
                    + livro.getEditora() + "')");

            db.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean editar(Livro livro) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("UPDATE " + TABELA + " SET " + TITULO + " = '" + livro.getTitulo() + "', " + AUTOR + " = '" + livro.getAutor() + "', " + ISBN + " = '" + livro.getIsbn() + "', " + ANO + " = " + Integer.parseInt(livro.getAnoLancamento()) + ", " + EDITORA + " = '" + livro.getEditora() + "' WHERE " + ID + " = " + livro.getId());

            db.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean remover(Livro livro) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABELA + " WHERE " + ID + " = " + livro.getId());

            db.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Livro buscarPorId(Integer id){
        Livro livro = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABELA + " WHERE " + ID + " = " + id, null);

            cursor.moveToFirst();
            if (cursor != null) {
                livro = new Livro(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))),
                        cursor.getString(cursor.getColumnIndex(TITULO)),
                        cursor.getString(cursor.getColumnIndex(AUTOR)),
                        cursor.getString(cursor.getColumnIndex(ISBN)),
                        cursor.getString(cursor.getColumnIndex(ANO)),
                        cursor.getString(cursor.getColumnIndex(EDITORA)));
            }

            db.close();
            return livro;
        } catch (Exception e){
            e.printStackTrace();
        }

        return livro;
    }

    public List<Livro> listar() {
        List<Livro> livros = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABELA, null);

            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                livros.add(new Livro(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))),
                        cursor.getString(cursor.getColumnIndex(TITULO)),
                        cursor.getString(cursor.getColumnIndex(AUTOR)),
                        cursor.getString(cursor.getColumnIndex(ISBN)),
                        cursor.getString(cursor.getColumnIndex(ANO)),
                        cursor.getString(cursor.getColumnIndex(EDITORA))));
                cursor.moveToNext();
            }

            db.close();
            return livros;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return livros;
    }

    public Integer getProximoId(){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT "+ ID +" FROM " + TABELA, null);

            if(cursor.getCount() > 0){
                cursor.moveToLast();
                Integer proxID = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)));
                return proxID++;
            }else return 1;

        } catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

}
