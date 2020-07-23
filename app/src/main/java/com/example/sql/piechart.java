package com.example.sql;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class piechart extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);
        mediaPlayer=MediaPlayer.create(piechart.this,R.raw.music);
        mediaPlayer.start();
        drawpie();
    }
    public void drawpie(){
        AnimatedPieView mAnimatedPieView = findViewById(R.id.pieid);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo(30, Color.parseColor("#B346B3"), "Food"))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(18.0f,Color.parseColor("#DAB77D"), "Clothes"))
                .addData(new SimplePieInfo(18.0f,Color.parseColor("#38E23C"), "Rent"))
                .addData(new SimplePieInfo(18.0f,Color.parseColor("#5EDEEE"), "Travel"))
               .addData(new SimplePieInfo(18.0f,Color.parseColor("#B2C403"), "Fuel"))
                //.addData(new SimplePieInfo(2.0f,Color.parseColor("#3E54E9E"), "Lifestyle"))
               // .addData(new SimplePieInfo(18.0f,Color.parseColor("#F01B63"), "Others"))
                .drawText(true).textSize(30)
      .duration(1500);

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();

    }



}
