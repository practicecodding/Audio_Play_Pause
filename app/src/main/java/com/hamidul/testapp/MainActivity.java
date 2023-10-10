package com.hamidul.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    private TrackModel[] trackList;
    private TrackAdapter adapter;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        loadTracks();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadTracks();

                TrackModel track = trackList[position];

                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                        mediaPlayer.reset();
                        track.setPlaying(false);
                    }
                }

                try {
                    mediaPlayer = MediaPlayer.create(MainActivity.this,track.getId());
                    if (mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        track.setPlaying(false);
                    } else {
                        mediaPlayer.start();
                        track.setPlaying(true);
                    }

                }catch (Exception e){
                    Log.e("Exception",e.getMessage());
                }

            }
        });

    }
    public void loadTracks(){
        trackList=new TrackModel[]{
                new TrackModel(R.raw.alone_sad_ringtone,"Alone Sad Ringtone",false),
                new TrackModel(R.raw.attitude_ringtone_song,"Attitude Ringtone Song",false),
                new TrackModel(R.raw.carol_of_bells_bgm_ringtone,"Carol of Bells",false),
                new TrackModel(R.raw.instagram_viral_ringtone_trending_bgm_mc_stan_ringtone,"Instagram Viral",false),
                new TrackModel(R.raw.mood_off_ringtone_status,"Mood off Ringtone",false),
                new TrackModel(R.raw.very_sad_ringtone__emotional_ringtone,"Very Sad Ringtone",false),
                new TrackModel(R.raw.viral_ringtone,"Viral Ringtone",false)

        };
        adapter = new TrackAdapter(MainActivity.this,trackList);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                mediaPlayer.reset();
            }
        }
    }
}