package com.hbg.module.content.ui.activity.live.rank;

import com.hbg.lib.network.hbg.core.bean.LiveGiftRank;
import com.hbg.module.content.adapter.i;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class GiftRankFragment$initVM$1 extends Lambda implements l<VmState<? extends LiveGiftRank>, Unit> {
    public final /* synthetic */ GiftRankFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GiftRankFragment$initVM$1(GiftRankFragment giftRankFragment) {
        super(1);
        this.this$0 = giftRankFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends LiveGiftRank>) (VmState) obj);
        return Unit.f56620a;
    }

    public final void invoke(VmState<? extends LiveGiftRank> vmState) {
        if (vmState instanceof VmState.b) {
            LiveGiftRank liveGiftRank = (LiveGiftRank) ((VmState.b) vmState).a();
            Unit unit = null;
            if (liveGiftRank != null) {
                GiftRankFragment giftRankFragment = this.this$0;
                if (b.w(liveGiftRank.topList)) {
                    GiftRankFragment.Th(giftRankFragment).D.i();
                } else {
                    if (liveGiftRank.myself != null) {
                        if (giftRankFragment.f18690q == 1) {
                            GiftRankFragment.Th(giftRankFragment).M(liveGiftRank.myself);
                            GiftRankFragment.Th(giftRankFragment).C.setVisibility(0);
                        }
                        unit = Unit.f56620a;
                    }
                    if (unit == null) {
                        GiftRankFragment.Th(giftRankFragment).C.setVisibility(8);
                    }
                    i iVar = new i(giftRankFragment.requireActivity(), giftRankFragment.f18690q);
                    GiftRankFragment.Th(giftRankFragment).E.setLayoutManager(b.t(giftRankFragment.requireActivity()));
                    GiftRankFragment.Th(giftRankFragment).E.setAdapter(iVar);
                    iVar.a(0, liveGiftRank.topList);
                    GiftRankFragment.Th(giftRankFragment).D.g();
                }
                unit = Unit.f56620a;
            }
            if (unit == null) {
                GiftRankFragment.Th(this.this$0).D.i();
            }
        } else if (vmState instanceof VmState.a) {
            GiftRankFragment.Th(this.this$0).D.k();
        } else {
            GiftRankFragment.Th(this.this$0).D.i();
        }
    }
}
