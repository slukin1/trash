package com.huobi.finance.presenter;

import com.huobi.finance.bean.ContractRecordWrapper;
import com.huobi.finance.presenter.ContractFinanceRecordPresenter;
import rx.functions.Func1;

public final /* synthetic */ class c2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractFinanceRecordPresenter.a f45831b;

    public /* synthetic */ c2(ContractFinanceRecordPresenter.a aVar) {
        this.f45831b = aVar;
    }

    public final Object call(Object obj) {
        return this.f45831b.h((ContractRecordWrapper) obj);
    }
}
