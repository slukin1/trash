package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class bd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50183a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50184b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50185c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50186d;

    private bd(TXVideoEditer tXVideoEditer, List list, int i11, int i12) {
        this.f50183a = tXVideoEditer;
        this.f50184b = list;
        this.f50185c = i11;
        this.f50186d = i12;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list, int i11, int i12) {
        return new bd(tXVideoEditer, list, i11, i12);
    }

    public final void run() {
        TXVideoEditer.lambda$setSplitScreenList$58(this.f50183a, this.f50184b, this.f50185c, this.f50186d);
    }
}
