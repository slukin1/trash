package com.sumsub.sns.internal.ml.core.pipeline;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.sumsub.sns.internal.ml.core.pipeline.core.c;

public final class b extends c<Bitmap, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final int f35031a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35032b;

    public b(int i11, int i12) {
        this.f35031a = i11;
        this.f35032b = i12;
    }

    /* renamed from: a */
    public Bitmap b(Bitmap bitmap) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i17 = this.f35031a;
        int i18 = 0;
        if (i17 > width) {
            i13 = (i17 - width) / 2;
            i11 = i13 + width;
            i12 = width;
            i14 = 0;
        } else {
            i14 = (width - i17) / 2;
            i12 = i14 + i17;
            i11 = i17;
            i13 = 0;
        }
        int i19 = this.f35032b;
        if (i19 > height) {
            i16 = (i19 - height) / 2;
            i15 = i16 + height;
        } else {
            int i21 = (height - i19) / 2;
            i18 = i21;
            height = i21 + i19;
            i15 = i19;
            i16 = 0;
        }
        Rect rect = new Rect(i14, i18, i12, height);
        Rect rect2 = new Rect(i13, i16, i11, i15);
        Bitmap createBitmap = Bitmap.createBitmap(this.f35031a, this.f35032b, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, rect, rect2, (Paint) null);
        return createBitmap;
    }
}
