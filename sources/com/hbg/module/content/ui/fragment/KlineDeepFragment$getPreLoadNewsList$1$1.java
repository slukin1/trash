package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.hbg.lib.network.hbg.core.bean.DeepNewsInfo;
import com.hbg.module.content.adapter.n;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import d10.q;
import i6.d;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class KlineDeepFragment$getPreLoadNewsList$1$1 extends Lambda implements l<List<DeepNewsInfo>, Unit> {
    public final /* synthetic */ KlineDeepFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KlineDeepFragment$getPreLoadNewsList$1$1(KlineDeepFragment klineDeepFragment) {
        super(1);
        this.this$0 = klineDeepFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<DeepNewsInfo>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<DeepNewsInfo> list) {
        DeepNewsInfo deepNewsInfo;
        DeepNewsInfo deepNewsInfo2;
        DeepNews news;
        this.this$0.ji(false);
        d.c("ray01", "3 getPreLoadNewsList end " + this.this$0.Zh());
        if (!b.w(list)) {
            q<Integer, Boolean, Boolean, Unit> Uh = this.this$0.Uh();
            if (Uh != null) {
                Uh.invoke(0, Boolean.TRUE, Boolean.FALSE);
            }
            n ai2 = this.this$0.ai();
            if (ai2 != null) {
                ai2.a(1, list);
            }
            if (!(list == null || (deepNewsInfo2 = (DeepNewsInfo) CollectionsKt___CollectionsKt.m0(list)) == null || (news = deepNewsInfo2.getNews()) == null)) {
                this.this$0.ii(news.getIssueTime());
            }
            if (list != null && (deepNewsInfo = (DeepNewsInfo) CollectionsKt___CollectionsKt.m0(list)) != null) {
                this.this$0.hi(deepNewsInfo.getDataSource());
            }
        } else if (this.this$0.Yh() != 0) {
            d.c("ray01", "4 getPreLoadNewsList NoMoreData ");
            q<Integer, Boolean, Boolean, Unit> Uh2 = this.this$0.Uh();
            if (Uh2 != null) {
                Boolean bool = Boolean.TRUE;
                Uh2.invoke(0, bool, bool);
            }
        }
    }
}
