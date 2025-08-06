package com.hbg.module.huobi.im.group.ui;

import android.widget.CompoundButton;

public final /* synthetic */ class h implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroupChatInfoActivity f20480b;

    public /* synthetic */ h(GroupChatInfoActivity groupChatInfoActivity) {
        this.f20480b = groupChatInfoActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        GroupChatInfoActivity.di(this.f20480b, compoundButton, z11);
    }
}
