package com.djtacho.bgtvapp;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

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
import io.vov.vitamio.widget.VideoView;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.util.Log;


public class FullImageActivity extends Activity {
    VideoView videoView;
    private int mVideoWidth;
    private int mVideoHeight;
    private MediaPlayer mMediaPlayer;
    private SurfaceView mPreview;
    private SurfaceHolder holder;
    private String path;
    private Bundle extras;
    private static final String MEDIA = "media";
    private static final int LOCAL_AUDIO = 1;
    private static final int STREAM_AUDIO = 2;
    private static final int RESOURCES_AUDIO = 3;
    private static final int LOCAL_VIDEO = 4;
    private static final int STREAM_VIDEO = 5;
    private boolean mIsVideoSizeKnown = false;
    private boolean mIsVideoReadyToBePlayed = false;
    private static final String TAG = "MediaPlayerDemo";
    private void startVideoPlayback(){
        String httpLiveUrl = "mms://video.djtacho.com/online";
        videoView = (VideoView) findViewById(R.id.VideoView);
        videoView.setVideoURI(Uri.parse(httpLiveUrl));
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.start();
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        startVideoPlayback();
    }
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        Log.v(TAG, "onVideoSizeChanged called");
        if (width == 0 || height == 0) {
            Log.e(TAG, "invalid video width(" + width + ") or height(" + height + ")");
            return;
        }
        mIsVideoSizeKnown = true;
        mVideoWidth = width;
        mVideoHeight = height;
        if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
            startVideoPlayback();
        }
    }
}
