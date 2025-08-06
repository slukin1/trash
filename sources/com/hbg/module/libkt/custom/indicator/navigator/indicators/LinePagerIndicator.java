package com.hbg.module.libkt.custom.indicator.navigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.hbg.module.libkt.base.ext.c;
import com.hbg.module.libkt.custom.indicator.navigator.model.PositionData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import pe.b;

public final class LinePagerIndicator extends View implements b {

    /* renamed from: n  reason: collision with root package name */
    public static final a f24808n = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public int f24809b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f24810c = new LinearInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f24811d = new LinearInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public float f24812e;

    /* renamed from: f  reason: collision with root package name */
    public float f24813f;

    /* renamed from: g  reason: collision with root package name */
    public float f24814g;

    /* renamed from: h  reason: collision with root package name */
    public float f24815h;

    /* renamed from: i  reason: collision with root package name */
    public float f24816i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f24817j = new Paint(1);

    /* renamed from: k  reason: collision with root package name */
    public List<? extends PositionData> f24818k;

    /* renamed from: l  reason: collision with root package name */
    public List<Integer> f24819l;

    /* renamed from: m  reason: collision with root package name */
    public RectF f24820m = new RectF();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public LinePagerIndicator(Context context) {
        super(context);
        this.f24817j.setStyle(Paint.Style.FILL);
        this.f24813f = (float) c.a(3.0f);
        this.f24815h = (float) c.a(10.0f);
    }

    public void a(ArrayList<PositionData> arrayList) {
        this.f24818k = arrayList;
    }

    public final Interpolator getEndInterpolator() {
        return this.f24811d;
    }

    public final int getMode() {
        return this.f24809b;
    }

    public final Interpolator getStartInterpolator() {
        return this.f24810c;
    }

    public void onDraw(Canvas canvas) {
        RectF rectF = this.f24820m;
        float f11 = this.f24816i;
        canvas.drawRoundRect(rectF, f11, f11, this.f24817j);
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        if (!com.hbg.module.libkt.base.ext.b.w(this.f24818k)) {
            List<Integer> list = this.f24819l;
            if (list != null && (!list.isEmpty())) {
                this.f24817j.setColor(ne.a.f25318a.a(f11, this.f24819l.get(Math.abs(i11) % this.f24819l.size()).intValue(), this.f24819l.get(Math.abs(i11 + 1) % this.f24819l.size()).intValue()));
            }
            ne.a aVar = ne.a.f25318a;
            PositionData b11 = aVar.b(this.f24818k, i11);
            PositionData b12 = aVar.b(this.f24818k, i11 + 1);
            int i13 = this.f24809b;
            if (i13 == 0) {
                f12 = ((float) b11.f()) + this.f24814g;
                f15 = ((float) b12.f()) + this.f24814g;
                f13 = ((float) b11.g()) - this.f24814g;
                f16 = (float) b12.g();
                f17 = this.f24814g;
            } else if (i13 != 1) {
                float f18 = (float) 2;
                f12 = ((float) b11.f()) + ((((float) b11.r()) - this.f24815h) / f18);
                f15 = ((float) b12.f()) + ((((float) b12.r()) - this.f24815h) / f18);
                f13 = ((float) b11.f()) + ((((float) b11.r()) + this.f24815h) / f18);
                f14 = ((float) b12.f()) + ((((float) b12.r()) + this.f24815h) / f18);
                this.f24820m.left = f12 + ((f15 - f12) * this.f24810c.getInterpolation(f11));
                this.f24820m.right = f13 + ((f14 - f13) * this.f24811d.getInterpolation(f11));
                this.f24820m.top = (((float) getHeight()) - this.f24813f) - this.f24812e;
                this.f24820m.bottom = ((float) getHeight()) - this.f24812e;
                invalidate();
            } else {
                f12 = ((float) b11.c()) + this.f24814g;
                f15 = ((float) b12.c()) + this.f24814g;
                f13 = ((float) b11.d()) - this.f24814g;
                f16 = (float) b12.d();
                f17 = this.f24814g;
            }
            f14 = f16 - f17;
            this.f24820m.left = f12 + ((f15 - f12) * this.f24810c.getInterpolation(f11));
            this.f24820m.right = f13 + ((f14 - f13) * this.f24811d.getInterpolation(f11));
            this.f24820m.top = (((float) getHeight()) - this.f24813f) - this.f24812e;
            this.f24820m.bottom = ((float) getHeight()) - this.f24812e;
            invalidate();
        }
    }

    public void onPageSelected(int i11) {
    }

    public final void setColors(int... iArr) {
        this.f24819l = ArraysKt___ArraysKt.v0(iArr);
    }

    public final void setEndInterpolator(Interpolator interpolator) {
        this.f24811d = interpolator;
    }

    public final void setLineHeight(float f11) {
        this.f24813f = f11;
    }

    public final void setLineWidth(float f11) {
        this.f24815h = f11;
    }

    public final void setMode(int i11) {
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            this.f24809b = i11;
            return;
        }
        throw new IllegalArgumentException("mode " + i11 + " not supported.");
    }

    public final void setStartInterpolator(Interpolator interpolator) {
        this.f24810c = interpolator;
    }

    public final void setYOffset(float f11) {
        this.f24812e = f11;
    }
}
