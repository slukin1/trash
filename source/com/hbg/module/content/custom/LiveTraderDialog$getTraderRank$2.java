package com.hbg.module.content.custom;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import lc.m0;

public final class LiveTraderDialog$getTraderRank$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ LiveTraderDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveTraderDialog$getTraderRank$2(LiveTraderDialog liveTraderDialog) {
        super(2);
        this.this$0 = liveTraderDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        m0 uh2;
        LoadingLayout loadingLayout;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        m0 uh3 = this.this$0.uh();
        if (!(uh3 == null || (smartRefreshLayout2 = uh3.G) == null)) {
            smartRefreshLayout2.finishRefresh();
        }
        m0 uh4 = this.this$0.uh();
        if (!(uh4 == null || (smartRefreshLayout = uh4.G) == null)) {
            smartRefreshLayout.w();
        }
        if (this.this$0.wh() == 1 && (uh2 = this.this$0.uh()) != null && (loadingLayout = uh2.D) != null) {
            loadingLayout.k();
        }
    }
}
