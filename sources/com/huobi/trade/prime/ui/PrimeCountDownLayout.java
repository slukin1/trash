package com.huobi.trade.prime.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.widgets.PrimeCountDownAnimView;
import com.huobi.R$styleable;
import ht.e;
import it.a;
import pro.huobi.R;

public class PrimeCountDownLayout extends LinearLayout implements a {

    /* renamed from: b  reason: collision with root package name */
    public PrimeCountDownAnimView f82206b;

    /* renamed from: c  reason: collision with root package name */
    public PrimeCountDownAnimView f82207c;

    /* renamed from: d  reason: collision with root package name */
    public PrimeCountDownAnimView f82208d;

    /* renamed from: e  reason: collision with root package name */
    public PrimeCountDownAnimView f82209e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f82210f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82211g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f82212h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f82213i;

    /* renamed from: j  reason: collision with root package name */
    public a f82214j;

    /* renamed from: k  reason: collision with root package name */
    public int f82215k;

    /* renamed from: l  reason: collision with root package name */
    public int f82216l;

    /* renamed from: m  reason: collision with root package name */
    public int f82217m;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f82218n;

    /* renamed from: o  reason: collision with root package name */
    public int f82219o;

    /* renamed from: p  reason: collision with root package name */
    public int f82220p;

    /* renamed from: q  reason: collision with root package name */
    public String f82221q;

    /* renamed from: r  reason: collision with root package name */
    public String f82222r;

    /* renamed from: s  reason: collision with root package name */
    public String f82223s;

    /* renamed from: t  reason: collision with root package name */
    public String f82224t;

    /* renamed from: u  reason: collision with root package name */
    public int f82225u;

    /* renamed from: v  reason: collision with root package name */
    public int f82226v;

    /* renamed from: w  reason: collision with root package name */
    public int f82227w;

    /* renamed from: x  reason: collision with root package name */
    public int f82228x;

    public PrimeCountDownLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final PrimeCountDownAnimView a(Context context) {
        PrimeCountDownAnimView primeCountDownAnimView = new PrimeCountDownAnimView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f82215k, this.f82216l);
        primeCountDownAnimView.setPadding(this.f82217m);
        primeCountDownAnimView.setLayoutParams(layoutParams);
        primeCountDownAnimView.setBackgroundDrawable(this.f82218n);
        primeCountDownAnimView.setTextSize(this.f82219o);
        primeCountDownAnimView.setTextColor(this.f82220p);
        return primeCountDownAnimView;
    }

    public void b(int i11, long j11, long[] jArr) {
        boolean z11 = j11 != getInitTime();
        this.f82206b.p((int) jArr[0], z11);
        if (this.f82206b.getVisibility() != 0) {
            jArr[1] = jArr[1] + (jArr[0] * Period.DAY_MILLS);
        }
        this.f82207c.p((int) jArr[1], z11);
        this.f82208d.p((int) jArr[2], z11);
        this.f82209e.p((int) jArr[3], z11);
        this.f82206b.setMax(Integer.MAX_VALUE);
        this.f82207c.setMax(24);
        this.f82208d.setMax(60);
        this.f82209e.setMax(60);
        a aVar = this.f82214j;
        if (aVar != null) {
            aVar.b(i11, j11, jArr);
        }
    }

    public void c(int i11) {
        a aVar = this.f82214j;
        if (aVar != null) {
            aVar.c(i11);
        }
    }

    public final TextView d(Context context) {
        return e(context, false);
    }

    public final TextView e(Context context, boolean z11) {
        int i11;
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f82225u;
        if (z11) {
            i11 = 0;
        } else {
            i11 = this.f82226v;
        }
        layoutParams.rightMargin = i11;
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(this.f82227w);
        textView.setTextSize(0, (float) this.f82228x);
        return textView;
    }

    public final int f(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void g(Context context) {
        setOrientation(0);
        setGravity(17);
        this.f82206b = a(context);
        this.f82207c = a(context);
        this.f82208d = a(context);
        this.f82209e = a(context);
        this.f82210f = d(context);
        this.f82211g = d(context);
        this.f82212h = d(context);
        this.f82213i = e(context, true);
        this.f82210f.setText(this.f82221q);
        this.f82211g.setText(this.f82222r);
        this.f82212h.setText(this.f82223s);
        this.f82213i.setText(this.f82224t);
        addView(this.f82206b);
        addView(this.f82210f);
        addView(this.f82207c);
        addView(this.f82211g);
        addView(this.f82208d);
        addView(this.f82212h);
        addView(this.f82209e);
        addView(this.f82213i);
    }

    public long getInitTime() {
        return e.k().j();
    }

    public void h() {
        e.k().t(this);
    }

    public void i() {
        e.k().x(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 == 0) {
            h();
        } else {
            i();
        }
    }

    public void setCountDownCallback(a aVar) {
        this.f82214j = aVar;
    }

    public void setDayVisible(boolean z11) {
        ViewUtil.m(this.f82206b, z11);
        ViewUtil.m(this.f82210f, z11);
    }

    public void setHourVisible(boolean z11) {
        ViewUtil.m(this.f82207c, z11);
        ViewUtil.m(this.f82211g, z11);
    }

    public void setSecondUnitVisible(boolean z11) {
        ViewUtil.m(this.f82213i, z11);
    }

    public void setValid(boolean z11) {
        this.f82206b.setValid(z11);
        this.f82207c.setValid(z11);
        this.f82208d.setValid(z11);
        this.f82209e.setValid(z11);
    }

    public PrimeCountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PrimeCountDownLayout, i11, 0);
        this.f82215k = obtainStyledAttributes.getDimensionPixelOffset(8, f(42.0f));
        this.f82216l = obtainStyledAttributes.getDimensionPixelOffset(4, f(30.0f));
        this.f82217m = obtainStyledAttributes.getDimensionPixelOffset(5, f(1.0f));
        this.f82219o = obtainStyledAttributes.getDimensionPixelOffset(7, f(24.0f));
        this.f82228x = obtainStyledAttributes.getDimensionPixelOffset(1, f(14.0f));
        this.f82220p = obtainStyledAttributes.getColor(6, -1);
        this.f82218n = obtainStyledAttributes.getDrawable(3);
        this.f82221q = obtainStyledAttributes.getString(9);
        this.f82222r = obtainStyledAttributes.getString(10);
        this.f82223s = obtainStyledAttributes.getString(13);
        this.f82224t = obtainStyledAttributes.getString(14);
        this.f82227w = obtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color.baseColorPrimaryText));
        this.f82225u = obtainStyledAttributes.getDimensionPixelOffset(11, 0);
        this.f82226v = obtainStyledAttributes.getDimensionPixelOffset(12, 0);
        obtainStyledAttributes.recycle();
        g(context);
    }
}
