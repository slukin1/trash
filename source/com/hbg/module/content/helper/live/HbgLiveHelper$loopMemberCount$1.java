package com.hbg.module.content.helper.live;

import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.MemberCountBean;
import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HbgLiveHelper$loopMemberCount$1 extends Lambda implements l<MemberCountBean, Unit> {
    public static final HbgLiveHelper$loopMemberCount$1 INSTANCE = new HbgLiveHelper$loopMemberCount$1();

    public HbgLiveHelper$loopMemberCount$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MemberCountBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(MemberCountBean memberCountBean) {
        ArrayList<GiftUser> arrayList;
        ArrayList<GiftUser> arrayList2;
        if (memberCountBean != null) {
            LiveDetailBean f11 = HbgLiveHelper.f18233g;
            if (f11 != null) {
                f11.onlineNum = memberCountBean.getMemberCount();
            }
            LiveDetailBean f12 = HbgLiveHelper.f18233g;
            if (!(f12 == null || (arrayList2 = f12.giftTopUser) == null)) {
                arrayList2.clear();
            }
            LiveDetailBean f13 = HbgLiveHelper.f18233g;
            if (!(f13 == null || (arrayList = f13.giftTopUser) == null)) {
                arrayList.addAll(memberCountBean.getGiftTopUser());
            }
            g g11 = HbgLiveHelper.f18232f;
            if (g11 != null) {
                g11.O9();
            }
        }
    }
}
