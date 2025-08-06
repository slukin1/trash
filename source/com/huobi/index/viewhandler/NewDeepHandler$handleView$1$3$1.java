package com.huobi.index.viewhandler;

import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import com.huobi.index.bean.IndexDeep;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewDeepHandler$handleView$1$3$1 extends Lambda implements l<CommentPraiseBean, Unit> {
    public final /* synthetic */ ImageView $ivLike;
    public final /* synthetic */ IndexDeep $news;
    public final /* synthetic */ TextView $tvAgree;
    public final /* synthetic */ NewDeepHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewDeepHandler$handleView$1$3$1(IndexDeep indexDeep, NewDeepHandler newDeepHandler, TextView textView, ImageView imageView) {
        super(1);
        this.$news = indexDeep;
        this.this$0 = newDeepHandler;
        this.$tvAgree = textView;
        this.$ivLike = imageView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentPraiseBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentPraiseBean commentPraiseBean) {
        if (commentPraiseBean != null) {
            IndexDeep indexDeep = this.$news;
            NewDeepHandler newDeepHandler = this.this$0;
            TextView textView = this.$tvAgree;
            ImageView imageView = this.$ivLike;
            int i11 = commentPraiseBean.praiseStatus;
            if (i11 != indexDeep.praiseStatus) {
                indexDeep.praiseStatus = i11;
                indexDeep.praiseNum = i11 == 1 ? indexDeep.praiseNum + 1 : indexDeep.praiseNum - 1;
            }
            newDeepHandler.k(textView, imageView, indexDeep);
        }
    }
}
