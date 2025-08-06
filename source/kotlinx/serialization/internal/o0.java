package kotlinx.serialization.internal;

import c10.a;
import java.util.List;
import kotlin.jvm.internal.x;
import kotlin.reflect.c;
import kotlin.reflect.e;
import kotlin.reflect.p;
import kotlin.reflect.q;

public final class o0 implements p {

    /* renamed from: b  reason: collision with root package name */
    public final p f57750b;

    public o0(p pVar) {
        this.f57750b = pVar;
    }

    public boolean b() {
        return this.f57750b.b();
    }

    public e c() {
        return this.f57750b.c();
    }

    public boolean equals(Object obj) {
        if (obj == null || !x.b(this.f57750b, obj)) {
            return false;
        }
        e c11 = c();
        if (c11 instanceof c) {
            e eVar = null;
            p pVar = obj instanceof p ? (p) obj : null;
            if (pVar != null) {
                eVar = pVar.c();
            }
            if (eVar != null && (eVar instanceof c)) {
                return x.b(a.a((c) c11), a.a((c) eVar));
            }
        }
        return false;
    }

    public List<q> g() {
        return this.f57750b.g();
    }

    public int hashCode() {
        return this.f57750b.hashCode();
    }

    public String toString() {
        return "KTypeWrapper: " + this.f57750b;
    }
}
