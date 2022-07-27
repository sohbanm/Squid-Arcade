package com.example.squidarcade20.MarblesClasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class gameSingleplayer implements Parcelable {

    private String winner;
    private String resultText;

    public gameSingleplayer() {
        this.winner = null;
    }

    protected gameSingleplayer(Parcel in) {
    }

    public static final Creator<gameSingleplayer> CREATOR = new Creator<gameSingleplayer>() {
        @Override
        public gameSingleplayer createFromParcel(Parcel in) {
            return new gameSingleplayer(in);
        }

        @Override
        public gameSingleplayer[] newArray(int size) {
            return new gameSingleplayer[size];
        }
    };

    public String getWinner(){
        return this.winner;
    }

    public void checkWin(Player human, Player cpu) {
        if (human.getMarbles() == 0) {
            this.winner = "cpu";
        } else if (cpu.getMarbles() == 0) {
            this.winner = "human";
        }
    }


    public void switchRole(Player human, Player cpu){
        if (human.getPlayerRole().equals("guesser") && cpu.getPlayerRole().equals("gambler")) {
            human.setPlayerRole("gambler");
            cpu.setPlayerRole("guesser");
        } else if (human.getPlayerRole().equals("gambler") && cpu.getPlayerRole().equals("guesser")) {
            human.setPlayerRole("guesser");
            cpu.setPlayerRole("gambler");
        } else {
            throw new IllegalArgumentException("playerRole of human: " + human.getPlayerRole() + " and cpu: " + cpu.getPlayerRole() + " are invalid");
        }
    }

    
    public void assignRole(Player human, Player cpu){
        Random zeroOrOne = new Random();
        int x = zeroOrOne.nextInt(2);
        if (x == 0) {
            human.setPlayerRole("guesser");
            cpu.setPlayerRole("gambler");
        } else {
            human.setPlayerRole("gambler");
            cpu.setPlayerRole("guesser");
        }
    }

    public void setResultText(String text){
        this.resultText = text;
    }

    public String getResultText(){
        return this.resultText;
    }

    public void transferMarbles(Player winner, Player loser, int marbles){
        winner.addMarbles(marbles);
        loser.loseMarbles(marbles);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
