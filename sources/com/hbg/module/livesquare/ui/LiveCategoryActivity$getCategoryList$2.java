package com.hbg.module.livesquare.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveCategoryActivity$getCategoryList$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ LiveCategoryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveCategoryActivity$getCategoryList$2(LiveCategoryActivity liveCategoryActivity) {
        super(2);
        this.this$0 = liveCategoryActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
        LiveCategoryActivity.zh(this.this$0).C.k();
    }
}
