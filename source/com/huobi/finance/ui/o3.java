package com.huobi.finance.ui;

import com.huobi.view.indexlist.IndexPartAdapter;
import java.util.List;

public final /* synthetic */ class o3 implements IndexPartAdapter.IndexCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CurrencyChooseActivity f47261a;

    public /* synthetic */ o3(CurrencyChooseActivity currencyChooseActivity) {
        this.f47261a = currencyChooseActivity;
    }

    public final void onFinished(List list) {
        this.f47261a.vh(list);
    }
}
