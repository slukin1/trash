package kotlin.coroutines;

import d10.p;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.a element;
    private final CoroutineContext left;

    public static final class Serialized implements Serializable {
        public static final a Companion = new a((r) null);
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }
        }

        public Serialized(CoroutineContext[] coroutineContextArr) {
            this.elements = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext plus : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(plus);
            }
            return coroutineContext;
        }

        public final CoroutineContext[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.a aVar) {
        this.left = coroutineContext;
        this.element = aVar;
    }

    private final boolean contains(CoroutineContext.a aVar) {
        return x.b(get(aVar.getKey()), aVar);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return contains((CoroutineContext.a) coroutineContext);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
        return false;
    }

    private final int size() {
        int i11 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i11;
            }
            i11++;
        }
    }

    private final Object writeReplace() {
        int size = size();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[size];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(Unit.f56620a, new CombinedContext$writeReplace$1(coroutineContextArr, ref$IntRef));
        if (ref$IntRef.element == size) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public <R> R fold(R r11, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return pVar.invoke(this.left.fold(r11, pVar), this.element);
    }

    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        CombinedContext combinedContext = this;
        while (true) {
            E e11 = combinedContext.element.get(bVar);
            if (e11 != null) {
                return e11;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.get(bVar);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        if (this.element.get(bVar) != null) {
            return this.left;
        }
        CoroutineContext minusKey = this.left.minusKey(bVar);
        if (minusKey == this.left) {
            return this;
        }
        if (minusKey == EmptyCoroutineContext.INSTANCE) {
            return this.element;
        }
        return new CombinedContext(minusKey, this.element);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + ']';
    }
}
