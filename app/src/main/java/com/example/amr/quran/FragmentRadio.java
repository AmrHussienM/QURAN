package com.example.amr.quran;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentRadio extends Fragment {
    View v;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Radio> listOfRadio;
    RadioAdapter adapter;
    ImageButton play;
    ImageButton stop;

    public FragmentRadio() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.radio_fragment,container,false);
        recyclerView=v.findViewById(R.id.radio_recyclerView);
        play=v.findViewById(R.id.icPlay);
        stop=v.findViewById(R.id.icStop);
        getChannels();
        return v;

    }
    SnapHelper snapHelper;
    public void SetAdapter(){
        adapter=new RadioAdapter(listOfRadio);
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        snapHelper=new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v=snapHelper.findSnapView(layoutManager);
                int pos=recyclerView.getChildAdapterPosition(v);
                Log.e("FreagmentRadio",listOfRadio.get(pos).getURL()+"");

                PlayChannel(listOfRadio.get(pos).getURL());
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopChannel();
            }
        });

    }

    MediaPlayer mediaPlayer;
    public void PlayChannel(String url){
        mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.e("FragmentRadio","aaaa");

                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stopChannel(){
        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
             mediaPlayer.stop();
        }

    }
    public void getChannels(){

        ApiManager.getAPIS().getRadioChannels().enqueue(new Callback<RadioResponse>() {
            @Override
            public void onResponse(Call<RadioResponse> call, Response<RadioResponse> response) {
                listOfRadio=response.body().getRadios();
                SetAdapter();
            }

            @Override
            public void onFailure(Call<RadioResponse> call, Throwable t) {
                t.getLocalizedMessage();
                Log.e("Fragment","failure");
            }
        });

    }

}
