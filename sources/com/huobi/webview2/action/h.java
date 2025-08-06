package com.huobi.webview2.action;

import com.hbg.module.content.utls.comment.CommentExtKt;
import v6.u;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20826b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20827c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f20828d;

    public /* synthetic */ h(u uVar, String str, String str2) {
        this.f20826b = uVar;
        this.f20827c = str;
        this.f20828d = str2;
    }

    public final void run() {
        CommentExtKt.h(this.f20826b.getActivity(), this.f20827c, new i(this.f20828d, this.f20826b));
    }
}
