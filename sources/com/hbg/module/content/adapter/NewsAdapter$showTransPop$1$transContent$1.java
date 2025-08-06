package com.hbg.module.content.adapter;

import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import com.huochat.community.widget.expandable.StatusType;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsAdapter$showTransPop$1$transContent$1 extends Lambda implements l<TranslateBean, Unit> {
    public final /* synthetic */ NewFlashInformation $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ NewsAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsAdapter$showTransPop$1$transContent$1(NewFlashInformation newFlashInformation, NewsAdapter newsAdapter, int i11) {
        super(1);
        this.$data = newFlashInformation;
        this.this$0 = newsAdapter;
        this.$position = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TranslateBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(TranslateBean translateBean) {
        if (translateBean != null) {
            NewFlashInformation newFlashInformation = this.$data;
            NewsAdapter newsAdapter = this.this$0;
            int i11 = this.$position;
            newFlashInformation.setOldTitle(newFlashInformation.getTitle());
            newFlashInformation.setOldContent(newFlashInformation.getContent());
            newFlashInformation.setTitle(translateBean.getTitle());
            newFlashInformation.setContent(translateBean.getContent());
            newFlashInformation.setTrans(true);
            newsAdapter.f17820i.put(Integer.valueOf(i11), StatusType.STATUS_CONTRACT);
            newsAdapter.notifyItemChanged(i11);
        }
    }
}
