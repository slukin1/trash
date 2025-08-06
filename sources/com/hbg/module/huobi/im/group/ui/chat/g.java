package com.hbg.module.huobi.im.group.ui.chat;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;

public final /* synthetic */ class g implements ChatPopMenuAction.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatView f20440a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIMessageBean f20441b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f20442c;

    public /* synthetic */ g(ChatView chatView, TUIMessageBean tUIMessageBean, int i11) {
        this.f20440a = chatView;
        this.f20441b = tUIMessageBean;
        this.f20442c = i11;
    }

    public final void onClick() {
        this.f20440a.lambda$initActions$5(this.f20441b, this.f20442c);
    }
}
