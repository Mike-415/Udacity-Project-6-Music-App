package com.example.android.udacitymusicapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//TODO: Make sure that you recreate the xml file for landscape to remove the Collapsible AppBar
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<Song> mSongs = new ArrayList<>();
    @BindView(R.id.container_recycler_view) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initSongs();
        initRecyclerView();
    }

    /**
     * Creates and adds Song instances to the songs ArrayList
     */
    private void initSongs(){
        mSongs.add(new Song("Hey Now", "Odesza", R.drawable.odesza_album_cover ));
        mSongs.add(new Song("Summer", "Vanilla", R.drawable.vanilla_album_cover));
        mSongs.add(new Song("Let It Happen", "Tame Impala", R.drawable.tame_impala_album_cover));
        mSongs.add(new Song("Fantasy", "Saint Pepsi", R.drawable.saint_pepsi_album_cover ));
        mSongs.add(new Song("Strangers", "Seven Lions", R.drawable.seven_lions_album_cover ));

    }

    /**
     * Sets the adapter to the recycler view container
     */
    private void initRecyclerView(){
        SongAdapter adapter = new SongAdapter(mSongs, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
