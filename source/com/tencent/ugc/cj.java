package com.tencent.ugc;

final /* synthetic */ class cj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50286a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50287b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50288c;

    private cj(TXVideoJoiner tXVideoJoiner, String str, int i11) {
        this.f50286a = tXVideoJoiner;
        this.f50287b = str;
        this.f50288c = i11;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, String str, int i11) {
        return new cj(tXVideoJoiner, str, i11);
    }

    public final void run() {
        TXVideoJoiner.lambda$joinVideo$8(this.f50286a, this.f50287b, this.f50288c);
    }
}
