package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.common.utils.PixelUtils;

public class CommonHorizontalIndicator extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f71110b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f71111c;

    /* renamed from: d  reason: collision with root package name */
    public float f71112d;

    /* renamed from: e  reason: collision with root package name */
    public float f71113e;

    /* renamed from: f  reason: collision with root package name */
    public float f71114f;

    /* renamed from: g  reason: collision with root package name */
    public float f71115g;

    /* renamed from: h  reason: collision with root package name */
    public int f71116h;

    /* renamed from: i  reason: collision with root package name */
    public int f71117i;

    /* renamed from: j  reason: collision with root package name */
    public int f71118j;

    /* renamed from: k  reason: collision with root package name */
    public int f71119k;

    /* renamed from: l  reason: collision with root package name */
    public int f71120l;

    public CommonHorizontalIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f71111c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f71110b.setColor(this.f71118j);
        RectF rectF = this.f71111c;
        float f11 = this.f71115g;
        canvas.drawRoundRect(rectF, f11, f11, this.f71110b);
        int i11 = this.f71119k;
        if (i11 == 0) {
            this.f71111c.set(0.0f, 0.0f, this.f71112d, (float) getHeight());
            this.f71110b.setColor(this.f71116h);
            RectF rectF2 = this.f71111c;
            float f12 = this.f71115g;
            canvas.drawRoundRect(rectF2, f12, f12, this.f71110b);
            RectF rectF3 = this.f71111c;
            float f13 = this.f71112d;
            float f14 = this.f71114f;
            rectF3.set(f13 + f14, 0.0f, f13 + f14 + this.f71113e, (float) getHeight());
            this.f71110b.setColor(this.f71117i);
            RectF rectF4 = this.f71111c;
            float f15 = this.f71115g;
            canvas.drawRoundRect(rectF4, f15, f15, this.f71110b);
            if (this.f71120l == 3) {
                RectF rectF5 = this.f71111c;
                float f16 = this.f71112d;
                float f17 = this.f71114f;
                float f18 = this.f71113e;
                rectF5.set((f17 * 2.0f) + f16 + f18, 0.0f, f16 + (f17 * 2.0f) + (f18 * 2.0f), (float) getHeight());
                this.f71110b.setColor(this.f71117i);
                RectF rectF6 = this.f71111c;
                float f19 = this.f71115g;
                canvas.drawRoundRect(rectF6, f19, f19, this.f71110b);
            }
        } else if (i11 == 1) {
            this.f71111c.set(0.0f, 0.0f, this.f71113e, (float) getHeight());
            this.f71110b.setColor(this.f71117i);
            RectF rectF7 = this.f71111c;
            float f21 = this.f71115g;
            canvas.drawRoundRect(rectF7, f21, f21, this.f71110b);
            RectF rectF8 = this.f71111c;
            float f22 = this.f71113e;
            float f23 = this.f71114f;
            rectF8.set(f22 + f23, 0.0f, f22 + f23 + this.f71112d, (float) getHeight());
            this.f71110b.setColor(this.f71116h);
            RectF rectF9 = this.f71111c;
            float f24 = this.f71115g;
            canvas.drawRoundRect(rectF9, f24, f24, this.f71110b);
            if (this.f71120l == 3) {
                RectF rectF10 = this.f71111c;
                float f25 = this.f71113e;
                float f26 = this.f71114f;
                float f27 = this.f71112d;
                rectF10.set((f26 * 2.0f) + f25 + f27, 0.0f, f25 + (f26 * 2.0f) + (f27 * 2.0f), (float) getHeight());
                this.f71110b.setColor(this.f71117i);
                RectF rectF11 = this.f71111c;
                float f28 = this.f71115g;
                canvas.drawRoundRect(rectF11, f28, f28, this.f71110b);
            }
        } else if (i11 == 2) {
            this.f71111c.set(0.0f, 0.0f, this.f71113e, (float) getHeight());
            this.f71110b.setColor(this.f71117i);
            RectF rectF12 = this.f71111c;
            float f29 = this.f71115g;
            canvas.drawRoundRect(rectF12, f29, f29, this.f71110b);
            RectF rectF13 = this.f71111c;
            float f31 = this.f71113e;
            float f32 = this.f71114f;
            rectF13.set(f31 + f32, 0.0f, f32 + f31 + f31, (float) getHeight());
            this.f71110b.setColor(this.f71117i);
            RectF rectF14 = this.f71111c;
            float f33 = this.f71115g;
            canvas.drawRoundRect(rectF14, f33, f33, this.f71110b);
            if (this.f71120l == 3) {
                RectF rectF15 = this.f71111c;
                float f34 = this.f71113e;
                float f35 = this.f71114f;
                rectF15.set((f34 * 2.0f) + (f35 * 2.0f), 0.0f, (f34 * 2.0f) + (f35 * 2.0f) + this.f71112d, (float) getHeight());
                this.f71110b.setColor(this.f71116h);
                RectF rectF16 = this.f71111c;
                float f36 = this.f71115g;
                canvas.drawRoundRect(rectF16, f36, f36, this.f71110b);
            }
        }
    }

    public void setPages(int i11) {
        this.f71120l = i11;
    }

    public void setPosition(int i11) {
        this.f71119k = i11;
        invalidate();
    }

    public CommonHorizontalIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71110b = new Paint();
        this.f71111c = new RectF();
        this.f71112d = (float) PixelUtils.a(10.0f);
        this.f71113e = (float) PixelUtils.a(5.0f);
        this.f71114f = (float) PixelUtils.a(2.0f);
        this.f71115g = (float) PixelUtils.a(2.0f);
        this.f71116h = getResources().getColor(R$color.baseColorThreeLevelText);
        this.f71117i = getResources().getColor(R$color.baseColorPrimarySeparator);
        this.f71118j = getResources().getColor(R$color.baseColorContentBackground);
        this.f71110b.setAntiAlias(true);
    }
}
