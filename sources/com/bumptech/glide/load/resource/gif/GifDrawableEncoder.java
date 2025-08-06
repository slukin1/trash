package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import f4.a;
import java.io.File;
import java.io.IOException;
import n3.f;
import y3.c;

public class GifDrawableEncoder implements f<c> {
    public EncodeStrategy b(Options options) {
        return EncodeStrategy.SOURCE;
    }

    /* renamed from: c */
    public boolean a(r<c> rVar, File file, Options options) {
        try {
            a.e(rVar.get().c(), file);
            return true;
        } catch (IOException e11) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e11);
            }
            return false;
        }
    }
}
