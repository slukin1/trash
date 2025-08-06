package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents;

import android.view.View;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecentCallsListAdapter f48573b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecentCallsItemHolder f48574c;

    public /* synthetic */ k(RecentCallsListAdapter recentCallsListAdapter, RecentCallsItemHolder recentCallsItemHolder) {
        this.f48573b = recentCallsListAdapter;
        this.f48574c = recentCallsItemHolder;
    }

    public final void onClick(View view) {
        this.f48573b.lambda$onBindViewHolder$1(this.f48574c, view);
    }
}
