package com.hbg.module.kline.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.ServerCurDate;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import td.e;
import v7.b;

public class NewSymbolCountDownLayout extends RelativeLayout implements vd.a {

    /* renamed from: b  reason: collision with root package name */
    public KlineCountDownLayout f24136b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24137c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24138d = false;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f24139e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24140f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24141g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24142h = true;

    public class a extends BaseSubscriber<ServerCurDate> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f24143b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24144c;

        public a(long j11, int i11) {
            this.f24143b = j11;
            this.f24144c = i11;
        }

        /* renamed from: a */
        public void onNext(ServerCurDate serverCurDate) {
            super.onNext(serverCurDate);
            long curDate = serverCurDate.getCurDate();
            long j11 = this.f24143b;
            if (j11 >= curDate) {
                long j12 = j11 - curDate;
                e.k().v(this.f24144c, j12);
                if (NewSymbolCountDownLayout.this.f24136b != null) {
                    NewSymbolCountDownLayout.this.f24136b.setValid(true);
                    if (j12 / Period.DAY_MILLS <= 0) {
                        NewSymbolCountDownLayout.this.f24136b.setDayVisible(false);
                    }
                }
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public NewSymbolCountDownLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public void b(int i11, long j11, long[] jArr) {
        KlineCountDownLayout klineCountDownLayout = this.f24136b;
        if (klineCountDownLayout != null) {
            klineCountDownLayout.b(i11, j11, jArr);
        }
    }

    public void c(int i11) {
        KlineCountDownLayout klineCountDownLayout = this.f24136b;
        if (klineCountDownLayout != null) {
            klineCountDownLayout.c(i11);
        }
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_kline_preonline_countdown, this, true);
        this.f24136b = (KlineCountDownLayout) findViewById(R$id.count_down_layout);
        int i11 = R$id.count_down_symbol_name;
        this.f24137c = (TextView) findViewById(i11);
        this.f24139e = (ViewGroup) findViewById(R$id.preonline_count_down_layout);
        this.f24140f = (TextView) findViewById(i11);
        this.f24141g = (TextView) findViewById(R$id.count_down_desc);
    }

    public void e(int i11, long j11) {
        b.a().queryCurDate().b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(j11, i11));
    }

    public void f() {
        this.f24142h = false;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24137c.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, getResources().getDimensionPixelOffset(R$dimen.dimen_97), layoutParams.rightMargin, layoutParams.bottomMargin);
        this.f24137c.setLayoutParams(layoutParams);
    }

    public void g() {
        KlineCountDownLayout klineCountDownLayout = this.f24136b;
        if (klineCountDownLayout != null) {
            klineCountDownLayout.j();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.k().t(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.k().w(this);
    }

    public void setCountDownCallback(vd.a aVar) {
        KlineCountDownLayout klineCountDownLayout = this.f24136b;
        if (klineCountDownLayout != null) {
            klineCountDownLayout.setCountDownCallback(aVar);
        }
    }

    public void setDayVisible(boolean z11) {
        KlineCountDownLayout klineCountDownLayout = this.f24136b;
        if (klineCountDownLayout != null) {
            klineCountDownLayout.setDayVisible(z11);
        }
    }

    public void setNightMode(boolean z11) {
        this.f24138d = z11;
        if (z11) {
            TextView textView = this.f24140f;
            Resources resources = getResources();
            int i11 = R$color.color_CFD3E9;
            textView.setTextColor(resources.getColor(i11));
            this.f24141g.setTextColor(getResources().getColor(i11));
            this.f24136b.setNumberBackground(getResources().getDrawable(R$drawable.bg_market_kline_time_light));
            this.f24136b.setNumberTextColor(getResources().getColor(R$color.color_2483FF));
            return;
        }
        TextView textView2 = this.f24140f;
        Resources resources2 = getResources();
        int i12 = R$color.color_14181F;
        textView2.setTextColor(resources2.getColor(i12));
        this.f24141g.setTextColor(getResources().getColor(i12));
        this.f24136b.setNumberBackground(getResources().getDrawable(R$drawable.bg_market_kline_time_night));
        this.f24136b.setNumberTextColor(getResources().getColor(R$color.color_0066ED));
    }

    public void setSymbolName(String str) {
        TextView textView = this.f24137c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public NewSymbolCountDownLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d();
    }
}
