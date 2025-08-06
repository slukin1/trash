package com.hbg.module.kline.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.KlineCountDownAnimView;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$font;
import com.hbg.module.kline.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;
import td.e;
import vd.a;

public class KlineCountDownLayout extends LinearLayout implements a {

    /* renamed from: b  reason: collision with root package name */
    public KlineCountDownAnimView f23886b;

    /* renamed from: c  reason: collision with root package name */
    public KlineCountDownAnimView f23887c;

    /* renamed from: d  reason: collision with root package name */
    public KlineCountDownAnimView f23888d;

    /* renamed from: e  reason: collision with root package name */
    public KlineCountDownAnimView f23889e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f23890f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f23891g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f23892h;

    /* renamed from: i  reason: collision with root package name */
    public a f23893i;

    /* renamed from: j  reason: collision with root package name */
    public int f23894j;

    /* renamed from: k  reason: collision with root package name */
    public int f23895k;

    /* renamed from: l  reason: collision with root package name */
    public int f23896l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f23897m;

    /* renamed from: n  reason: collision with root package name */
    public int f23898n;

    /* renamed from: o  reason: collision with root package name */
    public int f23899o;

    /* renamed from: p  reason: collision with root package name */
    public int f23900p;

    /* renamed from: q  reason: collision with root package name */
    public int f23901q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f23902r;

    /* renamed from: s  reason: collision with root package name */
    public int f23903s;

    /* renamed from: t  reason: collision with root package name */
    public int f23904t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f23905u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f23906v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f23907w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f23908x;

    public KlineCountDownLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KlineCountDownAnimView a(Context context, int i11) {
        KlineCountDownAnimView klineCountDownAnimView = new KlineCountDownAnimView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, this.f23895k);
        klineCountDownAnimView.setPadding(this.f23896l);
        klineCountDownAnimView.setLayoutParams(layoutParams);
        klineCountDownAnimView.setBackgroundDrawable(this.f23897m);
        klineCountDownAnimView.setTextSize(this.f23898n);
        klineCountDownAnimView.setTextColor(this.f23899o);
        klineCountDownAnimView.setTextStyle(ResourcesCompat.h(context, R$font.roboto_medium));
        return klineCountDownAnimView;
    }

    public void b(int i11, long j11, long[] jArr) {
        boolean z11 = j11 != getInitTime();
        this.f23886b.p((int) jArr[0], z11);
        this.f23887c.p((int) jArr[1], z11);
        this.f23888d.p((int) jArr[2], z11);
        this.f23889e.p((int) jArr[3], z11);
        this.f23886b.setMax(999);
        this.f23887c.setMax(99);
        this.f23888d.setMax(60);
        this.f23889e.setMax(60);
        a aVar = this.f23893i;
        if (aVar != null) {
            aVar.b(i11, j11, jArr);
        }
    }

    public void c(int i11) {
        a aVar = this.f23893i;
        if (aVar != null) {
            aVar.c(i11);
        }
    }

    public TextView d(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("：");
        textView.setPadding(f(5.0f), 0, f(-5.0f), 0);
        textView.setTextSize((float) this.f23903s);
        textView.setTextColor(this.f23904t);
        textView.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        return textView;
    }

    public ImageView e(Context context, int i11) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(i11, i11));
        imageView.setImageResource(R$drawable.index_new_user_guide_time_dash);
        return imageView;
    }

    public final int f(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void g(Context context) {
        setOrientation(0);
        setGravity(17);
        this.f23886b = a(context, (int) (((float) this.f23894j) * 1.5f));
        this.f23887c = a(context, this.f23894j);
        this.f23888d = a(context, this.f23894j);
        this.f23889e = a(context, this.f23894j);
        this.f23886b.setTextAlign(Paint.Align.RIGHT);
        int dimension = (int) context.getResources().getDimension(R$dimen.dimen_17);
        if (!this.f23902r) {
            this.f23890f = e(context, dimension);
            this.f23891g = e(context, dimension);
            this.f23892h = e(context, dimension);
            addView(this.f23886b);
            addView(this.f23890f);
            addView(this.f23887c);
            addView(this.f23891g);
            addView(this.f23888d);
            addView(this.f23892h);
            addView(this.f23889e);
            return;
        }
        this.f23905u = d(context);
        this.f23906v = d(context);
        this.f23907w = d(context);
        this.f23908x = d(context);
        addView(this.f23886b);
        addView(this.f23905u);
        addView(this.f23887c);
        addView(this.f23906v);
        addView(this.f23888d);
        addView(this.f23907w);
        addView(this.f23889e);
    }

    public long getInitTime() {
        return e.k().j();
    }

    public void h() {
        e.k().u();
    }

    public void i() {
        e.k().t(this);
    }

    public void j() {
        h();
    }

    public void k() {
        e.k().w(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 == 0) {
            i();
        } else {
            k();
        }
    }

    public void setCountDownCallback(a aVar) {
        this.f23893i = aVar;
    }

    public void setDashTextColor(int i11) {
        this.f23904t = i11;
        TextView textView = this.f23905u;
        if (textView != null) {
            textView.setTextColor(i11);
        }
        TextView textView2 = this.f23906v;
        if (textView2 != null) {
            textView2.setTextColor(i11);
        }
        TextView textView3 = this.f23907w;
        if (textView3 != null) {
            textView3.setTextColor(i11);
        }
        TextView textView4 = this.f23908x;
        if (textView4 != null) {
            textView4.setTextColor(i11);
        }
    }

    public void setDayVisible(boolean z11) {
        ViewUtil.m(this.f23886b, z11);
        ViewUtil.m(this.f23890f, z11);
        ViewUtil.m(this.f23905u, z11);
    }

    public void setNumberBackground(Drawable drawable) {
        this.f23897m = drawable;
        KlineCountDownAnimView klineCountDownAnimView = this.f23886b;
        if (klineCountDownAnimView != null) {
            klineCountDownAnimView.setBackground(drawable);
        }
        KlineCountDownAnimView klineCountDownAnimView2 = this.f23887c;
        if (klineCountDownAnimView2 != null) {
            klineCountDownAnimView2.setBackground(this.f23897m);
        }
        KlineCountDownAnimView klineCountDownAnimView3 = this.f23888d;
        if (klineCountDownAnimView3 != null) {
            klineCountDownAnimView3.setBackground(this.f23897m);
        }
        KlineCountDownAnimView klineCountDownAnimView4 = this.f23889e;
        if (klineCountDownAnimView4 != null) {
            klineCountDownAnimView4.setBackground(this.f23897m);
        }
    }

    public void setNumberTextColor(int i11) {
        this.f23899o = i11;
        KlineCountDownAnimView klineCountDownAnimView = this.f23886b;
        if (klineCountDownAnimView != null) {
            klineCountDownAnimView.setTextColor(i11);
        }
        KlineCountDownAnimView klineCountDownAnimView2 = this.f23887c;
        if (klineCountDownAnimView2 != null) {
            klineCountDownAnimView2.setTextColor(this.f23899o);
        }
        KlineCountDownAnimView klineCountDownAnimView3 = this.f23888d;
        if (klineCountDownAnimView3 != null) {
            klineCountDownAnimView3.setTextColor(this.f23899o);
        }
        KlineCountDownAnimView klineCountDownAnimView4 = this.f23889e;
        if (klineCountDownAnimView4 != null) {
            klineCountDownAnimView4.setTextColor(this.f23899o);
        }
    }

    public void setValid(boolean z11) {
        this.f23886b.setValid(z11);
        this.f23887c.setValid(z11);
        this.f23888d.setValid(z11);
        this.f23889e.setValid(z11);
    }

    public KlineCountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PrimeCountDownLayout, i11, 0);
        this.f23894j = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.PrimeCountDownLayout_number_width, f(42.0f));
        this.f23895k = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.PrimeCountDownLayout_number_height, f(30.0f));
        this.f23896l = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.PrimeCountDownLayout_number_padding, 1);
        this.f23898n = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.PrimeCountDownLayout_number_text_size, f(24.0f));
        this.f23899o = obtainStyledAttributes.getColor(R$styleable.PrimeCountDownLayout_number_text_color, -1);
        this.f23897m = obtainStyledAttributes.getDrawable(R$styleable.PrimeCountDownLayout_number_bg);
        this.f23900p = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.PrimeCountDownLayout_unit_margin_left, 0);
        this.f23901q = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.PrimeCountDownLayout_unit_margin_right, 0);
        this.f23902r = obtainStyledAttributes.getBoolean(R$styleable.PrimeCountDownLayout_is_dash_text, false);
        this.f23903s = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.PrimeCountDownLayout_dash_text_size, f(16.0f));
        this.f23904t = obtainStyledAttributes.getColor(R$styleable.PrimeCountDownLayout_dash_text_color, RoundedDrawable.DEFAULT_BORDER_COLOR);
        obtainStyledAttributes.recycle();
        g(context);
    }
}
