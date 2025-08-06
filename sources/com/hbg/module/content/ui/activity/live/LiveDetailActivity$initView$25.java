package com.hbg.module.content.ui.activity.live;

import com.hbg.module.huobi.im.gift.d;
import com.hbg.module.huobi.im.utils.MessageBusinessID;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveDetailActivity$initView$25 extends Lambda implements l<MessageBusinessID, Unit> {
    public static final LiveDetailActivity$initView$25 INSTANCE = new LiveDetailActivity$initView$25();

    public LiveDetailActivity$initView$25() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MessageBusinessID) obj);
        return Unit.f56620a;
    }

    public final void invoke(MessageBusinessID messageBusinessID) {
        if (MessageBusinessID.MSG_BUSINESS_ID_GIFT == messageBusinessID) {
            d.f19724a.f0();
        }
    }
}
