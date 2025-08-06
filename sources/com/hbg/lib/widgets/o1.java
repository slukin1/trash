package com.hbg.lib.widgets;

public final /* synthetic */ class o1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TopScrollItemView f72111b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TopScrollData f72112c;

    public /* synthetic */ o1(TopScrollItemView topScrollItemView, TopScrollData topScrollData) {
        this.f72111b = topScrollItemView;
        this.f72112c = topScrollData;
    }

    public final void run() {
        this.f72111b.f(this.f72112c);
    }
}
