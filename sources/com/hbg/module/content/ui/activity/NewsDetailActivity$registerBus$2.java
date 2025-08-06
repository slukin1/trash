package com.hbg.module.content.ui.activity;

import com.hbg.module.content.adapter.CommentListAdapter;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xe.g;

public final class NewsDetailActivity$registerBus$2 extends Lambda implements l<g, Unit> {
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$registerBus$2(NewsDetailActivity newsDetailActivity) {
        super(1);
        this.this$0 = newsDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((g) obj);
        return Unit.f56620a;
    }

    public final void invoke(g gVar) {
        CommentListAdapter Ch;
        NewsDetailActivity newsDetailActivity = this.this$0;
        if (gVar.c() && (Ch = newsDetailActivity.f18299n) != null) {
            Ch.W(gVar);
        }
    }
}
