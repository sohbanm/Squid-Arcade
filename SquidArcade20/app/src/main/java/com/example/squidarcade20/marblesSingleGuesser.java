package com.example.squidarcade20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.squidarcade20.MarblesClasses.CPU;
import com.example.squidarcade20.MarblesClasses.Human;
import com.example.squidarcade20.MarblesClasses.gameSingleplayer;

public class marblesSingleGuesser extends AppCompatActivity implements View.OnClickListener{
    Button evenBtn;
    Button oddBtn;
    gameSingleplayer currentGame;
    TextView marblesRemaining;
    CPU currentCpu;
    Human currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_single_guess);

        evenBtn = (Button) findViewById(R.id.evenGuess);
        oddBtn = (Button) findViewById(R.id.oddGuess);
        currentPlayer = getIntent().getParcelableExtra("currentPlayer");
        currentCpu = getIntent().getParcelableExtra("currentCPU");
        marblesRemaining = (TextView) findViewById(R.id.playerOne);
        marblesRemaining.setText("Marbles Remaining: " +currentPlayer.getMarbles());

        currentGame = new gameSingleplayer();
        evenBtn.setOnClickListener(this);
        oddBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        currentCpu.generateGamble();
        currentGame.switchRole(currentPlayer, currentCpu);
        int gamble = currentCpu.getGamble();

        if (view == evenBtn) {
            if (gamble % 2 == 0) {
                currentGame.transferMarbles(currentPlayer, currentCpu, gamble);
                currentGame.checkWin(currentPlayer, currentCpu);

                if (currentGame.getWinner() == null) {
                    AlertDialog.Builder invalidInput = new AlertDialog.Builder(marblesSingleGuesser.this);
                    invalidInput.setMessage("CPU gambled " + currentCpu.getGamble() + "! " + gamble + " marbles have been taken from the CPU").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent a = new Intent(view.getContext(), marblesSingleTurnResultsScreen.class);
                            a.putExtra("currentCPU", currentCpu);
                            a.putExtra("currentPlayer", currentPlayer);
                            startActivity(a);
                        }
                    });
                    AlertDialog alert = invalidInput.create();
                    alert.show();

                } else if (currentGame.getWinner().equals("cpu")) {
                    Intent a = new Intent(this, marblesScreenTurnResultsScreenCpuWin.class);
                    startActivity(a);
                } else if (currentGame.getWinner().equals("human")) {
                    Intent a = new Intent(this, marbleScreenTurnResultsScreenPlayerWin.class);
                    startActivity(a);
                }

            } else if (gamble % 2 != 0) {
                currentGame.transferMarbles(currentCpu, currentPlayer, gamble);
                currentGame.checkWin(currentPlayer, currentCpu);

                if (currentGame.getWinner() == null) {
                    AlertDialog.Builder invalidInput = new AlertDialog.Builder(marblesSingleGuesser.this);
                    invalidInput.setMessage("CPU gambled " + currentCpu.getGamble() + "! " + gamble + " marbles have been taken from you").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent a = new Intent(view.getContext(), marblesSingleTurnResultsScreen.class);
                            a.putExtra("currentCPU", currentCpu);
                            a.putExtra("currentPlayer", currentPlayer);
                            startActivity(a);
                        }
                    });
                    AlertDialog alert = invalidInput.create();
                    alert.show();

                } else if (currentGame.getWinner().equals("cpu")) {
                    Intent a = new Intent(this, marblesScreenTurnResultsScreenCpuWin.class);
                    startActivity(a);
                } else if (currentGame.getWinner().equals("human")) {
                    Intent a = new Intent(this, marbleScreenTurnResultsScreenPlayerWin.class);
                    startActivity(a);
                }
            }


        } else if (view == oddBtn) {
            if (gamble % 2 == 0) {
                currentGame.transferMarbles(currentCpu, currentPlayer, gamble);
                currentGame.checkWin(currentPlayer, currentCpu);

                if (currentGame.getWinner() == null) {
                    AlertDialog.Builder invalidInput = new AlertDialog.Builder(marblesSingleGuesser.this);
                    invalidInput.setMessage("CPU gambled " + currentCpu.getGamble() + "! " + gamble + " marbles have been taken from you").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent a = new Intent(view.getContext(), marblesSingleTurnResultsScreen.class);
                            a.putExtra("currentCPU", currentCpu);
                            a.putExtra("currentPlayer", currentPlayer);
                            startActivity(a);
                        }
                    });
                    AlertDialog alert = invalidInput.create();
                    alert.show();

                } else if (currentGame.getWinner().equals("cpu")) {
                    Intent a = new Intent(this, marblesScreenTurnResultsScreenCpuWin.class);
                    startActivity(a);
                } else if (currentGame.getWinner().equals("human")) {
                    Intent a = new Intent(this, marbleScreenTurnResultsScreenPlayerWin.class);
                    startActivity(a);
                }

            } else if (gamble % 2 != 0) {
                currentGame.transferMarbles(currentPlayer, currentCpu, gamble);
                currentGame.checkWin(currentPlayer, currentCpu);

                if (currentGame.getWinner() == null) {
                    AlertDialog.Builder invalidInput = new AlertDialog.Builder(marblesSingleGuesser.this);
                    invalidInput.setMessage("CPU gambled " + currentCpu.getGamble() + "! " + gamble + " marbles have been taken from the CPU").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent a = new Intent(view.getContext(), marblesSingleTurnResultsScreen.class);
                            a.putExtra("currentCPU", currentCpu);
                            a.putExtra("currentPlayer", currentPlayer);
                            startActivity(a);
                        }
                    });
                    AlertDialog alert = invalidInput.create();
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