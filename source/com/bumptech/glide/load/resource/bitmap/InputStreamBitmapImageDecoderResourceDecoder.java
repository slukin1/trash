package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import f4.a;
import java.io.IOException;
import java.io.InputStream;
import n3.e;

public final class InputStreamBitmapImageDecoderResourceDecoder implements e<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapImageDecoderResourceDecoder f64063a = new BitmapImageDecoderResourceDecoder();

    /* renamed from: c */
    public r<Bitmap> b(InputStream inputStream, int i11, int i12, Options options) throws IOException {
        return this.f64063a.b(ImageDecoder.createSource(a.b(inputStream)), i11, i12, options);
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) throws IOException {
        return true;
    }
}
