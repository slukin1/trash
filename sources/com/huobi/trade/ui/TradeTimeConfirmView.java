package com.huobi.trade.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import nk.a;
import pro.huobi.R;
import rj.b;

public class TradeTimeConfirmView extends FrameLayout implements a.C0579a {

    /* renamed from: b  reason: collision with root package name */
    public Context f82456b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayoutCompat f82457c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentActivity f82458d;

    /* renamed from: e  reason: collision with root package name */
    public b f82459e;

    /* renamed from: f  reason: collision with root package name */
    public String f82460f;

    public TradeTimeConfirmView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        this.f82456b = context;
        c(LayoutInflater.from(context).inflate(R.layout.trade_time_order, this, true));
    }

    public final void b(LinearLayoutCompat linearLayoutCompat) {
        b bVar = this.f82459e;
        if (bVar != null) {
            View E = bVar.E("trade_time_order_confirm.xml", getContext(), false, (JSONObject) null);
            this.f82459e.H();
            if (!TextUtils.isEmpty(this.f82460f)) {
                b bVar2 = this.f82459e;
                bVar2.I("refreshData('" + this.f82460f + "')");
            }
            linearLayoutCompat.addView(E);
        }
    }

    public final void c(View view) {
        this.f82457c = (LinearLayoutCompat) view.findViewById(R.id.ll_container);
    }

    public void close() {
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        this.f82458d = fragmentActivity;
    }

    public void setEdgeEngine(b bVar) {
        this.f82459e = bVar;
        b(this.f82457c);
    }

    public void setParam(String str) {
        this.f82460f = str;
    }

    public TradeTimeConfirmView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
