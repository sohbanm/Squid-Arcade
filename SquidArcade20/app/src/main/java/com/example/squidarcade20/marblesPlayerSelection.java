package com.example.squidarcade20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import com.example.squidarcade20.MarblesClasses.CPU;
import com.example.squidarcade20.MarblesClasses.Human;
import com.example.squidarcade20.MarblesClasses.gameSingleplayer;

public class marblesPlayerSelection extends AppCompatActivity implements View.OnClickListener{
    Button singleplayerButton;
    Button multiplayerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_player_selection);

        singleplayerButton = (Button) findViewById(R.id.singleplayer2);
        multiplayerButton = (Button) findViewById(R.id.multiplayer2);

        singleplayerButton.setOnClickListener(this);
        multiplayerButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == singleplayerButton) {

            //initializing new singleplayer game
            gameSingleplayer currentGame = new gameSingleplayer();
            Human currentPlayer = new Human();
            CPU currentCpu = new CPU();
            currentGame.assignRole(currentPlayer, currentCpu);

            if (currentPlayer.getPlayerRole() == "guesser") {
                Intent switchGuesser = new Intent(this, marblesSingleGuesser.class);
                switchGuesser.putExtra("currentPlayer", currentPlayer);
                switchGuesser.putExtra("currentCPU", currentCpu);
                startActivity(switchGuesser);

            } else if (currentPlayer.getPlayerRole() == "gambler") {
                Intent switchGambler = new Intent(this, marblesSingleGambler.class);
                switchGambler.putExtra("currentPlayer", currentPlayer);
                switchGambler.putExtra("currentCPU", currentCpu);
                startActivity(switchGambler);
            }

        } else if (view == multiplayerButton) {
            Intent switchMultiplayer = new Intent(this, marblesMultiGamble.class);
            Human playerOne = new Human();
            Human playerTwo = new Human();
            playerOne.startTurns();
            switchMultiplayer.putExtra("playerOne", playerOne);
            switchMultiplayer.putExtra("playerTwo", playerTwo);
            startActivity(switchMultiplayer);
        }


    }


}