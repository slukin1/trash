package com.hbg.module.content.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommentListAdapter f17834b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17835c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommentInfo f17836d;

    public /* synthetic */ a(CommentListAdapter commentListAdapter, int i11, CommentInfo commentInfo) {
        this.f17834b = commentListAdapter;
        this.f17835c = i11;
        this.f17836d = commentInfo;
    }

    public final void onClick(View view) {
        CommentListAdapter.M(this.f17834b, this.f17835c, this.f17836d, view);
    }
}
