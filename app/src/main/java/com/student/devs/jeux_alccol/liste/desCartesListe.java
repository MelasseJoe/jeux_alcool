package com.student.devs.jeux_alccol.liste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.student.devs.jeux_alccol.R;
import com.student.devs.jeux_alccol.activity.desActivity;
import com.student.devs.jeux_alccol.adapter.RepertoireAdapter_chants;
import com.student.devs.jeux_alccol.activity.jeux_activity;

import java.util.ArrayList;
import java.util.List;

public class desCartesListe extends AppCompatActivity
{
    ListView vue;
    List<String> nom = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeuxliste);

        vue = findViewById(R.id.liste_vue);

        nom.add("Cartes");
        nom.add("Dés");

        // 2 lignes qui permettent d'utiliser la listeView perso
        RepertoireAdapter_chants listeAdapter = new RepertoireAdapter_chants(nom, this.getApplicationContext());
        vue.setAdapter(listeAdapter);

        vue.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position == 0) {
                    Intent i = new Intent(desCartesListe.this, jeux_activity.class);
                    startActivity(i);
                }
                else if (position == 1) {
                    Intent i = new Intent(desCartesListe.this, desActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}