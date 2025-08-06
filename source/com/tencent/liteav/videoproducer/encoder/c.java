package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.util.LiteavLog;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final b f22691a;

    private c(b bVar) {
        this.f22691a = bVar;
    }

    public static Runnable a(b bVar) {
        return new c(bVar);
    }

    public final void run() {
        b bVar = this.f22691a;
        if (bVar.f22668e != null) {
            LiteavLog.w(bVar.f22664a, "onRequestRestart");
            bVar.f22668e.a();
        }
    }
}
