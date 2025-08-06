package com.tencent.thumbplayer.tcmedia.g.d;

import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.g.b.e;
import com.tencent.thumbplayer.tcmedia.g.b.f;
import com.tencent.thumbplayer.tcmedia.g.f.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private c f49292a;

    /* renamed from: b  reason: collision with root package name */
    private final int f49293b;

    /* renamed from: c  reason: collision with root package name */
    private final String f49294c;

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArraySet<f> f49295d = new CopyOnWriteArraySet<>();

    public b(int i11, String str) {
        this.f49293b = i11;
        this.f49294c = str;
    }

    private f a(f fVar, Iterator it2) {
        while (it2.hasNext()) {
            f fVar2 = (f) it2.next();
            if (TextUtils.equals(fVar.m(), fVar2.m())) {
                return fVar2;
            }
        }
        return null;
    }

    private f b() {
        Iterator<f> it2 = this.f49295d.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        return null;
    }

    private final f b(e eVar) {
        Iterator<f> it2 = this.f49295d.iterator();
        while (it2.hasNext()) {
            f next = it2.next();
            if (!next.f49245b && next.a(eVar) != a.b.KEEP_CODEC_RESULT_NO) {
                return next;
            }
            next.k();
            if (next.l()) {
                b(next);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r4 = a(r4, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.thumbplayer.tcmedia.g.b.f c(com.tencent.thumbplayer.tcmedia.g.b.f r4) {
        /*
            r3 = this;
            java.util.concurrent.CopyOnWriteArraySet<com.tencent.thumbplayer.tcmedia.g.b.f> r0 = r3.f49295d
            java.util.Iterator r0 = r0.iterator()
            com.tencent.thumbplayer.tcmedia.g.a r1 = com.tencent.thumbplayer.tcmedia.g.a.a()
            com.tencent.thumbplayer.tcmedia.g.f.b r1 = r1.d()
            com.tencent.thumbplayer.tcmedia.g.f.b$a r1 = r1.f49329d
            com.tencent.thumbplayer.tcmedia.g.f.b$a r2 = com.tencent.thumbplayer.tcmedia.g.f.b.a.SAME
            if (r1 != r2) goto L_0x001b
            com.tencent.thumbplayer.tcmedia.g.b.f r4 = r3.a(r4, r0)
            if (r4 == 0) goto L_0x001b
            return r4
        L_0x001b:
            com.tencent.thumbplayer.tcmedia.g.b.f r4 = r3.b()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.g.d.b.c(com.tencent.thumbplayer.tcmedia.g.b.f):com.tencent.thumbplayer.tcmedia.g.b.f");
    }

    public final f a(e eVar) {
        f b11 = b(eVar);
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("CodecWrapperPool", "obtain codecWrapper:".concat(String.valueOf(b11)));
        }
        if (b11 == null) {
            return null;
        }
        this.f49295d.remove(b11);
        return b11;
    }

    public final void a(f fVar) {
        if (a()) {
            b(c(fVar));
        }
        this.f49295d.add(fVar);
    }

    public final void a(c cVar) {
        this.f49292a = cVar;
    }

    public final boolean a() {
        return this.f49295d.size() == this.f49293b;
    }

    public final void b(f fVar) {
        if (this.f49295d.remove(fVar)) {
            c cVar = this.f49292a;
            if (cVar != null) {
                cVar.a(fVar);
                return;
            }
            return;
        }
        com.tencent.thumbplayer.tcmedia.g.h.b.d("CodecWrapperPool", "pool:" + this.f49294c + " remove " + fVar + " not found");
    }

    public final String toString() {
        return "size:" + this.f49295d.size() + " elements:" + this.f49295d;
    }
}
