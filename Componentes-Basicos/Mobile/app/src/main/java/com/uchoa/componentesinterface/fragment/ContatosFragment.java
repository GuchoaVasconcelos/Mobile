package com.uchoa.componentesinterface.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.uchoa.componentesinterface.R;

import java.util.List;

public class ContatosFragment extends Fragment {

    private ListView listViewContatos;

    public ContatosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contatos, container, false);
        listViewContatos = view.findViewById(R.id.contatos);

        String strcontatos[] = { "Joãozinho", "Pedrinho", "José"};
        ArrayAdapter<String> adpater = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, strcontatos);
        listViewContatos.setAdapter(adpater);

        return view;
    }
}