package com.example.shivam.musicplayerapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class songAdapter extends ArrayAdapter<song> {

    public songAdapter(@NonNull Context context, @NonNull List<song> songs) {
        super(context, 0 ,songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {

        final song currentsong = getItem(position);
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        TextView song_name = listItemView.findViewById(R.id.name_of_song);
        assert currentsong != null;
        song_name.setText(currentsong.getName_song());

        TextView name_artist = listItemView.findViewById(R.id.name_of_artist);
        name_artist.setText(currentsong.getName_artist());

        ImageView song_img = listItemView.findViewById(R.id.image_of_song);
        song_img.setImageResource(currentsong.getImageResourceId());

        return listItemView;
    }

}
