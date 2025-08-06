package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.k;

public abstract class BaseContinuationImpl implements c<Object>, c, Serializable {
    private final c<Object> completion;

    public BaseContinuationImpl(c<Object> cVar) {
        this.completion = cVar;
    }

    public c<Unit> create(c<?> cVar) {
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public c getCallerFrame() {
        c<Object> cVar = this.completion;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public final c<Object> getCompletion() {
        return this.completion;
    }

    public abstract /* synthetic */ CoroutineContext getContext();

    public StackTraceElement getStackTraceElement() {
        return e.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    public final void resumeWith(Object obj) {
        c cVar = this;
        while (true) {
            f.b(cVar);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) cVar;
            c cVar2 = baseContinuationImpl.completion;
            try {
                Object invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                if (invokeSuspend != IntrinsicsKt__IntrinsicsKt.d()) {
                    Result.a aVar = Result.Companion;
                    obj = Result.m3072constructorimpl(invokeSuspend);
                    baseContinuationImpl.releaseIntercepted();
                    if (cVar2 instanceof BaseContinuationImpl) {
                        cVar = cVar2;
                    } else {
                        cVar2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th2) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m3072constructorimpl(k.a(th2));
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public c<Unit> create(Object obj, c<?> cVar) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
