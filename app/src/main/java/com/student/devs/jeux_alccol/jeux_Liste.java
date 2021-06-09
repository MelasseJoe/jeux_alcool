package com.student.devs.jeux_alccol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jeux_Liste extends AppCompatActivity
{
    private AdView mAdView;
    ListView vue;
    List<String> nom = new ArrayList<String>();
    String[] liste;
    List<Integer> numero = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeuxliste);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        vue = findViewById(R.id.liste_vue);

        try
        {
            liste = getAssets().list("html/jeux");
            if (liste.length > 0)
            {
                Arrays.sort(liste);
                for (String file : liste)
                {
                    nom.add(file.split("\\.")[0].split("&")[0]);
                    numero.add(Integer.parseInt(file.split("\\.")[0].split("&")[1]));
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // 2 lignes qui permettent d'utiliser la listeView perso
        RepertoireAdapter listeAdapter = new RepertoireAdapter(nom, numero, this.getApplicationContext());
        vue.setAdapter(listeAdapter);

        vue.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i = new Intent(jeux_Liste.this, jeux_activity.class);
                i.putExtra("html", "jeux/" + liste[position]);
                startActivity(i);
            }
        });
    }
}