package com.huobi.finance.presenter;

import com.huobi.finance.bean.ContractRecordWrapper;
import com.huobi.finance.presenter.ContractDetailPresenter;
import rx.functions.Func1;

public final /* synthetic */ class z1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractDetailPresenter.a f46199b;

    public /* synthetic */ z1(ContractDetailPresenter.a aVar) {
        this.f46199b = aVar;
    }

    public final Object call(Object obj) {
        return this.f46199b.h((ContractRecordWrapper) obj);
    }
}
