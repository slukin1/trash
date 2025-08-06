package com.huobi.index.countdown;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.PrimeCountDownAnimView;
import com.huobi.R$styleable;
import ht.e;
import it.a;
import pro.huobi.R;

public class CountDownLayout extends LinearLayout implements a {

    /* renamed from: b  reason: collision with root package name */
    public PrimeCountDownAnimView f73239b;

    /* renamed from: c  reason: collision with root package name */
    public PrimeCountDownAnimView f73240c;

    /* renamed from: d  reason: collision with root package name */
    public PrimeCountDownAnimView f73241d;

    /* renamed from: e  reason: collision with root package name */
    public PrimeCountDownAnimView f73242e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f73243f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f73244g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f73245h;

    /* renamed from: i  reason: collision with root package name */
    public a f73246i;

    /* renamed from: j  reason: collision with root package name */
    public int f73247j;

    /* renamed from: k  reason: collision with root package name */
    public int f73248k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f73249l;

    /* renamed from: m  reason: collision with root package name */
    public int f73250m;

    /* renamed from: n  reason: collision with root package name */
    public int f73251n;

    /* renamed from: o  reason: collision with root package name */
    public int f73252o;

    /* renamed from: p  reason: collision with root package name */
    public int f73253p;

    public CountDownLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrimeCountDownAnimView a(Context context) {
        PrimeCountDownAnimView primeCountDownAnimView = new PrimeCountDownAnimView(context);
        primeCountDownAnimView.setLayoutParams(new LinearLayout.LayoutParams(this.f73247j, this.f73248k));
        primeCountDownAnimView.setBackgroundDrawable(this.f73249l);
        primeCountDownAnimView.setTextSize(this.f73250m);
        primeCountDownAnimView.setTextColor(this.f73251n);
        primeCountDownAnimView.setTextStyle(ResourcesCompat.h(context, R.font.roboto_medium));
        return primeCountDownAnimView;
    }

    public void b(int i11, long j11, long[] jArr) {
        boolean z11 = j11 != getInitTime();
        this.f73239b.p((int) jArr[0], z11);
        this.f73240c.p((int) jArr[1], z11);
        this.f73241d.p((int) jArr[2], z11);
        this.f73242e.p((int) jArr[3], z11);
        this.f73239b.setMax(Integer.MAX_VALUE);
        this.f73240c.setMax(99);
        this.f73241d.setMax(60);
        this.f73242e.setMax(60);
        a aVar = this.f73246i;
        if (aVar != null) {
            aVar.b(i11, j11, jArr);
        }
    }

    public void c(int i11) {
        a aVar = this.f73246i;
        if (aVar != null) {
            aVar.c(i11);
        }
    }

    public ImageView d(Context context, int i11) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(i11, i11));
        imageView.setImageResource(R.drawable.index_new_user_guide_time_dash);
        return imageView;
    }

    public final int e(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void f(Context context) {
        setOrientation(0);
        setGravity(17);
        this.f73239b = a(context);
        this.f73240c = a(context);
        this.f73241d = a(context);
        this.f73242e = a(context);
        int dimension = (int) context.getResources().getDimension(R.dimen.dimen_17);
        this.f73243f = d(context, dimension);
        this.f73244g = d(context, dimension);
        this.f73245h = d(context, dimension);
        addView(this.f73239b);
        addView(this.f73243f);
        addView(this.f73240c);
        addView(this.f73244g);
        addView(this.f73241d);
        addView(this.f73245h);
        addView(this.f73242e);
    }

    public void g() {
        e.k().t(this);
    }

    public long getInitTime() {
        return e.k().j();
    }

    public void h() {
        e.k().x(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 == 0) {
            g();
        } else {
            h();
        }
    }

    public void setCountDownCallback(a aVar) {
        this.f73246i = aVar;
    }

    public void setDayInVisible(boolean z11) {
        ViewUtil.n(this.f73239b, z11);
        ViewUtil.n(this.f73243f, z11);
    }

    public void setDayVisible(boolean z11) {
        ViewUtil.m(this.f73239b, z11);
        ViewUtil.m(this.f73243f, z11);
    }

    public void setValid(boolean z11) {
        this.f73239b.setValid(z11);
        this.f73240c.setValid(z11);
        this.f73241d.setValid(z11);
        this.f73242e.setValid(z11);
    }

    public CountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PrimeCountDownLayout, i11, 0);
        this.f73247j = obtainStyledAttributes.getDimensionPixelOffset(8, e(42.0f));
        this.f73248k = obtainStyledAttributes.getDimensionPixelOffset(4, e(30.0f));
        this.f73250m = obtainStyledAttributes.getDimensionPixelOffset(7, e(24.0f));
        this.f73251n = obtainStyledAttributes.getColor(6, -1);
        this.f73249l = obtainStyledAttributes.getDrawable(3);
        this.f73252o = obtainStyledAttributes.getDimensionPixelOffset(11, 0);
        this.f73253p = obtainStyledAttributes.getDimensionPixelOffset(12, 0);
        obtainStyledAttributes.recycle();
        f(context);
    }
}
