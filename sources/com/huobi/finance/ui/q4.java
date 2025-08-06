package com.huobi.finance.ui;

import android.content.Context;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.ui.CurrencyFromCCDetailActivity;
import rx.functions.Action1;

public final /* synthetic */ class q4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f47289b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyFromCCDetailActivity.a f47290c;

    public /* synthetic */ q4(Context context, CurrencyFromCCDetailActivity.a aVar) {
        this.f47289b = context;
        this.f47290c = aVar;
    }

    public final void call(Object obj) {
        CurrencyFromCCDetailActivity.Sh(this.f47289b, this.f47290c, (BalanceDetailInfo) obj);
    }
}
