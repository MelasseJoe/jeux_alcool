package com.student.devs.jeux_alccol.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.student.devs.jeux_alccol.R;

import java.util.List;

public class RepertoireAdapter_chants extends ArrayAdapter<String> // creation d'un adapter perso pour avoir sa propre view
{
    private Context context2;
    private List Liste;

    public RepertoireAdapter_chants(List list1, Context context)
    {
        // on cree un nouveau constructeur pour passer les 2 listes en arguments
        super(context, R.layout.my_listview_chants, list1);
        Liste = list1;
        context2 = context;
    }

    public String getItem(int position)
    {
        // obligatoire mais peut être utile
        return (String)Liste.get(position);
    }

    public long getItemId(int position)
    {
        // obligatoire mais est utile
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // obligatoire mais important

        // dunno
        LayoutInflater inflater = (LayoutInflater) context2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // creation de la vue à partir du xml perso
        View rowView = inflater.inflate(R.layout.my_listview_chants, parent, false);

        // ajout des éléments du xml
        TextView textView = (TextView) rowView.findViewById(R.id.chants);

        // liaison des elements qu'on veut aux vues
        textView.setText(String.valueOf(Liste.get(position)));

        //dunno
        return rowView;
    }

    @Override
    public int getCount()
    {
        // obligatoire
        return Liste.size();
    }
}
