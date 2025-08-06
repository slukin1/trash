package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xe.c;

public final class TopicDetailChildFragment$initView$1 extends Lambda implements l<c, Unit> {
    public final /* synthetic */ TopicDetailChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicDetailChildFragment$initView$1(TopicDetailChildFragment topicDetailChildFragment) {
        super(1);
        this.this$0 = topicDetailChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((c) obj);
        return Unit.f56620a;
    }

    public final void invoke(c cVar) {
        CommunityFeedInfo.ListBean listBean = new CommunityFeedInfo.ListBean();
        listBean.setId(Integer.parseInt(cVar.a()));
        int indexOf = this.this$0.f17543u.indexOf(listBean);
        if (indexOf >= 0) {
            this.this$0.f17543u.remove(indexOf);
            MultiTypeAdapter Sh = this.this$0.f17544v;
            MultiTypeAdapter multiTypeAdapter = null;
            if (Sh == null) {
                Sh = null;
            }
            Sh.setItems(this.this$0.f17543u);
            MultiTypeAdapter Sh2 = this.this$0.f17544v;
            if (Sh2 != null) {
                multiTypeAdapter = Sh2;
            }
            multiTypeAdapter.notifyItemRemoved(indexOf);
        }
    }
}
