package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class CommunityBaseCommonBinder$requestAttention$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ CommunityBaseCommonBinder<CommunityFeedInfo.ListBean, l> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityBaseCommonBinder$requestAttention$2(CommunityBaseCommonBinder<CommunityFeedInfo.ListBean, l> communityBaseCommonBinder) {
        super(2);
        this.this$0 = communityBaseCommonBinder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        a<Unit> D = this.this$0.D();
        if (D != null) {
            Unit invoke = D.invoke();
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
    }
}
