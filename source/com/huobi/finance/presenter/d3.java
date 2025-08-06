package com.huobi.finance.presenter;

import android.view.View;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;

public final /* synthetic */ class d3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l3 f45847b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f45848c;

    public /* synthetic */ d3(l3 l3Var, ContractCurrencyInfo contractCurrencyInfo) {
        this.f45847b = l3Var;
        this.f45848c = contractCurrencyInfo;
    }

    public final void onClick(View view) {
        this.f45847b.I(this.f45848c, view);
    }
}
