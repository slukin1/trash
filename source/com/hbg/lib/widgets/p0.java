package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import java.security.MessageDigest;
import n3.b;

public class p0 extends CenterCrop {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f72114c = "com.bumptech.glide.transformations.GlideRoundTransform".getBytes(b.f66506a);

    /* renamed from: d  reason: collision with root package name */
    public static float f72115d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public static float f72116e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public static int f72117f;

    public p0(Context context, float f11, int i11, float f12) {
        f72115d = Resources.getSystem().getDisplayMetrics().density * f11;
        f72117f = i11;
        f72116e = Resources.getSystem().getDisplayMetrics().density * f12;
    }

    public static void a(Canvas canvas, Paint paint, float f11, float f12, Paint paint2) {
        float f13 = f72116e / 2.0f;
        Path path = new Path();
        float[] fArr = new float[8];
        int i11 = 15;
        for (int i12 = 3; i12 >= 0; i12--) {
            int i13 = i12 * 2;
            int i14 = i11 & 1;
            float f14 = 0.0f;
            fArr[i13 + 1] = i14 > 0 ? f72115d : 0.0f;
            if (i14 > 0) {
                f14 = f72115d;
            }
            fArr[i13] = f14;
            i11 >>= 1;
        }
        path.addRoundRect(new RectF(f13, f13, f11 - f13, f12 - f13), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
    }

    public static Bitmap roundCrop(e eVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap d11 = eVar.d(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (d11 == null) {
            d11 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(d11);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        if (f72117f != 0) {
            Paint paint2 = new Paint(1);
            paint2.setColor(f72117f);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f72116e);
            a(canvas, paint, (float) bitmap.getWidth(), (float) bitmap.getHeight(), paint2);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            float f11 = f72115d;
            canvas.drawRoundRect(rectF, f11, f11, paint);
        }
        return d11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p0) {
            p0 p0Var = (p0) obj;
            float f11 = f72115d;
            if (f11 == f11) {
                float f12 = f72116e;
                if (f12 == f12) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) (((float) 356303905) + (f72115d * 1000.0f) + (f72116e * 10.0f) + ((float) f72117f));
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        return roundCrop(eVar, super.transform(eVar, bitmap, i11, i12));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("com.bumptech.glide.transformations.GlideRoundTransform" + f72115d + f72116e + f72117f).getBytes(b.f66506a));
    }
}
