package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ l f45963b = new l();

    public final void call(Object obj) {
        d.j("addAddress", ((APIStatusErrorException) obj).getErrMsg());
    }
}
