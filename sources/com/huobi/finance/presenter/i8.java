package com.huobi.finance.presenter;

import com.hbg.lib.network.hbg.core.util.C2CTransferDirect;
import rx.functions.Action1;

public final /* synthetic */ class i8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f45924b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2CTransferDirect f45925c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f45926d;

    public /* synthetic */ i8(UnifyTransferPresenter unifyTransferPresenter, C2CTransferDirect c2CTransferDirect, String str) {
        this.f45924b = unifyTransferPresenter;
        this.f45925c = c2CTransferDirect;
        this.f45926d = str;
    }

    public final void call(Object obj) {
        this.f45924b.V2(this.f45925c, this.f45926d, obj);
    }
}
