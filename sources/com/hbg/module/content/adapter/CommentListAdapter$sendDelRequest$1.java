package com.hbg.module.content.adapter;

import com.hbg.lib.network.hbg.core.bean.CommentDelBean;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import we.c;

public final class CommentListAdapter$sendDelRequest$1 extends Lambda implements l<CommentDelBean, Unit> {
    public final /* synthetic */ Integer $childPos;
    public final /* synthetic */ String $cid;
    public final /* synthetic */ int $pos;
    public final /* synthetic */ CommentListAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentListAdapter$sendDelRequest$1(Integer num, CommentListAdapter commentListAdapter, int i11, String str) {
        super(1);
        this.$childPos = num;
        this.this$0 = commentListAdapter;
        this.$pos = i11;
        this.$cid = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentDelBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentDelBean commentDelBean) {
        if (this.$childPos == null) {
            this.this$0.g().remove(this.$pos);
            this.this$0.notifyDataSetChanged();
        } else {
            ((CommentInfo) this.this$0.g().get(this.$pos)).children.remove(this.$childPos.intValue());
            this.this$0.notifyItemChanged(this.$pos);
        }
        if (!b.x(this.this$0.D())) {
            c cVar = c.f26319a;
            int i11 = x.b(this.this$0.E(), "1") ? 1 : 2;
            String D = this.this$0.D();
            c.o(i11, (D != null ? Long.valueOf(Long.parseLong(D)) : null).longValue(), this.this$0.B(), commentDelBean != null ? commentDelBean.commentNum : 0, 0, (CommentInfo) null, this.this$0.I(), true, this.$cid, 48, (Object) null);
        }
    }
}
