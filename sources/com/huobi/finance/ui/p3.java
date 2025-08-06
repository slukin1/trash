package com.huobi.finance.ui;

import android.view.View;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.view.indexlist.IndexPartAdapter;

public final /* synthetic */ class p3 implements IndexPartAdapter.OnItemContentClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CurrencyChooseActivity f47275a;

    public /* synthetic */ p3(CurrencyChooseActivity currencyChooseActivity) {
        this.f47275a = currencyChooseActivity;
    }

    public final void onItemClick(View view, int i11, int i12, Object obj) {
        this.f47275a.sh(view, i11, i12, (SymbolCurrencyEntity) obj);
    }
}
