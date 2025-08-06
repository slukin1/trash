package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsDetailActivity$initView$9$onViewClick$1$1 extends Lambda implements l<TranslateBean, Unit> {
    public final /* synthetic */ NewFlashInformation $it;
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$initView$9$onViewClick$1$1(NewFlashInformation newFlashInformation, NewsDetailActivity newsDetailActivity) {
        super(1);
        this.$it = newFlashInformation;
        this.this$0 = newsDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TranslateBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(TranslateBean translateBean) {
        if (translateBean != null) {
            NewFlashInformation newFlashInformation = this.$it;
            NewsDetailActivity newsDetailActivity = this.this$0;
            newFlashInformation.setOldTitle(newFlashInformation.getTitle());
            newFlashInformation.setOldContent(newFlashInformation.getContent());
            newFlashInformation.setTitle(translateBean.getTitle());
            newFlashInformation.setContent(translateBean.getContent());
            newFlashInformation.setTrans(true);
            NewsDetailActivity.Dh(newsDetailActivity).O(newFlashInformation);
        }
    }
}
