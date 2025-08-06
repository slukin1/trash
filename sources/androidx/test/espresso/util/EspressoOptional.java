package androidx.test.espresso.util;

import androidx.test.espresso.core.internal.deps.guava.base.Optional;

public final class EspressoOptional<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Optional<T> f11368a;

    public EspressoOptional(Optional<T> optional) {
        this.f11368a = optional;
    }

    public static <T> EspressoOptional<T> a() {
        return new EspressoOptional<>(Optional.absent());
    }

    public T b() {
        return this.f11368a.get();
    }

    public boolean c() {
        return this.f11368a.isPresent();
    }

    public boolean equals(Object obj) {
        if (obj instanceof EspressoOptional) {
            return ((EspressoOptional) obj).f11368a.equals(this.f11368a);
        }
        return false;
    }

    public int hashCode() {
        return this.f11368a.hashCode();
    }

    public String toString() {
        return this.f11368a.toString();
    }
}
