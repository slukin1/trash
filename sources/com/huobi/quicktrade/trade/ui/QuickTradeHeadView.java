package com.huobi.quicktrade.trade.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.huobi.quicktrade.bean.QuickTradeDismissEvent;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import sq.j;
import sq.k;
import sq.l;

public class QuickTradeHeadView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80644b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80645c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80646d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f80647e;

    /* renamed from: f  reason: collision with root package name */
    public QuickNewestPriceHorizontalView f80648f;

    /* renamed from: g  reason: collision with root package name */
    public int f80649g;

    public QuickTradeHeadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e(View view) {
        EventBus.d().k(new QuickTradeDismissEvent());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        j();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        j();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_quick_trade_head, this, true);
        this.f80644b = (TextView) findViewById(R.id.trade_head_symbol_tv);
        this.f80645c = (TextView) findViewById(R.id.trade_price_change_tv);
        this.f80646d = (TextView) findViewById(R.id.tv_price_limit);
        this.f80647e = (LinearLayout) findViewById(R.id.ll_to_spot_trade);
        findViewById(R.id.iv_close).setOnClickListener(l.f26133b);
        this.f80644b.setOnClickListener(new k(this));
        this.f80647e.setOnClickListener(new j(this));
        this.f80648f = (QuickNewestPriceHorizontalView) findViewById(R.id.trade_newest_price_view);
    }

    public QuickNewestPriceHorizontalView getPriceView() {
        return this.f80648f;
    }

    public void h(String str, int i11, int i12) {
        this.f80645c.setText(str);
        this.f80645c.setTextColor(i11);
        this.f80645c.setBackgroundResource(i12);
        this.f80646d.setText(str);
        this.f80646d.setTextColor(i11);
        if (ContextCompat.getColor(getContext(), w.d()) == i11) {
            if (w.l()) {
                this.f80647e.setBackgroundResource(R.drawable.bg_asset_price_green);
            } else {
                this.f80647e.setBackgroundResource(R.drawable.bg_asset_price_red);
            }
        } else if (w.l()) {
            this.f80647e.setBackgroundResource(R.drawable.bg_asset_price_red);
        } else {
            this.f80647e.setBackgroundResource(R.drawable.bg_asset_price_green);
        }
    }

    public void i() {
        com.huobi.trade.helper.l.b().e();
    }

    public final void j() {
        String charSequence = this.f80644b.getText().toString();
        if (!TextUtils.isEmpty(charSequence) || this.f80649g == 1) {
            k0.O(getContext(), charSequence.replace("/", "").toLowerCase(), true);
            EventBus.d().k(new QuickTradeDismissEvent());
        }
    }

    public void k() {
        this.f80648f.e();
    }

    public void l(String str) {
        this.f80644b.setText(str);
    }

    public void setType(int i11) {
        this.f80649g = i11;
        if (i11 == 1) {
            this.f80647e.setVisibility(0);
            this.f80645c.setVisibility(8);
            return;
        }
        this.f80647e.setVisibility(8);
        this.f80645c.setVisibility(0);
    }

    public QuickTradeHeadView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f80649g = -1;
        d();
    }
}
