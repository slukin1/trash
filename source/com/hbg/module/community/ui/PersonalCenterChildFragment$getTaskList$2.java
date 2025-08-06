package com.hbg.module.community.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class PersonalCenterChildFragment$getTaskList$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ PersonalCenterChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalCenterChildFragment$getTaskList$2(PersonalCenterChildFragment personalCenterChildFragment) {
        super(2);
        this.this$0 = personalCenterChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        PersonalCenterChildFragment.Th(this.this$0).C.setVisibility(8);
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }
}
