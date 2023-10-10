package com.hamidul.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TrackAdapter extends BaseAdapter {
    private Context context;
    private TrackModel[] tracks;

    TrackAdapter(Context context,TrackModel[] tracks){
        this.context=context;
        this.tracks=tracks;
    }

    @Override
    public int getCount() {
        return tracks.length;
    }

    @Override
    public Object getItem(int position) {
        return tracks[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TrackModel track = (TrackModel) getItem(position);

        ViewHolder holder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.song,parent,false);
            holder = new ViewHolder();
            holder.trackImage = convertView.findViewById(R.id.icon);
            holder.tittleText = convertView.findViewById(R.id.tvSong);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tittleText.setText(track.getName());

        if (track.isPlaying()){
            holder.trackImage.setImageResource(R.drawable.pause_icon);
        }else {
            holder.trackImage.setImageResource(R.drawable.play_icon);
        }

        return convertView;
    }

    static class ViewHolder{
        ImageView trackImage;
        TextView tittleText;

    }

}
