package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xe.c;

public final class PersonalCenterChildFragment$initView$1 extends Lambda implements l<c, Unit> {
    public final /* synthetic */ PersonalCenterChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalCenterChildFragment$initView$1(PersonalCenterChildFragment personalCenterChildFragment) {
        super(1);
        this.this$0 = personalCenterChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((c) obj);
        return Unit.f56620a;
    }

    public final void invoke(c cVar) {
        CommunityFeedInfo.ListBean listBean = new CommunityFeedInfo.ListBean();
        listBean.setId(Integer.parseInt(cVar.a()));
        int indexOf = this.this$0.f17485t.indexOf(listBean);
        if (indexOf >= 0) {
            this.this$0.f17485t.remove(indexOf);
            MultiTypeAdapter Sh = this.this$0.f17486u;
            MultiTypeAdapter multiTypeAdapter = null;
            if (Sh == null) {
                Sh = null;
            }
            Sh.setItems(this.this$0.f17485t);
            MultiTypeAdapter Sh2 = this.this$0.f17486u;
            if (Sh2 != null) {
                multiTypeAdapter = Sh2;
            }
            multiTypeAdapter.notifyItemRemoved(indexOf);
        }
    }
}
