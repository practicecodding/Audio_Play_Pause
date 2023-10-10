package com.hamidul.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    GridView gridView;
    MediaPlayer mediaPlayer;
    public static HashMap<String ,String> hashMap;
    public static ArrayList<HashMap<String,String>> MainList = new ArrayList<>();
    public static ArrayList <HashMap<String,String>> A = new ArrayList<>();
    public static ArrayList <HashMap<String,String>> B = new ArrayList<>();
    public static String Name = "";
    TextView itemToolbar;
    String pUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main2);

        gridView = findViewById(R.id.gridView);
        itemToolbar = findViewById(R.id.itemToolbar);

        itemToolbar.setText(Name);

        MyAdapter myAdapter = new MyAdapter(this);
        gridView.setAdapter(myAdapter);


    }

    private class MyAdapter extends BaseAdapter {
        private Context context;
        private int selectedItem = -1; // Track the selected item position
        private boolean isMediaPlayerPlaying = false;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return MainList.size();
        }

        @Override
        public Object getItem(int i) {

            return MainList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
//            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View myView = layoutInflater.inflate(R.layout.song,viewGroup,false);

            pUrl = "";

            View myView = view;
            if (myView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                myView = inflater.inflate(R.layout.song, null);
            }

            TextView songName = myView.findViewById(R.id.tvSong);
            ImageView imageView = myView.findViewById(R.id.icon);

            HashMap hashMap1 = MainList.get(position);

            String song = (String) hashMap1.get("song");
            String url = (String) hashMap1.get("url");

            pUrl = url;

            int x = position+1;

            songName.setText(x+". "+song);

            if (position == selectedItem) {
                if (isMediaPlayerPlaying) {
                    imageView.setImageResource(R.drawable.pause_icon); // Replace with your playing image resource
                } else {
                    imageView.setImageResource(R.drawable.play_icon); // Replace with your stopped image resource
                }
            }

//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    setSelectedItem(position);
//                    notifyDataSetChanged();
//
//                    if (mediaPlayer!=null) mediaPlayer.release();
//                    mediaPlayer = new MediaPlayer();
//                    try {
//                        mediaPlayer.setDataSource(url);
//                        mediaPlayer.prepare();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    // Start or stop the media player based on your logic
//                    if (!isMediaPlayerPlaying) {
//                        mediaPlayer.start();
//                        setMediaPlayerPlaying(true);
//                    } else {
//                        mediaPlayer.pause();
//                        setMediaPlayerPlaying(false);
//                    }
//                }
//            });

            return myView;
        }

        // Set the selected item position

        public void setSelectedItem(int position) {
            selectedItem = position;
        }

        // Set the media player state
        public void setMediaPlayerPlaying(boolean isPlaying) {
            isMediaPlayerPlaying = isPlaying;
        }

    }


    public static void Album (){
        hashMap = new HashMap<>();
        hashMap.put("name","Mizanur Rahman Ajhari");
        MainList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Deloar Hossain Saidi");
        MainList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Md Hamidul Sarder");
        MainList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Md Ujjal Sarder");
        MainList.add(hashMap);

    }

    public static void A (){
        hashMap = new HashMap<>();
        hashMap.put("song","Waz 1");
        hashMap.put("url","https://smhamidulcodding.000webhostapp.com/mp3/Alone_Sad_Ringtone.mp3");
        A.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("song","Waz 2");
        hashMap.put("url","https://smhamidulcodding.000webhostapp.com/mp3/Alone_Sad_Ringtone.mp3");
        A.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("song","Waz 3");
        hashMap.put("url","https://smhamidulcodding.000webhostapp.com/mp3/Alone_Sad_Ringtone.mp3");
        A.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("song","Waz 4");
        hashMap.put("url","https://smhamidulcodding.000webhostapp.com/mp3/viral_ringtone.mp3");
        A.add(hashMap);

    }

    public static void B (){
        hashMap = new HashMap<>();
        hashMap.put("song","Song B1");
        B.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("song","Song B2");
        B.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("song","Song B3");
        B.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("song","Song B4");
        B.add(hashMap);

    }


}