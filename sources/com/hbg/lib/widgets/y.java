package com.hbg.lib.widgets;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonTabLayout f72435b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f72436c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f72437d;

    public /* synthetic */ y(CommonTabLayout commonTabLayout, int i11, boolean z11) {
        this.f72435b = commonTabLayout;
        this.f72436c = i11;
        this.f72437d = z11;
    }

    public final void run() {
        this.f72435b.o(this.f72436c, this.f72437d);
    }
}
