package com.tencent.liteav.txcvodplayer.c;

import com.tencent.liteav.txcvodplayer.b.c;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f21971a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21972b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21973c;

    /* renamed from: d  reason: collision with root package name */
    private final c.b f21974d;

    private c(a aVar, int i11, String str, c.b bVar) {
        this.f21971a = aVar;
        this.f21972b = i11;
        this.f21973c = str;
        this.f21974d = bVar;
    }

    public static Runnable a(a aVar, int i11, String str, c.b bVar) {
        return new c(aVar, i11, str, bVar);
    }

    public final void run() {
        a.a(this.f21971a, this.f21972b, this.f21973c, this.f21974d);
    }
}
