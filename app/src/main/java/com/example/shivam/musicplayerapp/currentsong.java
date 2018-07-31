package com.example.shivam.musicplayerapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class currentsong extends AppCompatActivity {

    ImageView img_play, shuffle, repeat, song_image;
    boolean state_playbutton, state_shuffle, state_repeat;
    TextView name_of_song, name_of_artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currentsong);

        img_play = findViewById(R.id.play);
        shuffle = findViewById(R.id.shuffle);
        repeat = findViewById(R.id.repeat);
        song_image = findViewById(R.id.song_image);
        name_of_song = findViewById(R.id.name_of_song);
        name_of_artist = findViewById(R.id.name_of_artist);

        state_playbutton = true;
        state_shuffle = true;
        state_repeat = true;

        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state_playbutton)
                {
                    img_play.setImageResource(R.drawable.ic_pause_black_24dp);
                    state_playbutton = false;
                }
                else
                {
                    img_play.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    state_playbutton = true;
                }

            }
        });

        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(state_shuffle)
                {
                    shuffle.setImageResource(R.drawable.ic_shuffle_red_24dp);
                    state_shuffle = false;
                }
                else
                {
                    shuffle.setImageResource(R.drawable.ic_shuffle_black_24dp);
                    state_shuffle = true;
                }
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state_repeat)
                {
                    repeat.setImageResource(R.drawable.ic_repeat_one_black_24dp);
                    state_repeat = false;
                }
                else
                {
                    repeat.setImageResource(R.drawable.ic_repeat_black_24dp);
                    state_repeat = true;
                }
            }
        });

        Bundle extras = getIntent().getExtras();
        String song_name = extras.getString("song_name");
        String song_artist = extras.getString("song_artist");
        int song_img = extras.getInt("song_img");

        song_image.setImageResource(song_img);
        name_of_song.setText(song_name);
        name_of_artist.setText(song_artist);

    }
}
