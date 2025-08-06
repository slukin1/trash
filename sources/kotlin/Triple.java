package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a11, B b11, C c11) {
        this.first = a11;
        this.second = b11;
        this.third = c11;
    }

    public static /* synthetic */ Triple copy$default(Triple triple, A a11, B b11, C c11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            a11 = triple.first;
        }
        if ((i11 & 2) != 0) {
            b11 = triple.second;
        }
        if ((i11 & 4) != 0) {
            c11 = triple.third;
        }
        return triple.copy(a11, b11, c11);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final Triple<A, B, C> copy(A a11, B b11, C c11) {
        return new Triple<>(a11, b11, c11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return x.b(this.first, triple.first) && x.b(this.second, triple.second) && x.b(this.third, triple.third);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a11 = this.first;
        int i11 = 0;
        int hashCode = (a11 == null ? 0 : a11.hashCode()) * 31;
        B b11 = this.second;
        int hashCode2 = (hashCode + (b11 == null ? 0 : b11.hashCode())) * 31;
        C c11 = this.third;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
