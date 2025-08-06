package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DynamicDetailActivity$initTrans$1$1$1 extends Lambda implements l<TranslateBean, Unit> {
    public final /* synthetic */ DynamicDetailInfo $data;
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$initTrans$1$1$1(DynamicDetailInfo dynamicDetailInfo, DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.$data = dynamicDetailInfo;
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TranslateBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(TranslateBean translateBean) {
        if (translateBean != null) {
            DynamicDetailInfo dynamicDetailInfo = this.$data;
            DynamicDetailActivity dynamicDetailActivity = this.this$0;
            dynamicDetailInfo.setOldTitle(dynamicDetailInfo.getTitle());
            dynamicDetailInfo.setTitle(translateBean.getTitle());
            int textType = dynamicDetailInfo.getTextType();
            if (textType == 0) {
                dynamicDetailInfo.setOldContent(dynamicDetailInfo.getContent());
                dynamicDetailInfo.setContent(translateBean.getContent());
            } else if (textType != 1) {
                dynamicDetailInfo.setOldContent(dynamicDetailInfo.getContentText());
                dynamicDetailInfo.setContentText(translateBean.getContent());
                dynamicDetailActivity.Mi();
            } else {
                dynamicDetailInfo.setOldContent(dynamicDetailInfo.getRichText());
                dynamicDetailInfo.setRichText(translateBean.getContent());
                String richText = dynamicDetailInfo.getRichText();
                if (richText == null) {
                    richText = "";
                }
                dynamicDetailActivity.Ri(richText);
            }
            dynamicDetailInfo.setTrans(true);
            DynamicDetailActivity.Mh(dynamicDetailActivity).M(dynamicDetailInfo);
        }
    }
}
