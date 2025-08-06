package p00;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f59943a;

    /* renamed from: b  reason: collision with root package name */
    public final long f59944b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f59945c;

    public b(T t11, long j11, TimeUnit timeUnit) {
        Objects.requireNonNull(t11, "value is null");
        this.f59943a = t11;
        this.f59944b = j11;
        Objects.requireNonNull(timeUnit, "unit is null");
        TimeUnit timeUnit2 = timeUnit;
        this.f59945c = timeUnit;
    }

    public long a() {
        return this.f59944b;
    }

    public T b() {
        return this.f59943a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equals(this.f59943a, bVar.f59943a) || this.f59944b != bVar.f59944b || !Objects.equals(this.f59945c, bVar.f59945c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j11 = this.f59944b;
        return (((this.f59943a.hashCode() * 31) + ((int) (j11 ^ (j11 >>> 31)))) * 31) + this.f59945c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f59944b + ", unit=" + this.f59945c + ", value=" + this.f59943a + "]";
    }
}
