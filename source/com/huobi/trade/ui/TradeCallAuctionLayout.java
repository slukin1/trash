package com.huobi.trade.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.trade.helper.i;
import com.huobi.utils.v0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.d;
import i6.m;
import it.a;
import pro.huobi.R;

public class TradeCallAuctionLayout extends ConstraintLayout implements a {

    /* renamed from: b  reason: collision with root package name */
    public TradeCallAuctionCountDownLayout f82356b;

    /* renamed from: c  reason: collision with root package name */
    public TradeCallAuctionCountDownLayout f82357c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f82358d;

    /* renamed from: e  reason: collision with root package name */
    public View f82359e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f82360f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82361g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f82362h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f82363i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f82364j;

    /* renamed from: k  reason: collision with root package name */
    public View f82365k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f82366l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f82367m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f82368n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f82369o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f82370p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f82371q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f82372r;

    /* renamed from: s  reason: collision with root package name */
    public a f82373s;

    public TradeCallAuctionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(View view) {
        v0.e(getContext(), "104900011957169");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(int i11, long j11, long[] jArr) {
    }

    public void c(int i11) {
        a aVar = this.f82373s;
        if (aVar != null) {
            aVar.c(i11);
        }
    }

    public final void i() {
        this.f82371q.setOnClickListener(new i1(this));
    }

    public void j() {
        setVisibility(8);
        this.f82356b.setCountDownCallback((a) null);
        this.f82357c.setCountDownCallback((a) null);
    }

    public final void k(Context context) {
        ViewGroup.inflate(context, R.layout.layout_trade_spot_call_auction, this);
        this.f82356b = (TradeCallAuctionCountDownLayout) findViewById(R.id.first_count_down_view);
        this.f82357c = (TradeCallAuctionCountDownLayout) findViewById(R.id.second_count_down_view);
        this.f82358d = (ImageView) findViewById(R.id.number_first_tv);
        this.f82359e = findViewById(R.id.first_container);
        this.f82360f = (TextView) findViewById(R.id.call_auction_first_time_tv);
        this.f82361g = (TextView) findViewById(R.id.call_auction_first_order_tv);
        this.f82362h = (ImageView) findViewById(R.id.number_second_tv);
        this.f82363i = (TextView) findViewById(R.id.call_auction_first_time_count_down_tv);
        this.f82364j = (TextView) findViewById(R.id.call_auction_first_end_tv);
        this.f82365k = findViewById(R.id.second_container);
        this.f82366l = (TextView) findViewById(R.id.call_auction_second_time_tv);
        this.f82367m = (TextView) findViewById(R.id.call_auction_second_not_start_tv);
        this.f82368n = (TextView) findViewById(R.id.call_auction_second_time_count_down_tv);
        this.f82369o = (TextView) findViewById(R.id.open_price_value_tv);
        this.f82370p = (TextView) findViewById(R.id.match_number_value_tv);
        this.f82371q = (TextView) findViewById(R.id.call_auction_desc_tv);
        this.f82372r = (TextView) findViewById(R.id.call_auction_second_order_tv);
        i();
    }

    public void o(int i11, long j11) {
        if (i11 == 1) {
            this.f82356b.setValid(true);
        } else {
            this.f82357c.setValid(true);
        }
        i.k().v(i11, j11);
    }

    public void p(CallAuction callAuction, String str) {
        if (callAuction == null) {
            this.f82369o.setText("--");
            this.f82370p.setText("--");
            return;
        }
        if (TextUtils.isEmpty(callAuction.getForecastPrice())) {
            this.f82369o.setText("--");
        } else {
            this.f82369o.setText(m.m(callAuction.getForecastPrice(), PrecisionUtil.e(str)));
        }
        if (TextUtils.isEmpty(callAuction.getMatchAmount())) {
            this.f82370p.setText("--");
        } else {
            this.f82370p.setText(m.m(callAuction.getMatchAmount(), PrecisionUtil.z(str)));
        }
    }

    public void q(String str) {
        SymbolBean J = a1.v().J(str, TradeType.PRO);
        if (J != null) {
            d.b("CallAuction isCallAuctionOne:" + J.isCallAuctionOne() + "====isCallAuctionTwo:" + J.isCallAuctionTwo());
            if (SymbolBean.ONLINE.equals(J.getState())) {
                StringBuilder sb2 = new StringBuilder(DateTimeUtils.h(J.getCa1OpenAt(), "HH:mm:ss"));
                sb2.append(" - ");
                sb2.append(DateTimeUtils.h(J.getCa1CloseAt(), "HH:mm:ss"));
                this.f82360f.setText(sb2);
                StringBuilder sb3 = new StringBuilder(DateTimeUtils.h(J.getCa2OpenAt(), "HH:mm:ss"));
                sb3.append(" - ");
                sb3.append(DateTimeUtils.h(J.getCa2CloseAt(), "HH:mm:ss"));
                this.f82366l.setText(sb3);
                if (J.isCallAuctionOne()) {
                    setVisibility(0);
                    this.f82356b.setCountDownCallback(this);
                    this.f82358d.setImageResource(R.drawable.call_auction_number_first);
                    this.f82359e.setBackgroundResource(R.drawable.shape_call_auction_first_bg);
                    this.f82363i.setVisibility(0);
                    this.f82356b.setVisibility(0);
                    this.f82364j.setVisibility(8);
                    this.f82365k.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.baseColorRemarksBackground));
                    this.f82367m.setVisibility(0);
                    this.f82368n.setVisibility(4);
                    this.f82357c.setVisibility(4);
                    this.f82362h.setImageResource(R.drawable.call_auction_number_second);
                    this.f82372r.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorThreeLevelText));
                    this.f82366l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorThreeLevelText));
                    this.f82360f.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText));
                    this.f82361g.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
                } else if (J.isCallAuctionTwo()) {
                    setVisibility(0);
                    this.f82357c.setCountDownCallback(this);
                    this.f82358d.setImageResource(R.drawable.call_auction_finish);
                    this.f82359e.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.baseColorRemarksBackground));
                    this.f82363i.setVisibility(4);
                    this.f82356b.setVisibility(4);
                    this.f82364j.setVisibility(0);
                    this.f82365k.setBackgroundResource(R.drawable.shape_call_auction_first_bg);
                    this.f82367m.setVisibility(8);
                    this.f82368n.setVisibility(0);
                    this.f82357c.setVisibility(0);
                    this.f82362h.setImageResource(R.drawable.call_auction_number_second_start);
                    this.f82372r.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
                    this.f82366l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText));
                    this.f82360f.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorThreeLevelText));
                    this.f82361g.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorThreeLevelText));
                } else {
                    setVisibility(8);
                    this.f82356b.setCountDownCallback((a) null);
                    this.f82357c.setCountDownCallback((a) null);
                }
            } else {
                setVisibility(8);
                this.f82356b.setCountDownCallback((a) null);
                this.f82357c.setCountDownCallback((a) null);
            }
        } else {
            setVisibility(8);
            this.f82356b.setCountDownCallback((a) null);
            this.f82357c.setCountDownCallback((a) null);
        }
    }

    public void setCountDownCallback(a aVar) {
        this.f82373s = aVar;
    }

    public TradeCallAuctionLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public TradeCallAuctionLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        k(context);
    }
}
