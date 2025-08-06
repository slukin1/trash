package com.tencent.liteav.txcvodplayer.renderer;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f22039a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22040b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22041c;

    private h(d dVar, int i11, int i12) {
        this.f22039a = dVar;
        this.f22040b = i11;
        this.f22041c = i12;
    }

    public static Runnable a(d dVar, int i11, int i12) {
        return new h(dVar, i11, i12);
    }

    public final void run() {
        d.a(this.f22039a, this.f22040b, this.f22041c);
    }
}
