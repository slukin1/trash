package com.tencent.liteav.videobase.b;

import java.util.List;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final b f22065a;

    /* renamed from: b  reason: collision with root package name */
    private final List f22066b;

    /* renamed from: c  reason: collision with root package name */
    private final List f22067c;

    private c(b bVar, List list, List list2) {
        this.f22065a = bVar;
        this.f22066b = list;
        this.f22067c = list2;
    }

    public static Runnable a(b bVar, List list, List list2) {
        return new c(bVar, list, list2);
    }

    public final void run() {
        b.a(this.f22065a, this.f22066b, this.f22067c);
    }
}
