package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsDetailActivity$getCommentList$1 extends Lambda implements l<List<CommentInfo>, Unit> {
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$getCommentList$1(NewsDetailActivity newsDetailActivity) {
        super(1);
        this.this$0 = newsDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<CommentInfo>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<CommentInfo> list) {
        ArrayList g11;
        NewsDetailActivity.Dh(this.this$0).Z.w();
        this.this$0.Df();
        NewsDetailActivity.Dh(this.this$0).f19309n0.setVisibility(8);
        if (!b.w(list)) {
            NewsDetailActivity.Dh(this.this$0).f19308m0.setVisibility(8);
            CommentListAdapter Ch = this.this$0.f18299n;
            if (Ch != null) {
                Ch.a(this.this$0.f18298m == 1 ? 0 : 1, list);
            }
            this.this$0.f18297l = ((CommentInfo) CollectionsKt___CollectionsKt.m0(list)).sortOrderScore;
            NewsDetailActivity newsDetailActivity = this.this$0;
            newsDetailActivity.f18298m = newsDetailActivity.f18298m + 1;
        } else {
            if (this.this$0.f18298m == 1) {
                NewsDetailActivity.Dh(this.this$0).f19308m0.setVisibility(0);
            }
            NewsDetailActivity.Dh(this.this$0).Z.e();
        }
        CommentListAdapter Ch2 = this.this$0.f18299n;
        if (((Ch2 == null || (g11 = Ch2.g()) == null) ? 0 : g11.size()) > 0) {
            this.this$0.di();
        } else {
            this.this$0.ci();
        }
        this.this$0.f18303r = false;
    }
}
