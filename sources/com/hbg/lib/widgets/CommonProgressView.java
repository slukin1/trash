package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.content.res.ResourcesCompat;

@Deprecated
public class CommonProgressView extends View implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71169b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f71170c;

    /* renamed from: d  reason: collision with root package name */
    public final TextPaint f71171d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f71172e;

    /* renamed from: f  reason: collision with root package name */
    public float f71173f;

    /* renamed from: g  reason: collision with root package name */
    public int f71174g;

    /* renamed from: h  reason: collision with root package name */
    public int f71175h;

    /* renamed from: i  reason: collision with root package name */
    public int f71176i;

    /* renamed from: j  reason: collision with root package name */
    public int f71177j;

    /* renamed from: k  reason: collision with root package name */
    public int f71178k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f71179l;

    /* renamed from: m  reason: collision with root package name */
    public final Rect f71180m;

    /* renamed from: n  reason: collision with root package name */
    public int f71181n;

    /* renamed from: o  reason: collision with root package name */
    public Interpolator f71182o;

    /* renamed from: p  reason: collision with root package name */
    public a f71183p;

    /* renamed from: q  reason: collision with root package name */
    public int f71184q;

    /* renamed from: r  reason: collision with root package name */
    public float f71185r;

    public interface a {
        void a(float f11, int i11, int i12);
    }

    public CommonProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        this.f71185r = 0.0f;
        int i11 = this.f71176i;
        if (i11 > 0) {
            int i12 = this.f71177j;
            if (i12 > i11) {
                this.f71185r = 1.0f;
            } else {
                this.f71185r = ((float) i12) / ((float) i11);
            }
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f71177j = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        a();
        invalidate();
        a aVar = this.f71183p;
        if (aVar != null) {
            aVar.a(this.f71185r, this.f71177j, this.f71176i);
        }
    }

    public void onDraw(Canvas canvas) {
        String str;
        super.onDraw(canvas);
        if (this.f71178k == 0) {
            this.f71178k = getHeight();
        }
        int paddingLeft = getPaddingLeft() != 0 ? getPaddingLeft() : getPaddingStart();
        int paddingRight = getPaddingRight() != 0 ? getPaddingRight() : getPaddingEnd();
        float f11 = (float) paddingLeft;
        this.f71172e.set(f11, (float) getPaddingTop(), (float) (getWidth() - paddingRight), (float) this.f71178k);
        this.f71169b.setColor(this.f71175h);
        RectF rectF = this.f71172e;
        float f12 = this.f71173f;
        canvas.drawRoundRect(rectF, f12, f12, this.f71169b);
        float f13 = this.f71185r;
        float width = ((float) ((getWidth() - paddingLeft) - paddingRight)) * f13;
        if (f13 > 0.0f && f13 <= 1.0f) {
            this.f71172e.set(f11, (float) getPaddingTop(), f11 + width, (float) this.f71178k);
            this.f71169b.setColor(this.f71174g);
            RectF rectF2 = this.f71172e;
            float f14 = this.f71173f;
            canvas.drawRoundRect(rectF2, f14, f14, this.f71169b);
        }
        if (this.f71184q > 0) {
            int i11 = this.f71178k;
            int i12 = i11 / 2;
            int width2 = (getWidth() - i11) / (this.f71184q - 1);
            int i13 = 0;
            for (int i14 = 0; i14 < this.f71184q; i14++) {
                canvas.drawCircle((float) (i12 + i13), (float) (getPaddingTop() + ((this.f71178k - getPaddingTop()) / 2)), (float) i12, this.f71170c);
                i13 += width2;
            }
        }
        if (this.f71179l) {
            this.f71171d.setColor(this.f71174g);
            if (this.f71176i == 100) {
                str = this.f71177j + "%";
            } else {
                str = ((int) (this.f71185r * 100.0f)) + "%";
            }
            this.f71171d.getTextBounds(str, 0, str.length(), this.f71180m);
            int width3 = this.f71180m.width();
            int i15 = width3 / 2;
            canvas.drawText(str, (f11 + Math.max(Math.min(width, (float) ((((getWidth() - paddingLeft) - paddingRight) - width3) + i15)), (float) (width3 - i15))) - ((float) i15), (float) (this.f71178k + ((this.f71180m.height() * 3) / 2)), this.f71171d);
        }
    }

    public void setBallCount(int i11) {
        this.f71184q = i11;
    }

    public void setCallback(a aVar) {
        this.f71183p = aVar;
    }

    public void setMax(int i11) {
        this.f71176i = i11;
    }

    public void setProgressBgColor(int i11) {
        this.f71175h = i11;
        invalidate();
    }

    public void setProgressColor(int i11) {
        this.f71174g = i11;
        invalidate();
    }

    public CommonProgressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f71169b = paint;
        Paint paint2 = new Paint();
        this.f71170c = paint2;
        TextPaint textPaint = new TextPaint();
        this.f71171d = textPaint;
        this.f71172e = new RectF();
        this.f71180m = new Rect();
        this.f71182o = new DecelerateInterpolator();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonProgressView, i11, 0);
        this.f71173f = obtainStyledAttributes.getDimension(R$styleable.CommonProgressView_cpv_corner, 0.0f);
        this.f71174g = obtainStyledAttributes.getColor(R$styleable.CommonProgressView_cpv_progress_color, 0);
        this.f71175h = obtainStyledAttributes.getColor(R$styleable.CommonProgressView_cpv_bg_color, 0);
        this.f71176i = obtainStyledAttributes.getInteger(R$styleable.CommonProgressView_cpv_max, 100);
        this.f71177j = obtainStyledAttributes.getInteger(R$styleable.CommonProgressView_cpv_progress, 0);
        this.f71178k = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonProgressView_cpv_progress_height, 0);
        this.f71179l = obtainStyledAttributes.getBoolean(R$styleable.CommonProgressView_cpv_show_progress_text, false);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonProgressView_cpv_progress_text_size, 0);
        this.f71181n = dimensionPixelOffset;
        if (dimensionPixelOffset == 0) {
            this.f71181n = getResources().getDimensionPixelOffset(R$dimen.global_text_size_12);
        }
        obtainStyledAttributes.recycle();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(getResources().getColor(R$color.global_seek_bar_circle_color));
        textPaint.setTextSize((float) this.f71181n);
        if (!isInEditMode()) {
            textPaint.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        }
    }
}
