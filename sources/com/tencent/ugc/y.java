package com.tencent.ugc;

import java.util.Collections;

final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50924a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50925b;

    private y(TXVideoEditer tXVideoEditer, String str) {
        this.f50924a = tXVideoEditer;
        this.f50925b = str;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, String str) {
        return new y(tXVideoEditer, str);
    }

    public final void run() {
        this.f50924a.setMediaSourcePathsInternal(Collections.singletonList(this.f50925b));
    }
}
