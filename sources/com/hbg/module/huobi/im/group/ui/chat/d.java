package com.hbg.module.huobi.im.group.ui.chat;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;

public final /* synthetic */ class d implements ChatPopMenuAction.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatView f20434a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIMessageBean f20435b;

    public /* synthetic */ d(ChatView chatView, TUIMessageBean tUIMessageBean) {
        this.f20434a = chatView;
        this.f20435b = tUIMessageBean;
    }

    public final void onClick() {
        this.f20434a.lambda$initActions$2(this.f20435b);
    }
}
