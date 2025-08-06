package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.n;
import com.bumptech.glide.load.engine.r;
import f4.h;
import f4.i;

public class c implements r<Bitmap>, n {

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f64075b;

    /* renamed from: c  reason: collision with root package name */
    public final e f64076c;

    public c(Bitmap bitmap, e eVar) {
        this.f64075b = (Bitmap) h.e(bitmap, "Bitmap must not be null");
        this.f64076c = (e) h.e(eVar, "BitmapPool must not be null");
    }

    public static c c(Bitmap bitmap, e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, eVar);
    }

    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    /* renamed from: b */
    public Bitmap get() {
        return this.f64075b;
    }

    public int getSize() {
        return i.h(this.f64075b);
    }

    public void initialize() {
        this.f64075b.prepareToDraw();
    }

    public void recycle() {
        this.f64076c.c(this.f64075b);
    }
}
