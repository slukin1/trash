package com.huobi.finance.presenter;

import com.hbg.lib.core.network.response.StringStatusResponse;
import rx.functions.Func1;

public final /* synthetic */ class a9 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f45805b;

    public /* synthetic */ a9(UnifyTransferPresenter unifyTransferPresenter) {
        this.f45805b = unifyTransferPresenter;
    }

    public final Object call(Object obj) {
        return this.f45805b.q3((StringStatusResponse) obj);
    }
}
