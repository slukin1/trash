package com.hbg.module.content.helper.live;

import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.PraiseCountBean;
import com.hbg.module.content.helper.live.g;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HbgLiveHelper$livePraise$1 extends Lambda implements l<PraiseCountBean, Unit> {
    public static final HbgLiveHelper$livePraise$1 INSTANCE = new HbgLiveHelper$livePraise$1();

    public HbgLiveHelper$livePraise$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PraiseCountBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(PraiseCountBean praiseCountBean) {
        LiveDetailBean f11;
        if (praiseCountBean != null) {
            int praiseNum = praiseCountBean.getPraiseNum();
            LiveDetailBean f12 = HbgLiveHelper.f18233g;
            if (praiseNum > (f12 != null ? f12.praiseNum : 0) && (f11 = HbgLiveHelper.f18233g) != null) {
                f11.praiseNum = praiseCountBean.getPraiseNum();
            }
            LiveDetailBean f13 = HbgLiveHelper.f18233g;
            if (f13 != null) {
                f13.praised = 1;
            }
            g g11 = HbgLiveHelper.f18232f;
            if (g11 != null) {
                g.a.a(g11, 0, 1, (Object) null);
            }
        }
    }
}
