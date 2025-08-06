package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class u8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ u8 f46136b = new u8();

    public final void call(Object obj) {
        UnifyTransferPresenter.z2((APIStatusErrorException) obj);
    }
}
