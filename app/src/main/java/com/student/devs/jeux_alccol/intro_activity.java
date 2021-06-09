package com.student.devs.jeux_alccol;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class intro_activity extends AppCompatActivity
{
    ImageView dtc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        dtc = findViewById(R.id.intro_titre);
        //alpha_animation(dtc,0.5f,0.5f,2000);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent menu = new Intent(intro_activity.this, menu_test.class);
                startActivity(menu);
                finish();
            }
        }, 1500);

    }

    public void alpha_animation(View vian, float debut, float fin, int temps)
    {
        AlphaAnimation animation1 = new AlphaAnimation(debut, fin);
        animation1.setDuration(temps);
        //animation1.setStartOffset(500);
        //animation1.setFillAfter(true);
        vian.startAnimation(animation1);
    }
}
