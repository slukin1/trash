package androidx.test.espresso.core.internal.deps.guava.base;

import java.io.IOException;
import java.util.Iterator;

public class Joiner {

    /* renamed from: a  reason: collision with root package name */
    public final String f11149a;

    public Joiner(String str) {
        this.f11149a = (String) Preconditions.i(str);
    }

    public static Joiner f(String str) {
        return new Joiner(str);
    }

    public <A extends Appendable> A a(A a11, Iterator<?> it2) throws IOException {
        Preconditions.i(a11);
        if (it2.hasNext()) {
            a11.append(g(it2.next()));
            while (it2.hasNext()) {
                a11.append(this.f11149a);
                a11.append(g(it2.next()));
            }
        }
        return a11;
    }

    public final StringBuilder b(StringBuilder sb2, Iterable<?> iterable) {
        return c(sb2, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb2, Iterator<?> it2) {
        try {
            a(sb2, it2);
            return sb2;
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public final String d(Iterable<?> iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator<?> it2) {
        return c(new StringBuilder(), it2).toString();
    }

    public CharSequence g(Object obj) {
        Preconditions.i(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
