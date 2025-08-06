package com.huobi.view.button;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class ArcProgressShape implements ILoadingShape {
    private float animStep;
    public boolean hasOpen;
    private float progressAngel;
    private float progressRadiu;
    private final float progressWidth;
    private float startAngel;
    private Paint yangePaint = new Paint(1);
    private Paint yinPaint = new Paint(1);

    public ArcProgressShape(float f11, float f12, float f13, int i11) {
        this.progressAngel = f11;
        this.progressRadiu = f13;
        this.yangePaint.setStyle(Paint.Style.STROKE);
        this.yinPaint.setStyle(Paint.Style.STROKE);
        this.progressWidth = f12;
        this.yinPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.yangePaint.setStrokeCap(Paint.Cap.SQUARE);
        this.yangePaint.setColor(Color.parseColor("#FFFFFF"));
        this.yinPaint.setColor(Color.parseColor("#99FFFFFF"));
    }

    public void exeAnim(float f11) {
        this.animStep = f11;
    }

    public void render(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        float f11 = this.animStep;
        if (f11 < 1.0f) {
            this.yangePaint.setStrokeWidth(this.progressWidth);
            this.yinPaint.setStrokeWidth(this.progressWidth);
            this.yangePaint.setAlpha((int) (this.animStep * 255.0f));
            this.yinPaint.setAlpha((int) (this.animStep * 255.0f));
            canvas2.drawCircle((float) (width / 2), (float) (height / 2), 1.0f, this.yangePaint);
        } else if (f11 < 5.0f) {
            float f12 = ((f11 - 1.0f) / 4.0f) * this.progressRadiu;
            float f13 = (float) (width / 2);
            float f14 = (float) (height / 2);
            canvas2.drawCircle(f13 + f12, f14, 1.0f, this.yinPaint);
            canvas2.drawCircle(f13 - f12, f14, 1.0f, this.yangePaint);
        } else if (((double) f11) <= 8.35d) {
            this.startAngel = ((f11 - 5.0f) / 7.0f) * 360.0f;
            this.progressAngel = ((f11 - 5.0f) * 108.0f) / 3.35f;
            float f15 = (float) (width / 2);
            float f16 = this.progressRadiu;
            float f17 = (float) (height / 2);
            canvas.drawArc(new RectF(f15 - f16, f17 - f16, f15 + f16, f16 + f17), this.startAngel, this.progressAngel, false, this.yinPaint);
            float f18 = this.progressRadiu;
            canvas.drawArc(new RectF(f15 - f18, f17 - f18, f15 + f18, f17 + f18), this.startAngel + 180.0f, this.progressAngel, false, this.yangePaint);
        } else if (((double) f11) <= 8.75d) {
            this.startAngel = ((f11 - 5.0f) / 7.0f) * 360.0f;
            this.progressAngel = 108.0f;
            float f19 = (float) (width / 2);
            float f21 = this.progressRadiu;
            float f22 = (float) (height / 2);
            canvas.drawArc(new RectF(f19 - f21, f22 - f21, f19 + f21, f21 + f22), this.startAngel, this.progressAngel, false, this.yinPaint);
            float f23 = this.progressRadiu;
            canvas.drawArc(new RectF(f19 - f23, f22 - f23, f19 + f23, f22 + f23), this.startAngel + 180.0f, this.progressAngel, false, this.yangePaint);
        } else if (f11 <= 12.0f) {
            this.startAngel = ((f11 - 5.0f) / 7.0f) * 360.0f;
            this.progressAngel = ((12.0f - f11) * 108.0f) / 3.35f;
            float f24 = (float) (width / 2);
            float f25 = this.progressRadiu;
            float f26 = (float) (height / 2);
            canvas.drawArc(new RectF(f24 - f25, f26 - f25, f24 + f25, f25 + f26), this.startAngel, this.progressAngel, false, this.yinPaint);
            float f27 = this.progressRadiu;
            canvas.drawArc(new RectF(f24 - f27, f26 - f27, f24 + f27, f26 + f27), this.startAngel + 180.0f, this.progressAngel, false, this.yangePaint);
        } else {
            float f28 = (15.0f - f11) / 3.0f;
            int i11 = (int) (255.0f * f28);
            this.yangePaint.setAlpha(i11);
            this.yinPaint.setAlpha(i11);
            this.startAngel = ((this.animStep - 12.0f) * 45.0f) / 3.0f;
            this.yangePaint.setStrokeWidth(this.progressWidth * f28);
            this.yinPaint.setStrokeWidth(this.progressWidth * f28);
            this.progressAngel = (f28 * 1.6f) + 1.0f;
            float f29 = (this.progressRadiu * (15.0f - this.animStep)) / 3.0f;
            float f31 = (float) (width / 2);
            float f32 = f31 - f29;
            float f33 = (float) (height / 2);
            float f34 = f33 - f29;
            float f35 = f31 + f29;
            float f36 = f33 + f29;
            canvas.drawArc(new RectF(f32, f34, f35, f36), this.startAngel, this.progressAngel, false, this.yinPaint);
            canvas.drawArc(new RectF(f32, f34, f35, f36), this.startAngel + 180.0f, this.progressAngel, false, this.yangePaint);
        }
    }
}
