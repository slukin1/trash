package com.hbg.module.huobi.im.group.ui.adapter;

import com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroupChatListMyAdapter.a f20132b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroupChatListMyAdapter f20133c;

    public /* synthetic */ h(GroupChatListMyAdapter.a aVar, GroupChatListMyAdapter groupChatListMyAdapter) {
        this.f20132b = aVar;
        this.f20133c = groupChatListMyAdapter;
    }

    public final void run() {
        GroupChatListMyAdapter.b.b(this.f20132b, this.f20133c);
    }
}
