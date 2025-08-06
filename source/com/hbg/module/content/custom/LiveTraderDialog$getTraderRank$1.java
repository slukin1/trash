package com.hbg.module.content.custom;

import com.hbg.lib.network.hbg.core.bean.TraderRank;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.adapter.v;
import com.hbg.module.libkt.base.ext.b;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import lc.m0;

public final class LiveTraderDialog$getTraderRank$1 extends Lambda implements l<TraderRank, Unit> {
    public final /* synthetic */ LiveTraderDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveTraderDialog$getTraderRank$1(LiveTraderDialog liveTraderDialog) {
        super(1);
        this.this$0 = liveTraderDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TraderRank) obj);
        return Unit.f56620a;
    }

    public final void invoke(TraderRank traderRank) {
        SmartRefreshLayout smartRefreshLayout;
        LoadingLayout loadingLayout;
        LoadingLayout loadingLayout2;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        m0 uh2 = this.this$0.uh();
        if (!(uh2 == null || (smartRefreshLayout3 = uh2.G) == null)) {
            smartRefreshLayout3.finishRefresh();
        }
        m0 uh3 = this.this$0.uh();
        if (!(uh3 == null || (smartRefreshLayout2 = uh3.G) == null)) {
            smartRefreshLayout2.w();
        }
        if (!b.w(traderRank != null ? traderRank.itemList : null)) {
            m0 uh4 = this.this$0.uh();
            if (!(uh4 == null || (loadingLayout2 = uh4.D) == null)) {
                loadingLayout2.g();
            }
            v sh2 = this.this$0.sh();
            if (sh2 != null) {
                sh2.a(this.this$0.wh() == 1 ? 0 : 1, traderRank.itemList);
            }
            LiveTraderDialog liveTraderDialog = this.this$0;
            liveTraderDialog.Ch(liveTraderDialog.wh() + 1);
        } else if (this.this$0.wh() == 1) {
            m0 uh5 = this.this$0.uh();
            if (uh5 != null && (loadingLayout = uh5.D) != null) {
                loadingLayout.i();
            }
        } else {
            m0 uh6 = this.this$0.uh();
            if (uh6 != null && (smartRefreshLayout = uh6.G) != null) {
                smartRefreshLayout.e();
            }
        }
    }
}
