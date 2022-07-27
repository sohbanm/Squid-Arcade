package com.example.squidarcade20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.squidarcade20.MarblesClasses.Human;

public class marblesMultiTurnResultsScreen extends AppCompatActivity implements View.OnClickListener {
    Human playerOne;
    Human playerTwo;
    TextView marblesRemainingP1;
    TextView marblesRemainingP2;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_multi_turn_results_screen);
        playerOne = getIntent().getParcelableExtra("playerOne");
        playerTwo = getIntent().getParcelableExtra("playerTwo");
        marblesRemainingP1 = (TextView) findViewById(R.id.playerOne2);
        marblesRemainingP2 = (TextView) findViewById(R.id.playerTwo2);
        marblesRemainingP1.setText("Player One Marbles Remaining: " + playerOne.getMarbles());
        marblesRemainingP2.setText("Player Two Marbles Remaining: " + playerTwo.getMarbles());
        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent next = new Intent(this, marblesMultiGamble.class);
        next.putExtra("playerOne", playerOne);
        next.putExtra("playerTwo", playerTwo);
        startActivity(next);
    }
}