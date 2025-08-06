package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.a;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.r;
import java.security.MessageDigest;

public class g implements n3.g<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    public final n3.g<Bitmap> f64093b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f64094c;

    public g(n3.g<Bitmap> gVar, boolean z11) {
        this.f64093b = gVar;
        this.f64094c = z11;
    }

    public n3.g<BitmapDrawable> a() {
        return this;
    }

    public final r<Drawable> b(Context context, r<Bitmap> rVar) {
        return j.c(context.getResources(), rVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f64093b.equals(((g) obj).f64093b);
        }
        return false;
    }

    public int hashCode() {
        return this.f64093b.hashCode();
    }

    public r<Drawable> transform(Context context, r<Drawable> rVar, int i11, int i12) {
        e g11 = a.d(context).g();
        Drawable drawable = rVar.get();
        r<Bitmap> a11 = f.a(g11, drawable, i11, i12);
        if (a11 != null) {
            r<Bitmap> transform = this.f64093b.transform(context, a11, i11, i12);
            if (!transform.equals(a11)) {
                return b(context, transform);
            }
            transform.recycle();
            return rVar;
        } else if (!this.f64094c) {
            return rVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f64093b.updateDiskCacheKey(messageDigest);
    }
}
