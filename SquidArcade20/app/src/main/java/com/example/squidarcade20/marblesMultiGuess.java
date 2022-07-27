package com.example.squidarcade20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.squidarcade20.MarblesClasses.Human;

public class marblesMultiGuess extends AppCompatActivity implements View.OnClickListener {
    Button even;
    Button odd;
    Human playerOne;
    Human playerTwo;
    TextView marblesRemainingP1;
    TextView marblesRemainingP2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_multi_guess);

        even = (Button) findViewById(R.id.evenGuess);
        odd = (Button) findViewById(R.id.oddGuess);
        playerOne = getIntent().getParcelableExtra("playerOne");
        playerTwo = getIntent().getParcelableExtra("playerTwo");
        marblesRemainingP1 = (TextView) findViewById(R.id.playerOne2);
        marblesRemainingP2 = (TextView) findViewById(R.id.playerTwo2);
        marblesRemainingP1.setText("Player One Marbles Remaining: " + playerOne.getMarbles());
        marblesRemainingP2.setText("Player Two Marbles Remaining: " + playerTwo.getMarbles());
        AlertDialog.Builder inputPlease = new AlertDialog.Builder(marblesMultiGuess.this);
        if (playerOne.getTurn() % 2 != 0) {
            inputPlease.setMessage("Player One please select your guess").setPositiveButton("Ok", null);
        } else {
            inputPlease.setMessage("Player Two please select your guess").setPositiveButton("Ok", null);
        }
        AlertDialog alert = inputPlease.create();
        alert.show();
        even.setOnClickListener(this);
        odd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (playerOne.getTurn() % 2 == 0 || playerOne.getTurn() == 0) {
            if (view == even) {
                if (playerOne.getGamble() % 2 == 0) {
                    playerOne.loseMarbles(playerOne.getGamble());
                    playerTwo.addMarbles(playerOne.getGamble());
                    AlertDialog.Builder winner = new AlertDialog.Builder(marblesMultiGuess.this);
                    winner.setMessage("Player 2 guessed correctly! " + playerOne.getGamble() + " marbles have been given to player 2").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (playerOne.getMarbles() <= 0) {
                                Intent winner = new Intent(view.getContext(), MarblesPlayerTwoWin.class);
                                startActivity(winner);
                            } else {
                                playerOne.advanceTurn();
                                Intent goNext = new Intent(view.getContext(),marblesMultiGamble.class);
                                goNext.putExtra("playerOne", playerOne);
                                goNext.putExtra("playerTwo", playerTwo);
                                startActivity(goNext);
                            }
                        }
                    });
                    AlertDialog alert = winner.create();
                    alert.show();

                } else if (playerOne.getGamble() % 2 != 0) {
                    playerOne.addMarbles(playerOne.getGamble());
                    playerTwo.loseMarbles(playerOne.getGamble());
                    AlertDialog.Builder winner = new AlertDialog.Builder(marblesMultiGuess.this);
                    winner.setMessage("Player 2 guessed incorrectly! " + playerOne.getGamble() + " marbles have been given to player 1").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (playerTwo.getMarbles() <= 0) {
                                Intent winner = new Intent(view.getContext(), MarblesPlayerOneWins.class);
                                startActivity(winner);
                            } else {
                                playerOne.advanceTurn();
                                Intent goNext = new Intent(view.getContext(), marblesMultiGamble.class);
                                goNext.putExtra("playerOne", playerOne);
                                goNext.putExtra("playerTwo", playerTwo);
                                startActivity(goNext);
                            }
                        }
                    });
                    AlertDialog alert = winner.create();
                    alert.show();
                }



            } else if (view == odd) {
                if (playerOne.getGamble() % 2 == 0) {
                    playerOne.addMarbles(playerOne.getGamble());
                    playerTwo.loseMarbles(playerOne.getGamble());
                    AlertDialog.Builder winner = new AlertDialog.Builder(marblesMultiGuess.this);
                    winner.setMessage("Player 2 guessed incorrectly! " + playerOne.getGamble() + " marbles have been given to player 1").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (playerTwo.getMarbles() <= 0) {
                                Intent winner = new Intent(view.getContext(), MarblesPlayerOneWins.class);
                                startActivity(winner);
                            } else {
                                playerOne.advanceTurn();
                                Intent goNext = new Intent(view.getContext(), marblesMultiGamble.class);
                                goNext.putExtra("playerOne", playerOne);
                                goNext.putExtra("playerTwo", playerTwo);
                                startActivity(goNext);
                            }
                        }
                    });
                    AlertDialog alert = winner.create();
                    alert.show();

                } else if (playerOne.getGamble() % 2 != 0) {
                    playerOne.loseMarbles(playerOne.getGamble());
                    playerTwo.addMarbles(playerOne.getGamble());
                    AlertDialog.Builder winner = new AlertDialog.Builder(marblesMultiGuess.this);
                    winner.setMessage("Player 2 guessed correctly! " + playerOne.getGamble() + " marbles have been given to player 2").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (playerOne.getMarbles() <= 0) {
                                Intent winner = new Intent(view.getContext(), MarblesPlayerTwoWin.class);
                                startActivity(winner);
                            } else {
                                playerOne.advanceTurn();
                                Intent goNext = new Intent(view.getContext(), marblesMultiGamble.class);
                                goNext.putExtra("playerOne", playerOne);
                                goNext.putExtra("playerTwo", playerTwo);
                                startActivity(goNext);
                            }
                        }
                    });
                    AlertDialog alert = winner.create();
                    alert.show();
                }


            }


        } else {

            if (view == even) {
                if (playerTwo.getGamble() % 2 == 0) {
                    playerTwo.loseMarbles(playerTwo.getGamble());
                    playerOne.addMarbles(playerTwo.getGamble());
                    AlertDialog.Builder winner = new AlertDialog.Builder(marblesMultiGuess.this);
                    winner.setMessage("Player 1 guessed correctly! " + playerOne.getGamble() + " marbles have been given to player 1").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (playerTwo.getMarbles() <= 0) {
                                Intent winner = new Intent(view.getContext(), MarblesPlayerOneWins.class);
                                startActivity(winner);
                            } else {
                                playerOne.advanceTurn();
                                Intent goNext = new Intent(view.getContext(), marblesMultiGamble.class);
                                goNext.putExtra("playerOne", playerOne);
                                goNext.putExtra("playerTwo", playerTwo);
                                startActivity(goNext);
                            }
                        }
                    });
                    AlertDialog alert = winner.create();
                    alert.show();

                } else if (playerTwo.getGamble() % 2 != 0) {
                    playerTwo.addMarbles(playerTwo.getGamble());
                    playerOne.loseMarbles(playerTwo.getGamble());
                    AlertDialog.Builder winner = new AlertDialog.Builder(marblesMultiGuess.this);
                    winner.setMessage("Player 1 guessed incorrectly! " + playerOne.getGamble() + " marbles have been given to player 2").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (playerOne.getMarbles() <= 0) {
                                Intent winner = new Intent(view.getContext(), MarblesPlayerTwoWin.class);
                                startActivity(winner);
                            } else {
                                playerOne.advanceTurn();
                                Intent goNext = new Intent(view.getContext(), marblesMultiGamble.class);
                                goNext.putExtra("playerOne", playerOne);
                                goNext.putExtra("playerTwo", playerTwo);
                                startActivity(goNext);
                            }
                        }
                    });
                    AlertDialog alert = winner.create();
                    alert.show();
                }



            } else if (view == odd) {
                if (playerTwo.getGamble() % 2 == 0) {
                    playerTwo.addMarbles(playerTwo.getGamble());
                    playerOne.loseMarbles(playerTwo.getGamble());
                    AlertDialog.Builder winner = new AlertDialog.Builder(marblesMultiGuess.this);
                    winner.setMessage("Player 1 guessed incorrectly! " + playerOne.getGamble() + " marbles have been given to player 2").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (playerOne.getMarbles() <= 0) {
                                Intent winner = new Intent(view.getContext(), MarblesPlayerTwoWin.class);
                                startActivity(winner);
                            } else {
                                playerOne.advanceTurn();
                                Intent goNext = new Intent(view.getContext(), marblesMultiGamble.class);
                                goNext.putExtra("playerOne", playerOne);
                                goNext.putExtra("playerTwo", playerTwo);
                                startActivity(goNext);
                            }
                        }
                    });
                    AlertDialog alert = winner.create();
                    alert.show();


                } else if (playerTwo.getGamble() % 2 != 0) {
                    playerTwo.loseMarbles(playerTwo.getGamble());
                    playerOne.addMarbles(playerTwo.getGamble());
                    AlertDialog.Builder winner = new AlertDialog.Builder(marblesMultiGuess.this);
                    winner.setMessage("Player 1 guessed correctly! " + playerOne.getGamble() + " marbles have been given to player 1").setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (playerTwo.getMarbles() <= 0) {
                                Intent winner = new Intent(view.getContext(), MarblesPlayerTwoWin.class);
                                startActivity(winner);
                            } else {
                                playerOne.advanceTurn();
                                Intent goNext = new Intent(view.getContext(), marblesMultiGamble.class);
                                goNext.putExtra("playerOne", playerOne);
                                goNext.putExtra("playerTwo", playerTwo);
                                startActivity(goNext);
                            }
                        }
                    });
                    AlertDialog alert = winner.create();
                    alert.show();
                }


            }





        }

    }


}

