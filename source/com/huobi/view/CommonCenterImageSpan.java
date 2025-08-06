package com.huobi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ImageSpan;

public class CommonCenterImageSpan extends ImageSpan {
    public CommonCenterImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate(f11, (float) ((((i15 - i13) - drawable.getBounds().bottom) / 2) + i13));
        drawable.draw(canvas);
        canvas.restore();
    }

    public CommonCenterImageSpan(Context context, Bitmap bitmap, int i11) {
        super(context, bitmap, i11);
    }

    public CommonCenterImageSpan(Drawable drawable) {
        super(drawable);
    }

    public CommonCenterImageSpan(Drawable drawable, int i11) {
        super(drawable, i11);
    }

    public CommonCenterImageSpan(Drawable drawable, String str) {
        super(drawable, str);
    }

    public CommonCenterImageSpan(Drawable drawable, String str, int i11) {
        super(drawable, str, i11);
    }

    public CommonCenterImageSpan(Context context, Uri uri) {
        super(context, uri);
    }

    public CommonCenterImageSpan(Context context, Uri uri, int i11) {
        super(context, uri, i11);
    }

    public CommonCenterImageSpan(Context context, int i11) {
        super(context, i11);
    }

    public CommonCenterImageSpan(Context context, int i11, int i12) {
        super(context, i11, i12);
    }
}
