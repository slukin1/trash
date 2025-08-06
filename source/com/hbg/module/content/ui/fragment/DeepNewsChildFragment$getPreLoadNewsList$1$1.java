package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.hbg.lib.network.hbg.core.bean.DeepNewsInfo;
import com.hbg.module.content.adapter.g;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import i6.d;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DeepNewsChildFragment$getPreLoadNewsList$1$1 extends Lambda implements l<List<DeepNewsInfo>, Unit> {
    public final /* synthetic */ DeepNewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepNewsChildFragment$getPreLoadNewsList$1$1(DeepNewsChildFragment deepNewsChildFragment) {
        super(1);
        this.this$0 = deepNewsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<DeepNewsInfo>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<DeepNewsInfo> list) {
        DeepNewsInfo deepNewsInfo;
        DeepNews news;
        this.this$0.gi(false);
        d.c("ray01", "3 getPreLoadNewsList end " + this.this$0.Yh());
        if (!b.w(list)) {
            DeepNewsChildFragment.Th(this.this$0).E.y(0, true, false);
            g Zh = this.this$0.Zh();
            if (Zh != null) {
                Zh.a(1, list);
            }
            if (list != null && (deepNewsInfo = (DeepNewsInfo) CollectionsKt___CollectionsKt.m0(list)) != null && (news = deepNewsInfo.getNews()) != null) {
                this.this$0.fi(news.getIssueTime());
            }
        } else if (this.this$0.Xh() != 0) {
            d.c("ray01", "4 getPreLoadNewsList NoMoreData ");
            DeepNewsChildFragment.Th(this.this$0).E.y(0, true, true);
        }
    }
}
