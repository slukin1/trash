package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;

public class MarqueeView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71525b;

    /* renamed from: c  reason: collision with root package name */
    public int f71526c;

    /* renamed from: d  reason: collision with root package name */
    public String f71527d;

    /* renamed from: e  reason: collision with root package name */
    public float f71528e;

    /* renamed from: f  reason: collision with root package name */
    public float f71529f;

    /* renamed from: g  reason: collision with root package name */
    public float f71530g;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f71531h;

    /* renamed from: i  reason: collision with root package name */
    public Paint.FontMetrics f71532i;

    /* renamed from: j  reason: collision with root package name */
    public float f71533j;

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f71525b = paint;
        this.f71529f = 50.0f;
        this.f71530g = 36.0f;
        this.f71533j = 0.0f;
        setWillNotDraw(false);
        paint.setTextAlign(Paint.Align.LEFT);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(ValueAnimator valueAnimator) {
        this.f71533j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void f() {
        float f11 = this.f71528e;
        if (f11 != 0.0f && f11 > ((float) (getMeasuredWidth() - this.f71526c))) {
            ValueAnimator valueAnimator = this.f71531h;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f71531h = null;
            }
            float f12 = this.f71528e;
            float f13 = this.f71529f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, f12 + f13});
            this.f71531h = ofFloat;
            ofFloat.setDuration((long) ((int) (((f12 + f13) / this.f71530g) * 1000.0f)));
            this.f71531h.setInterpolator(new LinearInterpolator());
            this.f71531h.setRepeatCount(-1);
            this.f71531h.addUpdateListener(new f1(this));
            this.f71531h.start();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint.FontMetrics fontMetrics = this.f71532i;
        float f11 = fontMetrics.descent;
        float measuredHeight = (((float) (getMeasuredHeight() >> 1)) + ((f11 - fontMetrics.ascent) / 2.0f)) - f11;
        if (!TextUtils.isEmpty(this.f71527d)) {
            canvas.drawText(this.f71527d, ((float) this.f71526c) - this.f71533j, measuredHeight, this.f71525b);
            float f12 = this.f71528e;
            int measuredWidth = getMeasuredWidth();
            int i11 = this.f71526c;
            if (f12 > ((float) (measuredWidth - i11))) {
                canvas.drawText(this.f71527d, ((((float) i11) + this.f71528e) + this.f71529f) - this.f71533j, measuredHeight, this.f71525b);
            }
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void setPaintAntiAlias(boolean z11) {
        this.f71525b.setAntiAlias(z11);
    }

    public void setRate(float f11) {
        this.f71530g = f11;
    }

    public void setText(String str) {
        this.f71527d = str;
        if (!TextUtils.isEmpty(str)) {
            this.f71528e = this.f71525b.measureText(str);
            postDelayed(new g1(this), 2000);
        }
        invalidate();
    }

    public void setTextColor(int i11) {
        this.f71525b.setColor(i11);
    }

    public void setTextFix(String str) {
        this.f71527d = str;
        if (!TextUtils.isEmpty(str)) {
            float measureText = this.f71525b.measureText(str);
            this.f71528e = measureText;
            if (measureText == 0.0f || measureText <= ((float) (getMeasuredWidth() - this.f71526c))) {
                ValueAnimator valueAnimator = this.f71531h;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f71531h = null;
                }
                this.f71533j = 0.0f;
            } else {
                postDelayed(new g1(this), 2000);
            }
        }
        invalidate();
    }

    public void setTextMarginLeft(int i11) {
        this.f71526c = i11;
    }

    public void setTextSize(float f11) {
        this.f71525b.setTextSize(f11);
        this.f71532i = this.f71525b.getFontMetrics();
    }

    public void setTextSpace(float f11) {
        this.f71529f = f11;
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71525b = new Paint();
        this.f71529f = 50.0f;
        this.f71530g = 36.0f;
        this.f71533j = 0.0f;
    }
}
