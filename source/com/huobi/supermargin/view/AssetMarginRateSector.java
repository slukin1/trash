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

public class AssetMarginRateSector extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f81484b;

    /* renamed from: c  reason: collision with root package name */
    public int f81485c;

    /* renamed from: d  reason: collision with root package name */
    public String f81486d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f81487e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f81488f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f81489g;

    public AssetMarginRateSector(Context context) {
        this(context, (AttributeSet) null);
    }

    public final float a(String str) {
        BigDecimal a11 = m.a(str);
        BigDecimal bigDecimal = m.f68179a;
        if (a11.multiply(bigDecimal).compareTo(new BigDecimal(this.f81484b)) >= 0) {
            return 0.0f;
        }
        if (m.a(str).multiply(bigDecimal).compareTo(new BigDecimal(this.f81485c)) <= 0) {
            return 250.0f;
        }
        return new BigDecimal(250).divide(new BigDecimal(this.f81484b - this.f81485c), 10, 1).multiply(new BigDecimal(this.f81484b).subtract(m.a(str).multiply(bigDecimal))).setScale(1, 1).floatValue();
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_asset_margin_rate_sector, this, true);
        this.f81487e = (ImageView) findViewById(R.id.margin_rate_pointer);
        this.f81488f = (ImageView) findViewById(R.id.margin_risk_empty);
        this.f81489g = (ImageView) findViewById(R.id.margin_rate_instrument);
        this.f81487e.setImageResource(R.drawable.edge_engine_asset_pointer);
        this.f81487e.setRotation(0.0f);
        this.f81489g.setImageResource(R.drawable.edge_engine_asset_instrument);
    }

    public void c(int i11, int i12) {
        this.f81484b = i11;
        this.f81485c = i12;
    }

    public void setEmpty(boolean z11) {
        if (z11) {
            this.f81488f.setVisibility(0);
            this.f81487e.setVisibility(8);
            return;
        }
        this.f81488f.setVisibility(8);
        this.f81487e.setVisibility(0);
    }

    public void setRate(String str) {
        float f11;
        if (!this.f81486d.equals(str)) {
            if ("-1".equals(this.f81486d)) {
                f11 = 0.0f;
            } else {
                f11 = a(this.f81486d);
            }
            float a11 = a(str);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f81487e, "rotation", new float[]{f11, a11});
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(400);
            ofFloat.start();
            this.f81486d = str;
        }
    }

    public AssetMarginRateSector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetMarginRateSector(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f81484b = 200;
        this.f81485c = 110;
        this.f81486d = "-1";
        b();
    }
}
