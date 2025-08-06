package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.r;

public final class f<T> implements c<T>, c {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56674c = new a((r) null);
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<f<?>, Object> f56675d = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "result");

    /* renamed from: b  reason: collision with root package name */
    public final c<T> f56676b;
    private volatile Object result;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public f(c<? super T> cVar, Object obj) {
        this.f56676b = cVar;
        this.result = obj;
    }

    public final Object b() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (androidx.concurrent.futures.a.a(f56675d, this, coroutineSingletons, IntrinsicsKt__IntrinsicsKt.d())) {
                return IntrinsicsKt__IntrinsicsKt.d();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return IntrinsicsKt__IntrinsicsKt.d();
        }
        if (!(obj instanceof Result.Failure)) {
            return obj;
        }
        throw ((Result.Failure) obj).exception;
    }

    public c getCallerFrame() {
        c<T> cVar = this.f56676b;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f56676b.getContext();
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (androidx.concurrent.futures.a.a(f56675d, this, coroutineSingletons, obj)) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt__IntrinsicsKt.d()) {
                throw new IllegalStateException("Already resumed");
            } else if (androidx.concurrent.futures.a.a(f56675d, this, IntrinsicsKt__IntrinsicsKt.d(), CoroutineSingletons.RESUMED)) {
                this.f56676b.resumeWith(obj);
                return;
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.f56676b;
    }

    public f(c<? super T> cVar) {
        this(cVar, CoroutineSingletons.UNDECIDED);
    }
}
