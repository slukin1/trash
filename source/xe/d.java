package xe;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f26364a;

    public d(int i11) {
        this.f26364a = i11;
    }

    public final int a() {
        return this.f26364a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f26364a == ((d) obj).f26364a;
    }

    public int hashCode() {
        return this.f26364a;
    }

    public String toString() {
        return "FloatEvent(type=" + this.f26364a + ')';
    }
}
