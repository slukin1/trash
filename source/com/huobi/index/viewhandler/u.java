package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;

public final /* synthetic */ class u implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsCommunityHandler f74486b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f74487c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f74488d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f74489e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f74490f;

    public /* synthetic */ u(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, Context context, TextView textView, ExpandableTextView expandableTextView) {
        this.f74486b = newsCommunityHandler;
        this.f74487c = listBean;
        this.f74488d = context;
        this.f74489e = textView;
        this.f74490f = expandableTextView;
    }

    public final boolean onLongClick(View view) {
        return NewsCommunityHandler.o(this.f74486b, this.f74487c, this.f74488d, this.f74489e, this.f74490f, view);
    }
}
