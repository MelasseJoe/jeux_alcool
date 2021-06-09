package com.student.devs.jeux_alccol.liste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.student.devs.jeux_alccol.R;
import com.student.devs.jeux_alccol.adapter.RepertoireAdapter_chants;
import com.student.devs.jeux_alccol.activity.jeux_activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chants_Liste extends AppCompatActivity
{
    ListView vue;
    List<String> nom = new ArrayList<String>();
    String[] liste;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeuxliste);

        vue = findViewById(R.id.liste_vue);

        try
        {
            liste = getAssets().list("html/chants");
            if (liste.length > 0)
            {
                Arrays.sort(liste);
                for (String file : liste)
                {
                    nom.add(file.split("\\.")[0]);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // 2 lignes qui permettent d'utiliser la listeView perso
        RepertoireAdapter_chants listeAdapter = new RepertoireAdapter_chants(nom, this.getApplicationContext());
        vue.setAdapter(listeAdapter);

        vue.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i = new Intent(chants_Liste.this, jeux_activity.class);
                i.putExtra("html", "chants/" + liste[position]);
                startActivity(i);
            }
        });
    }
}