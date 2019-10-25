package com.example.makethisdrawgraph;

import android.opengl.GLES20;
import android.util.Log;

import java.nio.FloatBuffer;

import static android.content.ContentValues.TAG;

public class Drawing {

    public final String vShaderCode =
            "attribute  vec2 vpos;" +
                    "void main() {" +
                    "  gl_Position = vec4(vpos, 0.0, 1.0);" +
                    "gl_PointSize = 15.0;" +
                    "}";

    public final String fShaderCode =
            "precision mediump float;" +
                    "uniform lowp vec4 fcol;" +
                    "void main() {" +
                    "  gl_FragColor = fcol;" +
                    "if(length(gl_PointCoord-vec2(0.5)) > 0.5) discard;"+
                    "}";

    private static final int INVALID = 0;
    private static final int FIRST_INDEX = 0;
    private static final int DEFAULT_OFFSET = 0;
    private int shaderProg;

    public static int ldShader(final int shaderType, final String source) {
        int shader = GLES20.glCreateShader(shaderType);
        if (shader != INVALID) {
            GLES20.glShaderSource(shader, source);
            GLES20.glCompileShader(shader);
            final int[] compiled = new int[1];
            GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compiled, DEFAULT_OFFSET);
            if (compiled[FIRST_INDEX] == INVALID) {
                Log.e(TAG, "ldShader:" + shaderType + ":" + GLES20.glGetShaderInfoLog(shader));
                GLES20.glDeleteShader(shader);
                shader = INVALID;
            }
        }
        return shader;
    }

    public Drawing() {
        int vShader = ldShader(GLES20.GL_VERTEX_SHADER, vShaderCode);
        int fShader = ldShader(GLES20.GL_FRAGMENT_SHADER, fShaderCode);
        shaderProg = GLES20.glCreateProgram();
        GLES20.glAttachShader(shaderProg, vShader);
        GLES20.glAttachShader(shaderProg, fShader);
        GLES20.glLinkProgram(shaderProg);
        GLES20.glDeleteShader(vShader);
        GLES20.glDeleteShader(fShader);
    }

    public void draw(FloatBuffer fcol, FloatBuffer vpos){
        GLES20.glUseProgram(shaderProg);

        int fcolx = GLES20.glGetUniformLocation(shaderProg, "fcol");
        GLES20.glUniform4fv(fcolx,1,fcol);

        int vposx = GLES20.glGetAttribLocation(shaderProg, "vpos");
        GLES20.glEnableVertexAttribArray(vposx);
        GLES20.glVertexAttribPointer
                (vposx, 2, GLES20.GL_FLOAT, false, 0, vpos);

        GLES20.glDrawArrays(GLES20.GL_POINTS, 0, vpos.capacity() / 2);
        GLES20.glDisableVertexAttribArray(vposx);
        GLES20.glUseProgram(0);
    }


}