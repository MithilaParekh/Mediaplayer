package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ambareamba);

        // register all the buttons using their appropriate IDs
        Button b1 = findViewById(R.id.playButton);
        Button b2 = findViewById(R.id.pauseButton);
        Button b3 = findViewById(R.id.stopButton);

        // handle the start button to
        // start the audio playbac
     /*   b1.setOnClickListener {
            // start method is used to start
            // playing the audio file
            mediaPlayer.start()
        }*/
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        // handle the pause button to put the
        // MediaPlayer instance at the Pause state
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                // after stopping the mediaplayer instance
                // it is again need to be prepared
                // for the next instance of playback
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // handle the stop button to stop playing
        // and prepare the mediaplayer instance
        // for the next instance of play
    }
}