package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class CommunityBaseCommonBinder$requestAttention$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ l<Integer, Unit> $onUpdateUI;
    public final /* synthetic */ int $type;
    public final /* synthetic */ CommunityBaseCommonBinder<CommunityFeedInfo.ListBean, l> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityBaseCommonBinder$requestAttention$1(CommunityBaseCommonBinder<CommunityFeedInfo.ListBean, l> communityBaseCommonBinder, l<? super Integer, Unit> lVar, int i11) {
        super(1);
        this.this$0 = communityBaseCommonBinder;
        this.$onUpdateUI = lVar;
        this.$type = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        a<Unit> D = this.this$0.D();
        if (D != null) {
            Unit invoke = D.invoke();
        }
        if (bool != null) {
            l<Integer, Unit> lVar = this.$onUpdateUI;
            int i11 = this.$type;
            if (bool.booleanValue()) {
                lVar.invoke(Integer.valueOf(i11));
            }
        }
    }
}
