package com.huobi.index.viewhandler;

import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import pro.huobi.R;

public final class NewsCommunityHandler$userMute$1 extends Lambda implements l<String, Unit> {
    public static final NewsCommunityHandler$userMute$1 INSTANCE = new NewsCommunityHandler$userMute$1();

    public NewsCommunityHandler$userMute$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        HuobiToastUtil.g(R.string.invite_share_completed);
    }
}
