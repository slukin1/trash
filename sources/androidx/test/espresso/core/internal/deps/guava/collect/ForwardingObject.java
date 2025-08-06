package androidx.test.espresso.core.internal.deps.guava.collect;

public abstract class ForwardingObject {
    public abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
