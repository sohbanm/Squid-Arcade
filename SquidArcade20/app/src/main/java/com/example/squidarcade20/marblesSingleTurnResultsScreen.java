package com.example.squidarcade20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.squidarcade20.MarblesClasses.CPU;
import com.example.squidarcade20.MarblesClasses.Human;

public class marblesSingleTurnResultsScreen extends AppCompatActivity implements View.OnClickListener{
    Button nextBtn;
    Human currentPlayer;
    CPU currentCpu;
    TextView marblesRemaining;
    TextView resultMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_single_turn_results_screen);

        nextBtn = (Button) findViewById(R.id.nextBtn);
        currentPlayer = getIntent().getParcelableExtra("currentPlayer");
        currentCpu = getIntent().getParcelableExtra("currentCPU");
        marblesRemaining = (TextView) findViewById(R.id.marblesRemaining2);
        marblesRemaining.setText("Marbles Remaining: " + currentPlayer.getMarbles());
        resultMsg = (TextView) findViewById(R.id.turnResultText);


        resultMsg.setText(currentPlayer.getResultText());
        System.out.println(currentPlayer.getResultText());

        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (currentPlayer.getPlayerRole().equals("guesser")){
            Intent switchGuesser = new Intent(this, marblesSingleGuesser.class);
            switchGuesser.putExtra("currentPlayer", currentPlayer);
            switchGuesser.putExtra("currentCPU", currentCpu);
            startActivity(switchGuesser);
        }

        else if (currentPlayer.getPlayerRole().equals("gambler")) {
            Intent switchGambler = new Intent(this, marblesSingleGambler.class);
            switchGambler.putExtra("currentPlayer", currentPlayer);
            switchGambler.putExtra("currentCPU", currentCpu);
            startActivity(switchGambler);
        }

    }
}