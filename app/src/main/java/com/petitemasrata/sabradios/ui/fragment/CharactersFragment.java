package com.petitemasrata.sabradios.ui.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.petitemasrata.sabradios.R;
import com.petitemasrata.sabradios.model.*;
import com.petitemasrata.sabradios.model.Character;
import com.petitemasrata.sabradios.ui.adapter.CharactersListAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CharactersFragment extends Fragment {

    private static final String LOG_TAG = CharactersFragment.class.getCanonicalName();
    public Context CONTEXT;

    @InjectView(R.id.list_characters)
    RecyclerView mListCharacters;

    CharactersListAdapter adapter;

    public CharactersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CONTEXT = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_characters, container, false);
        ButterKnife.inject(this, rootView);

        initListCharacters();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    //================================================================================
    //Init Methods
    //================================================================================
    private void initListCharacters() {
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
        adapter = new CharactersListAdapter(CONTEXT);

        ArrayList<Character> characters = new ArrayList<Character>();

        Character mono1 = new Character();
        mono1.setName("El Monigote");
        characters.add(mono1);

        Character mono2 = new Character();
        mono2.setName("El Mitotero");
        characters.add(mono2);

        Character mono3 = new Character();
        mono3.setName("El Matorral");
        characters.add(mono3);

        Character mono4 = new Character();
        mono4.setName("El Mequetrefe");
        characters.add(mono4);

        Character mono5 = new Character();
        mono5.setName("El Merolico");
        characters.add(mono5);

        adapter.updateList(characters);

        mListCharacters.setLayoutManager(lm);
        mListCharacters.setAdapter(adapter);

    }

}