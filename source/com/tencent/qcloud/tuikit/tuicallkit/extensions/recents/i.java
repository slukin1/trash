package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents;

import android.view.View;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecentCallsListAdapter f48569b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecentCallsItemHolder f48570c;

    public /* synthetic */ i(RecentCallsListAdapter recentCallsListAdapter, RecentCallsItemHolder recentCallsItemHolder) {
        this.f48569b = recentCallsListAdapter;
        this.f48570c = recentCallsItemHolder;
    }

    public final void onClick(View view) {
        this.f48569b.lambda$onBindViewHolder$0(this.f48570c, view);
    }
}
