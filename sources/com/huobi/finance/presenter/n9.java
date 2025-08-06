package com.huobi.finance.presenter;

import com.hbg.lib.network.hbg.core.bean.CopyTradingAssetInfo;
import rx.functions.Func1;

public final /* synthetic */ class n9 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f46018b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f46019c;

    public /* synthetic */ n9(UnifyTransferPresenter unifyTransferPresenter, int i11) {
        this.f46018b = unifyTransferPresenter;
        this.f46019c = i11;
    }

    public final Object call(Object obj) {
        return this.f46018b.H2(this.f46019c, (CopyTradingAssetInfo) obj);
    }
}
