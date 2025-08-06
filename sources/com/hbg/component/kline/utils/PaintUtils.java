package com.hbg.component.kline.utils;

import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Shader;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.widgets.R$font;

public class PaintUtils {

    /* renamed from: a  reason: collision with root package name */
    public static PathEffect f67401a = new DashPathEffect(new float[]{(float) DimenUtils.a(1.5f), (float) DimenUtils.a(1.5f)}, 0.0f);

    /* renamed from: b  reason: collision with root package name */
    public static PathEffect f67402b = new CornerPathEffect(5.0f);

    public static void a(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    public static void b(Paint paint, int i11, float f11) {
        d(paint, i11, f11);
        paint.setPathEffect(f67401a);
    }

    public static void c(Paint paint, int i11) {
        a(paint);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(i11);
    }

    public static void d(Paint paint, int i11, float f11) {
        a(paint);
        paint.setStrokeWidth(f11);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i11);
    }

    public static void e(Paint paint, int i11, float f11, PathEffect pathEffect) {
        d(paint, i11, f11);
        paint.setPathEffect(pathEffect);
    }

    public static void f(Paint paint, int i11, float f11) {
        d(paint, i11, f11);
        paint.setPathEffect(f67402b);
    }

    public static void g(Paint paint, Shader shader) {
        a(paint);
        paint.setShader(shader);
    }

    public static void h(Paint paint, Paint.Align align, int i11, float f11) {
        a(paint);
        paint.setColor(i11);
        if (0.0f != f11) {
            paint.setTypeface(ResourcesCompat.h(BaseApplication.b(), R$font.roboto_regular));
            paint.setTextSize(f11);
        }
        paint.setTextAlign(align);
    }
}
