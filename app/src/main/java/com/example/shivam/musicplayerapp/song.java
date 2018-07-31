package com.example.shivam.musicplayerapp;

public class song {

 private String name_song, name_artist;
 private int imageResourceId;

    public song(String name_song, String name_artist, int imageResourceId) {
        this.name_song = name_song;
        this.name_artist = name_artist;
        this.imageResourceId = imageResourceId;
    }

    public String getName_song() {
        return name_song;
    }

    public String getName_artist() {
        return name_artist;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
