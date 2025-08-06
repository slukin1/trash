package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float trackLength = 300.0f;

    public LinearDrawingDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    private static void drawRoundedEnd(Canvas canvas, Paint paint, float f11, float f12, float f13, boolean z11, RectF rectF) {
        Canvas canvas2 = canvas;
        float f14 = f11;
        float f15 = f12;
        canvas.save();
        float f16 = f13;
        canvas.translate(f13, 0.0f);
        if (!z11) {
            canvas.rotate(180.0f);
        }
        float f17 = ((-f14) / 2.0f) + f15;
        float f18 = (f14 / 2.0f) - f15;
        Canvas canvas3 = canvas;
        Paint paint2 = paint;
        canvas3.drawRect(-f15, f17, 0.0f, f18, paint2);
        canvas.save();
        canvas.translate(0.0f, f17);
        RectF rectF2 = rectF;
        canvas3.drawArc(rectF2, 180.0f, 90.0f, true, paint2);
        canvas.restore();
        canvas.translate(0.0f, f18);
        canvas3.drawArc(rectF2, 180.0f, -90.0f, true, paint2);
        canvas.restore();
    }

    public void adjustCanvas(Canvas canvas, float f11) {
        Rect clipBounds = canvas.getClipBounds();
        this.trackLength = (float) clipBounds.width();
        float f12 = (float) ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate(((float) clipBounds.left) + (((float) clipBounds.width()) / 2.0f), ((float) clipBounds.top) + (((float) clipBounds.height()) / 2.0f) + Math.max(0.0f, ((float) (clipBounds.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.drawable.isShowing() && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.drawable.isShowing() || this.drawable.isHiding()) {
            canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness) * (f11 - 1.0f)) / 2.0f);
        }
        float f13 = this.trackLength;
        canvas.clipRect((-f13) / 2.0f, (-f12) / 2.0f, f13 / 2.0f, f12 / 2.0f);
        S s11 = this.spec;
        this.displayedTrackThickness = ((float) ((LinearProgressIndicatorSpec) s11).trackThickness) * f11;
        this.displayedCornerRadius = ((float) ((LinearProgressIndicatorSpec) s11).trackCornerRadius) * f11;
    }

    public void fillIndicator(Canvas canvas, Paint paint, float f11, float f12, int i11) {
        Paint paint2 = paint;
        if (f11 != f12) {
            float f13 = this.trackLength;
            float f14 = this.displayedCornerRadius;
            float f15 = ((-f13) / 2.0f) + f14 + ((f13 - (f14 * 2.0f)) * f11);
            float f16 = ((-f13) / 2.0f) + f14 + ((f13 - (f14 * 2.0f)) * f12);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(i11);
            float f17 = this.displayedTrackThickness;
            canvas.drawRect(f15, (-f17) / 2.0f, f16, f17 / 2.0f, paint);
            float f18 = this.displayedCornerRadius;
            RectF rectF = new RectF(-f18, -f18, f18, f18);
            Canvas canvas2 = canvas;
            Paint paint3 = paint;
            float f19 = f15;
            RectF rectF2 = rectF;
            drawRoundedEnd(canvas2, paint3, this.displayedTrackThickness, this.displayedCornerRadius, f19, true, rectF2);
            drawRoundedEnd(canvas2, paint3, this.displayedTrackThickness, this.displayedCornerRadius, f16, false, rectF2);
        }
    }

    public void fillTrack(Canvas canvas, Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        float f11 = ((-this.trackLength) / 2.0f) + this.displayedCornerRadius;
        float f12 = -f11;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        float f13 = this.displayedTrackThickness;
        canvas.drawRect(f11, (-f13) / 2.0f, f12, f13 / 2.0f, paint);
        float f14 = this.displayedCornerRadius;
        RectF rectF = new RectF(-f14, -f14, f14, f14);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f11, true, rectF);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f12, false, rectF);
    }

    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    public int getPreferredWidth() {
        return -1;
    }
}
