package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import f4.h;
import f4.i;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import n3.b;

public final class m extends BitmapTransformation {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f64113c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(b.f66506a);

    /* renamed from: b  reason: collision with root package name */
    public final int f64114b;

    public m(int i11) {
        h.a(i11 > 0, "roundingRadius must be greater than 0.");
        this.f64114b = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m) || this.f64114b != ((m) obj).f64114b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return i.n(-569625254, i.m(this.f64114b));
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        return o.o(eVar, bitmap, this.f64114b);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f64113c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f64114b).array());
    }
}
