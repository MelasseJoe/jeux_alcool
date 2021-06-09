package com.student.devs.jeux_alccol;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.student.devs.jeux_alccol.liste.chants_Liste;
import com.student.devs.jeux_alccol.liste.desCartesListe;
import com.student.devs.jeux_alccol.liste.jeux_Liste;
import com.student.devs.jeux_alccol.liste.regles_Liste;

public class menu_test extends AppCompatActivity
{
    private final static int DIALOG_ALERT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_test);

        WebView web = findViewById(R.id.webview);

        if (isFirstTime())
        {
            showDialog(DIALOG_ALERT);
        }

        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient());
        //web.getSettings().setLightTouchEnabled(false);
        web.loadUrl("file:///android_asset/html/menu_test.html");
        web.setWebViewClient(new MyWebViewClient(this));
    }


    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
            case DIALOG_ALERT:
                // Create out AlterDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Note de mise à jour : ");
                builder.setMessage("- Corrections orthographiques" + "\n" + "- Correction du plantage au lancement" + "\n" + "\n"
                        + "N'hésitez pas à nous proposer vos idées de jeux, de règles et de chants à student.devs4@gmail.com.");
                builder.setCancelable(true);
                //builder.setPositiveButton("Ok", new OkOnClickListener());
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        return super.onCreateDialog(id);
    }

    private boolean isFirstTime()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore)
        {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }
}

class MyWebViewClient extends WebViewClient
{
    private Context context;

    public MyWebViewClient(Context context)
    {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        if(url.equals("jeux://jeux"))
        {
            Intent i = new Intent(context, jeux_Liste.class);
            context.startActivity(i);
            return true;
        }
        else if(url.equals("jeux://regles"))
        {
            Intent i = new Intent(context, regles_Liste.class);
            context.startActivity(i);
            return true;
        }
        else if(url.equals("jeux://chants"))
        {
            Intent i = new Intent(context, chants_Liste.class);
            context.startActivity(i);
            return true;
        }
        else if(url.equals("jeux://desCartes"))
        {
            Intent i = new Intent(context, desCartesListe.class);
            context.startActivity(i);
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}


