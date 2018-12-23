package com.example.android.udacitymusicapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private static final String TAG = "SongAdapter";
    private ArrayList<Song> mSongs;
    private Context mContext;

    public SongAdapter(ArrayList<Song> songs, Context context) {
        mSongs = songs;
        mContext = context;
    }

    /**
     * This inner class holds the widgets of each list item in memory
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mTitle, mArtist;
        LinearLayout mParentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.list_item_image_view);
            mTitle = itemView.findViewById(R.id.list_item_title_text_view);
            mArtist = itemView.findViewById(R.id.list_item_artist_text_view);
            mParentLayout = itemView.findViewById(R.id.list_item_parent_layout);
        }
    }

    /**
     * This callback method is responsible for inflating the new items in the RecyclerView
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * This callback method is called each time a new item is added to the RecyclerView
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mImage.setImageResource(mSongs.get(position).getImageResourceId());
        holder.mTitle.setText(mSongs.get(position).getTitle());
        holder.mArtist.setText(mSongs.get(position).getArtist());
        holder.mParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, ""+mSongs.get(position));
                Song clickedSong = mSongs.get(position);
                Intent intent = new Intent(mContext, NowPlayingActivity.class);
                intent.putExtra(Song.INTENT_TAG, clickedSong);
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * This call back method is used to determine the size of the RecyclerView
     */
    @Override
    public int getItemCount() {
        return mSongs.size();
    }

}
