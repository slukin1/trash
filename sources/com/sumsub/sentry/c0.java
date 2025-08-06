package com.sumsub.sentry;

import android.content.Context;
import com.sumsub.sentry.android.h;
import com.sumsub.sns.internal.log.cacher.e;
import d10.p;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

public final class c0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: f  reason: collision with root package name */
    public static final a f30303f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final String f30304g = "SentryExceptionHandler";

    /* renamed from: a  reason: collision with root package name */
    public final Context f30305a;

    /* renamed from: b  reason: collision with root package name */
    public final d10.a<String> f30306b;

    /* renamed from: c  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f30307c;

    /* renamed from: d  reason: collision with root package name */
    public final h0 f30308d = i0.a(f1.b(Executors.newSingleThreadExecutor()));

    /* renamed from: e  reason: collision with root package name */
    public final e<v> f30309e;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Throwable a(Thread thread, Throwable th2) {
            return new i(new o((Thread) null, "UncaughtExceptionHandler", (String) null, (String) null, Boolean.FALSE, (Map) null, (Map) null, (Boolean) null, 237, (r) null), th2, thread, false, 8, (r) null);
        }

        public a() {
        }
    }

    @d(c = "com.sumsub.sentry.SentryExceptionHandler$uncaughtException$1", f = "SentryExceptionHandler.kt", l = {38}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30310a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c0 f30311b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f30312c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c0 c0Var, v vVar, c<? super b> cVar) {
            super(2, cVar);
            this.f30311b = c0Var;
            this.f30312c = vVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new b(this.f30311b, this.f30312c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f30310a;
            if (i11 == 0) {
                k.b(obj);
                e a11 = this.f30311b.f30309e;
                v vVar = this.f30312c;
                this.f30310a = 1;
                if (a11.send(vVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                try {
                    k.b(obj);
                } catch (Exception e11) {
                    com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                    com.sumsub.log.logger.a.b(aVar, c0.f30304g, "Error while sending uncaught exception: " + e11, (Throwable) null, 4, (Object) null);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public c0(Context context, d10.a<String> aVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f30305a = context;
        this.f30306b = aVar;
        this.f30307c = uncaughtExceptionHandler;
        e<v> eVar = new e<>(new g0(com.sumsub.sns.a.f30554g), context.getCacheDir());
        eVar.a("_SentrySink");
        com.sumsub.sns.internal.log.cacher.d.f34872a.a(eVar);
        this.f30309e = eVar;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            v a11 = a(thread, th2);
            if (a11 != null) {
                n1 unused = i.d(this.f30308d, (CoroutineContext) null, (CoroutineStart) null, new b(this, a11, (c<? super b>) null), 3, (Object) null);
            } else {
                com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, f30304g, "Ignoring host application's exceptions", (Throwable) null, 4, (Object) null);
            }
            uncaughtExceptionHandler = this.f30307c;
            if (uncaughtExceptionHandler == null) {
                return;
            }
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.b(aVar, f30304g, "Error while preparing Sentry evenelope: " + e11, (Throwable) null, 4, (Object) null);
            uncaughtExceptionHandler = this.f30307c;
            if (uncaughtExceptionHandler == null) {
                return;
            }
        } catch (Throwable th3) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f30307c;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th2);
            }
            throw th3;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th2);
    }

    public final v a(Thread thread, Throwable th2) {
        Throwable th3 = th2;
        if (!a(th3)) {
            return null;
        }
        Throwable a11 = f30303f.a(thread, th3);
        String invoke = this.f30306b.invoke();
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.a(aVar, f30304g, "prepare envelope: applicantId=" + invoke + " exception=" + th3, (Throwable) null, 4, (Object) null);
        try {
            z zVar = new z((String) null, (String) null, (p) null, (String) null, (m0) null, (m0) null, (SentryLevel) null, (String) null, (List) null, (Map) null, (g) null, 2047, (r) null);
            zVar.a(a11);
            z a12 = new com.sumsub.sentry.android.c(this.f30305a, new com.sumsub.sentry.android.a(), new h(this.f30305a, (com.sumsub.sentry.android.a) null, (String[]) null, (String[]) null, (Runtime) null, 30, (r) null), invoke).a(new n((l0) null, (b0) null, k.f30403g.a(), 3, (r) null).a(zVar));
            return new v(new w(a12.j(), (s) null, 2, (r) null), CollectionsKt__CollectionsJVMKt.e(x.f30523c.a(a12)));
        } catch (Throwable th4) {
            com.sumsub.sns.internal.log.a.f34862a.e(f30304g, "Failed to create event", th4);
            return null;
        }
    }

    public final boolean a(Throwable th2) {
        boolean z11 = false;
        if (th2 == null) {
            return false;
        }
        StackTraceElement[] stackTrace = th2.getStackTrace();
        int length = stackTrace.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            } else if (StringsKt__StringsJVMKt.M(stackTrace[i11].getClassName(), "com.sumsub", false, 2, (Object) null)) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        return !z11 ? a(th2.getCause()) : z11;
    }
}
