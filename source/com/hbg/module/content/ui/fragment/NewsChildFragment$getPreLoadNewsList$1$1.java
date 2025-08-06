package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.module.content.adapter.NewsAdapter;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import i6.d;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class NewsChildFragment$getPreLoadNewsList$1$1 extends Lambda implements l<List<NewFlashInformation>, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$getPreLoadNewsList$1$1(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<NewFlashInformation>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<NewFlashInformation> list) {
        NewFlashInformation newFlashInformation;
        this.this$0.Ji(false);
        d.c("ray01", "2 getPreLoadNewsList end " + this.this$0.oi());
        if (!b.w(list)) {
            NewsChildFragment.Zh(this.this$0).E.y(0, true, false);
            NewsAdapter ci2 = this.this$0.f18781p;
            if (ci2 != null) {
                ci2.a(1, list);
            }
            if (list != null && (newFlashInformation = (NewFlashInformation) CollectionsKt___CollectionsKt.m0(list)) != null) {
                this.this$0.Ii(String.valueOf(newFlashInformation.getIssueTime()));
            }
        } else if (!b.x(this.this$0.ni())) {
            NewsChildFragment.Zh(this.this$0).E.y(0, true, true);
        }
    }
}
