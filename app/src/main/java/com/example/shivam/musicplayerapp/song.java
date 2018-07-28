package com.example.shivam.musicplayerapp;

import android.graphics.drawable.Drawable;

public class song {

 public String name_song, name_artist;
 public Drawable image;

    public song(String name_song, String name_artist, Drawable image) {
        this.name_song = name_song;
        this.name_artist = name_artist;
        this.image = image;
    }

    public String getName_song() {
        return name_song;
    }

    public void setName_song(String name_song) {
        this.name_song = name_song;
    }

    public String getName_artist() {
        return name_artist;
    }

    public void setName_artist(String name_artist) {
        this.name_artist = name_artist;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
