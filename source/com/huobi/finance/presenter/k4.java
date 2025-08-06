package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class k4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoanSymbolDetailPresenter f45954b;

    public /* synthetic */ k4(LoanSymbolDetailPresenter loanSymbolDetailPresenter) {
        this.f45954b = loanSymbolDetailPresenter;
    }

    public final void call(Object obj) {
        this.f45954b.W((APIStatusErrorException) obj);
    }
}
