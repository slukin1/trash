package com.huobi.tradenew.prime.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huobi.trade.prime.ui.PrimeCountDownLayout;
import it.a;
import pro.huobi.R;

public class PrimeTradeTopLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f83051b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f83052c;

    /* renamed from: d  reason: collision with root package name */
    public PrimeCountDownLayout f83053d;

    /* renamed from: e  reason: collision with root package name */
    public Context f83054e;

    public PrimeTradeTopLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        this.f83054e = context;
        LayoutInflater.from(context).inflate(R.layout.layout_top_prime_trade, this);
        this.f83051b = (TextView) findViewById(R.id.prime_time_hint_tv);
        this.f83053d = (PrimeCountDownLayout) findViewById(R.id.prime_time_view);
        this.f83052c = (TextView) findViewById(R.id.id_prime_detail_btn);
    }

    public void setCountDownCallback(a aVar) {
        this.f83053d.setCountDownCallback(aVar);
    }

    public PrimeTradeTopLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
