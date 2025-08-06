package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommentListFragment$getCommentList$1 extends Lambda implements l<List<CommentInfo>, Unit> {
    public final /* synthetic */ CommentListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentListFragment$getCommentList$1(CommentListFragment commentListFragment) {
        super(1);
        this.this$0 = commentListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<CommentInfo>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<CommentInfo> list) {
        CommentListFragment.Th(this.this$0).D.w();
        CommentListFragment.Th(this.this$0).D.finishRefresh();
        this.this$0.sh();
        CommentListFragment.Th(this.this$0).B.g();
        if (!b.w(list)) {
            CommentListAdapter Sh = this.this$0.f17259t;
            if (Sh != null) {
                Sh.a(this.this$0.f17260u == 1 ? 0 : 1, list);
            }
            this.this$0.f17261v = ((CommentInfo) CollectionsKt___CollectionsKt.m0(list)).sortOrderScore;
            CommentListFragment commentListFragment = this.this$0;
            commentListFragment.f17260u = commentListFragment.f17260u + 1;
            return;
        }
        if (this.this$0.f17260u == 1) {
            CommentListFragment.Th(this.this$0).B.i();
        }
        CommentListFragment.Th(this.this$0).D.e();
    }
}
