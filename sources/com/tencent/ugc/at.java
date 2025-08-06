package com.tencent.ugc;

final /* synthetic */ class at implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50162a;

    private at(TXVideoEditer tXVideoEditer) {
        this.f50162a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new at(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$previewAtTime$49(this.f50162a);
    }
}
