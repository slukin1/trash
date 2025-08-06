package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import f4.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import n3.e;

public class d implements e<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final e f64077a;

    public d(e eVar) {
        this.f64077a = eVar;
    }

    /* renamed from: c */
    public r<Bitmap> b(ByteBuffer byteBuffer, int i11, int i12, Options options) throws IOException {
        return this.f64077a.f(a.f(byteBuffer), i11, i12, options);
    }

    /* renamed from: d */
    public boolean a(ByteBuffer byteBuffer, Options options) {
        return this.f64077a.q(byteBuffer);
    }
}
