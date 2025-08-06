package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewsInfoResultVO;
import d10.a;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.l;
import nc.c;

public final class NewsDetailActivity$getAdBanner$1$1$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ NewsInfoResultVO $it;
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$getAdBanner$1$1$1(NewsDetailActivity newsDetailActivity, NewsInfoResultVO newsInfoResultVO) {
        super(0);
        this.this$0 = newsDetailActivity;
        this.$it = newsInfoResultVO;
    }

    public final void invoke() {
        Pair[] pairArr = new Pair[2];
        NewFlashInformation Bh = this.this$0.f18296k;
        pairArr[0] = l.a("contentid", Bh != null ? Long.valueOf(Bh.getId()) : null);
        pairArr[1] = l.a("textId", this.$it.getTextId());
        c.a("app_news_details_resource_click", MapsKt__MapsKt.j(pairArr));
    }
}
