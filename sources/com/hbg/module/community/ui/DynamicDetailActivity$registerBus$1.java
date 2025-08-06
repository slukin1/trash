package com.hbg.module.community.ui;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.libkt.utils.event.bean.CommentNum;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DynamicDetailActivity$registerBus$1 extends Lambda implements l<CommentNum, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$registerBus$1(DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentNum) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentNum commentNum) {
        CommentListAdapter Lh;
        DynamicDetailActivity dynamicDetailActivity = this.this$0;
        if (commentNum.e() == 2) {
            DynamicDetailInfo Gh = dynamicDetailActivity.f17332n;
            if (Gh != null) {
                Gh.setCommentNum(commentNum.g());
            }
            DynamicDetailActivity.Mh(dynamicDetailActivity).M(dynamicDetailActivity.f17332n);
            if (commentNum.i()) {
                if (!commentNum.f()) {
                    return;
                }
                if (TextUtils.isEmpty(commentNum.a())) {
                    String d11 = commentNum.d();
                    if (d11 != null && (Lh = dynamicDetailActivity.f17334p) != null) {
                        Lh.A(d11);
                        return;
                    }
                    return;
                }
                CommentListAdapter Lh2 = dynamicDetailActivity.f17334p;
                if (Lh2 != null) {
                    Lh2.v(commentNum);
                }
            } else if (commentNum.c() != null && commentNum.f()) {
                CommentListAdapter Lh3 = dynamicDetailActivity.f17334p;
                if (Lh3 != null) {
                    Lh3.V(commentNum);
                }
                DynamicDetailActivity.Mh(dynamicDetailActivity).G0.setVisibility(8);
                DynamicDetailActivity.Mh(dynamicDetailActivity).H0.setVisibility(8);
            }
        }
    }
}
