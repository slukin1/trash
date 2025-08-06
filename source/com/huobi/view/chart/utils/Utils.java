package com.huobi.view.chart.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.exoplayer2.audio.AacUtil;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huobi.view.chart.formatter.DefaultValueFormatter;
import com.huobi.view.chart.formatter.ValueFormatter;
import java.util.List;

public abstract class Utils {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final double DOUBLE_EPSILON = Double.longBitsToDouble(1);
    public static final float FDEG2RAD = 0.017453292f;
    public static final float FLOAT_EPSILON = Float.intBitsToFloat(1);
    private static final int[] POW_10 = {1, 10, 100, 1000, 10000, AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, 1000000, ExceptionCode.CRASH_EXCEPTION, 100000000, 1000000000};
    private static Rect mCalcTextHeightRect = new Rect();
    private static Rect mCalcTextSizeRect = new Rect();
    private static ValueFormatter mDefaultValueFormatter = generateDefaultValueFormatter();
    private static Rect mDrawTextRectBuffer = new Rect();
    private static Rect mDrawableBoundsCache = new Rect();
    private static Paint.FontMetrics mFontMetrics = new Paint.FontMetrics();
    private static Paint.FontMetrics mFontMetricsBuffer = new Paint.FontMetrics();
    private static int mMaximumFlingVelocity = 8000;
    private static DisplayMetrics mMetrics;
    private static int mMinimumFlingVelocity = 50;

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = mCalcTextHeightRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize calcTextSize(Paint paint, String str) {
        FSize instance = FSize.getInstance(0.0f, 0.0f);
        calcTextSize(paint, str, instance);
        return instance;
    }

    public static int calcTextWidth(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float convertDpToPixel(float f11) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics != null) {
            return f11 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f11;
    }

    public static int[] convertIntegers(List<Integer> list) {
        int[] iArr = new int[list.size()];
        copyIntegers(list, iArr);
        return iArr;
    }

    public static float convertPixelsToDp(float f11) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics != null) {
            return f11 / displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
        return f11;
    }

    public static String[] convertStrings(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = list.get(i11);
        }
        return strArr;
    }

    public static void copyIntegers(List<Integer> list, int[] iArr) {
        int length = iArr.length < list.size() ? iArr.length : list.size();
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = list.get(i11).intValue();
        }
    }

    public static void copyStrings(List<String> list, String[] strArr) {
        int length = strArr.length < list.size() ? strArr.length : list.size();
        for (int i11 = 0; i11 < length; i11++) {
            strArr[i11] = list.get(i11);
        }
    }

    public static void drawImage(Canvas canvas, Drawable drawable, int i11, int i12, int i13, int i14) {
        MPPointF instance = MPPointF.getInstance();
        instance.f19016x = (float) (i11 - (i13 / 2));
        instance.f19017y = (float) (i12 - (i14 / 2));
        drawable.copyBounds(mDrawableBoundsCache);
        Rect rect = mDrawableBoundsCache;
        int i15 = rect.left;
        int i16 = rect.top;
        drawable.setBounds(i15, i16, i15 + i13, i13 + i16);
        int save = canvas.save();
        canvas.translate(instance.f19016x, instance.f19017y);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void drawMultilineText(Canvas canvas, StaticLayout staticLayout, float f11, float f12, TextPaint textPaint, MPPointF mPPointF, float f13) {
        float fontMetrics = textPaint.getFontMetrics(mFontMetricsBuffer);
        float width = (float) staticLayout.getWidth();
        float lineCount = ((float) staticLayout.getLineCount()) * fontMetrics;
        float f14 = 0.0f - ((float) mDrawTextRectBuffer.left);
        float f15 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f13 != 0.0f) {
            float f16 = f14 - (width * 0.5f);
            float f17 = f15 - (lineCount * 0.5f);
            if (!(mPPointF.f19016x == 0.5f && mPPointF.f19017y == 0.5f)) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(width, lineCount, f13);
                f11 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.f19016x - 0.5f);
                f12 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.f19017y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f11, f12);
            canvas.rotate(f13);
            canvas.translate(f16, f17);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            float f18 = mPPointF.f19016x;
            if (!(f18 == 0.0f && mPPointF.f19017y == 0.0f)) {
                f14 -= width * f18;
                f15 -= lineCount * mPPointF.f19017y;
            }
            canvas.save();
            canvas.translate(f14 + f11, f15 + f12);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    public static void drawXAxisValue(Canvas canvas, String str, float f11, float f12, Paint paint, MPPointF mPPointF, float f13) {
        float fontMetrics = paint.getFontMetrics(mFontMetricsBuffer);
        paint.getTextBounds(str, 0, str.length(), mDrawTextRectBuffer);
        float f14 = 0.0f - ((float) mDrawTextRectBuffer.left);
        float f15 = (-mFontMetricsBuffer.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f13 != 0.0f) {
            float width = f14 - (((float) mDrawTextRectBuffer.width()) * 0.5f);
            float f16 = f15 - (fontMetrics * 0.5f);
            if (!(mPPointF.f19016x == 0.5f && mPPointF.f19017y == 0.5f)) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees((float) mDrawTextRectBuffer.width(), fontMetrics, f13);
                f11 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.f19016x - 0.5f);
                f12 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.f19017y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f11, f12);
            canvas.rotate(f13);
            canvas.drawText(str, width, f16, paint);
            canvas.restore();
        } else {
            if (!(mPPointF.f19016x == 0.0f && mPPointF.f19017y == 0.0f)) {
                f14 -= ((float) mDrawTextRectBuffer.width()) * mPPointF.f19016x;
                f15 -= fontMetrics * mPPointF.f19017y;
            }
            canvas.drawText(str, f14 + f11, f15 + f12, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String formatNumber(float f11, int i11, boolean z11) {
        return formatNumber(f11, i11, z11, '.');
    }

    private static ValueFormatter generateDefaultValueFormatter() {
        return new DefaultValueFormatter(1);
    }

    public static int getDecimals(float f11) {
        float roundToNextSignificant = roundToNextSignificant((double) f11);
        if (Float.isInfinite(roundToNextSignificant)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10((double) roundToNextSignificant))) + 2;
    }

    public static ValueFormatter getDefaultValueFormatter() {
        return mDefaultValueFormatter;
    }

    public static float getLineHeight(Paint paint) {
        return getLineHeight(paint, mFontMetrics);
    }

    public static float getLineSpacing(Paint paint) {
        return getLineSpacing(paint, mFontMetrics);
    }

    public static int getMaximumFlingVelocity() {
        return mMaximumFlingVelocity;
    }

    public static int getMinimumFlingVelocity() {
        return mMinimumFlingVelocity;
    }

    public static float getNormalizedAngle(float f11) {
        while (f11 < 0.0f) {
            f11 += 360.0f;
        }
        return f11 % 360.0f;
    }

    public static MPPointF getPosition(MPPointF mPPointF, float f11, float f12) {
        MPPointF instance = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(mPPointF, f11, f12, instance);
        return instance;
    }

    public static int getSDKInt() {
        return Build.VERSION.SDK_INT;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(FSize fSize, float f11) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f11 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(FSize fSize, float f11) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f11);
    }

    public static void init(Context context) {
        if (context == null) {
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        mMetrics = context.getResources().getDisplayMetrics();
    }

    public static double nextUp(double d11) {
        if (d11 == Double.POSITIVE_INFINITY) {
            return d11;
        }
        double d12 = d11 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d12) + (d12 >= 0.0d ? 1 : -1));
    }

    @SuppressLint({"NewApi"})
    public static void postInvalidateOnAnimation(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10);
        }
    }

    public static float roundToNextSignificant(double d11) {
        if (Double.isInfinite(d11) || Double.isNaN(d11) || d11 == 0.0d) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d11 < 0.0d ? -d11 : d11)))))));
        return ((float) Math.round(d11 * ((double) pow))) / pow;
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, (float) mMaximumFlingVelocity);
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

    public static String formatNumber(float f11, int i11, boolean z11, char c11) {
        boolean z12;
        float f12 = f11;
        char[] cArr = new char[35];
        if (f12 == 0.0f) {
            return "0";
        }
        int i12 = 0;
        boolean z13 = f12 < 1.0f && f12 > -1.0f;
        if (f12 < 0.0f) {
            f12 = -f12;
            z12 = true;
        } else {
            z12 = false;
        }
        int[] iArr = POW_10;
        int i13 = i11;
        int length = i13 > iArr.length ? iArr.length - 1 : i13;
        long round = (long) Math.round(f12 * ((float) iArr[length]));
        int i14 = 34;
        boolean z14 = false;
        while (true) {
            if (round == 0 && i12 >= length + 1) {
                break;
            }
            boolean z15 = z14;
            round /= 10;
            int i15 = i14 - 1;
            cArr[i14] = (char) (((int) (round % 10)) + 48);
            i12++;
            if (i12 == length) {
                i14 = i15 - 1;
                cArr[i15] = ',';
                i12++;
                z14 = true;
            } else {
                if (z11 && round != 0 && i12 > length) {
                    if (z15) {
                        if ((i12 - length) % 4 == 0) {
                            i14 = i15 - 1;
                            cArr[i15] = c11;
                        }
                    } else if ((i12 - length) % 4 == 3) {
                        i14 = i15 - 1;
                        cArr[i15] = c11;
                    }
                    i12++;
                    z14 = z15;
                }
                i14 = i15;
                z14 = z15;
            }
        }
        if (z13) {
            cArr[i14] = '0';
            i12++;
            i14--;
        }
        if (z12) {
            cArr[i14] = '-';
            i12++;
        }
        int i16 = 35 - i12;
        return String.valueOf(cArr, i16, 35 - i16);
    }

    public static float getLineHeight(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getLineSpacing(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f11, float f12, float f13) {
        return getSizeOfRotatedRectangleByRadians(f11, f12, f13 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(float f11, float f12, float f13) {
        double d11 = (double) f13;
        return FSize.getInstance(Math.abs(((float) Math.cos(d11)) * f11) + Math.abs(((float) Math.sin(d11)) * f12), Math.abs(f11 * ((float) Math.sin(d11))) + Math.abs(f12 * ((float) Math.cos(d11))));
    }

    public static void calcTextSize(Paint paint, String str, FSize fSize) {
        Rect rect = mCalcTextSizeRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.width = (float) rect.width();
        fSize.height = (float) rect.height();
    }

    public static void getPosition(MPPointF mPPointF, float f11, float f12, MPPointF mPPointF2) {
        double d11 = (double) f11;
        double d12 = (double) f12;
        mPPointF2.f19016x = (float) (((double) mPPointF.f19016x) + (Math.cos(Math.toRadians(d12)) * d11));
        mPPointF2.f19017y = (float) (((double) mPPointF.f19017y) + (d11 * Math.sin(Math.toRadians(d12))));
    }

    @Deprecated
    public static void init(Resources resources) {
        mMetrics = resources.getDisplayMetrics();
        mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static void drawMultilineText(Canvas canvas, String str, float f11, float f12, TextPaint textPaint, FSize fSize, MPPointF mPPointF, float f13) {
        TextPaint textPaint2 = textPaint;
        drawMultilineText(canvas, new StaticLayout(str, 0, str.length(), textPaint2, (int) Math.max(Math.ceil((double) fSize.width), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f11, f12, textPaint2, mPPointF, f13);
    }
}
