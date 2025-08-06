package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityViewModel$requestFeedInfoByKline$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ int $loadStatus;
    public final /* synthetic */ CommunityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityViewModel$requestFeedInfoByKline$2(CommunityViewModel communityViewModel, int i11) {
        super(2);
        this.this$0 = communityViewModel;
        this.$loadStatus = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
        MutableLiveData<Boolean> l02 = this.this$0.l0();
        int i11 = this.$loadStatus;
        boolean z11 = true;
        if (!(i11 == 1 || i11 == -1)) {
            z11 = false;
        }
        l02.setValue(Boolean.valueOf(z11));
    }
}
