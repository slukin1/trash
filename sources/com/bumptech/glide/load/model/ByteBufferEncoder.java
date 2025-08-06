package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Options;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import n3.a;

public class ByteBufferEncoder implements a<ByteBuffer> {
    /* renamed from: c */
    public boolean a(ByteBuffer byteBuffer, File file, Options options) {
        try {
            f4.a.e(byteBuffer, file);
            return true;
        } catch (IOException e11) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e11);
            }
            return false;
        }
    }
}
