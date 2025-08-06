package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.v;

public abstract class SuspendLambda extends ContinuationImpl implements v<Object> {
    private final int arity;

    public SuspendLambda(int i11, c<Object> cVar) {
        super(cVar);
        this.arity = i11;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if (getCompletion() == null) {
            return Reflection.l(this);
        }
        return super.toString();
    }

    public SuspendLambda(int i11) {
        this(i11, (c<Object>) null);
    }
}
