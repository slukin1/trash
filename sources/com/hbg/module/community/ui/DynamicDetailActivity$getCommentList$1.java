package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DynamicDetailActivity$getCommentList$1 extends Lambda implements l<List<CommentInfo>, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$getCommentList$1(DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<CommentInfo>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<CommentInfo> list) {
        ArrayList g11;
        DynamicDetailActivity.Mh(this.this$0).f19150e0.w();
        this.this$0.Df();
        DynamicDetailActivity.Mh(this.this$0).H0.setVisibility(8);
        if (!b.w(list)) {
            DynamicDetailActivity.Mh(this.this$0).G0.setVisibility(8);
            CommentListAdapter Lh = this.this$0.f17334p;
            if (Lh != null) {
                Lh.a(this.this$0.f17333o == 1 ? 0 : 1, list);
            }
            this.this$0.f17335q = ((CommentInfo) CollectionsKt___CollectionsKt.m0(list)).sortOrderScore;
            DynamicDetailActivity dynamicDetailActivity = this.this$0;
            dynamicDetailActivity.f17333o = dynamicDetailActivity.f17333o + 1;
        } else {
            if (this.this$0.f17333o == 1) {
                DynamicDetailActivity.Mh(this.this$0).G0.setVisibility(0);
            }
            DynamicDetailActivity.Mh(this.this$0).f19150e0.e();
        }
        CommentListAdapter Lh2 = this.this$0.f17334p;
        if (((Lh2 == null || (g11 = Lh2.g()) == null) ? 0 : g11.size()) > 0) {
            this.this$0.Ji();
        } else {
            this.this$0.Ii();
        }
        this.this$0.f17329k = false;
    }
}
