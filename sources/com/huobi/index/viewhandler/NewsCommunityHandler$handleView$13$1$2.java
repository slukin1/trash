package com.huobi.index.viewhandler;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsCommunityHandler$handleView$13$1$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public static final NewsCommunityHandler$handleView$13$1$2 INSTANCE = new NewsCommunityHandler$handleView$13$1$2();

    public NewsCommunityHandler$handleView$13$1$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
    }
}
