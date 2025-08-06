package com.huobi.finance.presenter;

import com.hbg.lib.network.option.core.bean.OptionFinancialRecordResponse;
import com.huobi.finance.presenter.OptionDetailPresenter;
import rx.functions.Func1;

public final /* synthetic */ class i5 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OptionDetailPresenter.a f45921b;

    public /* synthetic */ i5(OptionDetailPresenter.a aVar) {
        this.f45921b = aVar;
    }

    public final Object call(Object obj) {
        return this.f45921b.l((OptionFinancialRecordResponse) obj);
    }
}
