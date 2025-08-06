package com.hbg.module.content.ui.fragment;

import com.hbg.module.content.adapter.NewsAdapter;
import com.hbg.module.libkt.utils.event.bean.CommentNum;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$registerBus$2 extends Lambda implements l<CommentNum, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$registerBus$2(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentNum) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentNum commentNum) {
        NewsAdapter ci2;
        NewsChildFragment newsChildFragment = this.this$0;
        if (commentNum.e() == 1 && (ci2 = newsChildFragment.f18781p) != null) {
            ci2.A(commentNum);
        }
    }
}
