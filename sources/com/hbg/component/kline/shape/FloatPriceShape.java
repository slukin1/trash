package com.hbg.component.kline.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.PaintUtils;

public class FloatPriceShape extends BaseShape {

    /* renamed from: y  reason: collision with root package name */
    public static float f67368y = ((float) DimenUtils.a(14.0f));

    /* renamed from: g  reason: collision with root package name */
    public String f67369g;

    /* renamed from: h  reason: collision with root package name */
    public String f67370h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67371i = false;

    /* renamed from: j  reason: collision with root package name */
    public Paint f67372j;

    /* renamed from: k  reason: collision with root package name */
    public float f67373k;

    /* renamed from: l  reason: collision with root package name */
    public RectF f67374l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    public float f67375m;

    /* renamed from: n  reason: collision with root package name */
    public int f67376n;

    /* renamed from: o  reason: collision with root package name */
    public int f67377o;

    /* renamed from: p  reason: collision with root package name */
    public int f67378p;

    /* renamed from: q  reason: collision with root package name */
    public int f67379q;

    /* renamed from: r  reason: collision with root package name */
    public float f67380r;

    /* renamed from: s  reason: collision with root package name */
    public float f67381s;

    /* renamed from: t  reason: collision with root package name */
    public float f67382t = ((float) DimenUtils.a(90.0f));

    /* renamed from: u  reason: collision with root package name */
    public float f67383u = ((float) DimenUtils.a(2.0f));

    /* renamed from: v  reason: collision with root package name */
    public Drawable f67384v;

    /* renamed from: w  reason: collision with root package name */
    public Rect f67385w = new Rect();

    /* renamed from: x  reason: collision with root package name */
    public boolean f67386x;

    public void l(Canvas canvas) {
        if (!TextUtils.isEmpty(this.f67369g) && g()) {
            if (this.f67386x) {
                this.f67382t = ((float) (canvas.getWidth() / 2)) - (this.f67374l.width() / 2.0f);
            }
            this.f67337c.set(this.f67374l);
            this.f67337c.offset((((float) canvas.getWidth()) - this.f67374l.width()) - this.f67382t, this.f67373k);
            canvas.save();
            canvas.translate(0.0f, this.f67373k);
            Paint paint = this.f67372j;
            int i11 = this.f67378p;
            int i12 = CandleStickRender.f67208x2;
            PaintUtils.b(paint, i11, (float) i12);
            canvas.drawLine(0.0f, 0.0f, (((float) canvas.getWidth()) - this.f67374l.width()) - this.f67382t, 0.0f, this.f67372j);
            canvas.drawLine(((float) canvas.getWidth()) - this.f67382t, 0.0f, (float) canvas.getWidth(), 0.0f, this.f67372j);
            canvas.restore();
            canvas.save();
            canvas.translate((((float) canvas.getWidth()) - this.f67374l.width()) - this.f67382t, this.f67373k);
            PaintUtils.c(this.f67372j, this.f67379q);
            RectF rectF = this.f67374l;
            float f11 = this.f67383u;
            canvas.drawRoundRect(rectF, f11, f11, this.f67372j);
            PaintUtils.d(this.f67372j, this.f67377o, (float) i12);
            RectF rectF2 = this.f67374l;
            float f12 = this.f67383u;
            canvas.drawRoundRect(rectF2, f12, f12, this.f67372j);
            Drawable drawable = this.f67384v;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            if (this.f67371i) {
                PaintUtils.h(this.f67372j, Paint.Align.RIGHT, this.f67376n, this.f67375m);
                canvas.drawText(this.f67369g, (this.f67374l.right - ((float) DimenUtils.a(3.0f))) - ((float) this.f67385w.width()), this.f67381s - ((float) DimenUtils.a(5.0f)), this.f67372j);
                PaintUtils.h(this.f67372j, Paint.Align.RIGHT, this.f67376n, this.f67375m);
                canvas.drawText(this.f67370h, (this.f67374l.right - ((float) DimenUtils.a(3.0f))) - ((float) this.f67385w.width()), this.f67381s + ((float) DimenUtils.a(5.0f)), this.f67372j);
            } else {
                PaintUtils.h(this.f67372j, Paint.Align.LEFT, this.f67376n, this.f67375m);
                canvas.drawText(this.f67369g, this.f67380r, this.f67381s, this.f67372j);
            }
            canvas.restore();
        }
    }

    public void m(String str, String str2, boolean z11, float f11, Drawable drawable, int i11, int i12, float f12, int i13, int i14, float f13, Paint paint, boolean z12) {
        this.f67372j = paint;
        this.f67373k = f13;
        this.f67375m = f11;
        this.f67384v = drawable;
        this.f67377o = i11;
        this.f67376n = i12;
        this.f67382t = f12;
        this.f67378p = i14;
        this.f67379q = i13;
        this.f67386x = z12;
        if (!TextUtils.isEmpty(str) && (!TextUtils.equals(str, this.f67369g) || z11 != this.f67371i || this.f67374l.isEmpty())) {
            PaintUtils.h(this.f67372j, Paint.Align.LEFT, i12, f11);
            int i15 = 0;
            this.f67372j.getTextBounds(str, 0, str.length(), this.f67336b);
            int max = Math.max(this.f67336b.width(), 0);
            if (z11) {
                this.f67372j.getTextBounds(str2, 0, str2.length(), this.f67336b);
                max = Math.max(this.f67336b.width(), max);
                this.f67374l.top = (float) (-DimenUtils.a(11.0f));
                this.f67374l.bottom = (float) DimenUtils.a(11.0f);
            } else {
                RectF rectF = this.f67374l;
                float f14 = f67368y;
                rectF.top = (-f14) / 2.0f;
                rectF.bottom = f14 / 2.0f;
            }
            RectF rectF2 = this.f67374l;
            rectF2.left = 0.0f;
            if (drawable != null) {
                i15 = drawable.getIntrinsicWidth();
            }
            rectF2.right = (float) (max + i15 + DimenUtils.a(6.0f));
            this.f67380r = (float) DimenUtils.a(2.0f);
            this.f67381s = (float) (-this.f67336b.centerY());
            this.f67337c.set(this.f67374l);
            if (drawable != null) {
                if (z11) {
                    this.f67385w.top = (int) ((this.f67374l.centerY() - ((float) DimenUtils.a(5.0f))) - ((float) (drawable.getIntrinsicHeight() / 2)));
                } else {
                    this.f67385w.top = (int) (this.f67374l.centerY() - ((float) (drawable.getIntrinsicHeight() / 2)));
                }
                Rect rect = this.f67385w;
                rect.bottom = rect.top + drawable.getIntrinsicHeight();
                this.f67385w.right = (int) (this.f67374l.right - ((float) DimenUtils.a(2.0f)));
                Rect rect2 = this.f67385w;
                rect2.left = rect2.right - drawable.getIntrinsicWidth();
                drawable.setBounds(this.f67385w);
            }
        }
        this.f67369g = str;
        this.f67370h = str2;
        this.f67371i = z11;
    }
}
