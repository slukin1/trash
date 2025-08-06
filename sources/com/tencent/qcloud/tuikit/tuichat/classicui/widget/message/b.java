package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageAdapter f48594b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f48595c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUIMessageBean f48596d;

    public /* synthetic */ b(MessageAdapter messageAdapter, int i11, TUIMessageBean tUIMessageBean) {
        this.f48594b = messageAdapter;
        this.f48595c = i11;
        this.f48596d = tUIMessageBean;
    }

    public final void run() {
        this.f48594b.lambda$onViewNeedRefresh$0(this.f48595c, this.f48596d);
    }
}
