package com.hbg.module.content.ui.activity;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.libkt.utils.event.bean.CommentNum;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsDetailActivity$registerBus$1 extends Lambda implements l<CommentNum, Unit> {
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$registerBus$1(NewsDetailActivity newsDetailActivity) {
        super(1);
        this.this$0 = newsDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentNum) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentNum commentNum) {
        CommentListAdapter Ch;
        NewsDetailActivity newsDetailActivity = this.this$0;
        if (commentNum.e() == 1) {
            NewFlashInformation Bh = newsDetailActivity.f18296k;
            if (Bh != null) {
                Bh.setComments(commentNum.g());
            }
            NewsDetailActivity.Dh(newsDetailActivity).O(newsDetailActivity.f18296k);
            if (commentNum.i()) {
                if (!commentNum.f()) {
                    return;
                }
                if (TextUtils.isEmpty(commentNum.a())) {
                    String d11 = commentNum.d();
                    if (d11 != null && (Ch = newsDetailActivity.f18299n) != null) {
                        Ch.A(d11);
                        return;
                    }
                    return;
                }
                CommentListAdapter Ch2 = newsDetailActivity.f18299n;
                if (Ch2 != null) {
                    Ch2.v(commentNum);
                }
            } else if (commentNum.c() != null && commentNum.f()) {
                CommentListAdapter Ch3 = newsDetailActivity.f18299n;
                if (Ch3 != null) {
                    Ch3.V(commentNum);
                }
                NewsDetailActivity.Dh(newsDetailActivity).f19308m0.setVisibility(8);
                NewsDetailActivity.Dh(newsDetailActivity).f19309n0.setVisibility(8);
            }
        }
    }
}
