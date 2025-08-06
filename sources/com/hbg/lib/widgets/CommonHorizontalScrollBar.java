package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CommonHorizontalScrollBar extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f71121b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f71122c;

    /* renamed from: d  reason: collision with root package name */
    public float f71123d;

    /* renamed from: e  reason: collision with root package name */
    public int f71124e;

    /* renamed from: f  reason: collision with root package name */
    public float f71125f;

    /* renamed from: g  reason: collision with root package name */
    public int f71126g;

    /* renamed from: h  reason: collision with root package name */
    public int f71127h;

    public CommonHorizontalScrollBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f71124e == 0) {
            this.f71124e = getWidth() / 2;
        }
        this.f71122c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f71121b.setColor(this.f71127h);
        RectF rectF = this.f71122c;
        float f11 = this.f71125f;
        canvas.drawRoundRect(rectF, f11, f11, this.f71121b);
        float f12 = this.f71123d;
        int width = getWidth();
        int i11 = this.f71124e;
        float f13 = f12 * ((float) (width - i11));
        this.f71122c.set(f13, 0.0f, ((float) i11) + f13, (float) getHeight());
        this.f71121b.setColor(this.f71126g);
        RectF rectF2 = this.f71122c;
        float f14 = this.f71125f;
        canvas.drawRoundRect(rectF2, f14, f14, this.f71121b);
    }

    public void setRate(float f11) {
        this.f71123d = f11;
        float min = Math.min(f11, 1.0f);
        this.f71123d = min;
        this.f71123d = Math.max(min, 0.0f);
        invalidate();
    }

    public CommonHorizontalScrollBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71121b = new Paint();
        this.f71122c = new RectF();
        this.f71125f = 0.0f;
        this.f71126g = getResources().getColor(R$color.login_v2_login_button_enable_bg);
        this.f71127h = getResources().getColor(R$color.color_eff2f4);
        this.f71121b.setAntiAlias(true);
    }
}
