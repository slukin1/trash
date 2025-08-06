package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewsInfoResultVO;
import com.hbg.module.content.widgets.ad.a;
import d10.l;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import nc.c;

public final class NewsDetailActivity$getAdBanner$1 extends Lambda implements l<NewsInfoResultVO, Unit> {
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$getAdBanner$1(NewsDetailActivity newsDetailActivity) {
        super(1);
        this.this$0 = newsDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NewsInfoResultVO) obj);
        return Unit.f56620a;
    }

    public final void invoke(NewsInfoResultVO newsInfoResultVO) {
        if (newsInfoResultVO != null) {
            NewsDetailActivity newsDetailActivity = this.this$0;
            if (x.b(newsInfoResultVO.getIsShow(), "1")) {
                NewsDetailActivity.Dh(newsDetailActivity).B.setAdType(1);
                a adDelegate = NewsDetailActivity.Dh(newsDetailActivity).B.getAdDelegate();
                if (adDelegate != null) {
                    adDelegate.a(newsInfoResultVO.getText());
                }
                a adDelegate2 = NewsDetailActivity.Dh(newsDetailActivity).B.getAdDelegate();
                if (adDelegate2 != null) {
                    adDelegate2.g(newsInfoResultVO.getIcon());
                }
                a adDelegate3 = NewsDetailActivity.Dh(newsDetailActivity).B.getAdDelegate();
                if (adDelegate3 != null) {
                    adDelegate3.e(newsInfoResultVO.getButton());
                }
                a adDelegate4 = NewsDetailActivity.Dh(newsDetailActivity).B.getAdDelegate();
                if (adDelegate4 != null) {
                    adDelegate4.f(newsInfoResultVO.getUrl());
                }
                a adDelegate5 = NewsDetailActivity.Dh(newsDetailActivity).B.getAdDelegate();
                if (adDelegate5 != null) {
                    adDelegate5.h(new NewsDetailActivity$getAdBanner$1$1$1(newsDetailActivity, newsInfoResultVO));
                }
                NewsDetailActivity.Dh(newsDetailActivity).B.i();
                Pair[] pairArr = new Pair[2];
                NewFlashInformation Bh = newsDetailActivity.f18296k;
                pairArr[0] = kotlin.l.a("contentid", Bh != null ? Long.valueOf(Bh.getId()) : null);
                pairArr[1] = kotlin.l.a("textId", newsInfoResultVO.getTextId());
                c.a("app_news_details_resource_show", MapsKt__MapsKt.j(pairArr));
                return;
            }
            NewsDetailActivity.Dh(newsDetailActivity).B.h();
        }
    }
}
