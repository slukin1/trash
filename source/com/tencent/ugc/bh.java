package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50217a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50218b;

    private bh(TXVideoEditer tXVideoEditer, List list) {
        this.f50217a = tXVideoEditer;
        this.f50218b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new bh(tXVideoEditer, list);
    }

    public final void run() {
        this.f50217a.setMediaSourcePathsInternal(this.f50218b);
    }
}
