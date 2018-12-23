package com.example.android.udacitymusicapplication;

import java.io.Serializable;

public class Song implements Serializable {
    public static final String INTENT_TAG = "Song instance";
    private String mTitle, mArtist;
    private int mImageResourceId;

    public Song(String title, String artist, int imageResourceId) {
        mTitle = title;
        mArtist = artist;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the song title
     * @return title
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the name of the artist of the song
     * @return artist name
     */
    public String getArtist() {
        return mArtist;
    }

    /**
     * Get the image resource ID number
     * @return image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "mTitle='" + mTitle + '\'' +
                ", mArtist='" + mArtist + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
