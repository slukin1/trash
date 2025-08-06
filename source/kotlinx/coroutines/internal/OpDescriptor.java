package kotlinx.coroutines.internal;

import kotlinx.coroutines.k0;

public abstract class OpDescriptor {
    public abstract Object a(Object obj);

    public String toString() {
        return k0.a(this) + '@' + k0.b(this);
    }
}
