package com.hbg.module.content.adapter;

import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommentListAdapter$showTransPop$1$transContent$1 extends Lambda implements l<TranslateBean, Unit> {
    public final /* synthetic */ CommentInfo $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ CommentListAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentListAdapter$showTransPop$1$transContent$1(CommentInfo commentInfo, CommentListAdapter commentListAdapter, int i11) {
        super(1);
        this.$data = commentInfo;
        this.this$0 = commentListAdapter;
        this.$position = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TranslateBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(TranslateBean translateBean) {
        if (translateBean != null) {
            CommentInfo commentInfo = this.$data;
            CommentListAdapter commentListAdapter = this.this$0;
            int i11 = this.$position;
            commentInfo.isTrans = true;
            commentInfo.oldContent = commentInfo.content;
            commentInfo.content = translateBean.getContent();
            commentListAdapter.notifyItemChanged(i11);
        }
    }
}
