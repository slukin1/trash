package com.huobi.trade.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huobi.trade.bean.OrderPlaceBean;
import d7.a1;
import nk.a;
import pro.huobi.R;
import rj.b;

public class TradeSpotConfirmView extends FrameLayout implements a.C0579a {

    /* renamed from: b  reason: collision with root package name */
    public Context f82440b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentActivity f82441c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutCompat f82442d;

    /* renamed from: e  reason: collision with root package name */
    public b f82443e;

    /* renamed from: f  reason: collision with root package name */
    public OrderPlaceBean f82444f;

    /* renamed from: g  reason: collision with root package name */
    public String f82445g;

    public TradeSpotConfirmView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        this.f82440b = context;
        c(LayoutInflater.from(context).inflate(R.layout.trade_spot_order, this, true));
    }

    public final void b(LinearLayoutCompat linearLayoutCompat) {
        b bVar = this.f82443e;
        if (bVar != null) {
            int i11 = 0;
            View E = bVar.E("spot_order_confirm.xml", getContext(), false, (JSONObject) null);
            this.f82443e.H();
            if (this.f82444f != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("baseCurrency", (Object) a1.v().n(this.f82444f.getSymbol()));
                jSONObject.put("quoteCurrency", (Object) a1.v().D(this.f82444f.getSymbol()));
                jSONObject.put("symbolName", (Object) a1.v().W(this.f82444f.getSymbol()));
                jSONObject.put("tradeType", (Object) Integer.valueOf(this.f82444f.isBuy() ^ true ? 1 : 0));
                if (this.f82444f.getTradeViewType() != 1) {
                    jSONObject.put("amount", (Object) this.f82444f.getDisplayAmount());
                    jSONObject.put("total", (Object) this.f82444f.getDisplayVolume());
                } else if (this.f82444f.isSelectedMarketAmount()) {
                    jSONObject.put("amount", (Object) this.f82444f.isBuy() ? this.f82444f.getMarketAmountText() : this.f82444f.getDisplayAmount());
                } else {
                    jSONObject.put("total", (Object) this.f82444f.isBuy() ? this.f82444f.getDisplayVolume() : this.f82444f.getMarketAmountText());
                }
                jSONObject.put("marketType", (Object) Integer.valueOf(this.f82444f.getTradeViewType()));
                if (this.f82444f.getTradeViewType() == 0) {
                    jSONObject.put("orderLimitType", (Object) Integer.valueOf(this.f82444f.getOrderLimitType()));
                }
                jSONObject.put(FirebaseAnalytics.Param.PRICE, (Object) this.f82444f.getDisplayPrice());
                jSONObject.put("stopPrice", (Object) this.f82444f.getDisplayStopPrice());
                jSONObject.put("planMarketMode", (Object) Integer.valueOf(this.f82444f.getPlanTradeMarketMode()));
                jSONObject.put("loanVolume", (Object) this.f82444f.getLoanAmount());
                jSONObject.put("repayVolume", (Object) this.f82444f.getRepayAmount());
                String format = String.format(j.c().getString(R.string.n_spot_order_interestRate_subtitle), new Object[]{this.f82444f.getInterestRate()});
                if (TextUtils.isEmpty(this.f82444f.getInterestRate()) || this.f82444f.getInterestRate().equals("--")) {
                    format = "";
                }
                jSONObject.put("interest", (Object) format);
                int i12 = (this.f82444f.getAutoType() == 1 || this.f82444f.getAutoType() == 3) ? 1 : 0;
                if (this.f82444f.getAutoType() == 2 || this.f82444f.getAutoType() == 3) {
                    i11 = 1;
                }
                jSONObject.put("isLoan", (Object) Integer.valueOf(i12));
                jSONObject.put("isRepay", (Object) Integer.valueOf(i11));
                jSONObject.put("marginName", (Object) this.f82445g);
                jSONObject.put("iceAmount", (Object) this.f82444f.getIceAmount());
                this.f82443e.I("refreshData('" + jSONObject.toJSONString() + "')");
            }
            linearLayoutCompat.addView(E);
        }
    }

    public final void c(View view) {
        this.f82442d = (LinearLayoutCompat) view.findViewById(R.id.ll_container);
    }

    public void close() {
    }

    public void d(OrderPlaceBean orderPlaceBean, String str) {
        this.f82444f = orderPlaceBean;
        this.f82445g = str;
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        this.f82441c = fragmentActivity;
    }

    public void setEdgeEngine(b bVar) {
        this.f82443e = bVar;
        b(this.f82442d);
    }

    public TradeSpotConfirmView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
