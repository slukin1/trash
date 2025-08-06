package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import java.security.MessageDigest;
import n3.b;

public class CircleCrop extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f64047b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(b.f66506a);

    public boolean equals(Object obj) {
        return obj instanceof CircleCrop;
    }

    public int hashCode() {
        return 1101716364;
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        return o.d(eVar, bitmap, i11, i12);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f64047b);
    }
}
