package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import java.security.MessageDigest;
import n3.b;

public class CenterCrop extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f64045b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(b.f66506a);

    public boolean equals(Object obj) {
        return obj instanceof CenterCrop;
    }

    public int hashCode() {
        return -599754482;
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        return o.b(eVar, bitmap, i11, i12);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f64045b);
    }
}
