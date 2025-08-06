package com.hbg.lib.widgets;

public final /* synthetic */ class q1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TopScrollNoticeItemView f72281b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TopScrollData f72282c;

    public /* synthetic */ q1(TopScrollNoticeItemView topScrollNoticeItemView, TopScrollData topScrollData) {
        this.f72281b = topScrollNoticeItemView;
        this.f72282c = topScrollData;
    }

    public final void run() {
        this.f72281b.h(this.f72282c);
    }
}
