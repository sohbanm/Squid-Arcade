package com.example.squidarcade20.MarblesClasses;

import android.os.Parcel;
import android.os.Parcelable;

public class gameMultiplayer implements Parcelable {
    protected gameMultiplayer(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<gameMultiplayer> CREATOR = new Creator<gameMultiplayer>() {
        @Override
        public gameMultiplayer createFromParcel(Parcel in) {
            return new gameMultiplayer(in);
        }

        @Override
        public gameMultiplayer[] newArray(int size) {
            return new gameMultiplayer[size];
        }
    };



}
