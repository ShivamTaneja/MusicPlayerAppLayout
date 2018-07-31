package com.example.shivam.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class English extends AppCompatActivity {

    Button btn_english, btn_hindi, btn_punjabi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_english = findViewById(R.id.button_english);
        btn_hindi = findViewById(R.id.button_hindi);
        btn_punjabi = findViewById(R.id.button_punjabi);

        btn_english.setBackgroundColor(getResources().getColor(R.color.orange));

        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_english.setBackgroundColor(getResources().getColor(R.color.orange));
                btn_hindi.setBackgroundColor(getResources().getColor(R.color.light_orange));
                btn_punjabi.setBackgroundColor(getResources().getColor(R.color.light_orange));


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

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<song> Songs = new ArrayList<song>();

        Songs.add(new song("SONG- The way i am ","ARTIST- Charlie Puth", R.drawable.iwayiam));
        Songs.add(new song("SONG- end game","ARTIST- Rupi",  R.drawable.endgame));
        Songs.add(new song("SONG- Love story ","ARTIST- Taylor Swift" , R.drawable.lovestory));
        Songs.add(new song("SONG- Unity", "ARTIST- Shubhi", R.drawable.unity));


        songAdapter itemsAdapter = new songAdapter(this, Songs);
        GridView gridView = findViewById(R.id.grid);
        gridView.setAdapter(itemsAdapter);

    }


}
