package com.example.squidarcade20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button goToMarbles;
    Button goToRlgl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToRlgl = (Button) findViewById(R.id.rlglButton);
        goToMarbles = (Button) findViewById(R.id.marblesButton);

        goToMarbles.setOnClickListener(this);
        goToRlgl.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.marblesButton) {
            Intent switchToMarbles = new Intent(this, marblesPlayerSelection.class);
            startActivity(switchToMarbles);

        } else if (view.getId() == R.id.rlglButton) {
            Intent switchToRlgl = new Intent(this, rlglDifficultySelect.class);
            startActivity(switchToRlgl);
        }

    }
}