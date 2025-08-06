package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.adapter.CommentListAdapter;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommentDetailActivity$getCommentList$1 extends Lambda implements l<List<CommentInfo>, Unit> {
    public final /* synthetic */ CommentDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentDetailActivity$getCommentList$1(CommentDetailActivity commentDetailActivity) {
        super(1);
        this.this$0 = commentDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<CommentInfo>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<CommentInfo> list) {
        this.this$0.Df();
        CommentDetailActivity.Eh(this.this$0).J.finishRefresh();
        CommentDetailActivity.Eh(this.this$0).J.w();
        if (list == null) {
            list = CollectionsKt__CollectionsKt.k();
        }
        if (!list.isEmpty()) {
            CommentDetailActivity.Eh(this.this$0).I.g();
            CommentInfo commentInfo = (CommentInfo) CollectionsKt___CollectionsKt.a0(list);
            if (this.this$0.f18262p == 1) {
                this.this$0.f18259m = commentInfo;
                CommentDetailActivity.Eh(this.this$0).M(commentInfo);
                this.this$0.Wh();
            }
            List<CommentInfo> list2 = commentInfo.children;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.k();
            }
            if (list2.isEmpty()) {
                CommentDetailActivity.Eh(this.this$0).J.setNoMoreData(true);
                return;
            }
            int i11 = this.this$0.f18262p == 1 ? 0 : 1;
            CommentListAdapter Dh = this.this$0.f18260n;
            if (Dh != null) {
                Dh.a(i11, list2);
            }
            this.this$0.f18261o = ((CommentInfo) CollectionsKt___CollectionsKt.m0(list2)).sortOrderScore;
            CommentDetailActivity commentDetailActivity = this.this$0;
            commentDetailActivity.f18262p = commentDetailActivity.f18262p + 1;
            if (list2.size() < 20) {
                CommentDetailActivity.Eh(this.this$0).J.setNoMoreData(true);
            }
        } else if (this.this$0.f18262p == 1) {
            CommentDetailActivity.Eh(this.this$0).I.k();
        }
    }
}
