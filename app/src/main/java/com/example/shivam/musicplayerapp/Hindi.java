package com.example.shivam.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class Hindi extends AppCompatActivity {

    Button btn_english, btn_hindi, btn_punjabi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hindi");

        btn_english = findViewById(R.id.button_english);
        btn_hindi = findViewById(R.id.button_hindi);
        btn_punjabi = findViewById(R.id.button_punjabi);

        btn_hindi.setBackgroundColor(getResources().getColor(R.color.orange));

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
            }
        });

        btn_punjabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_punjabi.setBackgroundColor(getResources().getColor(R.color.orange));
                btn_hindi.setBackgroundColor(getResources().getColor(R.color.light_orange));
                btn_english.setBackgroundColor(getResources().getColor(R.color.light_orange));

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        final ArrayList<song> Songs = new ArrayList<song>();

        Songs.add(new song(getString(R.string.halka_halka), getString(R.string.saurabh),R.drawable.halkahalks));
        Songs.add(new song(getString(R.string.baarish),getString(R.string.rahat),  R.drawable.bararish));

        songAdapter itemsAdapter = new songAdapter(this, Songs);
        GridView gridView = findViewById(R.id.grid);
        gridView.setAdapter(itemsAdapter);

        gridView.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                song s = Songs.get(i);
                Intent intent = new Intent(getApplicationContext() , currentsong.class);
                intent.putExtra("song", (Parcelable) s);
                startActivity(intent);
            }
        });
    }
}
