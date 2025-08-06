package com.ytjojo.shadowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import hz.a;
import hz.b;
import hz.c;
import hz.d;

public class ShadowLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public d f52713b;

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void dispatchDraw(Canvas canvas) {
        this.f52713b.a(canvas);
        this.f52713b.b(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        try {
            canvas.save();
            return super.drawChild(canvas, view, j11) & this.f52713b.f(canvas, view);
        } finally {
            canvas.restore();
        }
    }

    public d getShadowDeltegate() {
        return this.f52713b;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f52713b.d();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f52713b.onDetachedFromWindow();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f52713b.c(z11, i11, i12, i13, i14);
        this.f52713b.e();
    }

    public void setShadowColor(int i11) {
        this.f52713b.g(i11);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShadowLayout);
        int i12 = obtainStyledAttributes.getInt(R$styleable.ShadowLayout_sl_shadow_model, 0);
        if (i12 == 0) {
            this.f52713b = new a(this, obtainStyledAttributes);
        } else if (i12 == 1) {
            this.f52713b = new b(this, obtainStyledAttributes);
        } else if (i12 == 2) {
            this.f52713b = new c(this, obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
    }
}
