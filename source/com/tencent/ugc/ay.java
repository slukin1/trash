package com.tencent.ugc;

final /* synthetic */ class ay implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50172a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50173b;

    private ay(TXVideoEditer tXVideoEditer, int i11) {
        this.f50172a = tXVideoEditer;
        this.f50173b = i11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11) {
        return new ay(tXVideoEditer, i11);
    }

    public final void run() {
        TXVideoEditer.lambda$setAudioBitrate$53(this.f50172a, this.f50173b);
    }
}
