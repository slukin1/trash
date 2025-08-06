package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;

abstract class Cut<C extends Comparable> implements Serializable, Comparable<Cut<C>> {
    private static final long serialVersionUID = 0;
    public final C endpoint;

    public static final class AboveAll extends Cut<Comparable<?>> {
        /* access modifiers changed from: private */
        public static final AboveAll INSTANCE = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super(null);
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        public void describeAsLowerBound(StringBuilder sb2) {
            throw new AssertionError();
        }

        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append("+∞)");
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }

        public boolean isLessThan(Comparable<?> comparable) {
            return false;
        }

        public String toString() {
            return "+∞";
        }
    }

    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public AboveValue(C c11) {
            super((Comparable) Preconditions.i(c11));
        }

        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append('(');
            sb2.append(this.endpoint);
        }

        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append(this.endpoint);
            sb2.append(']');
        }

        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        public boolean isLessThan(C c11) {
            return Range.compareOrThrow(this.endpoint, c11) < 0;
        }

        public String toString() {
            String valueOf = String.valueOf(this.endpoint);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2);
            sb2.append("/");
            sb2.append(valueOf);
            sb2.append("\\");
            return sb2.toString();
        }
    }

    public static final class BelowAll extends Cut<Comparable<?>> {
        /* access modifiers changed from: private */
        public static final BelowAll INSTANCE = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super(null);
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append("(-∞");
        }

        public void describeAsUpperBound(StringBuilder sb2) {
            throw new AssertionError();
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }

        public boolean isLessThan(Comparable<?> comparable) {
            return true;
        }

        public String toString() {
            return "-∞";
        }
    }

    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public BelowValue(C c11) {
            super((Comparable) Preconditions.i(c11));
        }

        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append('[');
            sb2.append(this.endpoint);
        }

        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append(this.endpoint);
            sb2.append(')');
        }

        public int hashCode() {
            return this.endpoint.hashCode();
        }

        public boolean isLessThan(C c11) {
            return Range.compareOrThrow(this.endpoint, c11) <= 0;
        }

        public String toString() {
            String valueOf = String.valueOf(this.endpoint);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2);
            sb2.append("\\");
            sb2.append(valueOf);
            sb2.append("/");
            return sb2.toString();
        }
    }

    public Cut(C c11) {
        this.endpoint = c11;
    }

    public static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.INSTANCE;
    }

    public static <C extends Comparable> Cut<C> aboveValue(C c11) {
        return new AboveValue(c11);
    }

    public static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.INSTANCE;
    }

    public static <C extends Comparable> Cut<C> belowValue(C c11) {
        return new BelowValue(c11);
    }

    public abstract void describeAsLowerBound(StringBuilder sb2);

    public abstract void describeAsUpperBound(StringBuilder sb2);

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            if (compareTo((Cut) obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public abstract int hashCode();

    public abstract boolean isLessThan(C c11);

    public int compareTo(Cut<C> cut) {
        if (cut == belowAll()) {
            return 1;
        }
        if (cut == aboveAll()) {
            return -1;
        }
        int compareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint);
        if (compareOrThrow != 0) {
            return compareOrThrow;
        }
        return Booleans.a(this instanceof AboveValue, cut instanceof AboveValue);
    }
}
