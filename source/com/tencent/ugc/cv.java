package com.tencent.ugc;

final /* synthetic */ class cv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50307a;

    private cv(TXVideoJoiner tXVideoJoiner) {
        this.f50307a = tXVideoJoiner;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner) {
        return new cv(tXVideoJoiner);
    }

    public final void run() {
        this.f50307a.stopPlayInternal();
    }
}
