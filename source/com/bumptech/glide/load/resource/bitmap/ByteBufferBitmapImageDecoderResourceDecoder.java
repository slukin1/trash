package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import java.io.IOException;
import java.nio.ByteBuffer;
import n3.e;

public final class ByteBufferBitmapImageDecoderResourceDecoder implements e<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapImageDecoderResourceDecoder f64044a = new BitmapImageDecoderResourceDecoder();

    /* renamed from: c */
    public r<Bitmap> b(ByteBuffer byteBuffer, int i11, int i12, Options options) throws IOException {
        return this.f64044a.b(ImageDecoder.createSource(byteBuffer), i11, i12, options);
    }

    /* renamed from: d */
    public boolean a(ByteBuffer byteBuffer, Options options) throws IOException {
        return true;
    }
}
