package com.huobi.app.rms;

import android.util.Log;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HBRMSManager$requestConfig$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ a<Unit> $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$requestConfig$2(a<Unit> aVar) {
        super(2);
        this.$action = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            Log.e("HBRMSManager", aPIStatusErrorException.getErrMsg());
        }
        this.$action.invoke();
    }
}
