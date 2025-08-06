package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import xe.b;

public final class CommunityFragment$initObservers$10 extends Lambda implements l<b, Unit> {
    public final /* synthetic */ CommunityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFragment$initObservers$10(CommunityFragment communityFragment) {
        super(1);
        this.this$0 = communityFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((b) obj);
        return Unit.f56620a;
    }

    public final void invoke(b bVar) {
        this.this$0.Lh();
        List<Object> ei2 = this.this$0.ei();
        CommunityFragment communityFragment = this.this$0;
        int i11 = 0;
        for (T next : ei2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            if (next instanceof CommunityFeedInfo.ListBean) {
                CommunityFeedInfo.ListBean listBean = (CommunityFeedInfo.ListBean) next;
                if (listBean.getItemType() == 1 && x.b(bVar.a(), String.valueOf(listBean.getId()))) {
                    listBean.setPraiseStatus(bVar.c());
                    listBean.setPraiseNum(bVar.b());
                    communityFragment.di().notifyItemChanged(i11, 0);
                }
            }
            i11 = i12;
        }
        this.this$0.sh();
    }
}
