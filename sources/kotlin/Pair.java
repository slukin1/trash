package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a11, B b11) {
        this.first = a11;
        this.second = b11;
    }

    public static /* synthetic */ Pair copy$default(Pair pair, A a11, B b11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            a11 = pair.first;
        }
        if ((i11 & 2) != 0) {
            b11 = pair.second;
        }
        return pair.copy(a11, b11);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final Pair<A, B> copy(A a11, B b11) {
        return new Pair<>(a11, b11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return x.b(this.first, pair.first) && x.b(this.second, pair.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a11 = this.first;
        int i11 = 0;
        int hashCode = (a11 == null ? 0 : a11.hashCode()) * 31;
        B b11 = this.second;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
