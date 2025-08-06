package com.tencent.liteav.txcvodplayer.c;

import com.tencent.liteav.txcvodplayer.b.c;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f21966a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21967b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21968c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21969d;

    /* renamed from: e  reason: collision with root package name */
    private final c.b f21970e;

    private b(a aVar, int i11, String str, String str2, c.b bVar) {
        this.f21966a = aVar;
        this.f21967b = i11;
        this.f21968c = str;
        this.f21969d = str2;
        this.f21970e = bVar;
    }

    public static Runnable a(a aVar, int i11, String str, String str2, c.b bVar) {
        return new b(aVar, i11, str, str2, bVar);
    }

    public final void run() {
        a.a(this.f21966a, this.f21967b, this.f21968c, this.f21969d, this.f21970e);
    }
}
