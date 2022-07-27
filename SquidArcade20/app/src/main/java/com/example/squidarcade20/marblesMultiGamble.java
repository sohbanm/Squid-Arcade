package com.example.squidarcade20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.squidarcade20.MarblesClasses.Human;

import org.w3c.dom.Text;

public class marblesMultiGamble extends AppCompatActivity implements View.OnClickListener{
    Button submitBtn;
    EditText gamble;
    Human playerOne;
    Human playerTwo;
    TextView marblesRemainingP1;
    TextView marblesRemainingP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_multi_gamble);

        submitBtn = (Button) findViewById(R.id.submitGamble);
        gamble = (EditText) findViewById(R.id.gambleAmount);
        playerOne = getIntent().getParcelableExtra("playerOne");
        playerTwo = getIntent().getParcelableExtra("playerTwo");
        marblesRemainingP1 = (TextView) findViewById(R.id.playerOne);
        marblesRemainingP2 = (TextView) findViewById(R.id.playerTwo);
        marblesRemainingP1.setText("Player One Marbles Remaining: " + playerOne.getMarbles());
        marblesRemainingP2.setText("Player Two Marbles Remaining: " + playerTwo.getMarbles());
        AlertDialog.Builder inputPlease = new AlertDialog.Builder(marblesMultiGamble.this);
        if (playerOne.getTurn() % 2 == 0) {
            inputPlease.setMessage("Player One please select the number of marbles you would like to bet this round").setPositiveButton("Ok", null);
        } else {
            inputPlease.setMessage("Player Two please select the number of marbles you would like to bet this round").setPositiveButton("Ok", null);
        }
        AlertDialog alert = inputPlease.create();
        alert.show();
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int gambleAmount = Integer.parseInt(gamble.getText().toString());

        if (playerOne.getTurn() % 2 == 0) {
            //event handler for invalid inputs
            if (gambleAmount > playerOne.getMarbles() || gambleAmount < 1 || TextUtils.isEmpty(gamble.getText().toString())) {
                AlertDialog.Builder invalidInput = new AlertDialog.Builder(marblesMultiGamble.this);
                invalidInput.setMessage("Error: Invalid Input, Please enter a valid number of marbles").setPositiveButton("Ok", null);
                AlertDialog alert = invalidInput.create();
                alert.show();
            } else {
                playerOne.setGamble(gambleAmount);
                Intent a = new Intent(this, marblesMultiGuess.class);
                a.putExtra("playerOne", playerOne);
                a.putExtra("playerTwo", playerTwo);
                startActivity(a);
            }
        }

        else if (playerOne.getTurn() % 2 != 0) {
            if (gambleAmount > playerTwo.getMarbles() || gambleAmount < 1 || TextUtils.isEmpty(gamble.getText().toString())) {
                AlertDialog.Builder invalidInput = new AlertDialog.Builder(marblesMultiGamble.this);
                invalidInput.setMessage("Error: Invalid Input, Please enter a valid number of marbles").setPositiveButton("Ok", null);
                AlertDialog alert = invalidInput.create();
                alert.show();
            } else {
                playerTwo.setGamble(gambleAmount);
                Intent a = new Intent(this, marblesMultiGuess.class);
                a.putExtra("playerOne", playerOne);
                a.putExtra("playerTwo", playerTwo);
                startActivity(a);
            }

        }
    }


}