package com.hbg.module.huobi.im.group.ui.chat;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;

public final /* synthetic */ class e implements ChatPopMenuAction.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatView f20436a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIMessageBean f20437b;

    public /* synthetic */ e(ChatView chatView, TUIMessageBean tUIMessageBean) {
        this.f20436a = chatView;
        this.f20437b = tUIMessageBean;
    }

    public final void onClick() {
        this.f20436a.lambda$initActions$3(this.f20437b);
    }
}
