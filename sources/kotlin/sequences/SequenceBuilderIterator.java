package kotlin.sequences;

import e10.a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.k;

final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, c<Unit>, a {

    /* renamed from: b  reason: collision with root package name */
    public int f56862b;

    /* renamed from: c  reason: collision with root package name */
    public T f56863c;

    /* renamed from: d  reason: collision with root package name */
    public Iterator<? extends T> f56864d;

    /* renamed from: e  reason: collision with root package name */
    public c<? super Unit> f56865e;

    public Object b(T t11, c<? super Unit> cVar) {
        this.f56863c = t11;
        this.f56862b = 3;
        this.f56865e = cVar;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        if (d11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return d11 == IntrinsicsKt__IntrinsicsKt.d() ? d11 : Unit.f56620a;
    }

    public Object d(Iterator<? extends T> it2, c<? super Unit> cVar) {
        if (!it2.hasNext()) {
            return Unit.f56620a;
        }
        this.f56864d = it2;
        this.f56862b = 2;
        this.f56865e = cVar;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        if (d11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return d11 == IntrinsicsKt__IntrinsicsKt.d() ? d11 : Unit.f56620a;
    }

    public final Throwable g() {
        int i11 = this.f56862b;
        if (i11 == 4) {
            return new NoSuchElementException();
        }
        if (i11 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f56862b);
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public boolean hasNext() {
        while (true) {
            int i11 = this.f56862b;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2 || i11 == 3) {
                        return true;
                    }
                    if (i11 == 4) {
                        return false;
                    }
                    throw g();
                } else if (this.f56864d.hasNext()) {
                    this.f56862b = 2;
                    return true;
                } else {
                    this.f56864d = null;
                }
            }
            this.f56862b = 5;
            c<? super Unit> cVar = this.f56865e;
            this.f56865e = null;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
        }
    }

    public final T i() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void j(c<? super Unit> cVar) {
        this.f56865e = cVar;
    }

    public T next() {
        int i11 = this.f56862b;
        if (i11 == 0 || i11 == 1) {
            return i();
        }
        if (i11 == 2) {
            this.f56862b = 1;
            return this.f56864d.next();
        } else if (i11 == 3) {
            this.f56862b = 0;
            T t11 = this.f56863c;
            this.f56863c = null;
            return t11;
        } else {
            throw g();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void resumeWith(Object obj) {
        k.b(obj);
        this.f56862b = 4;
    }
}
