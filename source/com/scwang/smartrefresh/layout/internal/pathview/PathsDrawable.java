package com.scwang.smartrefresh.layout.internal.pathview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.List;
import my.a;

public class PathsDrawable extends Drawable {

    /* renamed from: n  reason: collision with root package name */
    public static final Region f29922n = new Region();

    /* renamed from: o  reason: collision with root package name */
    public static final Region f29923o = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: a  reason: collision with root package name */
    public Paint f29924a;

    /* renamed from: b  reason: collision with root package name */
    public List<Path> f29925b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f29926c;

    /* renamed from: d  reason: collision with root package name */
    public int f29927d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f29928e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f29929f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f29930g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f29931h;

    /* renamed from: i  reason: collision with root package name */
    public int f29932i;

    /* renamed from: j  reason: collision with root package name */
    public List<Path> f29933j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f29934k;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f29935l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f29936m;

    public PathsDrawable() {
        Paint paint = new Paint();
        this.f29924a = paint;
        paint.setColor(-15614977);
        this.f29924a.setStyle(Paint.Style.FILL);
        this.f29924a.setAntiAlias(true);
    }

    public boolean a(int i11, int i12) {
        return i11 == this.f29935l.getWidth() && i12 == this.f29935l.getHeight();
    }

    public boolean b() {
        return !this.f29936m;
    }

    public void c(int i11, int i12) {
        if (this.f29935l == null || !a(i11, i12)) {
            this.f29935l = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            this.f29936m = true;
        }
    }

    public final void d(Canvas canvas) {
        canvas.translate((float) (-this.f29929f), (float) (-this.f29930g));
        if (this.f29925b != null) {
            for (int i11 = 0; i11 < this.f29925b.size(); i11++) {
                List<Integer> list = this.f29926c;
                if (list != null && i11 < list.size()) {
                    this.f29924a.setColor(this.f29926c.get(i11).intValue());
                }
                canvas.drawPath(this.f29925b.get(i11), this.f29924a);
            }
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.f29924a.getAlpha() == 255) {
            canvas.save();
            canvas.translate((float) (bounds.left - this.f29929f), (float) (bounds.top - this.f29930g));
            if (this.f29925b != null) {
                for (int i11 = 0; i11 < this.f29925b.size(); i11++) {
                    List<Integer> list = this.f29926c;
                    if (list != null && i11 < list.size()) {
                        this.f29924a.setColor(this.f29926c.get(i11).intValue());
                    }
                    canvas.drawPath(this.f29925b.get(i11), this.f29924a);
                }
                this.f29924a.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        c(width, height);
        if (!b()) {
            m(width, height);
            l();
        }
        canvas.drawBitmap(this.f29935l, (float) bounds.left, (float) bounds.top, this.f29924a);
    }

    public Paint e() {
        return this.f29924a;
    }

    public int f() {
        return getBounds().height();
    }

    public void g() {
        Integer num;
        Integer num2;
        Integer num3;
        int i11;
        int i12;
        int i13;
        List<Path> list = this.f29925b;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num = null;
            for (Path path : list) {
                Region region = f29922n;
                region.setPath(path, f29923o);
                Rect bounds = region.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num = Integer.valueOf(Math.max(num == null ? bounds.bottom : num.intValue(), bounds.bottom));
            }
            num3 = num4;
            num4 = num5;
        } else {
            num3 = null;
            num2 = null;
            num = null;
        }
        int i14 = 0;
        if (num4 == null) {
            i11 = 0;
        } else {
            i11 = num4.intValue();
        }
        this.f29929f = i11;
        if (num3 == null) {
            i12 = 0;
        } else {
            i12 = num3.intValue();
        }
        this.f29930g = i12;
        if (num2 == null) {
            i13 = 0;
        } else {
            i13 = num2.intValue() - this.f29929f;
        }
        this.f29927d = i13;
        if (num != null) {
            i14 = num.intValue() - this.f29930g;
        }
        this.f29928e = i14;
        if (this.f29931h == 0) {
            this.f29931h = this.f29927d;
        }
        if (this.f29932i == 0) {
            this.f29932i = i14;
        }
        Rect bounds2 = getBounds();
        int i15 = bounds2.left;
        int i16 = bounds2.top;
        super.setBounds(i15, i16, this.f29927d + i15, this.f29928e + i16);
    }

    public int getOpacity() {
        return -3;
    }

    public void h(int... iArr) {
        this.f29926c = new ArrayList();
        for (int valueOf : iArr) {
            this.f29926c.add(Integer.valueOf(valueOf));
        }
    }

    public void i(String... strArr) {
        this.f29932i = 0;
        this.f29931h = 0;
        this.f29934k = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f29933j = arrayList;
        this.f29925b = arrayList;
        for (String str : strArr) {
            this.f29934k.add(str);
            this.f29933j.add(a.d(str));
        }
        g();
    }

    public void j(int i11) {
        Rect bounds = getBounds();
        float height = (((float) i11) * 1.0f) / ((float) bounds.height());
        setBounds((int) (((float) bounds.left) * height), (int) (((float) bounds.top) * height), (int) (((float) bounds.right) * height), (int) (((float) bounds.bottom) * height));
    }

    public void k(int i11) {
        Rect bounds = getBounds();
        float width = (((float) i11) * 1.0f) / ((float) bounds.width());
        setBounds((int) (((float) bounds.left) * width), (int) (((float) bounds.top) * width), (int) (((float) bounds.right) * width), (int) (((float) bounds.bottom) * width));
    }

    public void l() {
        this.f29936m = false;
    }

    public void m(int i11, int i12) {
        this.f29935l.eraseColor(0);
        d(new Canvas(this.f29935l));
    }

    public int n() {
        return getBounds().width();
    }

    public void setAlpha(int i11) {
        this.f29924a.setAlpha(i11);
    }

    public void setBounds(int i11, int i12, int i13, int i14) {
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        List<Path> list = this.f29933j;
        if (list == null || list.size() <= 0 || (i15 == this.f29927d && i16 == this.f29928e)) {
            super.setBounds(i11, i12, i13, i14);
            return;
        }
        this.f29925b = a.h((((float) i15) * 1.0f) / ((float) this.f29931h), (((float) i16) * 1.0f) / ((float) this.f29932i), this.f29933j, this.f29934k);
        g();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f29924a.setColorFilter(colorFilter);
    }

    public void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
