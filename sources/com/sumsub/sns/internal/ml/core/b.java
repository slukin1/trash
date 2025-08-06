package com.sumsub.sns.internal.ml.core;

import com.sumsub.sns.internal.core.analytics.Action;
import com.sumsub.sns.internal.core.analytics.o;
import com.sumsub.sns.internal.core.common.b1;
import com.sumsub.sns.internal.ml.core.e;
import d10.l;
import d10.p;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h0;
import org.tensorflow.lite.InterpreterApi;

public abstract class b<Input, Output> implements e<Input, Output> {

    /* renamed from: a  reason: collision with root package name */
    public final String f34988a;

    /* renamed from: b  reason: collision with root package name */
    public final b1 f34989b = new b1();

    /* renamed from: c  reason: collision with root package name */
    public InterpreterApi f34990c;

    /* renamed from: d  reason: collision with root package name */
    public final long f34991d;

    /* renamed from: e  reason: collision with root package name */
    public final kotlin.i f34992e = LazyKt__LazyJVMKt.a(new j(this));

    /* renamed from: f  reason: collision with root package name */
    public final kotlin.i f34993f = LazyKt__LazyJVMKt.a(new c(this));

    /* renamed from: g  reason: collision with root package name */
    public boolean f34994g;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.ml.core.MlSolution", f = "MlSolution.kt", l = {139}, m = "close$suspendImpl")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34995a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f34996b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b<Input, Output> f34997c;

        /* renamed from: d  reason: collision with root package name */
        public int f34998d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b<Input, Output> bVar, kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
            this.f34997c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34996b = obj;
            this.f34998d |= Integer.MIN_VALUE;
            return b.a((b) this.f34997c, (kotlin.coroutines.c) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.ml.core.MlSolution$close$2", f = "MlSolution.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.internal.ml.core.b$b  reason: collision with other inner class name */
    public static final class C0408b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34999a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b<Input, Output> f35000b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0408b(b<Input, Output> bVar, kotlin.coroutines.c<? super C0408b> cVar) {
            super(2, cVar);
            this.f35000b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((C0408b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new C0408b(this.f35000b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f34999a == 0) {
                k.b(obj);
                this.f35000b.k();
                InterpreterApi c11 = this.f35000b.f34990c;
                if (c11 != null) {
                    c11.close();
                }
                this.f35000b.f34990c = null;
                this.f35000b.b().close();
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.ml.core.MlSolution$finalize$1", f = "MlSolution.kt", l = {153}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35002a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b<Input, Output> f35003b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b<Input, Output> bVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f35003b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f35003b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35002a;
            if (i11 == 0) {
                k.b(obj);
                b<Input, Output> bVar = this.f35003b;
                this.f35002a = 1;
                if (bVar.a((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.ml.core.MlSolution", f = "MlSolution.kt", l = {87}, m = "preloadModel-IoAF18A")
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f35004a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b<Input, Output> f35005b;

        /* renamed from: c  reason: collision with root package name */
        public int f35006c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b<Input, Output> bVar, kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
            this.f35005b = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35004a = obj;
            this.f35006c |= Integer.MIN_VALUE;
            Object b11 = this.f35005b.b((kotlin.coroutines.c<? super Result<Boolean>>) this);
            return b11 == IntrinsicsKt__IntrinsicsKt.d() ? b11 : Result.m3071boximpl(b11);
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements p<h0, kotlin.coroutines.c<? super Result<? extends Boolean>>, Object> {
        public f(Object obj) {
            super(2, obj, x.a.class, "suspendConversion0", "preloadModel_IoAF18A$suspendConversion0(Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Result<Boolean>> cVar) {
            Object a11 = ((Result) ((l) this.receiver).invoke(h0Var)).m3081unboximpl();
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public /* synthetic */ class h extends FunctionReferenceImpl implements p<h0, kotlin.coroutines.c<? super e.a<Output>>, Object> {
        public h(Object obj) {
            super(2, obj, x.a.class, "suspendConversion0", "run$suspendConversion0-0(Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super e.a<Output>> cVar) {
            return ((l) this.receiver).invoke(h0Var);
        }
    }

    public static final class j extends Lambda implements d10.a<ExecutorService> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b<Input, Output> f35013a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(b<Input, Output> bVar) {
            super(0);
            this.f35013a = bVar;
        }

        /* renamed from: a */
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor(new i(this.f35013a));
        }

        public static final Thread a(b bVar, Runnable runnable) {
            return new Thread(runnable, bVar.h() + "Thread");
        }
    }

    public b(String str) {
        this.f34988a = str;
    }

    public abstract Output a(Input input, long j11);

    public Object a(kotlin.coroutines.c<? super Unit> cVar) throws Throwable {
        return a(this, (kotlin.coroutines.c) cVar);
    }

    public void a(InterpreterApi interpreterApi) {
    }

    public abstract Object[] a(Input input);

    public abstract a e();

    public final void finalize() {
        Object unused = kotlinx.coroutines.h.b((CoroutineContext) null, new d(this, (kotlin.coroutines.c<? super d>) null), 1, (Object) null);
    }

    public abstract Map<Integer, Object> g();

    public abstract String h();

    public final ExecutorService i() {
        return (ExecutorService) this.f34992e.getValue();
    }

    public final InterpreterApi j() {
        c cVar = c.f35017a;
        String str = this.f34988a;
        c.b(cVar, str, "initInterpreter: " + e(), (Throwable) null, 4, (Object) null);
        return org.tensorflow.lite.b.b(e().a(), d());
    }

    public final void k() {
        o.a(com.sumsub.sns.internal.core.analytics.f.a(0, 1, (Object) null).a(Action.MlModelExecution).e().a((Pair<String, ? extends Object>[]) new Pair[]{kotlin.l.a("name", h()), kotlin.l.a("average", this.f34989b.a()), kotlin.l.a("median", Long.valueOf(this.f34989b.c())), kotlin.l.a("p99", Long.valueOf(this.f34989b.e())), kotlin.l.a("p100", Long.valueOf(this.f34989b.d()))}), false, 1, (Object) null);
        this.f34989b.f();
    }

    public static final class c extends Lambda implements d10.a<ExecutorCoroutineDispatcher> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b<Input, Output> f35001a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b<Input, Output> bVar) {
            super(0);
            this.f35001a = bVar;
        }

        /* renamed from: a */
        public final ExecutorCoroutineDispatcher invoke() {
            return f1.b(Executors.newSingleThreadExecutor(new f(this.f35001a)));
        }

        public static final Thread a(b bVar, Runnable runnable) {
            return new Thread(runnable, bVar.h() + "CoroutineThread");
        }
    }

    public Object a(Input input, kotlin.coroutines.c<? super e.a<Output>> cVar) throws Throwable {
        return kotlinx.coroutines.g.g(b(), new h(new i(this, input)), cVar);
    }

    public long c() {
        return this.f34991d;
    }

    public final boolean f() {
        return this.f34994g;
    }

    public final ExecutorCoroutineDispatcher b() {
        return (ExecutorCoroutineDispatcher) this.f34993f.getValue();
    }

    public InterpreterApi.Options d() {
        InterpreterApi.Options options = new InterpreterApi.Options();
        options.setNumThreads(-1);
        options.setCancellable(true);
        return options;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlin.coroutines.c<? super kotlin.Result<java.lang.Boolean>> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.ml.core.b.e
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.ml.core.b$e r0 = (com.sumsub.sns.internal.ml.core.b.e) r0
            int r1 = r0.f35006c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35006c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.ml.core.b$e r0 = new com.sumsub.sns.internal.ml.core.b$e
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f35004a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35006c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r11)
            goto L_0x0057
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0031:
            kotlin.k.b(r11)
            com.sumsub.sns.internal.ml.core.c r4 = com.sumsub.sns.internal.ml.core.c.f35017a
            java.lang.String r5 = r10.f34988a
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r6 = "preloadModel"
            com.sumsub.sns.internal.ml.core.c.b(r4, r5, r6, r7, r8, r9)
            com.sumsub.sns.internal.ml.core.b$g r11 = new com.sumsub.sns.internal.ml.core.b$g
            r11.<init>(r10)
            kotlinx.coroutines.ExecutorCoroutineDispatcher r2 = r10.b()
            com.sumsub.sns.internal.ml.core.b$f r4 = new com.sumsub.sns.internal.ml.core.b$f
            r4.<init>(r11)
            r0.f35006c = r3
            java.lang.Object r11 = kotlinx.coroutines.g.g(r2, r4, r0)
            if (r11 != r1) goto L_0x0057
            return r1
        L_0x0057:
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r11 = r11.m3081unboximpl()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.core.b.b(kotlin.coroutines.c):java.lang.Object");
    }

    public static final class i extends Lambda implements l<h0, e.a<Output>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b<Input, Output> f35009a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Input f35010b;

        public static final class a extends Lambda implements d10.a<Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b<Input, Output> f35011a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Input f35012b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b<Input, Output> bVar, Input input) {
                super(0);
                this.f35011a = bVar;
                this.f35012b = input;
            }

            public final void a() {
                this.f35011a.a().runForMultipleInputsOutputs(this.f35011a.a(this.f35012b), this.f35011a.g());
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b<Input, Output> bVar, Input input) {
            super(1);
            this.f35009a = bVar;
            this.f35010b = input;
        }

        /* renamed from: a */
        public final e.a<Output> invoke(h0 h0Var) {
            Future submit = this.f35009a.i().submit(new h(this.f35009a, this.f35010b));
            if (this.f35009a.c() <= 0) {
                return (e.a) submit.get();
            }
            try {
                return (e.a) submit.get(this.f35009a.c(), TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused) {
                c cVar = c.f35017a;
                String d11 = this.f35009a.f34988a;
                c.a(cVar, d11, "MlSolution timeout (" + this.f35009a.h() + ')', (Throwable) null, 4, (Object) null);
                return new e.a.C0411e();
            }
        }

        public static final e.a a(b bVar, Object obj) {
            try {
                return new e.a.d(bVar.a(obj, bVar.f34989b.a((d10.a<Unit>) new a(bVar, obj))));
            } catch (UnsatisfiedLinkError e11) {
                bVar.f34994g = true;
                com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, bVar.f34988a, "Error while loading TF library", e11);
                c.f35017a.a(bVar.f34988a, "Error while loading TF library", e11);
                return new e.a.b(e11);
            } catch (d e12) {
                bVar.f34994g = true;
                com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, bVar.f34988a, "Error while executing ML model", e12);
                c.f35017a.a(bVar.f34988a, "Error while executing ML model", e12);
                return new e.a.b(e12);
            } catch (Throwable th2) {
                com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, bVar.f34988a, "Error while executing ML model", th2);
                c.f35017a.a(bVar.f34988a, "Error while executing ML model", th2);
                return new e.a.b(th2);
            }
        }
    }

    public static final class g extends Lambda implements l<h0, Result<? extends Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b<Input, Output> f35007a;

        public static final class a extends Lambda implements d10.a<Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b<Input, Output> f35008a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b<Input, Output> bVar) {
                super(0);
                this.f35008a = bVar;
            }

            public final void a() {
                InterpreterApi unused = this.f35008a.a();
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(b<Input, Output> bVar) {
            super(1);
            this.f35007a = bVar;
        }

        public final Object a(h0 h0Var) {
            Future submit = this.f35007a.i().submit(new g(this.f35007a));
            if (this.f35007a.c() <= 0) {
                return ((Result) submit.get()).m3081unboximpl();
            }
            try {
                return ((Result) submit.get(this.f35007a.c(), TimeUnit.MILLISECONDS)).m3081unboximpl();
            } catch (TimeoutException e11) {
                c cVar = c.f35017a;
                String d11 = this.f35007a.f34988a;
                c.a(cVar, d11, "MlSolution timeout (" + this.f35007a.h() + ')', (Throwable) null, 4, (Object) null);
                Result.a aVar = Result.Companion;
                return Result.m3072constructorimpl(k.a(e11));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Result.m3071boximpl(a((h0) obj));
        }

        public static final Result a(b bVar) {
            Object obj;
            try {
                bVar.f34989b.a((d10.a<Unit>) new a(bVar));
                c.b(c.f35017a, bVar.f34988a, "preloadModel finished", (Throwable) null, 4, (Object) null);
                Result.a aVar = Result.Companion;
                obj = Result.m3072constructorimpl(Boolean.TRUE);
            } catch (UnsatisfiedLinkError e11) {
                bVar.f34994g = true;
                c.f35017a.a(bVar.f34988a, "Error while loading TF library", e11);
                Result.a aVar2 = Result.Companion;
                obj = Result.m3072constructorimpl(k.a(e11));
            } catch (d e12) {
                bVar.f34994g = true;
                c.f35017a.a(bVar.f34988a, "Error while executing ML model", e12);
                Result.a aVar3 = Result.Companion;
                obj = Result.m3072constructorimpl(k.a(e12));
            } catch (Throwable th2) {
                c.f35017a.a(bVar.f34988a, "Error while executing ML model", th2);
                Result.a aVar4 = Result.Companion;
                obj = Result.m3072constructorimpl(k.a(th2));
            }
            return Result.m3071boximpl(obj);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(com.sumsub.sns.internal.ml.core.b r5, kotlin.coroutines.c r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.sumsub.sns.internal.ml.core.b.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.ml.core.b$a r0 = (com.sumsub.sns.internal.ml.core.b.a) r0
            int r1 = r0.f34998d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34998d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.ml.core.b$a r0 = new com.sumsub.sns.internal.ml.core.b$a
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f34996b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34998d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f34995a
            com.sumsub.sns.internal.ml.core.b r5 = (com.sumsub.sns.internal.ml.core.b) r5
            kotlin.k.b(r6)
            goto L_0x004d
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.k.b(r6)
            kotlinx.coroutines.ExecutorCoroutineDispatcher r6 = r5.b()
            com.sumsub.sns.internal.ml.core.b$b r2 = new com.sumsub.sns.internal.ml.core.b$b
            r4 = 0
            r2.<init>(r5, r4)
            r0.f34995a = r5
            r0.f34998d = r3
            java.lang.Object r6 = kotlinx.coroutines.g.g(r6, r2, r0)
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            java.util.concurrent.ExecutorService r5 = r5.i()
            r5.shutdown()
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.core.b.a(com.sumsub.sns.internal.ml.core.b, kotlin.coroutines.c):java.lang.Object");
    }

    public final InterpreterApi a() {
        InterpreterApi interpreterApi = this.f34990c;
        if (interpreterApi != null) {
            return interpreterApi;
        }
        InterpreterApi j11 = j();
        this.f34990c = j11;
        a(j11);
        return j11;
    }
}
