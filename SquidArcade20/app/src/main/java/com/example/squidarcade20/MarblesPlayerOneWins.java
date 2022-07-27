package com.example.squidarcade20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MarblesPlayerOneWins extends AppCompatActivity implements View.OnClickListener {

    Button playAgain;
    Button mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_screen_turn_results_screen_cpu_win);
        playAgain = (Button) findViewById(R.id.nextBtn);
        mainMenu = (Button) findViewById(R.id.mainmenu2);
        playAgain.setOnClickListener(this);
        mainMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == playAgain) {
            Intent playAgain = new Intent(this, marblesPlayerSelection.class);
            startActivity(playAgain);
        } else if (view == mainMenu){
            Intent mainMenu = new Intent(this, MainActivity.class);
            startActivity(mainMenu);
        }
    }
}