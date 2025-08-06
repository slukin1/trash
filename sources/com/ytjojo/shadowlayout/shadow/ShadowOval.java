package com.ytjojo.shadowlayout.shadow;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.ViewGroup;
import gz.a;

public class ShadowOval implements a {

    /* renamed from: a  reason: collision with root package name */
    public ShapeDrawable f52714a = new ShapeDrawable(new OvalShape());

    /* renamed from: b  reason: collision with root package name */
    public ShapeDrawable f52715b = new ShapeDrawable(new OvalShape());

    /* renamed from: c  reason: collision with root package name */
    public RectF f52716c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    public RectF f52717d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    public Path f52718e = new Path();

    /* renamed from: f  reason: collision with root package name */
    public RectF f52719f = new RectF();

    public void a(Canvas canvas) {
        canvas.drawOval(this.f52717d, this.f52715b.getPaint());
        canvas.drawOval(this.f52716c, this.f52714a.getPaint());
    }

    public void b(Canvas canvas) {
    }

    public void c(int i11, int i12, float f11, float f12, float f13, float f14, Rect rect) {
        RectF rectF = this.f52716c;
        int i13 = rect.left;
        rectF.left = (float) i13;
        int i14 = rect.top;
        rectF.top = ((float) i14) + f11;
        int i15 = rect.right;
        rectF.right = (float) i15;
        int i16 = rect.bottom;
        rectF.bottom = ((float) i16) + f11;
        RectF rectF2 = this.f52717d;
        rectF2.left = (float) i13;
        rectF2.top = ((float) i14) + f12;
        rectF2.right = (float) i15;
        rectF2.bottom = ((float) i16) + f12;
        this.f52714a.getPaint().setColor(i11);
        if (0.0f < f13) {
            this.f52714a.getPaint().setMaskFilter(new BlurMaskFilter(f13, BlurMaskFilter.Blur.NORMAL));
        } else {
            this.f52714a.getPaint().setMaskFilter((MaskFilter) null);
        }
        this.f52715b.getPaint().setColor(i12);
        if (0.0f < f14) {
            this.f52715b.getPaint().setMaskFilter(new BlurMaskFilter(f14, BlurMaskFilter.Blur.NORMAL));
        } else {
            this.f52715b.getPaint().setMaskFilter((MaskFilter) null);
        }
    }

    public boolean d(Canvas canvas, View view) {
        this.f52718e.reset();
        int min = Math.min(view.getHeight(), view.getWidth());
        this.f52718e.addCircle((float) (view.getLeft() + (view.getWidth() / 2)), (float) (view.getTop() + (view.getHeight() / 2)), (float) (min / 2), Path.Direction.CW);
        canvas.clipPath(this.f52718e, Region.Op.REPLACE);
        return false;
    }

    public void e(View view, int i11, int i12, int i13, int i14) {
        ViewGroup viewGroup = (ViewGroup) view;
        Path path = this.f52718e;
        RectF rectF = this.f52719f;
        path.addRoundRect(rectF, rectF.width(), this.f52719f.width(), Path.Direction.CW);
    }
}
