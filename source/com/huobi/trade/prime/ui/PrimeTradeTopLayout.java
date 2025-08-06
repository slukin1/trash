package com.huobi.trade.prime.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrimeInfo;
import ht.e;
import it.a;
import java.util.Locale;
import pro.huobi.R;

public class PrimeTradeTopLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f82254b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f82255c;

    /* renamed from: d  reason: collision with root package name */
    public PrimeCountDownLayout f82256d;

    /* renamed from: e  reason: collision with root package name */
    public Context f82257e;

    /* renamed from: f  reason: collision with root package name */
    public PrimeInfo f82258f;

    public PrimeTradeTopLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String a(PrimeInfo primeInfo) {
        if (primeInfo.getTotalRounds() <= 1) {
            return String.format(Locale.US, getResources().getString(R.string.current_round_remaining_time_end), new Object[0]);
        }
        return String.format(Locale.US, getResources().getString(R.string.current_round_remaining_time), new Object[]{String.valueOf(primeInfo.getCurrentRoundNumber())});
    }

    public String b(PrimeInfo primeInfo) {
        if (primeInfo.getTotalRounds() <= 1) {
            return String.format(Locale.US, getResources().getString(R.string.prime_count_down_until_start_tips), new Object[0]);
        }
        return String.format(Locale.US, getResources().getString(R.string.current_round_remaining_start_time), new Object[]{String.valueOf(primeInfo.getCurrentRoundNumber())});
    }

    public final void c(Context context) {
        this.f82257e = context;
        LayoutInflater.from(context).inflate(R.layout.layout_top_prime_trade, this);
        this.f82254b = (TextView) findViewById(R.id.prime_time_hint_tv);
        this.f82256d = (PrimeCountDownLayout) findViewById(R.id.prime_time_view);
        this.f82255c = (TextView) findViewById(R.id.id_prime_detail_btn);
    }

    public void d(PrimeInfo primeInfo, String str) {
        if (primeInfo == null) {
            this.f82256d.setValid(false);
            this.f82254b.setText("--");
            e.k().u();
            return;
        }
        this.f82258f = primeInfo;
        this.f82256d.setValid(true);
        int status = primeInfo.getStatus();
        if (status == 1) {
            this.f82254b.setText(b(primeInfo));
        } else if (status == 2) {
            this.f82254b.setText(a(primeInfo));
        } else if (status == 3) {
            this.f82254b.setText("--");
            e.k().u();
        }
        e();
    }

    public final void e() {
        if (this.f82258f.isPrime()) {
            this.f82255c.setBackgroundResource(R.drawable.prime_shape_rect_see_detail_bg);
            this.f82255c.setTextColor(getResources().getColor(R.color.prime));
            this.f82255c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.prime_retract, 0, 0, 0);
            return;
        }
        this.f82255c.setBackgroundResource(R.drawable.prime_lite_shape_rect_see_detail_bg);
        this.f82255c.setTextColor(getResources().getColor(R.color.prime_lite));
        this.f82255c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.prime_lite_retract, 0, 0, 0);
    }

    public void setCountDownCallback(a aVar) {
        this.f82256d.setCountDownCallback(aVar);
    }

    public PrimeTradeTopLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context);
    }
}
