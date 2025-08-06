package com.tencent.qcloud.tuikit.timcommon.component.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.a;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.bitmap.c;
import java.security.MessageDigest;
import n3.g;

public class CornerTransform implements g<Bitmap> {
    private boolean exceptLeftBottom;
    private boolean exceptLeftTop;
    private boolean exceptRightBottom;
    private boolean exceptRightTop;
    private e mBitmapPool;
    private float radius;

    public CornerTransform(Context context, float f11) {
        this.mBitmapPool = a.d(context).g();
        this.radius = f11;
    }

    public void setExceptCorner(boolean z11, boolean z12, boolean z13, boolean z14) {
        this.exceptLeftTop = z11;
        this.exceptRightTop = z12;
        this.exceptLeftBottom = z13;
        this.exceptRightBottom = z14;
    }

    public r<Bitmap> transform(Context context, r<Bitmap> rVar, int i11, int i12) {
        int i13;
        int i14;
        Bitmap bitmap = rVar.get();
        if (i11 > i12) {
            float f11 = (float) i12;
            float f12 = (float) i11;
            i13 = bitmap.getWidth();
            i14 = (int) (((float) bitmap.getWidth()) * (f11 / f12));
            if (i14 > bitmap.getHeight()) {
                i14 = bitmap.getHeight();
                i13 = (int) (((float) bitmap.getHeight()) * (f12 / f11));
            }
        } else if (i11 < i12) {
            float f13 = (float) i11;
            float f14 = (float) i12;
            int height = bitmap.getHeight();
            int height2 = (int) (((float) bitmap.getHeight()) * (f13 / f14));
            if (height2 > bitmap.getWidth()) {
                i13 = bitmap.getWidth();
                i14 = (int) (((float) bitmap.getWidth()) * (f14 / f13));
            } else {
                int i15 = height;
                i13 = height2;
                i14 = i15;
            }
        } else {
            i13 = bitmap.getHeight();
            i14 = i13;
        }
        this.radius *= ((float) i14) / ((float) i12);
        Bitmap d11 = this.mBitmapPool.d(i13, i14, Bitmap.Config.ARGB_8888);
        if (d11 == null) {
            d11 = Bitmap.createBitmap(i13, i14, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(d11);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        int width = (bitmap.getWidth() - i13) / 2;
        int height3 = (bitmap.getHeight() - i14) / 2;
        if (!(width == 0 && height3 == 0)) {
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) (-width), (float) (-height3));
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        float f15 = this.radius;
        canvas.drawRoundRect(rectF, f15, f15, paint);
        if (this.exceptLeftTop) {
            float f16 = this.radius;
            canvas.drawRect(0.0f, 0.0f, f16, f16, paint);
        }
        if (this.exceptRightTop) {
            float f17 = this.radius;
            canvas.drawRect(((float) canvas.getWidth()) - f17, 0.0f, f17, f17, paint);
        }
        if (this.exceptLeftBottom) {
            float f18 = this.radius;
            canvas.drawRect(0.0f, ((float) canvas.getHeight()) - f18, f18, (float) canvas.getHeight(), paint);
        }
        if (this.exceptRightBottom) {
            canvas.drawRect(((float) canvas.getWidth()) - this.radius, ((float) canvas.getHeight()) - this.radius, (float) canvas.getWidth(), (float) canvas.getHeight(), paint);
        }
        return c.c(d11, this.mBitmapPool);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
