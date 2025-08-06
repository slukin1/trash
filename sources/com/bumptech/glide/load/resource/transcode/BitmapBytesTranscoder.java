package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import java.io.ByteArrayOutputStream;
import v3.a;
import z3.c;

public class BitmapBytesTranscoder implements c<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.CompressFormat f64136a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64137b;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public r<byte[]> a(r<Bitmap> rVar, Options options) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        rVar.get().compress(this.f64136a, this.f64137b, byteArrayOutputStream);
        rVar.recycle();
        return new a(byteArrayOutputStream.toByteArray());
    }

    public BitmapBytesTranscoder(Bitmap.CompressFormat compressFormat, int i11) {
        this.f64136a = compressFormat;
        this.f64137b = i11;
    }
}
