package androidx.core.util;

public class c<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f8468a;

    /* renamed from: b  reason: collision with root package name */
    public final S f8469b;

    public c(F f11, S s11) {
        this.f8468a = f11;
        this.f8469b = s11;
    }

    public static <A, B> c<A, B> a(A a11, B b11) {
        return new c<>(a11, b11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!b.a(cVar.f8468a, this.f8468a) || !b.a(cVar.f8469b, this.f8469b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f11 = this.f8468a;
        int i11 = 0;
        int hashCode = f11 == null ? 0 : f11.hashCode();
        S s11 = this.f8469b;
        if (s11 != null) {
            i11 = s11.hashCode();
        }
        return hashCode ^ i11;
    }

    public String toString() {
        return "Pair{" + this.f8468a + " " + this.f8469b + "}";
    }
}
