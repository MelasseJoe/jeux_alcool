package com.student.devs.jeux_alccol.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.student.devs.jeux_alccol.R;

import java.util.Random;

public class desActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    final int maximumDiceValue = 6;
    final int maximumNumberOfDices = 5;

    ImageView firstDice = null;
    ImageView secondDice = null;
    ImageView thirdDice = null;
    ImageView fourthDice = null;
    ImageView fifthDice = null;
    ImageView sixthDice = null;

    Boolean isFirstClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des);

        firstDice = (ImageView)findViewById(R.id.firstDice);
        secondDice = (ImageView)findViewById(R.id.secondDice);
        thirdDice = (ImageView)findViewById(R.id.thirdDice);
        fourthDice = (ImageView)findViewById(R.id.fourthDice);
        fifthDice = (ImageView)findViewById(R.id.fifthDice);
        sixthDice = (ImageView)findViewById(R.id.sixthDice);

        // Source : https://developer.android.com/guide/topics/ui/controls/spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numberOfDice, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setSelection(maximumNumberOfDices);
    }

    // Mandatory method to use the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
        switch (pos) {
            case 0 :
                secondDice.setVisibility(View.GONE);
                thirdDice.setVisibility(View.GONE);
                fourthDice.setVisibility(View.GONE);
                fifthDice.setVisibility(View.GONE);
                sixthDice.setVisibility(View.GONE);
                break;
            case 1 :
                secondDice.setVisibility(View.VISIBLE);
                thirdDice.setVisibility(View.GONE);
                fourthDice.setVisibility(View.GONE);
                fifthDice.setVisibility(View.GONE);
                sixthDice.setVisibility(View.GONE);
                break;
            case 2 :
                secondDice.setVisibility(View.VISIBLE);
                thirdDice.setVisibility(View.VISIBLE);
                fourthDice.setVisibility(View.GONE);
                fifthDice.setVisibility(View.GONE);
                sixthDice.setVisibility(View.GONE);
                break;
            case 3 :
                secondDice.setVisibility(View.VISIBLE);
                thirdDice.setVisibility(View.VISIBLE);
                fourthDice.setVisibility(View.VISIBLE);
                fifthDice.setVisibility(View.GONE);
                sixthDice.setVisibility(View.GONE);
                break;
            case 4 :
                secondDice.setVisibility(View.VISIBLE);
                thirdDice.setVisibility(View.VISIBLE);
                fourthDice.setVisibility(View.VISIBLE);
                fifthDice.setVisibility(View.VISIBLE);
                sixthDice.setVisibility(View.GONE);
                break;
            case 5 :
                secondDice.setVisibility(View.VISIBLE);
                thirdDice.setVisibility(View.VISIBLE);
                fourthDice.setVisibility(View.VISIBLE);
                fifthDice.setVisibility(View.VISIBLE);
                sixthDice.setVisibility(View.VISIBLE);
        }
    }

    // Mandatory method to use the spinner
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void rollDice (View view) {
        getRandomDice(6);
        if (!isFirstClick) {
            firstDice.setBackground(Drawable.createFromPath(""));
            secondDice.setBackground(Drawable.createFromPath(""));
            thirdDice.setBackground(Drawable.createFromPath(""));
            fourthDice.setBackground(Drawable.createFromPath(""));
            fifthDice.setBackground(Drawable.createFromPath(""));
            sixthDice.setBackground(Drawable.createFromPath(""));
            isFirstClick = true;
        }
    }

    public void getRandomDice(int numberOfDices) {
        int diceNumber = 0;

        while (diceNumber < numberOfDices) {
            Random r = new Random();
            int rand = r.nextInt(maximumDiceValue);
            switch (diceNumber) {
                case 0 :
                    setImageFromRandomNumber(firstDice, rand);
                    break;
                case 1 :
                    setImageFromRandomNumber(secondDice, rand);
                    break;
                case 2 :
                    setImageFromRandomNumber(thirdDice, rand);
                    break;
                case 3 :
                    setImageFromRandomNumber(fourthDice, rand);
                    break;
                case 4 :
                    setImageFromRandomNumber(fifthDice, rand);
                    break;
                case 5 :
                    setImageFromRandomNumber(sixthDice, rand);
                    break;
            }
            diceNumber++;
        }
    }

    public void setImageFromRandomNumber (ImageView image, int randomResult) {
        switch (randomResult) {
            case 0 :
                image.setImageResource(R.drawable.dice1);
                break;
            case 1 :
                image.setImageResource(R.drawable.dice2);
                break;
            case 2 :
                image.setImageResource(R.drawable.dice3);
                break;
            case 3 :
                image.setImageResource(R.drawable.dice4);
                break;
            case 4 :
                image.setImageResource(R.drawable.dice5);
                break;
            case 5 :
                image.setImageResource(R.drawable.dice6);
                break;
        }
    }
}
