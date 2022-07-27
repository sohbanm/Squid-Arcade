package com.example.squidarcade20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.squidarcade20.MarblesClasses.CPU;
import com.example.squidarcade20.MarblesClasses.Human;
import com.example.squidarcade20.MarblesClasses.gameSingleplayer;

public class marblesSingleGambler extends AppCompatActivity implements View.OnClickListener{
    Button submitBtn;
    EditText gamble;
    gameSingleplayer currentGame;
    TextView marblesRemaining;
    CPU currentCpu;
    Human currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_single_gamble);

        submitBtn = (Button) findViewById(R.id.submitGamble);
        gamble = (EditText) findViewById(R.id.gambleAmount);
        currentPlayer = getIntent().getParcelableExtra("currentPlayer");
        currentCpu = getIntent().getParcelableExtra("currentCPU");
        marblesRemaining = (TextView) findViewById(R.id.playerOne);
        marblesRemaining.setText("Marbles Remaining: " + currentPlayer.getMarbles());
        //this implementation is really scuffed I know but another iteration I tried sending the game class with the human and cpu as instance
        //variables of a gameSingleplayer object but android studio's intent and parcelable class just refused to cooperate and send over
        //the information of the player and cpu class for some reason so this was the messy work around I thought of
        currentGame = new gameSingleplayer();
        submitBtn.setOnClickListener(this);

    }



    //onclick event handler for submit button
    @Override
    public void onClick(View view) {
        int gambleAmount = Integer.parseInt(gamble.getText().toString());

        //event handler for invalid inputs
        if (gambleAmount > currentPlayer.getMarbles() || gambleAmount < 1|| TextUtils.isEmpty(gamble.getText().toString())) {
            AlertDialog.Builder invalidInput = new AlertDialog.Builder(marblesSingleGambler.this);
            invalidInput.setMessage("Error: Invalid Input, Please enter a valid number of marbles").setPositiveButton("Ok", null);
            AlertDialog alert = invalidInput.create();
            alert.show();


        } else {
            currentCpu.newGuess();
            currentGame.switchRole(currentPlayer, currentCpu);


            if (gambleAmount % 2 == 0 && currentCpu.getGuess().equals("odd")) {
                currentGame.transferMarbles(currentPlayer, currentCpu, gambleAmount);
                currentGame.checkWin(currentPlayer, currentCpu);

                if (currentGame.getWinner() == null) {
                    AlertDialog.Builder resultBox = new AlertDialog.Builder(marblesSingleGambler.this);
                    resultBox.setMessage("CPU guessed " + currentCpu.getGuess() + "! " + gambleAmount +
                            " marbles have been taken from the CPU").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent a = new Intent(view.getContext(), marblesSingleTurnResultsScreen.class);
                            a.putExtra("currentCPU", currentCpu);
                            a.putExtra("currentPlayer", currentPlayer);
                            startActivity(a);
                        }
                    });
                    AlertDialog alert = resultBox.create();
                    alert.show();

                } else if (currentGame.getWinner().equals("cpu")) {
                    Intent a = new Intent(this, marblesScreenTurnResultsScreenCpuWin.class);
                    startActivity(a);
                } else if (currentGame.getWinner().equals("human")) {
                    Intent a = new Intent(this, marbleScreenTurnResultsScreenPlayerWin.class);
                    startActivity(a);
                }
            }


            else if (gambleAmount % 2 == 0 && currentCpu.getGuess().equals("even")) {
                currentGame.transferMarbles(currentCpu, currentPlayer, gambleAmount);
                currentGame.checkWin(currentPlayer, currentCpu);

                if (currentGame.getWinner() == null) {
                    AlertDialog.Builder resultBox = new AlertDialog.Builder(marblesSingleGambler.this);
                    resultBox.setMessage("CPU guessed " + currentCpu.getGuess() + "! " + gambleAmount +
                            " marbles have been taken from you").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent a = new Intent(view.getContext(), marblesSingleTurnResultsScreen.class);
                            a.putExtra("currentCPU", currentCpu);
                            a.putExtra("currentPlayer", currentPlayer);
                            startActivity(a);
                        }
                    });
                    AlertDialog alert = resultBox.create();
                    alert.show();

                } else if (currentGame.getWinner().equals("cpu")) {
                    Intent a = new Intent(this, marblesScreenTurnResultsScreenCpuWin.class);
                    startActivity(a);
                } else if (currentGame.getWinner().equals("human")) {
                    Intent a = new Intent(this, marbleScreenTurnResultsScreenPlayerWin.class);
                    startActivity(a);
                }
            }


            else if (gambleAmount % 2 != 0 && currentCpu.getGuess().equals("odd")) {
                currentGame.transferMarbles(currentCpu, currentPlayer, gambleAmount);
                currentGame.checkWin(currentPlayer, currentCpu);

                if (currentGame.getWinner() == null) {
                    AlertDialog.Builder resultBox = new AlertDialog.Builder(marblesSingleGambler.this);
                    resultBox.setMessage("CPU guessed " + currentCpu.getGuess() + "! " + gambleAmount +
                            " marbles have been taken from you").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent a = new Intent(view.getContext(), marblesSingleTurnResultsScreen.class);
                                    a.putExtra("currentCPU", currentCpu);
                                    a.putExtra("currentPlayer", currentPlayer);
                                    startActivity(a);
                                }
                            });
                    AlertDialog alert = resultBox.create();
                    alert.show();

                } else if (currentGame.getWinner().equals("cpu")) {
                    Intent a = new Intent(this, marblesScreenTurnResultsScreenCpuWin.class);
                    startActivity(a);
                } else if (currentGame.getWinner().equals("human")) {
                    Intent a = new Intent(this, marbleScreenTurnResultsScreenPlayerWin.class);
                    startActivity(a);
                }
            }


            else if (gambleAmount % 2 != 0 && currentCpu.getGuess().equals("even")) {
                currentGame.transferMarbles(currentPlayer, currentCpu, gambleAmount);
                currentGame.checkWin(currentPlayer, currentCpu);

                if (currentGame.getWinner() == null) {
                    AlertDialog.Builder resultBox = new AlertDialog.Builder(marblesSingleGambler.this);
                    resultBox.setMessage("CPU guessed " + currentCpu.getGuess() + "! " + gambleAmount +
                            " marbles have been taken from the CPU").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent a = new Intent(view.getContext(), marblesSingleTurnResultsScreen.class);
                            a.putExtra("currentCPU", currentCpu);
                            a.putExtra("currentPlayer", currentPlayer);
                            startActivity(a);
                        }
                    });
                    AlertDialog alert = resultBox.create();
                    alert.show();

                } else if (currentGame.getWinner().equals("cpu")) {
                    Intent a = new Intent(this, marblesScreenTurnResultsScreenCpuWin.class);
                    startActivity(a);
                } else if (currentGame.getWinner().equals("human")) {
                    Intent a = new Intent(this, marbleScreenTurnResultsScreenPlayerWin.class);
                    startActivity(a);
                }
            }



        }

    }
}