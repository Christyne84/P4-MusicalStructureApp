package com.example.android.p4_musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Boolean flagMainActivitySongs = false;
    public static Boolean flagMainActivityNowPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the songs category
        TextView songs = (TextView) findViewById(R.id.songs);

        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SongsActivity}
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);

                // Start the new activity
                startActivity(songsIntent);

                //When the SongsActivity starts from the MainActivity,
                // modify the flag from false to true
                flagMainActivitySongs = true;
            }
        });

        // Find the View that shows the nowPlaying category
        TextView nowPlaying = (TextView) findViewById(R.id.now_playing);

        // Set a click listener on that View
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the nowPlaying category is clicked on.
            @Override
            public void onClick(View view) {
                //When the NowPlayingActivity starts from the MainActivity,
                // modify the flag from false to true
                flagMainActivityNowPlaying = true;

                // Create a new intent to open the {@link NowPlayingActivity}
                Intent nowPlaying = new Intent(MainActivity.this, NowPlayingActivity.class);

                // Start the new activity
                startActivity(nowPlaying);

            }
        });

    }
}
