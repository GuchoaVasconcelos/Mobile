package com.elenilson.mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.elenilson.mobile.R;
import com.elenilson.mobile.model.Livro;

import java.util.List;

public class LivroAdapterArray extends ArrayAdapter<Livro> {

    private static class ViewHolder{
        private TextView titulo;
        private TextView autor;
        private TextView isbn;
        private TextView ano;
        private TextView editora;
    }

    public LivroAdapterArray(@NonNull Context context, @NonNull List<Livro> objects) {
        super(context, R.layout.layout_livro, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Pega o objeto livro da lista
        Livro livro = getItem(position);

        ViewHolder viewHolder;

        if( convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.layout_livro, parent, false);
            viewHolder.titulo   = convertView.findViewById(R.id.textTituloLayout);
            viewHolder.autor    = convertView.findViewById(R.id.textAutorLayout);
            viewHolder.ano      = convertView.findViewById(R.id.textAnoLayout);
            viewHolder.editora  = convertView.findViewById(R.id.textEditoraLayout);
            viewHolder.isbn     = convertView.findViewById(R.id.textIsbnLayout);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titulo.setText(livro.getTitulo());
        viewHolder.autor.setText(livro.getAutor());
        viewHolder.ano.setText(livro.getAnoLancamento());
        viewHolder.isbn.setText(livro.getIsbn());
        viewHolder.editora.setText(livro.getEditora());

        return convertView;
    }
}
