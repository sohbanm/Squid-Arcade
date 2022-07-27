package com.example.squidarcade20.MarblesClasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class CPU implements Player, Parcelable {
    private int marbles;
    private String playerRole;
    private String guess;
    private int gamble;


    public CPU(){
        this.marbles = 10;
    }

    protected CPU(Parcel in) {
        marbles = in.readInt();
        playerRole = in.readString();
        guess = in.readString();
        gamble = in.readInt();
    }

    public static final Creator<CPU> CREATOR = new Creator<CPU>() {
        @Override
        public CPU createFromParcel(Parcel in) {
            return new CPU(in);
        }

        @Override
        public CPU[] newArray(int size) {
            return new CPU[size];
        }
    };

    //Generates random number from 1-3, unless there are less than 3 marbles.
    @Override
    public void generateGamble(){
        Random randomNumber = new Random();
        int gamble;
        if(this.marbles>2){
            gamble = randomNumber.nextInt(3)+1;
        }else{
            gamble = randomNumber.nextInt(this.marbles)+1;    //upper bound becomes # of marbles
        }
        this.gamble = gamble;
    }

    @Override
    public void loseMarbles(int marblesLost) {
        this.marbles -= marblesLost;
    }

    @Override
    public void addMarbles(int marblesGained) {
        this.marbles += marblesGained;
    }

    @Override
    public void setGamble(int gamble) {

    }

    @Override
    public String getPlayerRole() {
        return this.playerRole;
    }

    @Override
    public String getGuess() {
        return this.guess;
    }

    @Override
    public void setPlayerRole(String newRole) {
        this.playerRole = newRole;
    }

    //sets a random Boolean value to guess for even or odd
    @Override
    public void newGuess(){
        String guess;
        Random randomBoolean = new Random();
        boolean evenOdd = randomBoolean.nextBoolean();
        if (evenOdd == true) {
             guess = "even";
        } else {
            guess = "odd";
        }
        this.guess = guess;
    }

    @Override
    public void setResultText(String text) {

    }

    @Override
    public String getResultText() {
        return null;
    }

    @Override
    public void setGuess(String guess) {

    }

    public int getMarbles(){
        return this.marbles;
    }

    @Override
    public int getGamble(){
        return this.gamble;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(marbles);
        parcel.writeString(playerRole);
        parcel.writeString(guess);
        parcel.writeInt(gamble);
    }
}
