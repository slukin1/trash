package com.hbg.module.content.ui.activity.live;

import com.hbg.module.content.adapter.h;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class GiftListFragment$initView$2 extends Lambda implements l<Integer, Unit> {
    public final /* synthetic */ GiftListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GiftListFragment$initView$2(GiftListFragment giftListFragment) {
        super(1);
        this.this$0 = giftListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11) {
        if (this.this$0.f18389t) {
            h Rh = this.this$0.f18388s;
            if (Rh != null) {
                Rh.x(1);
            }
            if (i11 == 0) {
                h Rh2 = this.this$0.f18388s;
                if (Rh2 != null) {
                    Rh2.r();
                    return;
                }
                return;
            }
            h Rh3 = this.this$0.f18388s;
            if (Rh3 != null) {
                Rh3.notifyDataSetChanged();
            }
        }
    }
}
