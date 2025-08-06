package com.hbg.module.huobi.im.group.ui.adapter;

import android.view.View;
import com.hbg.module.huobi.im.group.ui.adapter.GroupChatListMyAdapter;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f20123b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f20124c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GroupChatListMyAdapter f20125d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GroupChatListMyAdapter.a f20126e;

    public /* synthetic */ e(String str, boolean z11, GroupChatListMyAdapter groupChatListMyAdapter, GroupChatListMyAdapter.a aVar) {
        this.f20123b = str;
        this.f20124c = z11;
        this.f20125d = groupChatListMyAdapter;
        this.f20126e = aVar;
    }

    public final void onClick(View view) {
        GroupChatListMyAdapter.j(this.f20123b, this.f20124c, this.f20125d, this.f20126e, view);
    }
}
