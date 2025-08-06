package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import java.io.IOException;

public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    public final e f64043b = new BitmapPoolAdapter();

    public r<Bitmap> c(ImageDecoder.Source source, int i11, int i12, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i11 + "x" + i12 + "]");
        }
        return new c(decodeBitmap, this.f64043b);
    }
}
