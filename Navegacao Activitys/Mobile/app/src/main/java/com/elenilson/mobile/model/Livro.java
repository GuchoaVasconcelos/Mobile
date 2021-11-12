package com.elenilson.mobile.model;

import java.io.Serializable;

public class Livro implements Serializable {

    private Integer id;
    private String autor;
    private String titulo;
    private String isbn;
    private String editora;
    private String anoLancamento;

    public Livro() {
    }

    public Livro(Integer id) {
        this.id = id;
    }

    public Livro(Integer id, String autor, String titulo, String isbn, String editora, String anoLancamento) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.editora = editora;
        this.anoLancamento = anoLancamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", editora='" + editora + '\'' +
                ", anoLancamento=" + anoLancamento +
                '}';
    }
}
