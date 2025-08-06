package com.huobi.index.ui.widget;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import pro.huobi.R;

public class IndicatorView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f74051b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    public int f74052c;

    /* renamed from: d  reason: collision with root package name */
    public int f74053d;

    /* renamed from: e  reason: collision with root package name */
    public int f74054e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f74055f = new Paint(1);

    /* renamed from: g  reason: collision with root package name */
    public RectF f74056g;

    /* renamed from: h  reason: collision with root package name */
    public float f74057h;

    /* renamed from: i  reason: collision with root package name */
    public float f74058i;

    /* renamed from: j  reason: collision with root package name */
    public int f74059j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f74060k;

    public class a implements TypeEvaluator<RectF> {
        public a() {
        }

        /* renamed from: a */
        public RectF evaluate(float f11, RectF rectF, RectF rectF2) {
            float f12 = rectF.left;
            float f13 = f12 + ((rectF2.left - f12) * f11);
            float f14 = rectF.right;
            return new RectF(f13, rectF.top, f14 + ((rectF2.right - f14) * f11), rectF.bottom);
        }
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int a11 = PixelUtils.a(2.0f);
        this.f74054e = a11;
        this.f74057h = (float) a11;
        this.f74052c = PixelUtils.a(16.0f);
        this.f74060k = PixelUtils.a(90.0f);
        this.f74055f.setColor(ContextCompat.getColor(getContext(), R.color.color_indicator_banner_normal));
        this.f74055f.setStrokeCap(Paint.Cap.ROUND);
        this.f74055f.setStrokeWidth((float) this.f74054e);
        this.f74055f.setStyle(Paint.Style.STROKE);
        this.f74051b.setColor(ContextCompat.getColor(getContext(), R.color.color_indicator_banner_focus));
        this.f74051b.setStrokeCap(Paint.Cap.ROUND);
        this.f74051b.setStrokeWidth((float) this.f74054e);
        this.f74051b.setStyle(Paint.Style.STROKE);
    }

    public final RectF a(int i11) {
        RectF rectF = new RectF();
        float f11 = this.f74057h;
        float f12 = this.f74058i;
        rectF.left = (((float) i11) * f12) + f11;
        int i12 = this.f74054e;
        rectF.top = (float) (i12 / 2);
        rectF.right = (f12 * ((float) (i11 + 1))) + f11;
        rectF.bottom = (float) (i12 / 2);
        return rectF;
    }

    public RectF b(int i11) {
        this.f74059j = i11;
        return a(i11);
    }

    public final void c(int i11) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this, "itemRect", new a(), new Object[]{a(i11)});
        ofObject.setDuration(300);
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.start();
    }

    public RectF getItemRect() {
        return this.f74056g;
    }

    public void onDraw(Canvas canvas) {
        if (this.f74058i != 0.0f) {
            float f11 = this.f74057h;
            int i11 = this.f74054e;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f11, (float) (i11 / 2), ((float) this.f74053d) - f11, (float) (i11 / 2), this.f74055f);
            RectF rectF = this.f74056g;
            canvas2.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, this.f74051b);
        }
    }

    public void onMeasure(int i11, int i12) {
        this.f74053d = View.resolveSizeAndState(this.f74053d, i11, 0);
        int resolveSizeAndState = View.resolveSizeAndState(this.f74054e, i12, 0);
        this.f74054e = resolveSizeAndState;
        setMeasuredDimension(this.f74053d, resolveSizeAndState);
    }

    public void setCurrent(int i11) {
        if (this.f74059j != i11) {
            this.f74059j = i11;
            c(i11);
        }
    }

    public void setItemRect(RectF rectF) {
        this.f74056g = rectF;
        invalidate();
    }

    public void setLength(int i11) {
        int i12 = this.f74052c * i11;
        this.f74053d = i12;
        int i13 = this.f74060k;
        if (i13 < i12) {
            this.f74053d = i13;
        }
        this.f74058i = (((float) this.f74053d) - (this.f74057h * 2.0f)) / ((float) i11);
        this.f74056g = b(this.f74059j);
        requestLayout();
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int a11 = PixelUtils.a(2.0f);
        this.f74054e = a11;
        this.f74057h = (float) a11;
        this.f74052c = PixelUtils.a(16.0f);
        this.f74060k = PixelUtils.a(90.0f);
        this.f74055f.setColor(ContextCompat.getColor(getContext(), R.color.color_indicator_banner_normal));
        this.f74055f.setStrokeCap(Paint.Cap.ROUND);
        this.f74055f.setStrokeWidth((float) this.f74054e);
        this.f74055f.setStyle(Paint.Style.STROKE);
        this.f74051b.setColor(ContextCompat.getColor(getContext(), R.color.color_indicator_banner_focus));
        this.f74051b.setStrokeCap(Paint.Cap.ROUND);
        this.f74051b.setStrokeWidth((float) this.f74054e);
        this.f74051b.setStyle(Paint.Style.STROKE);
    }
}
