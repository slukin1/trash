package com.hbg.module.content.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.LiveGroupUserListData;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f17890b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveGroupUserListData.GroupUser f17891c;

    public /* synthetic */ k(l lVar, LiveGroupUserListData.GroupUser groupUser) {
        this.f17890b = lVar;
        this.f17891c = groupUser;
    }

    public final void onClick(View view) {
        l.p(this.f17890b, this.f17891c, view);
    }
}
