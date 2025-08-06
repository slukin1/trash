package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import f4.i;
import n3.e;

public final class UnitBitmapDecoder implements e<Bitmap, Bitmap> {

    public static final class a implements r<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f64070b;

        public a(Bitmap bitmap) {
            this.f64070b = bitmap;
        }

        public Class<Bitmap> a() {
            return Bitmap.class;
        }

        /* renamed from: b */
        public Bitmap get() {
            return this.f64070b;
        }

        public int getSize() {
            return i.h(this.f64070b);
        }

        public void recycle() {
        }
    }

    /* renamed from: c */
    public r<Bitmap> b(Bitmap bitmap, int i11, int i12, Options options) {
        return new a(bitmap);
    }

    /* renamed from: d */
    public boolean a(Bitmap bitmap, Options options) {
        return true;
    }
}
