package com.hbg.module.content.ui.fragment;

import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.module.content.adapter.NewsAdapter;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$getNewListBySelect$1 extends Lambda implements l<List<NewFlashInformation>, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$getNewListBySelect$1(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<NewFlashInformation>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<NewFlashInformation> list) {
        ArrayList g11;
        NewFlashInformation newFlashInformation;
        int i11 = 0;
        this.this$0.Ji(false);
        this.this$0.sh();
        NewsChildFragment.Zh(this.this$0).E.finishRefresh();
        NewsChildFragment.Zh(this.this$0).E.w();
        if (!b.w(list)) {
            NewsChildFragment.Zh(this.this$0).C.g();
            NewsAdapter ci2 = this.this$0.f18781p;
            if (ci2 != null) {
                if (!b.x(this.this$0.ni())) {
                    NewsChildFragment.Zh(this.this$0).E.w();
                    i11 = 1;
                }
                ci2.a(i11, list);
            }
            if (!(list == null || (newFlashInformation = (NewFlashInformation) CollectionsKt___CollectionsKt.m0(list)) == null)) {
                this.this$0.Ii(String.valueOf(newFlashInformation.getIssueTime()));
            }
        } else {
            if (b.x(this.this$0.ni())) {
                NewsAdapter ci3 = this.this$0.f18781p;
                if (!(ci3 == null || (g11 = ci3.g()) == null)) {
                    g11.clear();
                }
                NewsAdapter ci4 = this.this$0.f18781p;
                if (ci4 != null) {
                    ci4.notifyDataSetChanged();
                }
                if (this.this$0.f18790y != null) {
                    NewsChildFragment.Zh(this.this$0).C.setEmptyView(this.this$0.f18790y);
                }
                NewsChildFragment.Zh(this.this$0).C.i();
            }
            NewsChildFragment.Zh(this.this$0).E.e();
        }
        if (this.this$0.ti() == 1) {
            BaseModuleConfig.a().z("huobiapp_market_market_favorite_news_end", "huobiapp_market_market_favorite_news_end", OptionsBridge.NETWORK_KEY, true);
        }
        Integer Xh = this.this$0.f18785t;
        if (Xh != null && Xh.intValue() == -1 && !this.this$0.A) {
            this.this$0.A = true;
            HbgBaseApmProvider Wh = this.this$0.B;
            if (Wh != null) {
                Wh.i("huobiapp_market_content_newsflash_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
            }
        }
    }
}
