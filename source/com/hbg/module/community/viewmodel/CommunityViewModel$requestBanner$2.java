package com.hbg.module.community.viewmodel;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityViewModel$requestBanner$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ CommunityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityViewModel$requestBanner$2(CommunityViewModel communityViewModel) {
        super(2);
        this.this$0 = communityViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.m0().setValue(Boolean.FALSE);
    }
}
