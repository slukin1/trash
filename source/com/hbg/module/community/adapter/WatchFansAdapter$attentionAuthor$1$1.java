package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import we.c;

public final class WatchFansAdapter$attentionAuthor$1$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ WatchFansBean $data;
    public final /* synthetic */ int $pos;
    public final /* synthetic */ int $status;
    public final /* synthetic */ WatchFansAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WatchFansAdapter$attentionAuthor$1$1(WatchFansBean watchFansBean, int i11, WatchFansAdapter watchFansAdapter, int i12) {
        super(1);
        this.$data = watchFansBean;
        this.$status = i11;
        this.this$0 = watchFansAdapter;
        this.$pos = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        if (x.b(bool, Boolean.TRUE)) {
            this.$data.setFocusStatus(this.$status);
            String uidUnique = this.$data.getUidUnique();
            if (uidUnique == null) {
                uidUnique = "";
            }
            c.q(uidUnique, this.$data.getFocusStatus());
        }
        this.this$0.notifyItemChanged(this.$pos);
    }
}
