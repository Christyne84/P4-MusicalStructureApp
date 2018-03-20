/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.p4_musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {
    public static final ArrayList<MusicInfo> musicInfos = new ArrayList<MusicInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_info);

        // Create an array of musicInfos
        musicInfos.add(new MusicInfo(getString(R.string.song_name1),getString(R.string.artist_name1)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name2), getString(R.string.artist_name2)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name3), getString(R.string.artist_name3)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name4), getString(R.string.artist_name4)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name5), getString(R.string.artist_name5)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name6), getString(R.string.artist_name6)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name7), getString(R.string.artist_name7)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name8), getString(R.string.artist_name8)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name9), getString(R.string.artist_name9)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name10), getString(R.string.artist_name10)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name11), getString(R.string.artist_name11)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name12), getString(R.string.artist_name12)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name13), getString(R.string.artist_name13)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name14), getString(R.string.artist_name14)));
        musicInfos.add(new MusicInfo(getString(R.string.song_name15), getString(R.string.artist_name15)));

        // Create an {@link MusicAdapter}, whose data source is a list of {@link MusicInfo}s. The
        // musicAdapter knows how to create list items for each item in the list.
        MusicAdapter musicAdapter = new MusicAdapter(this, musicInfos);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // music_info.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link MusicAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link MusicInfo} in the list.
        listView.setAdapter(musicAdapter);

        AdapterView.OnItemClickListener adapterViewClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicAdapter.currentMusicInfo = musicInfos.get(position);
                Intent intent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                startActivity(intent);
           }
        };

        listView.setOnItemClickListener(adapterViewClickListener);
    }
}
