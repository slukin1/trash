package com.rodolfonavalon.shaperipplelibrary.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class BaseShape {

    /* renamed from: a  reason: collision with root package name */
    public int f28861a;

    /* renamed from: b  reason: collision with root package name */
    public int f28862b;

    public abstract void a(Canvas canvas, int i11, int i12, float f11, int i13, int i14, Paint paint);

    public abstract void b(Context context, Paint paint);

    public void c(int i11) {
        this.f28862b = i11;
    }

    public void d(int i11) {
        this.f28861a = i11;
    }
}
