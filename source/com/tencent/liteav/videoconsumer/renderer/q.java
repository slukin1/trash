package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videoconsumer.renderer.k;

final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final k.AnonymousClass1 f22465a;

    private q(k.AnonymousClass1 r12) {
        this.f22465a = r12;
    }

    public static Runnable a(k.AnonymousClass1 r12) {
        return new q(r12);
    }

    public final void run() {
        k.m(k.this);
    }
}
