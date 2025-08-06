package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.CommentDelBean;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import we.c;

public final class CommentDetailActivity$sendDelRequest$1 extends Lambda implements l<CommentDelBean, Unit> {
    public final /* synthetic */ CommentDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentDetailActivity$sendDelRequest$1(CommentDetailActivity commentDetailActivity) {
        super(1);
        this.this$0 = commentDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentDelBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentDelBean commentDelBean) {
        if (!b.x(this.this$0.f18255i)) {
            c cVar = c.f26319a;
            int i11 = x.b(this.this$0.f18256j, "1") ? 1 : 2;
            String Gh = this.this$0.f18255i;
            c.o(i11, (Gh != null ? Long.valueOf(Long.parseLong(Gh)) : null).longValue(), this.this$0.f18257k, 0, 0, (CommentInfo) null, true, true, (String) null, 312, (Object) null);
        }
        this.this$0.finish();
    }
}
