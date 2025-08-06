package com.huobi.kyc.presenter;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.kyc.util.KycProxy;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ g f74844b = new g();

    public final Object call(Object obj) {
        return KycProxy.l().j().map(new d((UserKycInfoNew) obj));
    }
}
