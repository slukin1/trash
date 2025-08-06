package com.huobi.account.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.R$styleable;
import it.a;
import pro.huobi.R;

public class CountDownLayout extends LinearLayout implements a {

    /* renamed from: b  reason: collision with root package name */
    public PrimeCountDownAnimView f41935b;

    /* renamed from: c  reason: collision with root package name */
    public PrimeCountDownAnimView f41936c;

    /* renamed from: d  reason: collision with root package name */
    public PrimeCountDownAnimView f41937d;

    /* renamed from: e  reason: collision with root package name */
    public PrimeCountDownAnimView f41938e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f41939f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f41940g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f41941h;

    /* renamed from: i  reason: collision with root package name */
    public a f41942i;

    /* renamed from: j  reason: collision with root package name */
    public int f41943j;

    /* renamed from: k  reason: collision with root package name */
    public int f41944k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f41945l;

    /* renamed from: m  reason: collision with root package name */
    public int f41946m;

    /* renamed from: n  reason: collision with root package name */
    public int f41947n;

    /* renamed from: o  reason: collision with root package name */
    public int f41948o;

    /* renamed from: p  reason: collision with root package name */
    public int f41949p;

    public CountDownLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrimeCountDownAnimView a(Context context) {
        PrimeCountDownAnimView primeCountDownAnimView = new PrimeCountDownAnimView(context);
        primeCountDownAnimView.setPadding(0);
        primeCountDownAnimView.setLayoutParams(new LinearLayout.LayoutParams(this.f41943j, this.f41944k));
        primeCountDownAnimView.setBackgroundDrawable(this.f41945l);
        primeCountDownAnimView.setTextSize(this.f41946m);
        primeCountDownAnimView.setTextColor(this.f41947n);
        int a11 = PixelUtils.a(2.0f);
        int a12 = PixelUtils.a(2.0f);
        primeCountDownAnimView.setPadding(a11, a12, a11, a12);
        return primeCountDownAnimView;
    }

    public void b(int i11, long j11, long[] jArr) {
        this.f41935b.p((int) jArr[0], true);
        this.f41936c.p((int) jArr[1], true);
        this.f41937d.p((int) jArr[2], true);
        this.f41938e.p((int) jArr[3], true);
        this.f41935b.setMax(Integer.MAX_VALUE);
        this.f41936c.setMax(99);
        this.f41937d.setMax(60);
        this.f41938e.setMax(60);
        a aVar = this.f41942i;
        if (aVar != null) {
            aVar.b(i11, j11, jArr);
        }
    }

    public void c(int i11) {
        a aVar = this.f41942i;
        if (aVar != null) {
            aVar.c(i11);
        }
    }

    public ImageView d(Context context, int i11) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(PixelUtils.a(7.0f), i11));
        imageView.setImageResource(R.drawable.ic_recommended_time_dash_account);
        return imageView;
    }

    public final int e(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void f(Context context) {
        setOrientation(0);
        setGravity(17);
        this.f41935b = a(context);
        this.f41936c = a(context);
        this.f41937d = a(context);
        this.f41938e = a(context);
        int dimension = (int) context.getResources().getDimension(R.dimen.dimen_14);
        this.f41939f = d(context, dimension);
        this.f41940g = d(context, dimension);
        this.f41941h = d(context, dimension);
        addView(this.f41935b);
        addView(this.f41939f);
        addView(this.f41936c);
        addView(this.f41940g);
        addView(this.f41937d);
        addView(this.f41941h);
        addView(this.f41938e);
        setGravity(16);
    }

    public final long[] g(long j11) {
        long j12 = j11 / Period.DAY_MILLS;
        long j13 = j11 - (Period.DAY_MILLS * j12);
        long j14 = j13 / Period.MIN60_MILLS;
        long j15 = j13 - (Period.MIN60_MILLS * j14);
        long j16 = j15 / 60000;
        long j17 = j15 - (60000 * j16);
        long j18 = j17 / 1000;
        long j19 = j17 - (1000 * j18);
        if (j12 > 99) {
            j12 = 99;
        }
        return new long[]{j12, j14, j16, j18, j19};
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
    }

    public void setCountDownCallback(a aVar) {
        this.f41942i = aVar;
    }

    public void setDayVisible(boolean z11) {
        ViewUtil.m(this.f41935b, z11);
        ViewUtil.m(this.f41939f, z11);
    }

    public void setTime(long j11) {
        setValid(true);
        if (j11 < 0) {
            j11 = 0;
        }
        b(0, 0, g(j11));
    }

    public void setValid(boolean z11) {
        this.f41935b.setValid(z11);
        this.f41936c.setValid(z11);
        this.f41937d.setValid(z11);
        this.f41938e.setValid(z11);
    }

    public CountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PrimeCountDownLayout, i11, 0);
        this.f41943j = obtainStyledAttributes.getDimensionPixelOffset(8, e(42.0f));
        this.f41944k = obtainStyledAttributes.getDimensionPixelOffset(4, e(30.0f));
        this.f41946m = obtainStyledAttributes.getDimensionPixelOffset(7, e(24.0f));
        this.f41947n = obtainStyledAttributes.getColor(6, -1);
        this.f41945l = obtainStyledAttributes.getDrawable(3);
        this.f41948o = obtainStyledAttributes.getDimensionPixelOffset(11, 0);
        this.f41949p = obtainStyledAttributes.getDimensionPixelOffset(12, 0);
        obtainStyledAttributes.recycle();
        f(context);
    }
}
