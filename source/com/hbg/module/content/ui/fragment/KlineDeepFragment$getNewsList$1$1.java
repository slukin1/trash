package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.hbg.lib.network.hbg.core.bean.DeepNewsInfo;
import com.hbg.module.content.adapter.n;
import com.hbg.module.libkt.base.ext.b;
import d10.a;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class KlineDeepFragment$getNewsList$1$1 extends Lambda implements l<List<DeepNewsInfo>, Unit> {
    public final /* synthetic */ KlineDeepFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KlineDeepFragment$getNewsList$1$1(KlineDeepFragment klineDeepFragment) {
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
        int i11 = 0;
        this.this$0.ji(false);
        this.this$0.sh();
        a<Unit> Xh = this.this$0.Xh();
        if (Xh != null) {
            Xh.invoke();
        }
        if (!b.w(list)) {
            KlineDeepFragment.Sh(this.this$0).B.g();
            n ai2 = this.this$0.ai();
            if (ai2 != null) {
                if (this.this$0.Yh() != 0) {
                    a<Unit> Vh = this.this$0.Vh();
                    if (Vh != null) {
                        Vh.invoke();
                    }
                    i11 = 1;
                }
                ai2.a(i11, list);
            }
            if (!(list == null || (deepNewsInfo2 = (DeepNewsInfo) CollectionsKt___CollectionsKt.m0(list)) == null || (news = deepNewsInfo2.getNews()) == null)) {
                this.this$0.ii(news.getIssueTime());
            }
            if (list != null && (deepNewsInfo = (DeepNewsInfo) CollectionsKt___CollectionsKt.m0(list)) != null) {
                this.this$0.hi(deepNewsInfo.getDataSource());
            }
        } else if (this.this$0.Yh() == 0) {
            KlineDeepFragment.Sh(this.this$0).B.i();
        } else {
            a<Unit> Wh = this.this$0.Wh();
            if (Wh != null) {
                Wh.invoke();
            }
        }
    }
}
