package com.example.makethisdrawgraph;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class BufferUtil {

   public static FloatBuffer convert(float[] data) {
       ByteBuffer bb = ByteBuffer.allocateDirect(data.length * 4);
       bb.order(ByteOrder.nativeOrder());

       FloatBuffer fb = bb.asFloatBuffer();
       fb.put(data);
       fb.position(0);
       return fb;
   }

   public static FloatBuffer convertx(float... args) {
       return convert(args);
   }
}
