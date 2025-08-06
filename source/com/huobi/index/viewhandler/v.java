package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huochat.community.widget.expandable.ExpandableTextView;

public final /* synthetic */ class v implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsCommunityHandler f74491b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f74492c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f74493d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f74494e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f74495f;

    public /* synthetic */ v(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, Context context, TextView textView, ExpandableTextView expandableTextView) {
        this.f74491b = newsCommunityHandler;
        this.f74492c = listBean;
        this.f74493d = context;
        this.f74494e = textView;
        this.f74495f = expandableTextView;
    }

    public final boolean onLongClick(View view) {
        return NewsCommunityHandler.q(this.f74491b, this.f74492c, this.f74493d, this.f74494e, this.f74495f, view);
    }
}
