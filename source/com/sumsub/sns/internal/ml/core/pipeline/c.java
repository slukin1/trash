package com.sumsub.sns.internal.ml.core.pipeline;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;

public final class c extends com.sumsub.sns.internal.ml.core.pipeline.core.c<Bitmap, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final int f35033a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35034b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f35035c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f35036d;

    public c(int i11, int i12, boolean z11, boolean z12) {
        this.f35033a = i11;
        this.f35034b = i12;
        this.f35035c = z11;
        this.f35036d = z12;
    }

    /* renamed from: a */
    public Bitmap b(Bitmap bitmap) {
        if (!this.f35036d) {
            return Bitmap.createScaledBitmap(bitmap, this.f35033a, this.f35034b, this.f35035c);
        }
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), new RectF(0.0f, 0.0f, (float) this.f35033a, (float) this.f35034b), Matrix.ScaleToFit.CENTER);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, this.f35035c);
    }
}
