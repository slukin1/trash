package com.hbg.module.libkt.utils;

import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import ue.b;

public final class CommonWidgetHelper$pkVote$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ b<CommonPkData> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonWidgetHelper$pkVote$2(b<CommonPkData> bVar) {
        super(2);
        this.$callback = bVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        b<CommonPkData> bVar = this.$callback;
        if (bVar != null) {
            String str = null;
            String errCode = aPIStatusErrorException != null ? aPIStatusErrorException.getErrCode() : null;
            if (aPIStatusErrorException != null) {
                str = aPIStatusErrorException.getErrMsg();
            }
            bVar.a(errCode, str);
        }
    }
}
