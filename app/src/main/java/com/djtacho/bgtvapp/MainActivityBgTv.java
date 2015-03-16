package com.djtacho.bgtvapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import io.vov.vitamio.LibsChecker;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;





public class MainActivityBgTv extends ActionBarActivity {

    private String pathToFileOrUrl= "mms://video.djtacho.com/online";
    private VideoView mVideoView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new com.djtacho.bgtvapp.ImageAdapter(this));
        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
//        if (!LibsChecker.checkVitamioLibs(this))
//            return;
//
//        setContentView(R.layout.activity_main_activity_bg_tv);

//        mVideoView = (VideoView) findViewById(R.id.surface_view);
//
//        if (pathToFileOrUrl == "") {
//            Toast.makeText(this, "Please set the video path for your media file", Toast.LENGTH_LONG).show();
//            return;
//        } else {
//
//            /*
//             * Alternatively,for streaming media you can use
//             * mVideoView.setVideoURI(Uri.parse(URLstring));
//             */
//            mVideoView.setVideoPath(pathToFileOrUrl);
//            mVideoView.setMediaController(new MediaController(this));
//            mVideoView.requestFocus();
//
//            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mediaPlayer) {
//                    // optional need Vitamio 4.0
//                    mediaPlayer.setPlaybackSpeed(1.0f);
//                }
//            });
//        }

    }

    public void startPlay(View view) {
        if (!TextUtils.isEmpty(pathToFileOrUrl)) {
            mVideoView.setVideoPath(pathToFileOrUrl);
        }
    }

    public void openVideo(View View) {
        mVideoView.setVideoPath(pathToFileOrUrl);
    }

    /**
     * Created by rsirako on 3/4/2015.
     */
    public static class ImageAdapter {
    }


}
