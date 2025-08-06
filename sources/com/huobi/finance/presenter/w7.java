package com.huobi.finance.presenter;

import com.hbg.lib.network.pro.core.bean.SuperMarginTransferLimit;
import rx.functions.Action1;

public final /* synthetic */ class w7 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f46163b;

    public /* synthetic */ w7(UnifyTransferPresenter unifyTransferPresenter) {
        this.f46163b = unifyTransferPresenter;
    }

    public final void call(Object obj) {
        this.f46163b.O4((SuperMarginTransferLimit) obj);
    }
}
