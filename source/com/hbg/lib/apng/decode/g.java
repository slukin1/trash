package com.hbg.lib.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import y5.a;
import y5.b;

public abstract class g<R extends a, W extends b> {

    /* renamed from: a  reason: collision with root package name */
    public final R f66202a;

    /* renamed from: b  reason: collision with root package name */
    public int f66203b;

    /* renamed from: c  reason: collision with root package name */
    public int f66204c;

    /* renamed from: d  reason: collision with root package name */
    public int f66205d;

    /* renamed from: e  reason: collision with root package name */
    public int f66206e;

    /* renamed from: f  reason: collision with root package name */
    public int f66207f;

    public g(R r11) {
        this.f66202a = r11;
    }

    public abstract Bitmap a(Canvas canvas, Paint paint, int i11, Bitmap bitmap, W w11);
}
