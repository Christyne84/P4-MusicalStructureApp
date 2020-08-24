package com.example.android.p4_musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * {@link NowPlayingActivity} represents the info shown in now_playing_info.xml populated with the
 * song and artist's names using the list of {@link MusicInfo} objects
 */
public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing_info);

        // Find the Views that show the song and artist's names in the now_playing_info.xml
        TextView songTitleTextView = findViewById(R.id.song_title_text_view);
        TextView artistNameTextView = findViewById(R.id.artist_text_view);

        //Get the intent
        getIntent();

        //If the user has never played a song and is accessing NowPlaying activity from the
        //MainActivity, instead of showing a song and artist name, ask the user to choose a
        //song from the list.
        if(MusicAdapter.currentMusicInfo == null) {
            songTitleTextView.setText(R.string.choose_song_text_view);
            songTitleTextView.setTextSize(16);
            artistNameTextView.setText("");

            //Adds a drawable below the song_title_text_view, to let the user know that the textView
            //is clickable
            songTitleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.folder_open);

            // Set a click listener on the songTitleTextView
            songTitleTextView.setOnClickListener(new View.OnClickListener() {

                // The code in this method will be executed when the songs category is clicked on.
                @Override
                public void onClick(View view) {
                    // Create a new intent to open the SongsActivity
                    Intent songsIntent = new Intent(NowPlayingActivity.this, SongsActivity.class);

                    // Start the new activity
                    startActivity(songsIntent);
                }
            });
        }

        //If the user already played a song from the list,
        // then show the name of the current song and artist
        else {
            songTitleTextView.setText(MusicAdapter.currentMusicInfo.getSongName());
            artistNameTextView.setText(MusicAdapter.currentMusicInfo.getArtistName());
        }
    }
}
