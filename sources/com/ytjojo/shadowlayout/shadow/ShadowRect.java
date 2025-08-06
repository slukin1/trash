package com.ytjojo.shadowlayout.shadow;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import gz.a;

public class ShadowRect implements a {

    /* renamed from: a  reason: collision with root package name */
    public ShapeDrawable f52720a = new ShapeDrawable(new RectShape());

    /* renamed from: b  reason: collision with root package name */
    public ShapeDrawable f52721b = new ShapeDrawable(new RectShape());

    /* renamed from: c  reason: collision with root package name */
    public Rect f52722c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public Rect f52723d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public Path f52724e = new Path();

    /* renamed from: f  reason: collision with root package name */
    public int f52725f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f52726g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public float f52727h;

    public void a(Canvas canvas) {
        if (this.f52725f <= 0) {
            canvas.drawRect(this.f52723d, this.f52721b.getPaint());
            canvas.drawRect(this.f52722c, this.f52720a.getPaint());
            return;
        }
        Rect rect = this.f52723d;
        RectF rectF = new RectF((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        int i11 = this.f52725f;
        canvas.drawRoundRect(rectF, (float) i11, (float) i11, this.f52721b.getPaint());
        Rect rect2 = this.f52722c;
        RectF rectF2 = new RectF((float) rect2.left, (float) rect2.top, (float) rect2.right, (float) rect2.bottom);
        int i12 = this.f52725f;
        canvas.drawRoundRect(rectF2, (float) i12, (float) i12, this.f52720a.getPaint());
    }

    public void b(Canvas canvas) {
    }

    public void c(int i11, int i12, float f11, float f12, float f13, float f14, Rect rect) {
        Rect rect2 = this.f52722c;
        rect2.left = rect.left;
        rect2.top = (int) (((float) rect.top) + f11);
        rect2.right = rect.right;
        rect2.bottom = (int) (((float) rect.bottom) + (f11 / 2.0f));
        Rect rect3 = this.f52723d;
        rect3.left = rect.left;
        rect3.top = (int) (((float) rect.top) + f12);
        rect3.right = rect.right;
        rect3.bottom = (int) (((float) rect.bottom) + (f12 / 2.0f));
        this.f52720a.getPaint().setColor(i11);
        if (0.0f < f13) {
            this.f52720a.getPaint().setMaskFilter(new BlurMaskFilter(f13, BlurMaskFilter.Blur.NORMAL));
        } else {
            this.f52720a.getPaint().setMaskFilter((MaskFilter) null);
        }
        this.f52721b.getPaint().setColor(i12);
        if (0.0f < f14) {
            this.f52721b.getPaint().setMaskFilter(new BlurMaskFilter(f14, BlurMaskFilter.Blur.NORMAL));
        } else {
            this.f52721b.getPaint().setMaskFilter((MaskFilter) null);
        }
        this.f52727h = f13;
    }

    public boolean d(Canvas canvas, View view) {
        if (this.f52725f <= 0) {
            return false;
        }
        this.f52726g.set((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
        this.f52724e.reset();
        Path path = this.f52724e;
        RectF rectF = this.f52726g;
        int i11 = this.f52725f;
        path.addRoundRect(rectF, (float) i11, (float) i11, Path.Direction.CW);
        canvas.clipPath(this.f52724e, Region.Op.REPLACE);
        return false;
    }

    public void e(View view, int i11, int i12, int i13, int i14) {
    }

    public void f(int i11) {
        this.f52725f = i11;
    }
}
