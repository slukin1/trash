package com.hbg.module.content.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;

public final /* synthetic */ class c implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommentListAdapter f17840b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommentInfo f17841c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f17842d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f17843e;

    public /* synthetic */ c(CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11, int i12) {
        this.f17840b = commentListAdapter;
        this.f17841c = commentInfo;
        this.f17842d = i11;
        this.f17843e = i12;
    }

    public final boolean onLongClick(View view) {
        return CommentListAdapter.L(this.f17840b, this.f17841c, this.f17842d, this.f17843e, view);
    }
}
