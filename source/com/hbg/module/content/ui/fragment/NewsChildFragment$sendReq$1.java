package com.hbg.module.content.ui.fragment;

import android.os.Handler;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.module.content.adapter.NewsAdapter;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$sendReq$1 extends Lambda implements l<List<? extends NewFlashInformation>, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$sendReq$1(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2(NewsChildFragment newsChildFragment) {
        newsChildFragment.Li();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends NewFlashInformation>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<? extends NewFlashInformation> list) {
        Handler ai2;
        NewFlashInformation newFlashInformation;
        NewFlashInformation newFlashInformation2;
        this.this$0.Ji(false);
        this.this$0.sh();
        NewsChildFragment.Zh(this.this$0).E.finishRefresh();
        NewsChildFragment.Zh(this.this$0).E.w();
        this.this$0.Fi(60000);
        if (!b.w(list)) {
            NewsChildFragment.Zh(this.this$0).C.g();
            NewsAdapter ci2 = this.this$0.f18781p;
            if (ci2 != null) {
                ci2.a(b.x(this.this$0.ni()) ^ true ? 1 : 0, list);
            }
            if (!(list == null || (newFlashInformation2 = (NewFlashInformation) CollectionsKt___CollectionsKt.m0(list)) == null)) {
                this.this$0.Ii(String.valueOf(newFlashInformation2.getIssueTime()));
            }
            if (!(list == null || (newFlashInformation = (NewFlashInformation) CollectionsKt___CollectionsKt.m0(list)) == null)) {
                this.this$0.Hi(newFlashInformation.getLanguageId());
            }
            Integer Xh = this.this$0.f18785t;
            if ((Xh == null || Xh.intValue() != -100) && (ai2 = this.this$0.vh()) != null) {
                ai2.postDelayed(new m(this.this$0), 500);
            }
        } else if (b.x(this.this$0.ni())) {
            if (this.this$0.f18790y != null) {
                NewsChildFragment.Zh(this.this$0).C.setEmptyView(this.this$0.f18790y);
            }
            NewsChildFragment.Zh(this.this$0).C.i();
        } else {
            NewsChildFragment.Zh(this.this$0).E.e();
        }
        Integer Xh2 = this.this$0.f18785t;
        if (Xh2 != null && Xh2.intValue() == -1 && !this.this$0.A) {
            this.this$0.A = true;
            HbgBaseApmProvider Wh = this.this$0.B;
            if (Wh != null) {
                Wh.i("huobiapp_market_content_newsflash_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
            }
        }
    }
}
