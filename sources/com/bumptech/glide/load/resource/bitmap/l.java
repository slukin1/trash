package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import n3.e;
import w3.d;

public class l implements e<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final d f64111a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f64112b;

    public l(d dVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f64111a = dVar;
        this.f64112b = eVar;
    }

    /* renamed from: c */
    public r<Bitmap> b(Uri uri, int i11, int i12, Options options) {
        r<Drawable> c11 = this.f64111a.b(uri, i11, i12, options);
        if (c11 == null) {
            return null;
        }
        return f.a(this.f64112b, c11.get(), i11, i12);
    }

    /* renamed from: d */
    public boolean a(Uri uri, Options options) {
        return "android.resource".equals(uri.getScheme());
    }
}
