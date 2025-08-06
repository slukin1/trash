package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;

final /* synthetic */ class hj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.b f50614a;

    private hj(UGCVideoProcessor.b bVar) {
        this.f50614a = bVar;
    }

    public static Runnable a(UGCVideoProcessor.b bVar) {
        return new hj(bVar);
    }

    public final void run() {
        UGCVideoProcessor.b.a(this.f50614a);
    }
}
