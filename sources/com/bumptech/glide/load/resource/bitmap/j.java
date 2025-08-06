package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.n;
import com.bumptech.glide.load.engine.r;
import f4.h;

public final class j implements r<BitmapDrawable>, n {

    /* renamed from: b  reason: collision with root package name */
    public final Resources f64108b;

    /* renamed from: c  reason: collision with root package name */
    public final r<Bitmap> f64109c;

    public j(Resources resources, r<Bitmap> rVar) {
        this.f64108b = (Resources) h.d(resources);
        this.f64109c = (r) h.d(rVar);
    }

    public static r<BitmapDrawable> c(Resources resources, r<Bitmap> rVar) {
        if (rVar == null) {
            return null;
        }
        return new j(resources, rVar);
    }

    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    /* renamed from: b */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f64108b, this.f64109c.get());
    }

    public int getSize() {
        return this.f64109c.getSize();
    }

    public void initialize() {
        r<Bitmap> rVar = this.f64109c;
        if (rVar instanceof n) {
            ((n) rVar).initialize();
        }
    }

    public void recycle() {
        this.f64109c.recycle();
    }
}
