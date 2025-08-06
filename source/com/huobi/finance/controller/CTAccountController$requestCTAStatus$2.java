package com.huobi.finance.controller;

import android.util.Log;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CTAccountController$requestCTAStatus$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public static final CTAccountController$requestCTAStatus$2 INSTANCE = new CTAccountController$requestCTAStatus$2();

    public CTAccountController$requestCTAStatus$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            Log.e("HBRMSManager", aPIStatusErrorException.getErrMsg());
        }
    }
}
