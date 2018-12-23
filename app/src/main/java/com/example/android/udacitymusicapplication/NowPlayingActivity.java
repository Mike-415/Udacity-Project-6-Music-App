package com.example.android.udacitymusicapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NowPlayingActivity extends AppCompatActivity {
    private static final String TAG = "NowPlayingActivity";
    @BindView(R.id.now_playing_title_text_view)
    TextView mTitle;
    @BindView(R.id.now_playing_artist_text_view)
    TextView mArtist;
    @BindView(R.id.now_playing_album_cover_image_view)
    ImageView mAlbumCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        setViews((Song) getIntent().getSerializableExtra(Song.INTENT_TAG));
        /*
        An example of an individual onClickListener without ButterKnife binding

        ImageButton playButton = (ImageButton) findViewById(R.id.now_playing_play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(this, "Play button pressed", Toast.LENGTH_SHORT).show();
            }
        });
         */
    }

    /**
     * Sets the ImageView and TextView with data from a song instance
     *
     * @param song     A Song instance
     */
    public void setViews(Song song) {
        mTitle.setText(song.getTitle());
        mArtist.setText("by " + song.getArtist());
        mAlbumCover.setImageResource(song.getImageResourceId());
    }

    /**
     * This method is called when a music-control button is click i.e. play, next, and previous.
     * When clicked, a toast displays with the name of that button.
     *
     * @param view    represents the button that was clicked
     */
    @OnClick({R.id.now_playing_previous_button,
              R.id.now_playing_play_button,
              R.id.now_playing_next_button})
    public void onViewClicked(View view) {
        StringBuilder results = new StringBuilder(" button clicked");
        switch (view.getId()) {
            case R.id.now_playing_previous_button:
                results.insert(0, "Previous");
                break;
            case R.id.now_playing_play_button:
                results.insert(0, "Play");
                break;
            case R.id.now_playing_next_button:
                results.insert(0, "Next");
                break;
        }
        Toast.makeText(this, results, Toast.LENGTH_SHORT).show();
    }
}
