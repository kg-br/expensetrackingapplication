package com.example.sql;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class aboutus extends AppCompatActivity {
    VideoView videoView;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        videoView=(VideoView)findViewById(R.id.videoView);
        Uri uri=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });



    }
}
