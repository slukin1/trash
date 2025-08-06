package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageAdapter f48591b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f48592c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f48593d;

    public /* synthetic */ a(MessageAdapter messageAdapter, int i11, int i12) {
        this.f48591b = messageAdapter;
        this.f48592c = i11;
        this.f48593d = i12;
    }

    public final void run() {
        this.f48591b.lambda$onViewNeedRefresh$1(this.f48592c, this.f48593d);
    }
}
