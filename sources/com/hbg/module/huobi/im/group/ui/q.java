package com.hbg.module.huobi.im.group.ui;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroupChatListActivity f20489b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f20490c;

    public /* synthetic */ q(GroupChatListActivity groupChatListActivity, boolean z11) {
        this.f20489b = groupChatListActivity;
        this.f20490c = z11;
    }

    public final void run() {
        GroupChatListActivity.Hh(this.f20489b, this.f20490c);
    }
}
