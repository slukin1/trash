package com.hbg.module.huobi.im.group.ui;

import android.view.KeyEvent;
import android.view.View;

public final /* synthetic */ class w implements View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroupMemberListActivity f20497b;

    public /* synthetic */ w(GroupMemberListActivity groupMemberListActivity) {
        this.f20497b = groupMemberListActivity;
    }

    public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
        return GroupMemberListActivity.Eh(this.f20497b, view, i11, keyEvent);
    }
}
