package com.github.mikephil.charting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.exoplayer2.audio.AacUtil;
import com.huawei.hms.framework.common.ExceptionCode;
import d5.b;
import d5.e;

public abstract class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f65557a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f65558b = 50;

    /* renamed from: c  reason: collision with root package name */
    public static int f65559c = 8000;

    /* renamed from: d  reason: collision with root package name */
    public static final double f65560d = Double.longBitsToDouble(1);

    /* renamed from: e  reason: collision with root package name */
    public static final float f65561e = Float.intBitsToFloat(1);

    /* renamed from: f  reason: collision with root package name */
    public static Rect f65562f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public static Paint.FontMetrics f65563g = new Paint.FontMetrics();

    /* renamed from: h  reason: collision with root package name */
    public static Rect f65564h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f65565i = {1, 10, 100, 1000, 10000, AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, 1000000, ExceptionCode.CRASH_EXCEPTION, 100000000, 1000000000};

    /* renamed from: j  reason: collision with root package name */
    public static e f65566j = h();

    /* renamed from: k  reason: collision with root package name */
    public static Rect f65567k = new Rect();

    /* renamed from: l  reason: collision with root package name */
    public static Rect f65568l = new Rect();

    /* renamed from: m  reason: collision with root package name */
    public static Paint.FontMetrics f65569m = new Paint.FontMetrics();

    public static int a(Paint paint, String str) {
        Rect rect = f65562f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize b(Paint paint, String str) {
        FSize b11 = FSize.b(0.0f, 0.0f);
        c(paint, str, b11);
        return b11;
    }

    public static void c(Paint paint, String str, FSize fSize) {
        Rect rect = f65564h;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.f65542c = (float) rect.width();
        fSize.f65543d = (float) rect.height();
    }

    public static int d(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float e(float f11) {
        DisplayMetrics displayMetrics = f65557a;
        if (displayMetrics != null) {
            return f11 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f11;
    }

    public static void f(Canvas canvas, Drawable drawable, int i11, int i12, int i13, int i14) {
        MPPointF b11 = MPPointF.b();
        b11.f65546c = (float) (i11 - (i13 / 2));
        b11.f65547d = (float) (i12 - (i14 / 2));
        drawable.copyBounds(f65567k);
        Rect rect = f65567k;
        int i15 = rect.left;
        int i16 = rect.top;
        drawable.setBounds(i15, i16, i15 + i13, i13 + i16);
        int save = canvas.save();
        canvas.translate(b11.f65546c, b11.f65547d);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void g(Canvas canvas, String str, float f11, float f12, Paint paint, MPPointF mPPointF, float f13) {
        float fontMetrics = paint.getFontMetrics(f65569m);
        paint.getTextBounds(str, 0, str.length(), f65568l);
        float f14 = 0.0f - ((float) f65568l.left);
        float f15 = (-f65569m.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f13 != 0.0f) {
            float width = f14 - (((float) f65568l.width()) * 0.5f);
            float f16 = f15 - (fontMetrics * 0.5f);
            if (!(mPPointF.f65546c == 0.5f && mPPointF.f65547d == 0.5f)) {
                FSize t11 = t((float) f65568l.width(), fontMetrics, f13);
                f11 -= t11.f65542c * (mPPointF.f65546c - 0.5f);
                f12 -= t11.f65543d * (mPPointF.f65547d - 0.5f);
                FSize.c(t11);
            }
            canvas.save();
            canvas.translate(f11, f12);
            canvas.rotate(f13);
            canvas.drawText(str, width, f16, paint);
            canvas.restore();
        } else {
            if (!(mPPointF.f65546c == 0.0f && mPPointF.f65547d == 0.0f)) {
                f14 -= ((float) f65568l.width()) * mPPointF.f65546c;
                f15 -= fontMetrics * mPPointF.f65547d;
            }
            canvas.drawText(str, f14 + f11, f15 + f12, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static e h() {
        return new b(1);
    }

    public static int i(float f11) {
        float y11 = y((double) f11);
        if (Float.isInfinite(y11)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10((double) y11))) + 2;
    }

    public static e j() {
        return f65566j;
    }

    public static float k(Paint paint) {
        return l(paint, f65563g);
    }

    public static float l(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float m(Paint paint) {
        return n(paint, f65563g);
    }

    public static float n(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int o() {
        return f65559c;
    }

    public static int p() {
        return f65558b;
    }

    public static float q(float f11) {
        while (f11 < 0.0f) {
            f11 += 360.0f;
        }
        return f11 % 360.0f;
    }

    public static void r(MPPointF mPPointF, float f11, float f12, MPPointF mPPointF2) {
        double d11 = (double) f11;
        double d12 = (double) f12;
        mPPointF2.f65546c = (float) (((double) mPPointF.f65546c) + (Math.cos(Math.toRadians(d12)) * d11));
        mPPointF2.f65547d = (float) (((double) mPPointF.f65547d) + (d11 * Math.sin(Math.toRadians(d12))));
    }

    public static int s() {
        return Build.VERSION.SDK_INT;
    }

    public static FSize t(float f11, float f12, float f13) {
        return u(f11, f12, f13 * 0.017453292f);
    }

    public static FSize u(float f11, float f12, float f13) {
        double d11 = (double) f13;
        return FSize.b(Math.abs(((float) Math.cos(d11)) * f11) + Math.abs(((float) Math.sin(d11)) * f12), Math.abs(f11 * ((float) Math.sin(d11))) + Math.abs(f12 * ((float) Math.cos(d11))));
    }

    public static void v(Context context) {
        if (context == null) {
            f65558b = ViewConfiguration.getMinimumFlingVelocity();
            f65559c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        f65558b = viewConfiguration.getScaledMinimumFlingVelocity();
        f65559c = viewConfiguration.getScaledMaximumFlingVelocity();
        f65557a = context.getResources().getDisplayMetrics();
    }

    public static double w(double d11) {
        if (d11 == Double.POSITIVE_INFINITY) {
            return d11;
        }
        double d12 = d11 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d12) + (d12 >= 0.0d ? 1 : -1));
    }

    @SuppressLint({"NewApi"})
    public static void x(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10);
        }
    }

    public static float y(double d11) {
        if (Double.isInfinite(d11) || Double.isNaN(d11) || d11 == 0.0d) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d11 < 0.0d ? -d11 : d11)))))));
        return ((float) Math.round(d11 * ((double) pow))) / pow;
    }

    public static void z(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, (float) f65559c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i11 = 0; i11 < pointerCount; i11++) {
            if (i11 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i11);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }
}
