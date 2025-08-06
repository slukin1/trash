package com.sumsub.sns.internal.fingerprint.tools.threading.safe;

import com.sumsub.sns.internal.fingerprint.tools.threading.b;
import d10.a;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.k;

public final class c {
    public static final <T> Object a(a<? extends T> aVar) {
        try {
            Result.a aVar2 = Result.Companion;
            return Result.m3072constructorimpl(aVar.invoke());
        } catch (Throwable th2) {
            Result.a aVar3 = Result.Companion;
            return Result.m3072constructorimpl(k.a(th2));
        }
    }

    public static /* synthetic */ Object a(long j11, a aVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = 1000;
        }
        return a(j11, aVar);
    }

    public static final <T> Object a(long j11, a<? extends T> aVar) {
        Object obj;
        Object obj2;
        StackTraceElement[] stackTrace;
        List list = null;
        AtomicReference atomicReference = new AtomicReference((Object) null);
        b bVar = b.f34676a;
        if (bVar.b()) {
            bVar.c();
        }
        try {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(b.b().submit(new d(atomicReference, aVar)));
        } catch (Throwable th2) {
            Result.a aVar3 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th2));
        }
        Throwable r22 = Result.m3075exceptionOrNullimpl(obj);
        if (r22 == null) {
            Future future = (Future) obj;
            try {
                Result.a aVar4 = Result.Companion;
                obj2 = Result.m3072constructorimpl(future.get(j11, TimeUnit.MILLISECONDS));
            } catch (Throwable th3) {
                Result.a aVar5 = Result.Companion;
                obj2 = Result.m3072constructorimpl(k.a(th3));
            }
            Throwable r52 = Result.m3075exceptionOrNullimpl(obj2);
            if (r52 != null) {
                try {
                    Result.a aVar6 = Result.Companion;
                    if (r52 instanceof TimeoutException) {
                        TimeoutException timeoutException = (TimeoutException) r52;
                        Thread thread = (Thread) atomicReference.get();
                        if (!(thread == null || (stackTrace = thread.getStackTrace()) == null)) {
                            list = ArraysKt___ArraysKt.F(stackTrace);
                        }
                        throw new a(timeoutException, list);
                    }
                    throw r52;
                } catch (Throwable th4) {
                    Result.a aVar7 = Result.Companion;
                    obj2 = Result.m3072constructorimpl(k.a(th4));
                }
            }
            if (Result.m3075exceptionOrNullimpl(obj2) != null) {
                try {
                    Result.a aVar8 = Result.Companion;
                    Result.m3072constructorimpl(Boolean.valueOf(future.cancel(true)));
                } catch (Throwable th5) {
                    Result.a aVar9 = Result.Companion;
                    Result.m3072constructorimpl(k.a(th5));
                }
            }
            return obj2;
        }
        Result.a aVar10 = Result.Companion;
        return Result.m3072constructorimpl(k.a(r22));
    }

    public static final Object a(AtomicReference atomicReference, a aVar) {
        b bVar = b.f34676a;
        bVar.d();
        atomicReference.set(Thread.currentThread());
        try {
            Object invoke = aVar.invoke();
            bVar.a();
            return invoke;
        } catch (Throwable th2) {
            b.f34676a.a();
            throw th2;
        }
    }
}
