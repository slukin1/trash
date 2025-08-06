package kotlinx.coroutines.flow.internal;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.p1;

public final class SafeCollector<T> extends ContinuationImpl implements e<T> {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final e<T> collector;
    private c<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    public SafeCollector(e<? super T> eVar, CoroutineContext coroutineContext) {
        super(i.f57262b, EmptyCoroutineContext.INSTANCE);
        this.collector = eVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, SafeCollector$collectContextSize$1.INSTANCE)).intValue();
    }

    private final void checkContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t11) {
        if (coroutineContext2 instanceof e) {
            exceptionTransparencyViolated((e) coroutineContext2, t11);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
    }

    private final void exceptionTransparencyViolated(e eVar, Object obj) {
        throw new IllegalStateException(StringsKt__IndentKt.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + eVar.f57260b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    public Object emit(T t11, c<? super Unit> cVar) {
        try {
            Object emit = emit(cVar, t11);
            if (emit == IntrinsicsKt__IntrinsicsKt.d()) {
                f.c(cVar);
            }
            return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
        } catch (Throwable th2) {
            this.lastEmissionContext = new e(th2, cVar.getContext());
            throw th2;
        }
    }

    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        c<? super Unit> cVar = this.completion;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        return coroutineContext == null ? EmptyCoroutineContext.INSTANCE : coroutineContext;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public Object invokeSuspend(Object obj) {
        Throwable r02 = Result.m3075exceptionOrNullimpl(obj);
        if (r02 != null) {
            this.lastEmissionContext = new e(r02, getContext());
        }
        c<? super Unit> cVar = this.completion;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return IntrinsicsKt__IntrinsicsKt.d();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(c<? super Unit> cVar, T t11) {
        CoroutineContext context = cVar.getContext();
        p1.i(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            checkContext(context, coroutineContext, t11);
            this.lastEmissionContext = context;
        }
        this.completion = cVar;
        Object invoke = SafeCollectorKt.f57255a.invoke(this.collector, t11, this);
        if (!x.b(invoke, IntrinsicsKt__IntrinsicsKt.d())) {
            this.completion = null;
        }
        return invoke;
    }
}
