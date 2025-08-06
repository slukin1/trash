package com.tencent.ugc;

final /* synthetic */ class cx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50310a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50311b;

    private cx(TXVideoJoiner tXVideoJoiner, int i11) {
        this.f50310a = tXVideoJoiner;
        this.f50311b = i11;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, int i11) {
        return new cx(tXVideoJoiner, i11);
    }

    public final void run() {
        this.f50310a.mProfile = this.f50311b;
    }
}
