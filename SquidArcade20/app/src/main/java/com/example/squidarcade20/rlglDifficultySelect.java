package com.example.squidarcade20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rlglDifficultySelect extends AppCompatActivity implements View.OnClickListener{
    Button easyBtn;
    Button mediumBtn;
    Button hardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlgl_difficulty_select);
        easyBtn = (Button) findViewById(R.id.easy);
        mediumBtn = (Button) findViewById(R.id.medium);
        hardBtn = (Button) findViewById(R.id.hard);
        easyBtn.setOnClickListener(this);
        mediumBtn.setOnClickListener(this);
        hardBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent startGame = new Intent(this, rlglGame.class);
        if (view == easyBtn) { startGame.putExtra("time", 60000); }
        else if (view == mediumBtn) { startGame.putExtra("time", 45000); }
        else if (view == hardBtn) { startGame.putExtra("time", 30000); }
        startActivity(startGame);
    }
}