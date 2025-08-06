package com.tencent.thumbplayer.tcmedia.g.d;

import com.tencent.thumbplayer.tcmedia.g.b.e;
import com.tencent.thumbplayer.tcmedia.g.b.f;
import com.tencent.thumbplayer.tcmedia.g.h.b;
import com.tencent.thumbplayer.tcmedia.g.h.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f49287a;

    /* renamed from: b  reason: collision with root package name */
    private final b f49288b = new b(Integer.MAX_VALUE, "running");

    public a() {
        b bVar = new b(2, "keep");
        this.f49287a = bVar;
        bVar.a((c) new c() {
            public void a(f fVar) {
                if (b.a()) {
                    b.b("CodecWrapperManager", "onErase codecWrapper:".concat(String.valueOf(fVar)));
                }
                fVar.i();
            }
        });
    }

    public final f a(e eVar) {
        f a11 = this.f49287a.a(eVar);
        if (b.a()) {
            b.b("CodecWrapperManager", "obtainCodecWrapper codecWrapper:".concat(String.valueOf(a11)));
        }
        return a11;
    }

    public final String a() {
        return "runningPool:" + this.f49288b + " keepPool:" + this.f49287a;
    }

    public final void a(final f fVar) {
        if (b.a()) {
            b.b("CodecWrapperManager", "transToRunning codecWrapper:".concat(String.valueOf(fVar)));
        }
        this.f49287a.b(fVar);
        this.f49288b.a(fVar);
        d.b(new Runnable() {
            public void run() {
                com.tencent.thumbplayer.tcmedia.g.a.a h11 = fVar.h();
                if (h11 != null) {
                    h11.onTransToRunningPool();
                }
            }
        });
    }

    public final void b(f fVar) {
        if (b.a()) {
            b.b("CodecWrapperManager", "removeFromRunning codecWrapper:".concat(String.valueOf(fVar)));
        }
        this.f49288b.b(fVar);
    }

    public final void c(f fVar) {
        if (b.a()) {
            b.b("CodecWrapperManager", "transTokeep codecWrapper:".concat(String.valueOf(fVar)));
        }
        this.f49288b.b(fVar);
        this.f49287a.a(fVar);
        com.tencent.thumbplayer.tcmedia.g.a.a h11 = fVar.h();
        if (h11 != null) {
            h11.onTransToKeepPool();
        }
    }
}
