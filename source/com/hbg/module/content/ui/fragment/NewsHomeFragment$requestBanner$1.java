package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.module.content.R$dimen;
import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsHomeFragment$requestBanner$1 extends Lambda implements l<ArrayList<LiveBannerData>, Unit> {
    public final /* synthetic */ NewsHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsHomeFragment$requestBanner$1(NewsHomeFragment newsHomeFragment) {
        super(1);
        this.this$0 = newsHomeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<LiveBannerData>) (ArrayList) obj);
        return Unit.f56620a;
    }

    public final void invoke(ArrayList<LiveBannerData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            NewsHomeFragment.Vh(this.this$0).B.getLayoutParams().height = 0;
            NewsHomeFragment.Vh(this.this$0).C.getRoot().setVisibility(8);
            NewsHomeFragment.Vh(this.this$0).B.requestLayout();
        } else {
            NewsHomeFragment.Vh(this.this$0).C.getRoot().setVisibility(0);
            NewsHomeFragment.Vh(this.this$0).B.getLayoutParams().height = (int) this.this$0.getResources().getDimension(R$dimen.dimen_120);
            NewsHomeFragment.Vh(this.this$0).B.requestLayout();
            this.this$0.bi(arrayList);
        }
        NewsHomeFragment.Vh(this.this$0).G.finishRefresh();
    }
}
