package com.huobi.index.viewhandler;

import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsCommunityHandler$showTransPop$1$transContent$1 extends Lambda implements l<TranslateBean, Unit> {
    public final /* synthetic */ CommunityFeedInfo.ListBean $data;
    public final /* synthetic */ ExpandableTextView $tvContent;
    public final /* synthetic */ TextView $tvTitle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsCommunityHandler$showTransPop$1$transContent$1(CommunityFeedInfo.ListBean listBean, TextView textView, ExpandableTextView expandableTextView) {
        super(1);
        this.$data = listBean;
        this.$tvTitle = textView;
        this.$tvContent = expandableTextView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TranslateBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(TranslateBean translateBean) {
        if (translateBean != null) {
            CommunityFeedInfo.ListBean listBean = this.$data;
            TextView textView = this.$tvTitle;
            ExpandableTextView expandableTextView = this.$tvContent;
            listBean.setOldTitle(listBean.getTitle());
            listBean.setOldContent(listBean.getContent());
            listBean.setTitle(translateBean.getTitle());
            listBean.setContent(translateBean.getContent());
            listBean.setTrans(true);
            textView.setText(listBean.getTitle());
            expandableTextView.setContent((CharSequence) listBean.getContent(), (StatusType) null);
        }
    }
}
