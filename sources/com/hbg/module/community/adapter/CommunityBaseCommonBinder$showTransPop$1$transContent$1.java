package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.huochat.community.widget.expandable.StatusType;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityBaseCommonBinder$showTransPop$1$transContent$1 extends Lambda implements l<TranslateBean, Unit> {
    public final /* synthetic */ CommunityFeedInfo.ListBean $data;
    public final /* synthetic */ CommunityBaseCommonBinder.a $holder;
    public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityBaseCommonBinder$showTransPop$1$transContent$1(CommunityFeedInfo.ListBean listBean, CommunityBaseCommonBinder.a aVar, CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder) {
        super(1);
        this.$data = listBean;
        this.$holder = aVar;
        this.this$0 = communityBaseCommonBinder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TranslateBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(TranslateBean translateBean) {
        String str;
        if (translateBean != null) {
            CommunityFeedInfo.ListBean listBean = this.$data;
            CommunityBaseCommonBinder.a aVar = this.$holder;
            CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder = this.this$0;
            listBean.setOldTitle(listBean.getTitle());
            if (listBean.getTextType() == 2) {
                str = listBean.getContentText();
            } else {
                str = listBean.getContent();
            }
            listBean.setOldContent(str);
            listBean.setTitle(translateBean.getTitle());
            listBean.setContent(translateBean.getContent());
            listBean.setContentText(translateBean.getContent());
            listBean.setTrans(true);
            aVar.e().f19335f0.setText(listBean.getTitle());
            if (listBean.getTextType() == 2) {
                communityBaseCommonBinder.c0(listBean, aVar);
            } else {
                aVar.e().Y.setContent((CharSequence) listBean.getContent(), (StatusType) null);
            }
        }
    }
}
