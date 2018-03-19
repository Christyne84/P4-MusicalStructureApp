package com.example.android.p4_musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link MusicAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link MusicInfo} objects.
 */
public class MusicAdapter extends ArrayAdapter<MusicInfo> {
    public static MusicInfo currentMusicInfo = null;

    /**
     * Create a new {@link MusicAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the musicAdapter is being created in.
     * @param musicInfos is the list of {@link MusicInfo}s to be displayed (like song and artist's name).
     */
    public MusicAdapter(Context context, ArrayList<MusicInfo> musicInfos) {
       /* We have initialized the global variable currentMusicInfo the ArrayAdapter's internal storage for the context and the list.
         This argument is used when the ArrayAdapter is populating a single TextView.
         Because this is a custom musicAdapter for two TextViews, the musicAdapter is not
         going to use this second argument, so it can be any value. Here, we used 0.
        */
        super(context, 0, musicInfos);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link MusicInfo} object located at this position in the list
        MusicInfo displayedMusicInfo = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID song_title_text_view.
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_text_view);

        // Get the Song Name from the currentMusicInfo object and set this text on
        // the songTitleTextView.
        if (displayedMusicInfo != null) {
            songTitleTextView.setText(displayedMusicInfo.getSongName());
        }

        // Find the TextView in the list_item.xml layout with the ID artist_text_view.
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);

        // Get the Artist Name from the displayedMusicInfo object and set this text on
        // the artistName TextView.
        if (displayedMusicInfo != null) {
            artistNameTextView.setText(displayedMusicInfo.getArtistName());
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
