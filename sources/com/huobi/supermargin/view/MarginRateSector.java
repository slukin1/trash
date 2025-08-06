package com.huobi.supermargin.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import i6.m;
import java.math.BigDecimal;
import pro.huobi.R;

public class MarginRateSector extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f81490b;

    /* renamed from: c  reason: collision with root package name */
    public int f81491c;

    /* renamed from: d  reason: collision with root package name */
    public String f81492d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f81493e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f81494f;

    public MarginRateSector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final float a(String str) {
        BigDecimal a11 = m.a(str);
        BigDecimal bigDecimal = m.f68179a;
        if (a11.multiply(bigDecimal).compareTo(new BigDecimal(this.f81490b)) >= 0) {
            return 0.0f;
        }
        if (m.a(str).multiply(bigDecimal).compareTo(new BigDecimal(this.f81491c)) <= 0) {
            return 250.0f;
        }
        return new BigDecimal(250).divide(new BigDecimal(this.f81490b - this.f81491c), 10, 1).multiply(new BigDecimal(this.f81490b).subtract(m.a(str).multiply(bigDecimal))).setScale(1, 1).floatValue();
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_margin_rate_sector, this, true);
        this.f81493e = (ImageView) findViewById(R.id.margin_rate_pointer);
        this.f81494f = (ImageView) findViewById(R.id.margin_rate_instrument);
        this.f81493e.setImageResource(R.drawable.margin_pointer);
        this.f81493e.setRotation(0.0f);
        this.f81494f.setImageResource(R.drawable.margin_instrument);
    }

    public void c() {
        this.f81493e.setRotation(0.0f);
        this.f81492d = "-1";
    }

    public void d(int i11, int i12) {
        this.f81490b = i11;
        this.f81491c = i12;
    }

    public void setRate(String str) {
        float f11;
        if (!this.f81492d.equals(str)) {
            if ("-1".equals(this.f81492d)) {
                f11 = 0.0f;
            } else {
                f11 = a(this.f81492d);
            }
            float a11 = a(str);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f81493e, "rotation", new float[]{f11, a11});
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(400);
            ofFloat.start();
            this.f81492d = str;
        }
    }

    public MarginRateSector(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f81490b = 200;
        this.f81491c = 110;
        this.f81492d = "-1";
        b();
    }
}
