package com.hbg.module.huobi.im.group.ui;

import android.widget.CompoundButton;

public final /* synthetic */ class e implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroupChatInfoActivity f20477b;

    public /* synthetic */ e(GroupChatInfoActivity groupChatInfoActivity) {
        this.f20477b = groupChatInfoActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        GroupChatInfoActivity.hi(this.f20477b, compoundButton, z11);
    }
}
