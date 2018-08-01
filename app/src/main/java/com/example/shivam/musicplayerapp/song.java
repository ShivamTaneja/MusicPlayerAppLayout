package com.example.shivam.musicplayerapp;

import android.os.Parcel;
import android.os.Parcelable;

public class song implements Parcelable{

 private String name_song, name_artist;
 private int imageResourceId;

    public song(String name_song, String name_artist, int imageResourceId) {
        this.name_song = name_song;
        this.name_artist = name_artist;
        this.imageResourceId = imageResourceId;
    }

    protected song(Parcel in) {
        name_song = in.readString();
        name_artist = in.readString();
        imageResourceId = in.readInt();
    }

    public static final Creator<song> CREATOR = new Creator<song>() {
        @Override
        public song createFromParcel(Parcel in) {
            return new song(in);
        }

        @Override
        public song[] newArray(int size) {
            return new song[size];
        }
    };

    public String getName_song() {
        return name_song;
    }

    public String getName_artist() {
        return name_artist;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name_song);
        parcel.writeString(name_artist);
        parcel.writeInt(imageResourceId);
    }
}
