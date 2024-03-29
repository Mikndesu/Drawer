package com.example.makethisdrawgraph;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLRenderer implements GLSurfaceView.Renderer {

    private final Context context;

    public GLRenderer(final Context cont){
        context = cont;
    }

    Drawing drawing;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //Prepare the shader program
        drawing = new Drawing();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        //set The View Port
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 unused) {

        ArrayList<Float> p = new ArrayList<>();

        for(int i = -1000; i < 1001; i++) {
            float f = (float)i * 0.005f;
            p.add(f);
            p.add((f * (float)MainActivity.number) + 1);
        }

        float[] points = Expression_Dealer.toArray(p);

        GLES20.glClearColor(0.839f, 0.776f, 0.686f, 1.0f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        FloatBuffer vpos = BufferUtil.convertx(
                0.0f, 0.5f, -0.5f, -0.5f, 0.5f, -0.5f
        );
        FloatBuffer fcol = BufferUtil.convertx(1.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glLineWidth(16.0f);
        drawing.draw(fcol, vpos);
    }
}
