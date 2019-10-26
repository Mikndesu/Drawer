package com.example.makethisdrawgraph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.Button;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;
    public static float color = 1.0f;
    private Button changer;

    public static String expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glSurfaceView = findViewById(R.id.glSurfaceView);
        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(new GLRenderer(getApplicationContext()));
        glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        changer = findViewById(R.id.changer);
        changer.setOnClickListener((v) -> {color = color - 1.0f;});

//        Intent intent = getIntent();
//        expression = intent.getStringExtra("expression");
    }

    @Override
    public void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }
}
