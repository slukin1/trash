package com.hbg.module.huobi.im.group.ui.chat;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;

public final /* synthetic */ class f implements ChatPopMenuAction.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatView f20438a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIMessageBean f20439b;

    public /* synthetic */ f(ChatView chatView, TUIMessageBean tUIMessageBean) {
        this.f20438a = chatView;
        this.f20439b = tUIMessageBean;
    }

    public final void onClick() {
        this.f20438a.lambda$initActions$4(this.f20439b);
    }
}
