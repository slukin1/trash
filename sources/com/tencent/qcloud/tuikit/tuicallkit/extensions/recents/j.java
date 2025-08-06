package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents;

import android.view.View;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecentCallsListAdapter f48571b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecentCallsItemHolder f48572c;

    public /* synthetic */ j(RecentCallsListAdapter recentCallsListAdapter, RecentCallsItemHolder recentCallsItemHolder) {
        this.f48571b = recentCallsListAdapter;
        this.f48572c = recentCallsItemHolder;
    }

    public final void onClick(View view) {
        this.f48571b.lambda$onBindViewHolder$2(this.f48572c, view);
    }
}
