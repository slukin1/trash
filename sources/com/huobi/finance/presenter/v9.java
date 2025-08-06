package com.huobi.finance.presenter;

import com.huobi.supermargin.bean.TransferOutQuota;
import java.util.Map;
import rx.functions.Func2;

public final /* synthetic */ class v9 implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f46151b;

    public /* synthetic */ v9(UnifyTransferPresenter unifyTransferPresenter) {
        this.f46151b = unifyTransferPresenter;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f46151b.S2((TransferOutQuota) obj, (Map) obj2);
    }
}
