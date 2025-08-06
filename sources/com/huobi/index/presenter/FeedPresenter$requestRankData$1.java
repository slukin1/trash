package com.huobi.index.presenter;

import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.index.presenter.FeedPresenter;
import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FeedPresenter$requestRankData$1 extends Lambda implements l<ArrayList<LiveBannerData>, Unit> {
    public final /* synthetic */ FeedPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedPresenter$requestRankData$1(FeedPresenter feedPresenter) {
        super(1);
        this.this$0 = feedPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<LiveBannerData>) (ArrayList) obj);
        return Unit.f56620a;
    }

    public final void invoke(ArrayList<LiveBannerData> arrayList) {
        if (!b.w(arrayList)) {
            ((FeedPresenter.a) this.this$0.getUI()).F9(arrayList);
        }
    }
}
