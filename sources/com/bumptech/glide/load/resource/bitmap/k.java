package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import java.io.IOException;
import n3.e;

public final class k implements e<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final e f64110a;

    public k(e eVar) {
        this.f64110a = eVar;
    }

    /* renamed from: c */
    public r<Bitmap> b(ParcelFileDescriptor parcelFileDescriptor, int i11, int i12, Options options) throws IOException {
        return this.f64110a.d(parcelFileDescriptor, i11, i12, options);
    }

    /* renamed from: d */
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, Options options) {
        return this.f64110a.o(parcelFileDescriptor);
    }
}
