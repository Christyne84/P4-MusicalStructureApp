package com.example.android.p4_musicalstructureapp;

/**
 * {@link MusicInfo} represents the info about a song and contains
 * the song's name and the artist's name.
 */
public class MusicInfo {

    /** song title */
    private String mSongName;

    /** artist name */
    private String mArtistName;

    /**
     * Create a new MusicInfo object.
     *
     * @param songName is the name of the song
     * @param artistName is the name of the artist
     */
    public MusicInfo(String songName, String artistName){
        mSongName = songName;
        mArtistName = artistName;
    }

    /**
     * Get the name of the song.
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the name of the artist.
     */
    public String getArtistName() {
        return mArtistName;
    }

}
