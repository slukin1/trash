package com.huobi.index.viewhandler;

import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsCommunityHandler$handleView$13$1$1 extends Lambda implements l<CommentPraiseBean, Unit> {
    public final /* synthetic */ ImageView $imageLike;
    public final /* synthetic */ CommunityFeedInfo.ListBean $item;
    public final /* synthetic */ TextView $tvLike;
    public final /* synthetic */ NewsCommunityHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsCommunityHandler$handleView$13$1$1(CommunityFeedInfo.ListBean listBean, NewsCommunityHandler newsCommunityHandler, TextView textView, ImageView imageView) {
        super(1);
        this.$item = listBean;
        this.this$0 = newsCommunityHandler;
        this.$tvLike = textView;
        this.$imageLike = imageView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentPraiseBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentPraiseBean commentPraiseBean) {
        if (commentPraiseBean != null) {
            CommunityFeedInfo.ListBean listBean = this.$item;
            NewsCommunityHandler newsCommunityHandler = this.this$0;
            TextView textView = this.$tvLike;
            ImageView imageView = this.$imageLike;
            if (commentPraiseBean.praiseStatus != listBean.getPraiseStatus()) {
                listBean.setPraiseStatus(commentPraiseBean.praiseStatus);
                listBean.setPraiseNum(commentPraiseBean.praiseStatus == 1 ? listBean.getPraiseNum() + 1 : listBean.getPraiseNum() - 1);
            }
            newsCommunityHandler.A(textView, imageView, listBean);
        }
    }
}
