package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50284a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50285b;

    private ci(TXVideoJoiner tXVideoJoiner, List list) {
        this.f50284a = tXVideoJoiner;
        this.f50285b = list;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, List list) {
        return new ci(tXVideoJoiner, list);
    }

    public final void run() {
        this.f50284a.mVideoSourceList = this.f50285b;
    }
}
