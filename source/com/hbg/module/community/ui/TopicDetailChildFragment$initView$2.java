package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import xe.e;

public final class TopicDetailChildFragment$initView$2 extends Lambda implements l<e, Unit> {
    public final /* synthetic */ TopicDetailChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicDetailChildFragment$initView$2(TopicDetailChildFragment topicDetailChildFragment) {
        super(1);
        this.this$0 = topicDetailChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((e) obj);
        return Unit.f56620a;
    }

    public final void invoke(e eVar) {
        List Uh = this.this$0.f17543u;
        TopicDetailChildFragment topicDetailChildFragment = this.this$0;
        int i11 = 0;
        for (Object next : Uh) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            CommunityFeedInfo.ListBean listBean = (CommunityFeedInfo.ListBean) next;
            if (x.b(listBean.getUidUnique(), eVar.b())) {
                listBean.setFocusStatus(eVar.a());
                MultiTypeAdapter Sh = topicDetailChildFragment.f17544v;
                if (Sh == null) {
                    Sh = null;
                }
                Sh.notifyItemChanged(i11);
            }
            i11 = i12;
        }
    }
}
