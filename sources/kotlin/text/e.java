package kotlin.text;

import kotlin.jvm.internal.x;
import kotlin.ranges.h;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f56926a;

    /* renamed from: b  reason: collision with root package name */
    public final h f56927b;

    public e(String str, h hVar) {
        this.f56926a = str;
        this.f56927b = hVar;
    }

    public final String a() {
        return this.f56926a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return x.b(this.f56926a, eVar.f56926a) && x.b(this.f56927b, eVar.f56927b);
    }

    public int hashCode() {
        return (this.f56926a.hashCode() * 31) + this.f56927b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f56926a + ", range=" + this.f56927b + ')';
    }
}
