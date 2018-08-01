package com.example.shivam.musicplayerapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class currentsong extends AppCompatActivity {

    ImageView img_play, shuffle, repeat, song_image;
    boolean state_playbutton, state_shuffle, state_repeat;
    TextView name_of_song, name_of_artist;
    ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    boolean temp=true;
    Button btn_english, btn_punjabi, btn_hindi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currentsong);
        setTitle("Current Song");


        img_play = findViewById(R.id.play);
        shuffle = findViewById(R.id.shuffle);
        repeat = findViewById(R.id.repeat);
        song_image = findViewById(R.id.song_image);
        name_of_song = findViewById(R.id.name_of_song);
        name_of_artist = findViewById(R.id.name_of_artist);
        progressBar = findViewById(R.id.progressBar);
        btn_english = findViewById(R.id.button_english);
        btn_hindi = findViewById(R.id.button_hindi);
        btn_punjabi = findViewById(R.id.button_punjabi);

        state_playbutton = true;
        state_shuffle = true;
        state_repeat = true;

        thread.start();

        btn_punjabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        btn_hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Hindi.class);
                startActivity(intent);

            }
        });

        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), English.class);
                startActivity(intent);

            }
        });

        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state_playbutton)
                {
                    img_play.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    state_playbutton = false;
                    temp = false;
                }
                else
                {
                    img_play.setImageResource(R.drawable.ic_pause_black_24dp);
                    state_playbutton = true;
                    temp = true;
                    thread.start();
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

        song s = getIntent().getExtras().getParcelable("song");
        song_image.setImageResource(s.getImageResourceId());
        name_of_song.setText(s.getName_song());
        name_of_artist.setText(s.getName_artist());

    }

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (progressStatus < 300 && temp) {
                // Update the progress status
                progressStatus += 1;

                // Try to sleep the thread for 100 milliseconds
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Update the progress bar
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(progressStatus);
                    }
                });
            }
        }
    });
}
