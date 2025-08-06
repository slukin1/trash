package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50315a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50316b;

    /* renamed from: c  reason: collision with root package name */
    private final List f50317c;

    private d(TXVideoEditer tXVideoEditer, int i11, List list) {
        this.f50315a = tXVideoEditer;
        this.f50316b = i11;
        this.f50317c = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, List list) {
        return new d(tXVideoEditer, i11, list);
    }

    public final void run() {
        TXVideoEditer.lambda$setPictureList$9(this.f50315a, this.f50316b, this.f50317c);
    }
}
