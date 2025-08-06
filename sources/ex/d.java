package ex;

public final class d<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final A f28977a;

    /* renamed from: b  reason: collision with root package name */
    public final B f28978b;

    public d(A a11, B b11) {
        this.f28977a = a11;
        this.f28978b = b11;
    }

    public static <A, B> d<A, B> b(A a11, B b11) {
        return new d<>(a11, b11);
    }

    public A a() {
        return this.f28977a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        A a11 = this.f28977a;
        if (a11 == null) {
            if (dVar.f28977a != null) {
                return false;
            }
        } else if (!a11.equals(dVar.f28977a)) {
            return false;
        }
        B b11 = this.f28978b;
        if (b11 == null) {
            if (dVar.f28978b != null) {
                return false;
            }
        } else if (!b11.equals(dVar.f28978b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a11 = this.f28977a;
        int i11 = 0;
        int hashCode = ((a11 == null ? 0 : a11.hashCode()) + 31) * 31;
        B b11 = this.f28978b;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return hashCode + i11;
    }
}
