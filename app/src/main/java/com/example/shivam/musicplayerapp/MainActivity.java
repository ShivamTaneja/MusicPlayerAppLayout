package com.example.shivam.musicplayerapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_english, btn_hindi, btn_punjabi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_english = findViewById(R.id.button_english);
        btn_hindi = findViewById(R.id.button_hindi);
        btn_punjabi = findViewById(R.id.button_punjabi);

        btn_punjabi.setBackgroundColor(getResources().getColor(R.color.orange));

        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_english.setBackgroundColor(getResources().getColor(R.color.orange));
                btn_hindi.setBackgroundColor(getResources().getColor(R.color.light_orange));
                btn_punjabi.setBackgroundColor(getResources().getColor(R.color.light_orange));

                Intent intent = new Intent(getApplicationContext(), English.class);
                startActivity(intent);

            }
        });

        btn_hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hindi.setBackgroundColor(getResources().getColor(R.color.orange));
                btn_english.setBackgroundColor(getResources().getColor(R.color.light_orange));
                btn_punjabi.setBackgroundColor(getResources().getColor(R.color.light_orange));

                Intent intent = new Intent(getApplicationContext(), Hindi.class);
                startActivity(intent);

            }
        });

        btn_punjabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_punjabi.setBackgroundColor(getResources().getColor(R.color.orange));
                btn_hindi.setBackgroundColor(getResources().getColor(R.color.light_orange));
                btn_english.setBackgroundColor(getResources().getColor(R.color.light_orange));


            }
        });

        ArrayList<song> Songs = new ArrayList<song>();

        Songs.add(new song("SONG- difference","ARTIST- Amrit Mann",  getResources().getDrawable(R.drawable.difference)));
        Songs.add(new song("SONG- trending nakhra", "ARTIST- Amrit Mann", getResources().getDrawable(R.drawable.trendingnakhra)));
        Songs.add(new song("SONG- prada","ARTIST- Jass Manak",  getResources().getDrawable(R.drawable.prada)));
        Songs.add(new song("SONG- Hath chumma","ARTIST- Ammy Virk",getResources().getDrawable(R.drawable.hathchumme)));

        songAdapter itemsAdapter = new songAdapter(this, Songs);
        GridView gridView = findViewById(R.id.grid);
        gridView.setAdapter(itemsAdapter);

    }

}
