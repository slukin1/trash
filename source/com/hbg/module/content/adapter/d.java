package com.hbg.module.content.adapter;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class d implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommentListAdapter f17844a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17845b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17846c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f17847d;

    public /* synthetic */ d(CommentListAdapter commentListAdapter, String str, int i11, Integer num) {
        this.f17844a = commentListAdapter;
        this.f17845b = str;
        this.f17846c = i11;
        this.f17847d = num;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        CommentListAdapter.z(this.f17844a, this.f17845b, this.f17846c, this.f17847d, hBDialogFragment);
    }
}
