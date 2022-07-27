package com.example.squidarcade20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class rlglGame extends AppCompatActivity implements View.OnLongClickListener {
    TextView countdown;
    Button run;
    CountDownTimer timer;
    private long timeLeft;
    String timeLeftText;
    private Handler repeatUpdateHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlgl_game);
        timeLeft = getIntent().getLongExtra("time", 0);
        countdown = (TextView) findViewById(R.id.timer);
        run = (Button) findViewById(R.id.run);
        startTimer();

    }

    public void startTimer(){
        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = 1;
                int seconds = (int) timeLeft/1000;
                timeLeftText = "" + seconds;
                countdown.setText(timeLeftText);
            }

            @Override
            public void onFinish() {
                Intent loss = new Intent(rlglGame.this, rlglLoss.class);
                startActivity(loss);
            }
        }.start();

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
}