package org.joda.time.format;

public class e implements k {

    /* renamed from: b  reason: collision with root package name */
    public final c f23228b;

    public e(c cVar) {
        this.f23228b = cVar;
    }

    public static k b(c cVar) {
        if (cVar instanceof l) {
            return (k) cVar;
        }
        if (cVar == null) {
            return null;
        }
        return new e(cVar);
    }

    public c a() {
        return this.f23228b;
    }

    public int estimateParsedLength() {
        return this.f23228b.estimateParsedLength();
    }

    public int parseInto(d dVar, CharSequence charSequence, int i11) {
        return this.f23228b.a(dVar, charSequence.toString(), i11);
    }
}
