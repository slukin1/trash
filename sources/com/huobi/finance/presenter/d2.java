package com.huobi.finance.presenter;

import com.huobi.finance.bean.ContractRecordWrapper;
import com.huobi.finance.presenter.ContractFinanceRecordPresenter;
import rx.functions.Func1;

public final /* synthetic */ class d2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractFinanceRecordPresenter.a f45846b;

    public /* synthetic */ d2(ContractFinanceRecordPresenter.a aVar) {
        this.f45846b = aVar;
    }

    public final Object call(Object obj) {
        return this.f45846b.i((ContractRecordWrapper) obj);
    }
}
