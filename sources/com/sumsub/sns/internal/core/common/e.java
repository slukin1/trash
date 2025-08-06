package com.sumsub.sns.internal.core.common;

import android.graphics.Bitmap;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.Config f32016a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f32017b;

    public e(Bitmap.Config config) {
        this.f32016a = config;
    }

    public final synchronized Bitmap a(int i11, int i12) {
        Bitmap bitmap;
        bitmap = this.f32017b;
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() != i11 || bitmap.getHeight() != i12) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            bitmap = Bitmap.createBitmap(i11, i12, this.f32016a);
        }
        this.f32017b = bitmap;
        return bitmap;
    }

    public final synchronized void a() {
        Bitmap bitmap = this.f32017b;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f32017b = null;
    }
}
