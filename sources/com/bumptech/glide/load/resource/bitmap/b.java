package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.r;
import java.io.File;
import n3.f;

public class b implements f<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final e f64073a;

    /* renamed from: b  reason: collision with root package name */
    public final f<Bitmap> f64074b;

    public b(e eVar, f<Bitmap> fVar) {
        this.f64073a = eVar;
        this.f64074b = fVar;
    }

    public EncodeStrategy b(Options options) {
        return this.f64074b.b(options);
    }

    /* renamed from: c */
    public boolean a(r<BitmapDrawable> rVar, File file, Options options) {
        return this.f64074b.a(new c(rVar.get().getBitmap(), this.f64073a), file, options);
    }
}
