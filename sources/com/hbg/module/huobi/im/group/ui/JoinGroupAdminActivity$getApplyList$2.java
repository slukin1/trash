package com.hbg.module.huobi.im.group.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class JoinGroupAdminActivity$getApplyList$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ JoinGroupAdminActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JoinGroupAdminActivity$getApplyList$2(JoinGroupAdminActivity joinGroupAdminActivity) {
        super(2);
        this.this$0 = joinGroupAdminActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
        JoinGroupAdminActivity.zh(this.this$0).E.finishRefresh();
        JoinGroupAdminActivity.zh(this.this$0).E.w();
    }
}
