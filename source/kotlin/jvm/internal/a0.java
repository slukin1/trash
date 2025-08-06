package kotlin.jvm.internal;

public final class a0 implements o {

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f56764b;

    /* renamed from: c  reason: collision with root package name */
    public final String f56765c;

    public a0(Class<?> cls, String str) {
        this.f56764b = cls;
        this.f56765c = str;
    }

    public Class<?> e() {
        return this.f56764b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a0) && x.b(e(), ((a0) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString() + " (Kotlin reflection is not available)";
    }
}
