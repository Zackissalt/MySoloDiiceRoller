package com.example.lyndsea.mysolodiceroller;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound= MediaPlayer.create(MainActivity.this,R.raw.dicesound);



    }
    public void rollButton(View view) {
        EditText amountText = findViewById(R.id.numberDice);
        EditText sidesText = findViewById(R.id.numberSide);
        sound.start();
        String amount = amountText.getText().toString();
        String sides = sidesText.getText().toString();
        Switch switchStatus = findViewById(R.id.switch1);
        Boolean isOn = switchStatus.isChecked();
        DiceRoller diceRoller = new DiceRoller(sides, amount);
        String result = diceRoller.rollDice(isOn);
        TextView textView = findViewById(R.id.rollResult);
        textView.setText(result);

    }





}
