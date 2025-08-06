package com.huobi.finance.presenter;

import com.huobi.finance.bean.ContractRecordWrapper;
import com.huobi.finance.presenter.ContractDetailPresenter;
import rx.functions.Func1;

public final /* synthetic */ class a2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractDetailPresenter.a f45798b;

    public /* synthetic */ a2(ContractDetailPresenter.a aVar) {
        this.f45798b = aVar;
    }

    public final Object call(Object obj) {
        return this.f45798b.i((ContractRecordWrapper) obj);
    }
}
