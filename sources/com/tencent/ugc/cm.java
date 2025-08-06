package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class cm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50292a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50293b;

    private cm(TXVideoJoiner tXVideoJoiner, List list) {
        this.f50292a = tXVideoJoiner;
        this.f50293b = list;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, List list) {
        return new cm(tXVideoJoiner, list);
    }

    public final void run() {
        TXVideoJoiner.lambda$setVideoVolumes$11(this.f50292a, this.f50293b);
    }
}
