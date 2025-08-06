package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import f4.h;
import java.io.IOException;
import n3.e;

public class a<DataType> implements e<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final e<DataType, Bitmap> f64071a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f64072b;

    public a(Resources resources, e<DataType, Bitmap> eVar) {
        this.f64072b = (Resources) h.d(resources);
        this.f64071a = (e) h.d(eVar);
    }

    public boolean a(DataType datatype, Options options) throws IOException {
        return this.f64071a.a(datatype, options);
    }

    public r<BitmapDrawable> b(DataType datatype, int i11, int i12, Options options) throws IOException {
        return j.c(this.f64072b, this.f64071a.b(datatype, i11, i12, options));
    }
}
