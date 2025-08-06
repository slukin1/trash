package com.hbg.lib.widgets.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.hbg.lib.widgets.ticker.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final a[] f72383a;

    /* renamed from: b  reason: collision with root package name */
    public final c f72384b;

    /* renamed from: c  reason: collision with root package name */
    public char f72385c = 0;

    /* renamed from: d  reason: collision with root package name */
    public char f72386d = 0;

    /* renamed from: e  reason: collision with root package name */
    public char[] f72387e;

    /* renamed from: f  reason: collision with root package name */
    public int f72388f;

    /* renamed from: g  reason: collision with root package name */
    public int f72389g;

    /* renamed from: h  reason: collision with root package name */
    public int f72390h;

    /* renamed from: i  reason: collision with root package name */
    public float f72391i;

    /* renamed from: j  reason: collision with root package name */
    public float f72392j;

    /* renamed from: k  reason: collision with root package name */
    public float f72393k;

    /* renamed from: l  reason: collision with root package name */
    public float f72394l;

    /* renamed from: m  reason: collision with root package name */
    public float f72395m;

    /* renamed from: n  reason: collision with root package name */
    public float f72396n;

    /* renamed from: o  reason: collision with root package name */
    public float f72397o;

    /* renamed from: p  reason: collision with root package name */
    public float f72398p;

    /* renamed from: q  reason: collision with root package name */
    public int f72399q;

    /* renamed from: r  reason: collision with root package name */
    public int f72400r;

    public b(a[] aVarArr, c cVar) {
        this.f72383a = aVarArr;
        this.f72384b = cVar;
    }

    public final void a() {
        float c11 = this.f72384b.c(this.f72386d);
        float f11 = this.f72394l;
        float f12 = this.f72395m;
        if (f11 == f12 && f12 != c11) {
            this.f72395m = c11;
            this.f72394l = c11;
            this.f72396n = c11;
        }
    }

    public void b(Canvas canvas, Paint paint) {
        if (c(canvas, paint, this.f72387e, this.f72390h, this.f72391i)) {
            int i11 = this.f72390h;
            if (i11 >= 0) {
                this.f72385c = this.f72387e[i11];
            }
            this.f72397o = this.f72391i;
        }
        c(canvas, paint, this.f72387e, this.f72390h + 1, this.f72391i - this.f72392j);
        c(canvas, paint, this.f72387e, this.f72390h - 1, this.f72391i + this.f72392j);
    }

    public final boolean c(Canvas canvas, Paint paint, char[] cArr, int i11, float f11) {
        if (i11 < 0 || i11 >= cArr.length) {
            return false;
        }
        paint.setAlpha(this.f72400r);
        canvas.drawText(cArr, i11, 1, 0.0f, f11, paint);
        return true;
    }

    public char d() {
        return this.f72385c;
    }

    public float e() {
        a();
        return this.f72394l;
    }

    public float f() {
        a();
        return this.f72396n;
    }

    public void g() {
        a();
        this.f72396n = this.f72394l;
    }

    public void h(float f11) {
        if (f11 == 1.0f) {
            this.f72385c = this.f72386d;
            this.f72397o = 0.0f;
            this.f72398p = 0.0f;
        }
        if (this.f72386d == 0) {
            this.f72400r = (int) ((1.0f - f11) * 255.0f);
        } else {
            this.f72400r = 255;
        }
        float b11 = this.f72384b.b();
        float abs = ((((float) Math.abs(this.f72389g - this.f72388f)) * b11) * f11) / b11;
        int i11 = (int) abs;
        float f12 = this.f72398p * (1.0f - f11);
        int i12 = this.f72399q;
        this.f72391i = ((abs - ((float) i11)) * b11 * ((float) i12)) + f12;
        this.f72390h = this.f72388f + (i11 * i12);
        this.f72392j = b11;
        float f13 = this.f72393k;
        this.f72394l = f13 + ((this.f72395m - f13) * f11);
    }

    public final void i() {
        this.f72387e = null;
        int i11 = 0;
        while (true) {
            a[] aVarArr = this.f72383a;
            if (i11 >= aVarArr.length) {
                break;
            }
            a.b a11 = aVarArr[i11].a(this.f72385c, this.f72386d, this.f72384b.d());
            if (a11 != null) {
                this.f72387e = this.f72383a[i11].b();
                this.f72388f = a11.f72380a;
                this.f72389g = a11.f72381b;
            }
            i11++;
        }
        if (this.f72387e == null) {
            char c11 = this.f72385c;
            char c12 = this.f72386d;
            if (c11 == c12) {
                this.f72387e = new char[]{c11};
                this.f72389g = 0;
                this.f72388f = 0;
                return;
            }
            this.f72387e = new char[]{c11, c12};
            this.f72388f = 0;
            this.f72389g = 1;
        }
    }

    public void j(char c11) {
        this.f72386d = c11;
        this.f72393k = this.f72394l;
        float c12 = this.f72384b.c(c11);
        this.f72395m = c12;
        this.f72396n = Math.max(this.f72393k, c12);
        i();
        int i11 = 1;
        if (!(this.f72389g >= this.f72388f)) {
            i11 = -1;
        }
        this.f72399q = i11;
        this.f72398p = this.f72397o;
        this.f72397o = 0.0f;
    }
}
