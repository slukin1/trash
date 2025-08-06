package com.hbg.module.content.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;

public final /* synthetic */ class b implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommentListAdapter f17837b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommentInfo f17838c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f17839d;

    public /* synthetic */ b(CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11) {
        this.f17837b = commentListAdapter;
        this.f17838c = commentInfo;
        this.f17839d = i11;
    }

    public final boolean onLongClick(View view) {
        return CommentListAdapter.K(this.f17837b, this.f17838c, this.f17839d, view);
    }
}
