package com.huobi.view.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.hbg.lib.common.utils.PixelUtils;

public class BgColorDrawable extends Drawable {
    private static final int DEFAULT_ALPHA = 255;
    private static final float DEFAULT_ALPHA_PCT = 1.0f;
    private static final int LEFTBOTTOM = 3;
    private static final int LEFTOP = 0;
    private static final int RADIUS_COUNT = 8;
    private static final int RADIUS_COUNT2 = 4;
    private static final int RIGHTBOTTOM = 2;
    private static final int RIGHTTOP = 1;
    private int alpha;
    private int borderColor;
    private float borderWidth;
    private Path clipPath;
    private int endColor;

    /* renamed from: lg  reason: collision with root package name */
    private LinearGradient f19023lg;
    private final Paint mPaint;
    private GradientOrientation orientation;
    private float[] outerRadius;
    private int startColor;

    public enum GradientOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public BgColorDrawable() {
        this.mPaint = new Paint(1);
        this.borderWidth = (float) PixelUtils.a(1.0f);
        this.orientation = GradientOrientation.HORIZONTAL;
        this.outerRadius = new float[8];
        this.clipPath = new Path();
        this.alpha = 255;
    }

    private void reCalcClipPath() {
        Rect bounds = getBounds();
        this.clipPath.reset();
        this.clipPath.addRoundRect(new RectF(bounds), this.outerRadius, Path.Direction.CCW);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.clipPath);
        this.mPaint.setShader(this.f19023lg);
        this.mPaint.setAlpha(this.alpha);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(getBounds(), this.mPaint);
        canvas.restore();
        if (this.borderColor != 0 || this.borderWidth > 0.0f) {
            this.mPaint.setShader((Shader) null);
            this.mPaint.setColor(this.borderColor);
            this.mPaint.setStrokeWidth(this.borderWidth);
            this.mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.clipPath, this.mPaint);
        }
    }

    public int getOpacity() {
        return -1;
    }

    public void onBoundsChange(Rect rect) {
        Rect rect2 = rect;
        super.onBoundsChange(rect);
        if (this.orientation == GradientOrientation.HORIZONTAL) {
            float f11 = (float) rect2.left;
            int i11 = rect2.top;
            this.f19023lg = new LinearGradient(f11, (float) i11, (float) rect2.right, (float) i11, this.startColor, this.endColor, Shader.TileMode.CLAMP);
        } else {
            int i12 = rect2.left;
            float f12 = (float) i12;
            float f13 = (float) rect2.top;
            float f14 = (float) i12;
            int i13 = this.startColor;
            int i14 = this.endColor;
            this.f19023lg = new LinearGradient(f12, f13, f14, (float) rect2.bottom, i13, i14, Shader.TileMode.CLAMP);
        }
        reCalcClipPath();
    }

    public void setAlpha(int i11) {
        this.alpha = Math.max(0, Math.min(255, i11));
    }

    public void setBorderColor(int i11) {
        this.borderColor = i11;
    }

    public void setBorderWidth(float f11) {
        this.borderWidth = f11;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setEndColor(int i11) {
        this.endColor = i11;
    }

    public void setOrientation(GradientOrientation gradientOrientation) {
        this.orientation = gradientOrientation;
    }

    public void setOuterRadius(float[] fArr) {
        if (fArr == null) {
            this.outerRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (fArr.length == 4) {
            this.outerRadius = new float[]{fArr[0], fArr[0], fArr[1], fArr[1], fArr[2], fArr[2], fArr[3], fArr[3]};
        } else if (fArr.length == 8) {
            this.outerRadius = fArr;
        } else {
            this.outerRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        reCalcClipPath();
    }

    public void setStartColor(int i11) {
        this.startColor = i11;
    }

    public void setAlpha(float f11) {
        setAlpha((int) (Math.max(0.0f, Math.min(1.0f, f11)) * 255.0f));
    }

    public BgColorDrawable(int i11) {
        this.mPaint = new Paint(1);
        this.borderWidth = (float) PixelUtils.a(1.0f);
        this.orientation = GradientOrientation.HORIZONTAL;
        this.outerRadius = new float[8];
        this.clipPath = new Path();
        this.alpha = 255;
        this.startColor = i11;
        this.endColor = i11;
    }

    public BgColorDrawable(int i11, float f11) {
        this(i11);
        setOuterRadius(new float[]{f11, f11, f11, f11, f11, f11, f11, f11});
    }

    public BgColorDrawable(int i11, float[] fArr) {
        this(i11);
        setOuterRadius(fArr);
    }

    public BgColorDrawable(int i11, int i12, float f11) {
        this(i11);
        this.borderColor = i12;
        this.borderWidth = f11;
    }

    public BgColorDrawable(int i11, int i12, float f11, float f12) {
        this(i11);
        this.borderColor = i12;
        this.borderWidth = f11;
        setOuterRadius(new float[]{f12, f12, f12, f12, f12, f12, f12, f12});
    }

    public BgColorDrawable(int i11, int i12, float f11, float[] fArr) {
        this(i11);
        this.borderColor = i12;
        this.borderWidth = f11;
        setOuterRadius(fArr);
    }

    public BgColorDrawable(int i11, int i12, GradientOrientation gradientOrientation) {
        this.mPaint = new Paint(1);
        this.borderWidth = (float) PixelUtils.a(1.0f);
        this.orientation = GradientOrientation.HORIZONTAL;
        this.outerRadius = new float[8];
        this.clipPath = new Path();
        this.alpha = 255;
        this.startColor = i11;
        this.endColor = i12;
        this.orientation = gradientOrientation;
    }

    public BgColorDrawable(int i11, int i12, float f11, GradientOrientation gradientOrientation) {
        this(i11, i12, gradientOrientation);
        setOuterRadius(new float[]{f11, f11, f11, f11, f11, f11, f11, f11});
    }

    public BgColorDrawable(int i11, int i12, float[] fArr, GradientOrientation gradientOrientation) {
        this(i11, i12, gradientOrientation);
        setOuterRadius(fArr);
    }

    public BgColorDrawable(int i11, int i12, int i13, float f11, GradientOrientation gradientOrientation) {
        this.mPaint = new Paint(1);
        this.borderWidth = (float) PixelUtils.a(1.0f);
        this.orientation = GradientOrientation.HORIZONTAL;
        this.outerRadius = new float[8];
        this.clipPath = new Path();
        this.alpha = 255;
        this.startColor = i11;
        this.endColor = i12;
        this.orientation = gradientOrientation;
        this.borderColor = i13;
        this.borderWidth = f11;
    }

    public BgColorDrawable(int i11, int i12, int i13, float f11, float f12, GradientOrientation gradientOrientation) {
        this(i11, i12, gradientOrientation);
        setOuterRadius(new float[]{f12, f12, f12, f12, f12, f12, f12, f12});
        this.borderColor = i13;
        this.borderWidth = f11;
    }

    public BgColorDrawable(int i11, int i12, int i13, float f11, float[] fArr, GradientOrientation gradientOrientation) {
        this(i11, i12, gradientOrientation);
        setOuterRadius(fArr);
        this.borderColor = i13;
        this.borderWidth = f11;
    }
}
