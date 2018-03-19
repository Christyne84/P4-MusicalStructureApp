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
    public static Boolean flagSongsActivitySongSelect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_info);
        flagSongsActivitySongSelect = false;

        // Create an array of musicInfos
        musicInfos.add(new MusicInfo("How high the Moon","Les Paul"));
        musicInfos.add(new MusicInfo("Stone Crazy", "Buddy Guy"));
        musicInfos.add(new MusicInfo("Pretty Woman", "Roy Orbison, Bruce Springsteen & James Burton"));
        musicInfos.add(new MusicInfo("Purple Haze", "Jimi Hendrix"));
        musicInfos.add(new MusicInfo("Black Magic Woman", "Carlos Santana"));
        musicInfos.add(new MusicInfo("Sultans Of Swing", "Dire Straits"));
        musicInfos.add(new MusicInfo("La Grange", "ZZ Top"));
        musicInfos.add(new MusicInfo("Solo from 'Can't You Hear Me Knocking'", "Mick Taylor"));
        musicInfos.add(new MusicInfo("Riding With The King", "B.B. King & Eric Clapton"));
        musicInfos.add(new MusicInfo("Born Under A Bad Sign", "Albert King"));
        musicInfos.add(new MusicInfo("Cold Shot", "Stevie Ray Vaughan"));
        musicInfos.add(new MusicInfo("A Day In The Life", "Jeff Beck"));
        musicInfos.add(new MusicInfo("Smoke on the water", "Ritchie Blackmore"));
        musicInfos.add(new MusicInfo("Comfortably Numb", "David Gilmour"));
        musicInfos.add(new MusicInfo("Shine On You Crazy Diamond", "David Gilmour"));

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
                flagSongsActivitySongSelect = true;
           }
        };

        listView.setOnItemClickListener(adapterViewClickListener);
    }
}
