package com.hbg.module.content.helper.live;

import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LivePraiseCount;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HbgLiveHelper$loopPraiseNum$1 extends Lambda implements l<LivePraiseCount, Unit> {
    public static final HbgLiveHelper$loopPraiseNum$1 INSTANCE = new HbgLiveHelper$loopPraiseNum$1();

    public HbgLiveHelper$loopPraiseNum$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LivePraiseCount) obj);
        return Unit.f56620a;
    }

    public final void invoke(LivePraiseCount livePraiseCount) {
        if (livePraiseCount != null) {
            int praiseNum = livePraiseCount.getPraiseNum();
            LiveDetailBean f11 = HbgLiveHelper.f18233g;
            int i11 = 0;
            if (praiseNum > (f11 != null ? f11.praiseNum : 0)) {
                int praiseNum2 = livePraiseCount.getPraiseNum();
                LiveDetailBean f12 = HbgLiveHelper.f18233g;
                if (f12 != null) {
                    i11 = f12.praiseNum;
                }
                i11 = praiseNum2 - i11;
                LiveDetailBean f13 = HbgLiveHelper.f18233g;
                if (f13 != null) {
                    f13.praiseNum = livePraiseCount.getPraiseNum();
                }
            }
            g g11 = HbgLiveHelper.f18232f;
            if (g11 != null) {
                g11.J3(i11);
            }
        }
    }
}
