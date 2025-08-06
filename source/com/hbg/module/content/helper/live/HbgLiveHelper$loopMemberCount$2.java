package com.hbg.module.content.helper.live;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HbgLiveHelper$loopMemberCount$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public static final HbgLiveHelper$loopMemberCount$2 INSTANCE = new HbgLiveHelper$loopMemberCount$2();

    public HbgLiveHelper$loopMemberCount$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getMessage());
        }
    }
}
