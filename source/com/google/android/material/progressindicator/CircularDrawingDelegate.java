package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor = 1;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void drawRoundedEnd(Canvas canvas, Paint paint, float f11, float f12, float f13, boolean z11, RectF rectF) {
        Canvas canvas2 = canvas;
        float f14 = z11 ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f13);
        float f15 = f11 / 2.0f;
        float f16 = f14 * f12;
        Paint paint2 = paint;
        canvas.drawRect((this.adjustedRadius - f15) + f12, Math.min(0.0f, ((float) this.arcDirectionFactor) * f16), (this.adjustedRadius + f15) - f12, Math.max(0.0f, f16 * ((float) this.arcDirectionFactor)), paint2);
        canvas.translate((this.adjustedRadius - f15) + f12, 0.0f);
        RectF rectF2 = rectF;
        canvas.drawArc(rectF2, 180.0f, (-f14) * 90.0f * ((float) this.arcDirectionFactor), true, paint2);
        canvas.translate(f11 - (f12 * 2.0f), 0.0f);
        canvas.drawArc(rectF2, 0.0f, f14 * 90.0f * ((float) this.arcDirectionFactor), true, paint2);
        canvas.restore();
    }

    private int getSize() {
        S s11 = this.spec;
        return ((CircularProgressIndicatorSpec) s11).indicatorSize + (((CircularProgressIndicatorSpec) s11).indicatorInset * 2);
    }

    public void adjustCanvas(Canvas canvas, float f11) {
        S s11 = this.spec;
        float f12 = (((float) ((CircularProgressIndicatorSpec) s11).indicatorSize) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) s11).indicatorInset);
        canvas.translate(f12, f12);
        canvas.rotate(-90.0f);
        float f13 = -f12;
        canvas.clipRect(f13, f13, f12, f12);
        S s12 = this.spec;
        this.arcDirectionFactor = ((CircularProgressIndicatorSpec) s12).indicatorDirection == 0 ? 1 : -1;
        this.displayedTrackThickness = ((float) ((CircularProgressIndicatorSpec) s12).trackThickness) * f11;
        this.displayedCornerRadius = ((float) ((CircularProgressIndicatorSpec) s12).trackCornerRadius) * f11;
        this.adjustedRadius = ((float) (((CircularProgressIndicatorSpec) s12).indicatorSize - ((CircularProgressIndicatorSpec) s12).trackThickness)) / 2.0f;
        if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
            this.adjustedRadius += ((1.0f - f11) * ((float) ((CircularProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f;
        } else if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            this.adjustedRadius -= ((1.0f - f11) * ((float) ((CircularProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f;
        }
    }

    public void fillIndicator(Canvas canvas, Paint paint, float f11, float f12, int i11) {
        Paint paint2 = paint;
        if (f11 != f12) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i11);
            paint.setStrokeWidth(this.displayedTrackThickness);
            int i12 = this.arcDirectionFactor;
            float f13 = f11 * 360.0f * ((float) i12);
            float f14 = (f12 >= f11 ? f12 - f11 : (f12 + 1.0f) - f11) * 360.0f * ((float) i12);
            float f15 = this.adjustedRadius;
            canvas.drawArc(new RectF(-f15, -f15, f15, f15), f13, f14, false, paint);
            if (this.displayedCornerRadius > 0.0f && Math.abs(f14) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                float f16 = this.displayedCornerRadius;
                RectF rectF = new RectF(-f16, -f16, f16, f16);
                Canvas canvas2 = canvas;
                Paint paint3 = paint;
                RectF rectF2 = rectF;
                drawRoundedEnd(canvas2, paint3, this.displayedTrackThickness, this.displayedCornerRadius, f13, true, rectF2);
                drawRoundedEnd(canvas2, paint3, this.displayedTrackThickness, this.displayedCornerRadius, f13 + f14, false, rectF2);
            }
        }
    }

    public void fillTrack(Canvas canvas, Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f11 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f11, -f11, f11, f11), 0.0f, 360.0f, false, paint);
    }

    public int getPreferredHeight() {
        return getSize();
    }

    public int getPreferredWidth() {
        return getSize();
    }
}
