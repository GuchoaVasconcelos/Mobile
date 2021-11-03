package com.uchoa.componentesinterface.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.uchoa.componentesinterface.R;

public class ConversasFragment extends Fragment {

    private ListView listViewConversas;

    public ConversasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conversas, container, false);
        listViewConversas = view.findViewById(R.id.conversas);

        String strcontatos[] = { "Joãozinho: Vamo tomar um sorvete?", "Pedrinho: Simbora", "José: Só vamo! :)"};
        ArrayAdapter<String> adpater = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, strcontatos);
        listViewConversas.setAdapter(adpater);

        return view;
    }
}