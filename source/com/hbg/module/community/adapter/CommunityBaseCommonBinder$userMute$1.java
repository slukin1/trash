package com.hbg.module.community.adapter;

import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityBaseCommonBinder$userMute$1 extends Lambda implements l<String, Unit> {
    public static final CommunityBaseCommonBinder$userMute$1 INSTANCE = new CommunityBaseCommonBinder$userMute$1();

    public CommunityBaseCommonBinder$userMute$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        HuobiToastUtil.g(R$string.invite_share_completed);
    }
}
