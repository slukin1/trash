package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.hbg.lib.network.hbg.core.bean.DeepNewsInfo;
import com.hbg.module.content.adapter.g;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DeepNewsChildFragment$getNewsList$1$1 extends Lambda implements l<List<DeepNewsInfo>, Unit> {
    public final /* synthetic */ DeepNewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepNewsChildFragment$getNewsList$1$1(DeepNewsChildFragment deepNewsChildFragment) {
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
        int i11 = 0;
        this.this$0.gi(false);
        this.this$0.sh();
        DeepNewsChildFragment.Th(this.this$0).E.finishRefresh();
        if (!b.w(list)) {
            DeepNewsChildFragment.Th(this.this$0).C.g();
            g Zh = this.this$0.Zh();
            if (Zh != null) {
                if (this.this$0.Xh() != 0) {
                    DeepNewsChildFragment.Th(this.this$0).E.w();
                    i11 = 1;
                }
                Zh.a(i11, list);
            }
            if (!(list == null || (deepNewsInfo = (DeepNewsInfo) CollectionsKt___CollectionsKt.m0(list)) == null || (news = deepNewsInfo.getNews()) == null)) {
                this.this$0.fi(news.getIssueTime());
            }
        } else if (this.this$0.Xh() == 0) {
            DeepNewsChildFragment.Th(this.this$0).C.i();
        } else {
            DeepNewsChildFragment.Th(this.this$0).E.e();
        }
        Integer Wh = this.this$0.Wh();
        if (Wh != null && Wh.intValue() == -1 && !this.this$0.f18738v) {
            this.this$0.f18738v = true;
            HbgBaseApmProvider Sh = this.this$0.f18739w;
            if (Sh != null) {
                Sh.i("huobiapp_market_content_deep_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
            }
        }
    }
}
