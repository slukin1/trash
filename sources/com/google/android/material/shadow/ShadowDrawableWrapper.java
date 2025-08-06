package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapper {
    public static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public static final float SHADOW_BOTTOM_SCALE = 1.0f;
    public static final float SHADOW_HORIZ_SCALE = 0.5f;
    public static final float SHADOW_MULTIPLIER = 1.5f;
    public static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners = true;
    public final RectF contentBounds;
    public float cornerRadius;
    public final Paint cornerShadowPaint;
    public Path cornerShadowPath;
    private boolean dirty = true;
    public final Paint edgeShadowPaint;
    public float maxShadowSize;
    private boolean printedShadowClipWarning = false;
    public float rawMaxShadowSize;
    public float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    public float shadowSize;
    private final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f11, float f12, float f13) {
        super(drawable);
        this.shadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = (float) Math.round(f11);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f12, f13);
    }

    private void buildComponents(Rect rect) {
        float f11 = this.rawMaxShadowSize;
        float f12 = 1.5f * f11;
        this.contentBounds.set(((float) rect.left) + f11, ((float) rect.top) + f12, ((float) rect.right) - f11, ((float) rect.bottom) - f12);
        Drawable wrappedDrawable = getWrappedDrawable();
        RectF rectF = this.contentBounds;
        wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f11 = this.cornerRadius;
        RectF rectF = new RectF(-f11, -f11, f11, f11);
        RectF rectF2 = new RectF(rectF);
        float f12 = this.shadowSize;
        rectF2.inset(-f12, -f12);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f13 = -rectF2.top;
        if (f13 > 0.0f) {
            float f14 = this.cornerRadius / f13;
            Paint paint = this.cornerShadowPaint;
            RadialGradient radialGradient = r8;
            float[] fArr = {0.0f, f14, ((1.0f - f14) / 2.0f) + f14, 1.0f};
            RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f13, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, fArr, Shader.TileMode.CLAMP);
            paint.setShader(radialGradient);
        }
        Paint paint2 = this.edgeShadowPaint;
        float f15 = rectF.top;
        float f16 = rectF2.top;
        paint2.setShader(new LinearGradient(0.0f, f15, 0.0f, f16, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) f11) + ((1.0d - COS_45) * ((double) f12))) : f11;
    }

    public static float calculateVerticalPadding(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) (f11 * 1.5f)) + ((1.0d - COS_45) * ((double) f12))) : f11 * 1.5f;
    }

    private void drawShadow(Canvas canvas) {
        float f11;
        int i11;
        int i12;
        float f12;
        float f13;
        float f14;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f15 = this.cornerRadius;
        float f16 = (-f15) - this.shadowSize;
        float f17 = f15 * 2.0f;
        boolean z11 = this.contentBounds.width() - f17 > 0.0f;
        boolean z12 = this.contentBounds.height() - f17 > 0.0f;
        float f18 = this.rawShadowSize;
        float f19 = f15 / ((f18 - (0.5f * f18)) + f15);
        float f21 = f15 / ((f18 - (0.25f * f18)) + f15);
        float f22 = f15 / ((f18 - (f18 * 1.0f)) + f15);
        int save2 = canvas.save();
        RectF rectF = this.contentBounds;
        canvas2.translate(rectF.left + f15, rectF.top + f15);
        canvas2.scale(f19, f21);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z11) {
            canvas2.scale(1.0f / f19, 1.0f);
            i12 = save2;
            f11 = f22;
            i11 = save;
            f12 = f21;
            canvas.drawRect(0.0f, f16, this.contentBounds.width() - f17, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            i12 = save2;
            f11 = f22;
            i11 = save;
            f12 = f21;
        }
        canvas2.restoreToCount(i12);
        int save3 = canvas.save();
        RectF rectF2 = this.contentBounds;
        canvas2.translate(rectF2.right - f15, rectF2.bottom - f15);
        float f23 = f11;
        canvas2.scale(f19, f23);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z11) {
            canvas2.scale(1.0f / f19, 1.0f);
            f13 = f12;
            f14 = f23;
            canvas.drawRect(0.0f, f16, this.contentBounds.width() - f17, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
        } else {
            f13 = f12;
            f14 = f23;
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.contentBounds;
        canvas2.translate(rectF3.left + f15, rectF3.bottom - f15);
        canvas2.scale(f19, f14);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z12) {
            canvas2.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f16, this.contentBounds.height() - f17, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.contentBounds;
        canvas2.translate(rectF4.right - f15, rectF4.top + f15);
        float f24 = f13;
        canvas2.scale(f19, f24);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z12) {
            canvas2.scale(1.0f / f24, 1.0f);
            canvas.drawRect(0.0f, f16, this.contentBounds.height() - f17, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(i11);
    }

    private static int toEven(float f11) {
        int round = Math.round(f11);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void draw(Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        ShadowDrawableWrapper.super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float f11 = this.rawMaxShadowSize;
        return (Math.max(f11, this.cornerRadius + ((f11 * 1.5f) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 1.5f * 2.0f);
    }

    public float getMinWidth() {
        float f11 = this.rawMaxShadowSize;
        return (Math.max(f11, this.cornerRadius + (f11 / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean z11) {
        this.addPaddingForCorners = z11;
        invalidateSelf();
    }

    public void setAlpha(int i11) {
        ShadowDrawableWrapper.super.setAlpha(i11);
        this.cornerShadowPaint.setAlpha(i11);
        this.edgeShadowPaint.setAlpha(i11);
    }

    public void setCornerRadius(float f11) {
        float round = (float) Math.round(f11);
        if (this.cornerRadius != round) {
            this.cornerRadius = round;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setMaxShadowSize(float f11) {
        setShadowSize(this.rawShadowSize, f11);
    }

    public final void setRotation(float f11) {
        if (this.rotation != f11) {
            this.rotation = f11;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f11, float f12) {
        if (f11 < 0.0f || f12 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = (float) toEven(f11);
        float even2 = (float) toEven(f12);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize != even || this.rawMaxShadowSize != even2) {
            this.rawShadowSize = even;
            this.rawMaxShadowSize = even2;
            this.shadowSize = (float) Math.round(even * 1.5f);
            this.maxShadowSize = even2;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f11) {
        setShadowSize(f11, this.rawMaxShadowSize);
    }
}
