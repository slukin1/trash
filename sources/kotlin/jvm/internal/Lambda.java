package kotlin.jvm.internal;

import java.io.Serializable;

public abstract class Lambda<R> implements v<R>, Serializable {
    private final int arity;

    public Lambda(int i11) {
        this.arity = i11;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        return Reflection.m(this);
    }
}
