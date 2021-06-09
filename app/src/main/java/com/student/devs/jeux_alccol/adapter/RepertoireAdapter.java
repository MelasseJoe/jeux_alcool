package com.student.devs.jeux_alccol.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.student.devs.jeux_alccol.R;

import java.util.List;

public class RepertoireAdapter extends ArrayAdapter<String> // creation d'un adapter perso pour avoir sa propre view
{
    LayoutInflater mInflater;
    private Context context2;
    private List Liste;
    private List numero;
    TextView vue = null;
    private Integer[] image = { // chaque R.dra... return un int qui rpz le code de l'image
            R.drawable.beer_1_5,
            R.drawable.beer_2_5,
            R.drawable.beer_3_5,
            R.drawable.beer_4_5,
            R.drawable.beer_5_5};

    public RepertoireAdapter(List list1, List number, Context context)
    {
        // on cree un nouveau constructeur pour passer les 2 listes en arguments
        super(context, R.layout.my_listview, list1);
        Liste = list1;
        context2 = context;
        numero = number;
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
        View rowView = inflater.inflate(R.layout.my_listview, parent, false);

        // ajout des éléments du xml
        TextView textView = (TextView) rowView.findViewById(R.id.titre);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);

        // liaison des elements qu'on veut aux vues
        textView.setText(String.valueOf(Liste.get(position)));
        imageView.setImageResource(image[(int)numero.get(position)-1]);


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
