package com.hbg.module.community.ui;

import d10.l;
import he.b;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xe.a;

public final class CommunityKLineFragment$initObservers$2 extends Lambda implements l<a, Unit> {
    public final /* synthetic */ CommunityKLineFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineFragment$initObservers$2(CommunityKLineFragment communityKLineFragment) {
        super(1);
        this.this$0 = communityKLineFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return Unit.f56620a;
    }

    public final void invoke(a aVar) {
        this.this$0.ei()[aVar.b()] = aVar.a();
        b.l(CommunityKLineFragment.Sh(this.this$0).C, String.valueOf(aVar.a()));
    }
}
