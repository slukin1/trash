package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50818a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50819b;

    private t(TXVideoEditer tXVideoEditer, List list) {
        this.f50818a = tXVideoEditer;
        this.f50819b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new t(tXVideoEditer, list);
    }

    public final void run() {
        TXVideoEditer.lambda$setRepeatPlay$24(this.f50818a, this.f50819b);
    }
}
