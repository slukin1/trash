package org.joda.time.format;

public class l implements c, k {

    /* renamed from: b  reason: collision with root package name */
    public final k f23265b;

    public l(k kVar) {
        this.f23265b = kVar;
    }

    public static c b(k kVar) {
        if (kVar instanceof e) {
            return ((e) kVar).a();
        }
        if (kVar instanceof c) {
            return (c) kVar;
        }
        if (kVar == null) {
            return null;
        }
        return new l(kVar);
    }

    public int a(d dVar, String str, int i11) {
        return this.f23265b.parseInto(dVar, str, i11);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            return this.f23265b.equals(((l) obj).f23265b);
        }
        return false;
    }

    public int estimateParsedLength() {
        return this.f23265b.estimateParsedLength();
    }

    public int parseInto(d dVar, CharSequence charSequence, int i11) {
        return this.f23265b.parseInto(dVar, charSequence, i11);
    }
}
