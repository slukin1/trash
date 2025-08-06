package com.huobi.trade.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huobi.trade.bean.TradeTimeInfo;
import d7.a1;
import nk.a;
import pro.huobi.R;
import qk.u0;
import rj.b;

public class TradeTimeView extends FrameLayout implements a.C0579a {

    /* renamed from: b  reason: collision with root package name */
    public Context f82470b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayoutCompat f82471c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentActivity f82472d;

    /* renamed from: e  reason: collision with root package name */
    public b f82473e;

    /* renamed from: f  reason: collision with root package name */
    public TradeTimeInfo f82474f;

    public TradeTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        this.f82470b = context;
        c(LayoutInflater.from(context).inflate(R.layout.trade_time_order, this, true));
    }

    public final void b(LinearLayoutCompat linearLayoutCompat) {
        b bVar = this.f82473e;
        if (bVar != null) {
            View E = bVar.E("trade_time_order.xml", this.f82472d, false, (JSONObject) null);
            this.f82473e.H();
            if (this.f82474f != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("baseCurrency", (Object) a1.v().n(this.f82474f.getSymbol()));
                jSONObject.put("quoteCurrency", (Object) a1.v().D(this.f82474f.getSymbol()));
                jSONObject.put("symbol", (Object) this.f82474f.getSymbol());
                jSONObject.put("symbolName", (Object) a1.v().W(this.f82474f.getSymbol()));
                jSONObject.put(FirebaseAnalytics.Param.PRICE, (Object) this.f82474f.getLastPriceNew());
                jSONObject.put("rise", (Object) Integer.valueOf(this.f82474f.isRise() ? 1 : 0));
                jSONObject.put("availableOfBuy", (Object) this.f82474f.getAvailableOfBuy());
                jSONObject.put("availableOfSell", (Object) this.f82474f.getAvailableOfSell());
                jSONObject.put("minTimeInterval", (Object) Integer.valueOf(this.f82474f.getMinTimeInterval()));
                jSONObject.put("maxTimeInterval", (Object) Integer.valueOf(this.f82474f.getMaxTimeInterval()));
                jSONObject.put("minPriceIntervalRatio", (Object) this.f82474f.getMinPriceIntervalRatio());
                jSONObject.put("maxPriceIntervalRatio", (Object) this.f82474f.getMaxPriceIntervalRatio());
                jSONObject.put("accountId", (Object) this.f82474f.getAccountId());
                jSONObject.put("source", (Object) "android");
                jSONObject.put("needOrderConfirm", (Object) Boolean.valueOf(u0.e("config_app_spot_time_confirm_key")));
                jSONObject.put("lessThan", (Object) this.f82474f.getLessThan());
                jSONObject.put("greaterThan", (Object) this.f82474f.getGreaterThan());
                jSONObject.put("tradeAmountPrecision", (Object) Integer.valueOf(this.f82474f.getAmountPrecision()));
                jSONObject.put("tradePricePrecision", (Object) Integer.valueOf(this.f82474f.getPricePrecision()));
                b bVar2 = this.f82473e;
                bVar2.I("refreshData('" + jSONObject.toJSONString() + "')");
            }
            linearLayoutCompat.addView(E);
        }
    }

    public final void c(View view) {
        this.f82471c = (LinearLayoutCompat) view.findViewById(R.id.ll_container);
    }

    public void close() {
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        this.f82472d = fragmentActivity;
    }

    public void setEdgeEngine(b bVar) {
        this.f82473e = bVar;
        b(this.f82471c);
    }

    public void setTradeTimeInfo(TradeTimeInfo tradeTimeInfo) {
        this.f82474f = tradeTimeInfo;
    }

    public TradeTimeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
