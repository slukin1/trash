package com.hbg.module.content.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.c;

public final class CommentListAdapter$praise$1 extends Lambda implements l<CommentPraiseBean, Unit> {
    public final /* synthetic */ Integer $childPos;
    public final /* synthetic */ String $cid;
    public final /* synthetic */ ImageView $imageLike;
    public final /* synthetic */ int $pos;
    public final /* synthetic */ TextView $tvLike;
    public final /* synthetic */ CommentListAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentListAdapter$praise$1(Integer num, CommentListAdapter commentListAdapter, int i11, String str, ImageView imageView, TextView textView) {
        super(1);
        this.$childPos = num;
        this.this$0 = commentListAdapter;
        this.$pos = i11;
        this.$cid = str;
        this.$imageLike = imageView;
        this.$tvLike = textView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentPraiseBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentPraiseBean commentPraiseBean) {
        CommentInfo commentInfo;
        if (commentPraiseBean != null) {
            Integer num = this.$childPos;
            CommentListAdapter commentListAdapter = this.this$0;
            int i11 = this.$pos;
            String str = this.$cid;
            ImageView imageView = this.$imageLike;
            TextView textView = this.$tvLike;
            if (num == null) {
                commentInfo = (CommentInfo) commentListAdapter.g().get(i11);
            } else {
                commentInfo = ((CommentInfo) commentListAdapter.g().get(i11)).children.get(num.intValue());
            }
            commentInfo.parseNums = commentPraiseBean.praiseNum;
            commentInfo.parseStatus = commentPraiseBean.praiseStatus;
            if (commentListAdapter.I()) {
                c.y(commentListAdapter.B(), str, commentPraiseBean.praiseNum, commentPraiseBean.praiseStatus, true);
            }
            int i12 = commentPraiseBean.praiseStatus;
            if (i12 == 0) {
                commentListAdapter.Q(imageView, textView, i12, commentPraiseBean.praiseNum, false, i11);
                return;
            }
            commentListAdapter.Q(imageView, textView, i12, commentPraiseBean.praiseNum, true, i11);
        }
    }
}
