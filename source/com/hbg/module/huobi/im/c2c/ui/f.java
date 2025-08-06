package com.hbg.module.huobi.im.c2c.ui;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.huobi.im.group.bean.UserStatusEntity;

public final /* synthetic */ class f implements DialogUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImC2CChatFragment f19686a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserStatusEntity f19687b;

    public /* synthetic */ f(ImC2CChatFragment imC2CChatFragment, UserStatusEntity userStatusEntity) {
        this.f19686a = imC2CChatFragment;
        this.f19687b = userStatusEntity;
    }

    public final void onClick() {
        this.f19686a.fi(this.f19687b);
    }
}
