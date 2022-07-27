package com.example.squidarcade20.MarblesClasses;

import android.os.Parcel;
import android.os.Parcelable;

public class Human implements Player, Parcelable {
    private int marbles;
    private int gamble;
    private String playerRole;
    private String guess;
    private String resultText;
    private int turn;

    public Human(){
        this.marbles = 10;
    }

    protected Human(Parcel in) {
        marbles = in.readInt();
        gamble = in.readInt();
        playerRole = in.readString();
        guess = in.readString();
    }

    public static final Creator<Human> CREATOR = new Creator<Human>() {
        @Override
        public Human createFromParcel(Parcel in) {
            return new Human(in);
        }

        @Override
        public Human[] newArray(int size) {
            return new Human[size];
        }
    };

    public int getMarbles(){
        return this.marbles;
    }

    //null
    @Override
    public void generateGamble() {
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
    public void setGamble(int gamble){
        this.gamble = gamble;
    }

    //Have Gamble be a boolean value. True for even and false for odd.
    //So even button will make gamble True and odd will make it False
    /*public void changeMarbles(Boolean gamble){
        if(gamble){
            if(marbles % 2 == 0){
                this.marbles = this.marbles - this.gamble;
            }else{
                this.marbles = this.marbles + this.gamble;
            }
        }
    }*/
    public String getPlayerRole(){
        return this.playerRole;
    }

    @Override
    public void newGuess() {
    }

    @Override
    public void setResultText(String text) {
        this.resultText = text;
    }

    @Override
    public String getResultText() {
        return this.resultText;
    }

    @Override
    public void setGuess(String guess){
        this.guess = guess;
    }

    @Override
    public int getGamble() {
        return this.gamble;
    }

    @Override
    public String getGuess() {
        return this.guess;
    }


    public void setPlayerRole(String newRole){
        this.playerRole = newRole;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(marbles);
        parcel.writeInt(gamble);
        parcel.writeString(playerRole);
        parcel.writeString(guess);
    }

    public void startTurns(){
        this.turn = 0;
    }

    public void advanceTurn(){
        this.turn += 1;
    }

    public int getTurn(){
        return this.turn;
    }
}
