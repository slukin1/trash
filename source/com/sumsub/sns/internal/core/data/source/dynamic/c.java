package com.sumsub.sns.internal.core.data.source.dynamic;

import com.sumsub.sns.core.data.model.FlowType;
import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.core.data.model.remote.response.d;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class c implements b {

    /* renamed from: s  reason: collision with root package name */
    public static final a f33304s = new a((kotlin.jvm.internal.r) null);

    /* renamed from: t  reason: collision with root package name */
    public static final long f33305t = 120000;

    /* renamed from: u  reason: collision with root package name */
    public static final List<String> f33306u = CollectionsKt__CollectionsKt.n("ARG", "BRA", "ARM", com.sumsub.sns.internal.core.common.n0.f32118f, "ATF", "ATG", "AUS", "AUT", "AZE", "BDI", "BEL", "BEN");

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.settings.b f33307a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.a f33308b;

    /* renamed from: c  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.b f33309c;

    /* renamed from: d  reason: collision with root package name */
    public final kotlinx.coroutines.h0 f33310d;

    /* renamed from: e  reason: collision with root package name */
    public final CoroutineDispatcher f33311e;

    /* renamed from: f  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.b<String> f33312f;

    /* renamed from: g  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.b<String> f33313g;

    /* renamed from: h  reason: collision with root package name */
    public n1 f33314h;

    /* renamed from: i  reason: collision with root package name */
    public n1 f33315i;

    /* renamed from: j  reason: collision with root package name */
    public final a<com.sumsub.sns.internal.core.data.model.g, String> f33316j;

    /* renamed from: k  reason: collision with root package name */
    public final a<com.sumsub.sns.internal.core.data.model.g, String> f33317k;

    /* renamed from: l  reason: collision with root package name */
    public final a<com.sumsub.sns.internal.core.data.model.t, Unit> f33318l;

    /* renamed from: m  reason: collision with root package name */
    public final a<com.sumsub.sns.internal.core.data.model.e, Boolean> f33319m;

    /* renamed from: n  reason: collision with root package name */
    public final a<b.c, Unit> f33320n;

    /* renamed from: o  reason: collision with root package name */
    public final a<b.C0365b, Unit> f33321o;

    /* renamed from: p  reason: collision with root package name */
    public final f1<SNSMessage.ServerMessage> f33322p;

    /* renamed from: q  reason: collision with root package name */
    public final b1<b.a> f33323q;

    /* renamed from: r  reason: collision with root package name */
    public final b1<b.a> f33324r;

    public static final class a {

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$Companion", f = "DataRepositoryImpl.kt", l = {540}, m = "generateFakeAgreements")
        /* renamed from: com.sumsub.sns.internal.core.data.source.dynamic.c$a$a  reason: collision with other inner class name */
        public static final class C0366a extends ContinuationImpl {

            /* renamed from: a  reason: collision with root package name */
            public /* synthetic */ Object f33325a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f33326b;

            /* renamed from: c  reason: collision with root package name */
            public int f33327c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0366a(a aVar, kotlin.coroutines.c<? super C0366a> cVar) {
                super(cVar);
                this.f33326b = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f33325a = obj;
                this.f33327c |= Integer.MIN_VALUE;
                return this.f33326b.a((com.sumsub.sns.internal.core.data.source.common.b) null, this);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
            r14 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r14);
         */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(com.sumsub.sns.internal.core.data.source.common.b r14, kotlin.coroutines.c<? super java.util.List<com.sumsub.sns.internal.core.data.model.d>> r15) {
            /*
                r13 = this;
                boolean r0 = r15 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.a.C0366a
                if (r0 == 0) goto L_0x0013
                r0 = r15
                com.sumsub.sns.internal.core.data.source.dynamic.c$a$a r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.a.C0366a) r0
                int r1 = r0.f33327c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f33327c = r1
                goto L_0x0018
            L_0x0013:
                com.sumsub.sns.internal.core.data.source.dynamic.c$a$a r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$a$a
                r0.<init>(r13, r15)
            L_0x0018:
                java.lang.Object r15 = r0.f33325a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f33327c
                r3 = 1
                if (r2 == 0) goto L_0x0031
                if (r2 != r3) goto L_0x0029
                kotlin.k.b(r15)
                goto L_0x003d
            L_0x0029:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L_0x0031:
                kotlin.k.b(r15)
                r0.f33327c = r3
                java.lang.Object r15 = r14.d(r0)
                if (r15 != r1) goto L_0x003d
                return r1
            L_0x003d:
                java.util.List r15 = (java.util.List) r15
                com.sumsub.sns.internal.ff.a r14 = com.sumsub.sns.internal.ff.a.f34215a
                com.sumsub.sns.internal.ff.core.a r14 = r14.a()
                java.lang.String r14 = r14.f()
                if (r14 == 0) goto L_0x0056
                java.lang.Integer r14 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r14)
                if (r14 == 0) goto L_0x0056
                int r14 = r14.intValue()
                goto L_0x005a
            L_0x0056:
                int r14 = r15.size()
            L_0x005a:
                int r0 = r15.size()
                if (r14 >= r0) goto L_0x0065
                java.util.List r14 = kotlin.collections.CollectionsKt___CollectionsKt.B0(r15, r14)
                goto L_0x00c4
            L_0x0065:
                java.util.ArrayList r14 = new java.util.ArrayList
                r14.<init>()
                r14.addAll(r15)
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = 10
                int r1 = kotlin.collections.CollectionsKt__IterablesKt.u(r15, r1)
                r0.<init>(r1)
                java.util.Iterator r15 = r15.iterator()
            L_0x007c:
                boolean r1 = r15.hasNext()
                if (r1 == 0) goto L_0x00c4
                java.lang.Object r1 = r15.next()
                com.sumsub.sns.internal.core.data.model.d r1 = (com.sumsub.sns.internal.core.data.model.d) r1
                java.util.List r1 = com.sumsub.sns.internal.core.data.source.dynamic.c.f33306u
                kotlin.random.Random$Default r2 = kotlin.random.Random.Default
                java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.t0(r1, r2)
                r3 = r1
                java.lang.String r3 = (java.lang.String) r3
                com.sumsub.sns.internal.core.data.model.d r1 = new com.sumsub.sns.internal.core.data.model.d
                com.sumsub.sns.internal.core.data.model.c r11 = new com.sumsub.sns.internal.core.data.model.c
                r11.<init>(r3)
                com.sumsub.sns.internal.core.data.model.b r12 = new com.sumsub.sns.internal.core.data.model.b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "countries."
                r2.append(r4)
                r2.append(r3)
                java.lang.String r8 = r2.toString()
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r9 = 30
                r10 = 0
                r2 = r12
                r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.util.List) r6, (java.lang.String) r7, (java.lang.String) r8, (int) r9, (kotlin.jvm.internal.r) r10)
                r1.<init>(r11, r12)
                r14.add(r1)
                r0.add(r1)
                goto L_0x007c
            L_0x00c4:
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.a.a(com.sumsub.sns.internal.core.data.source.common.b, kotlin.coroutines.c):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getStringsAsResult$2", f = "DataRepositoryImpl.kt", l = {419}, m = "invokeSuspend")
    public static final class a0 extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super e<b.c>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33328a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33329b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(c cVar, kotlin.coroutines.c<? super a0> cVar2) {
            super(1, cVar2);
            this.f33329b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super e<b.c>> cVar) {
            return ((a0) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new a0(this.f33329b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33328a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a k11 = this.f33329b.f33320n;
                this.f33328a = 1;
                obj = a.b(k11, false, (Object) null, this, 2, (Object) null);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$applicantActionKeeper$1", f = "DataRepositoryImpl.kt", l = {81}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements d10.q<String, com.sumsub.sns.internal.core.data.model.g, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33330a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33331b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33332c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, kotlin.coroutines.c<? super b> cVar2) {
            super(3, cVar2);
            this.f33332c = cVar;
        }

        /* renamed from: a */
        public final Object invoke(String str, com.sumsub.sns.internal.core.data.model.g gVar, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> cVar) {
            b bVar = new b(this.f33332c, cVar);
            bVar.f33331b = str;
            return bVar.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33330a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                String str = (String) this.f33331b;
                com.sumsub.sns.internal.core.data.source.common.b c11 = this.f33332c.f33309c;
                if (str == null) {
                    str = this.f33332c.f33307a.b();
                }
                this.f33330a = 1;
                obj = c11.a(str, (kotlin.coroutines.c<? super d.c.C0351d>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return com.sumsub.sns.internal.core.data.model.remote.response.e.b((d.c.C0351d) obj);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$restartManualUpdate$1", f = "DataRepositoryImpl.kt", l = {445}, m = "invokeSuspend")
    public static final class b0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33333a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33334b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33335c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$restartManualUpdate$1$1", f = "DataRepositoryImpl.kt", l = {449}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33336a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f33337b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f33338c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, kotlin.coroutines.c<? super a> cVar2) {
                super(2, cVar2);
                this.f33338c = cVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(this.f33338c, cVar);
                aVar.f33337b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f33336a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    c cVar = this.f33338c;
                    this.f33336a = 1;
                    if (cVar.a((kotlinx.coroutines.h0) this.f33337b, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(c cVar, kotlin.coroutines.c<? super b0> cVar2) {
            super(2, cVar2);
            this.f33335c = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            b0 b0Var = new b0(this.f33335c, cVar);
            b0Var.f33334b = obj;
            return b0Var;
        }

        /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r9.f33333a
                r2 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 != r2) goto L_0x0014
                java.lang.Object r1 = r9.f33334b
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                kotlin.k.b(r10)
                r10 = r9
                goto L_0x0039
            L_0x0014:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001c:
                kotlin.k.b(r10)
                java.lang.Object r10 = r9.f33334b
                kotlinx.coroutines.h0 r10 = (kotlinx.coroutines.h0) r10
                r1 = r10
                r10 = r9
            L_0x0025:
                boolean r3 = kotlinx.coroutines.i0.i(r1)
                if (r3 == 0) goto L_0x0057
                r10.f33334b = r1
                r10.f33333a = r2
                r3 = 120000(0x1d4c0, double:5.9288E-319)
                java.lang.Object r3 = kotlinx.coroutines.DelayKt.b(r3, r10)
                if (r3 != r0) goto L_0x0039
                return r0
            L_0x0039:
                kotlinx.coroutines.i0.h(r1)
                com.sumsub.sns.core.c r3 = com.sumsub.sns.core.c.f30748a
                r6 = 0
                r7 = 4
                r8 = 0
                java.lang.String r4 = "DataRepository"
                java.lang.String r5 = "Manually updating data"
                com.sumsub.sns.core.c.b(r3, r4, r5, r6, r7, r8)
                com.sumsub.sns.internal.core.data.source.dynamic.c$b0$a r6 = new com.sumsub.sns.internal.core.data.source.dynamic.c$b0$a
                com.sumsub.sns.internal.core.data.source.dynamic.c r3 = r10.f33335c
                r4 = 0
                r6.<init>(r3, r4)
                r5 = 0
                r7 = 3
                r3 = r1
                kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r3, r4, r5, r6, r7, r8)
                goto L_0x0025
            L_0x0057:
                kotlin.Unit r10 = kotlin.Unit.f56620a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.b0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$applicantKeeper$1", f = "DataRepositoryImpl.kt", l = {92}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.internal.core.data.source.dynamic.c$c  reason: collision with other inner class name */
    public static final class C0367c extends SuspendLambda implements d10.q<String, com.sumsub.sns.internal.core.data.model.g, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33339a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33340b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33341c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0367c(c cVar, kotlin.coroutines.c<? super C0367c> cVar2) {
            super(3, cVar2);
            this.f33341c = cVar;
        }

        /* renamed from: a */
        public final Object invoke(String str, com.sumsub.sns.internal.core.data.model.g gVar, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> cVar) {
            C0367c cVar2 = new C0367c(this.f33341c, cVar);
            cVar2.f33340b = str;
            return cVar2.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33339a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                String str = (String) this.f33340b;
                com.sumsub.sns.internal.core.data.source.common.b c11 = this.f33341c.f33309c;
                if (str == null) {
                    str = this.f33341c.f33307a.a();
                }
                this.f33339a = 1;
                obj = c11.e(str, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return com.sumsub.sns.internal.core.data.model.remote.response.e.a((d.c.C0351d) obj);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$socketEventsFlow$1", f = "DataRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class c0 extends SuspendLambda implements d10.p<SNSMessage.ServerMessage, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33342a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33343b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33344c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$socketEventsFlow$1$2", f = "DataRepositoryImpl.kt", l = {261}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33345a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f33346b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f33347c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, kotlin.coroutines.c<? super a> cVar2) {
                super(2, cVar2);
                this.f33347c = cVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(this.f33347c, cVar);
                aVar.f33346b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f33345a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    c cVar = this.f33347c;
                    this.f33345a = 1;
                    if (cVar.a((kotlinx.coroutines.h0) this.f33346b, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$socketEventsFlow$1$4", f = "DataRepositoryImpl.kt", l = {268}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33348a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f33349b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f33350c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(c cVar, kotlin.coroutines.c<? super b> cVar2) {
                super(2, cVar2);
                this.f33350c = cVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                b bVar = new b(this.f33350c, cVar);
                bVar.f33349b = obj;
                return bVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f33348a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    c cVar = this.f33350c;
                    this.f33348a = 1;
                    if (cVar.a((kotlinx.coroutines.h0) this.f33349b, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$socketEventsFlow$1$6", f = "DataRepositoryImpl.kt", l = {276}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.core.data.source.dynamic.c$c0$c  reason: collision with other inner class name */
        public static final class C0368c extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33351a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f33352b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f33353c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0368c(c cVar, kotlin.coroutines.c<? super C0368c> cVar2) {
                super(2, cVar2);
                this.f33353c = cVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((C0368c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0368c cVar2 = new C0368c(this.f33353c, cVar);
                cVar2.f33352b = obj;
                return cVar2;
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f33351a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    c cVar = this.f33353c;
                    this.f33351a = 1;
                    if (cVar.b((kotlinx.coroutines.h0) this.f33352b, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(c cVar, kotlin.coroutines.c<? super c0> cVar2) {
            super(2, cVar2);
            this.f33344c = cVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSMessage.ServerMessage serverMessage, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c0) create(serverMessage, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c0 c0Var = new c0(this.f33344c, cVar);
            c0Var.f33343b = obj;
            return c0Var;
        }

        public final Object invokeSuspend(Object obj) {
            String d11;
            String d12;
            String e11;
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f33342a == 0) {
                kotlin.k.b(obj);
                SNSMessage.ServerMessage serverMessage = (SNSMessage.ServerMessage) this.f33343b;
                com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                com.sumsub.sns.core.c.b(cVar, d.f33473a, "Socket event " + serverMessage.a() + com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b + serverMessage, (Throwable) null, 4, (Object) null);
                if (serverMessage instanceof SNSMessage.ServerMessage.e) {
                    SNSMessage.ServerMessage.e.c d13 = ((SNSMessage.ServerMessage.e) serverMessage).d();
                    if (!(d13 == null || (e11 = d13.e()) == null)) {
                        this.f33344c.f33312f.a(e11);
                    }
                    n1 unused2 = kotlinx.coroutines.i.d(this.f33344c.f33310d, this.f33344c.f33311e, (CoroutineStart) null, new a(this.f33344c, (kotlin.coroutines.c<? super a>) null), 2, (Object) null);
                } else if (serverMessage instanceof SNSMessage.ServerMessage.g) {
                    SNSMessage.ServerMessage.g.c d14 = ((SNSMessage.ServerMessage.g) serverMessage).d();
                    if (!(d14 == null || (d12 = d14.d()) == null)) {
                        this.f33344c.f33312f.a(d12);
                    }
                    n1 unused3 = kotlinx.coroutines.i.d(this.f33344c.f33310d, this.f33344c.f33311e, (CoroutineStart) null, new b(this.f33344c, (kotlin.coroutines.c<? super b>) null), 2, (Object) null);
                    this.f33344c.i();
                } else if (serverMessage instanceof SNSMessage.ServerMessage.c) {
                    SNSMessage.ServerMessage.c.C0335c d15 = ((SNSMessage.ServerMessage.c) serverMessage).d();
                    if (!(d15 == null || (d11 = d15.d()) == null)) {
                        this.f33344c.f33312f.a(d11);
                    }
                    n1 unused4 = kotlinx.coroutines.i.d(this.f33344c.f33310d, this.f33344c.f33311e, (CoroutineStart) null, new C0368c(this.f33344c, (kotlin.coroutines.c<? super C0368c>) null), 2, (Object) null);
                    this.f33344c.i();
                } else if (serverMessage instanceof SNSMessage.ServerMessage.b) {
                    this.f33344c.i();
                } else if (!(serverMessage instanceof SNSMessage.ServerMessage.f)) {
                    com.sumsub.sns.core.c.b(cVar, d.f33473a, "event dropped", (Throwable) null, 4, (Object) null);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$configKeeper$1", f = "DataRepositoryImpl.kt", l = {143, 167}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements d10.q<Boolean, com.sumsub.sns.internal.core.data.model.e, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33354a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33355b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33356c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33357d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar, kotlin.coroutines.c<? super d> cVar2) {
            super(3, cVar2);
            this.f33357d = cVar;
        }

        /* renamed from: a */
        public final Object invoke(Boolean bool, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e> cVar) {
            d dVar = new d(this.f33357d, cVar);
            dVar.f33355b = bool;
            dVar.f33356c = eVar;
            return dVar.invokeSuspend(Unit.f56620a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:216:0x0362, code lost:
            if (r0 == null) goto L_0x0369;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:327:0x051e, code lost:
            if (r0 != null) goto L_0x052d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0169, code lost:
            if (r4 == null) goto L_0x016b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x019a  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x01aa  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x01c2  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x01c7  */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x01ce  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x0284  */
        /* JADX WARNING: Removed duplicated region for block: B:213:0x0357  */
        /* JADX WARNING: Removed duplicated region for block: B:217:0x0365  */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x036b  */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x0370  */
        /* JADX WARNING: Removed duplicated region for block: B:226:0x037f  */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x0384  */
        /* JADX WARNING: Removed duplicated region for block: B:230:0x038b  */
        /* JADX WARNING: Removed duplicated region for block: B:274:0x0441  */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0513  */
        /* JADX WARNING: Removed duplicated region for block: B:328:0x0521  */
        /* JADX WARNING: Removed duplicated region for block: B:330:0x0527  */
        /* JADX WARNING: Removed duplicated region for block: B:331:0x052c  */
        /* JADX WARNING: Removed duplicated region for block: B:334:0x0539  */
        /* JADX WARNING: Removed duplicated region for block: B:338:0x0543  */
        /* JADX WARNING: Removed duplicated region for block: B:339:0x054a  */
        /* JADX WARNING: Removed duplicated region for block: B:341:0x054e  */
        /* JADX WARNING: Removed duplicated region for block: B:342:0x0555  */
        /* JADX WARNING: Removed duplicated region for block: B:345:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:348:0x0569  */
        /* JADX WARNING: Removed duplicated region for block: B:359:0x05b2  */
        /* JADX WARNING: Removed duplicated region for block: B:360:0x05bc  */
        /* JADX WARNING: Removed duplicated region for block: B:363:0x05c1  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
        /* JADX WARNING: Removed duplicated region for block: B:373:0x05f0  */
        /* JADX WARNING: Removed duplicated region for block: B:375:0x05fb  */
        /* JADX WARNING: Removed duplicated region for block: B:387:0x0162 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:397:0x0287 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:406:0x035a A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:415:0x0444 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:424:0x0516 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x015f  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x016d  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0173  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x017a  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x018a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                r24 = this;
                r0 = r24
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f33354a
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x002a
                if (r2 == r4) goto L_0x0020
                if (r2 != r3) goto L_0x0018
                kotlin.k.b(r25)
                r2 = r25
                r5 = 0
                goto L_0x05a4
            L_0x0018:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0020:
                java.lang.Object r1 = r0.f33355b
                com.sumsub.sns.internal.core.data.model.e r1 = (com.sumsub.sns.internal.core.data.model.e) r1
                kotlin.k.b(r25)
                r2 = r25
                goto L_0x0080
            L_0x002a:
                kotlin.k.b(r25)
                java.lang.Object r2 = r0.f33355b
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                java.lang.Object r6 = r0.f33356c
                com.sumsub.sns.internal.core.data.model.e r6 = (com.sumsub.sns.internal.core.data.model.e) r6
                com.sumsub.sns.internal.core.common.c0 r7 = com.sumsub.sns.internal.core.common.c0.f32001a
                com.sumsub.sns.internal.core.common.e0 r8 = com.sumsub.sns.internal.core.common.e0.f32018a
                java.util.Locale r9 = r8.getLocale()
                java.lang.String r7 = r7.a((java.util.Locale) r9)
                com.sumsub.sns.core.c r9 = com.sumsub.sns.core.c.f30748a
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r11 = "updating config, reinit="
                r10.append(r11)
                r10.append(r2)
                java.lang.String r11 = ", language="
                r10.append(r11)
                r10.append(r7)
                java.lang.String r11 = r10.toString()
                r12 = 0
                r13 = 4
                r14 = 0
                java.lang.String r10 = "DataRepository"
                com.sumsub.sns.core.c.b(r9, r10, r11, r12, r13, r14)
                java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.a.a(r4)
                boolean r2 = kotlin.jvm.internal.x.b(r2, r9)
                if (r2 == 0) goto L_0x0581
                com.sumsub.sns.internal.core.data.source.dynamic.c r2 = r0.f33357d
                com.sumsub.sns.internal.core.data.source.common.b r2 = r2.f33309c
                r0.f33355b = r6
                r0.f33354a = r4
                java.lang.Object r2 = r2.b(r7, r0)
                if (r2 != r1) goto L_0x007f
                return r1
            L_0x007f:
                r1 = r6
            L_0x0080:
                com.sumsub.sns.internal.core.data.model.remote.i r2 = (com.sumsub.sns.internal.core.data.model.remote.i) r2
                com.sumsub.sns.internal.core.data.model.e r3 = com.sumsub.sns.internal.core.data.model.remote.j.a(r2)
                java.lang.String r6 = r2.x()
                if (r6 != 0) goto L_0x0098
                if (r1 == 0) goto L_0x0093
                java.lang.String r6 = r1.s()
                goto L_0x0094
            L_0x0093:
                r6 = 0
            L_0x0094:
                if (r6 != 0) goto L_0x0098
                java.lang.String r6 = "<unknown>"
            L_0x0098:
                r8 = r6
                com.sumsub.sns.core.data.model.FlowType r6 = r2.J()
                if (r6 != 0) goto L_0x00ab
                if (r1 == 0) goto L_0x00a6
                com.sumsub.sns.core.data.model.FlowType r6 = r1.y()
                goto L_0x00a7
            L_0x00a6:
                r6 = 0
            L_0x00a7:
                if (r6 != 0) goto L_0x00ab
                com.sumsub.sns.core.data.model.FlowType r6 = com.sumsub.sns.core.data.model.FlowType.Standalone
            L_0x00ab:
                r9 = r6
                java.lang.String r6 = r2.L()
                if (r6 != 0) goto L_0x00bb
                if (r1 == 0) goto L_0x00b9
                java.lang.String r6 = r1.z()
                goto L_0x00bb
            L_0x00b9:
                r10 = 0
                goto L_0x00bc
            L_0x00bb:
                r10 = r6
            L_0x00bc:
                java.util.Map r6 = r2.R()
                if (r6 == 0) goto L_0x016b
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                java.util.Set r6 = r6.entrySet()
                java.util.Iterator r6 = r6.iterator()
            L_0x00cf:
                boolean r11 = r6.hasNext()
                if (r11 == 0) goto L_0x0165
                java.lang.Object r11 = r6.next()
                java.util.Map$Entry r11 = (java.util.Map.Entry) r11
                java.lang.Object r12 = r11.getKey()
                boolean r13 = r12 instanceof java.lang.String
                if (r13 != 0) goto L_0x00e4
                r12 = 0
            L_0x00e4:
                java.lang.String r12 = (java.lang.String) r12
                if (r12 != 0) goto L_0x00ea
                goto L_0x015c
            L_0x00ea:
                java.lang.Object r11 = r11.getValue()
                boolean r13 = r11 instanceof java.util.Map
                if (r13 == 0) goto L_0x00f5
                java.util.Map r11 = (java.util.Map) r11
                goto L_0x00f6
            L_0x00f5:
                r11 = 0
            L_0x00f6:
                if (r11 == 0) goto L_0x015c
                java.util.Set r13 = r11.keySet()
                if (r13 == 0) goto L_0x015c
                java.util.ArrayList r14 = new java.util.ArrayList
                r14.<init>()
                java.util.Iterator r13 = r13.iterator()
            L_0x0107:
                boolean r15 = r13.hasNext()
                if (r15 == 0) goto L_0x0119
                java.lang.Object r15 = r13.next()
                boolean r5 = r15 instanceof java.lang.Object
                if (r5 == 0) goto L_0x0107
                r14.add(r15)
                goto L_0x0107
            L_0x0119:
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.Iterator r13 = r14.iterator()
            L_0x0122:
                boolean r14 = r13.hasNext()
                if (r14 == 0) goto L_0x0145
                java.lang.Object r14 = r13.next()
                java.lang.Object r15 = r11.get(r14)
                boolean r4 = r15 instanceof java.lang.Object
                if (r4 == 0) goto L_0x0135
                goto L_0x0136
            L_0x0135:
                r15 = 0
            L_0x0136:
                if (r15 == 0) goto L_0x013d
                kotlin.Pair r4 = kotlin.l.a(r14, r15)
                goto L_0x013e
            L_0x013d:
                r4 = 0
            L_0x013e:
                if (r4 == 0) goto L_0x0143
                r5.add(r4)
            L_0x0143:
                r4 = 1
                goto L_0x0122
            L_0x0145:
                boolean r4 = r5.isEmpty()
                r11 = 1
                r4 = r4 ^ r11
                if (r4 == 0) goto L_0x014e
                goto L_0x014f
            L_0x014e:
                r5 = 0
            L_0x014f:
                if (r5 == 0) goto L_0x015c
                java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r5)
                if (r4 == 0) goto L_0x015c
                kotlin.Pair r4 = kotlin.l.a(r12, r4)
                goto L_0x015d
            L_0x015c:
                r4 = 0
            L_0x015d:
                if (r4 == 0) goto L_0x0162
                r7.add(r4)
            L_0x0162:
                r4 = 1
                goto L_0x00cf
            L_0x0165:
                java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.s(r7)
                if (r4 != 0) goto L_0x0171
            L_0x016b:
                if (r1 == 0) goto L_0x0173
                java.util.Map r4 = r1.C()
            L_0x0171:
                r11 = r4
                goto L_0x0174
            L_0x0173:
                r11 = 0
            L_0x0174:
                java.util.Map r4 = r2.z()
                if (r4 != 0) goto L_0x0183
                if (r1 == 0) goto L_0x0181
                java.util.Map r4 = r1.v()
                goto L_0x0183
            L_0x0181:
                r12 = 0
                goto L_0x0184
            L_0x0183:
                r12 = r4
            L_0x0184:
                java.util.Map r4 = r2.V()
                if (r4 != 0) goto L_0x0193
                if (r1 == 0) goto L_0x0191
                java.util.Map r4 = r1.E()
                goto L_0x0193
            L_0x0191:
                r13 = 0
                goto L_0x0194
            L_0x0193:
                r13 = r4
            L_0x0194:
                java.util.Map r4 = r2.P()
                if (r4 != 0) goto L_0x01a3
                if (r1 == 0) goto L_0x01a1
                java.util.Map r4 = r1.B()
                goto L_0x01a3
            L_0x01a1:
                r14 = 0
                goto L_0x01a4
            L_0x01a3:
                r14 = r4
            L_0x01a4:
                java.util.Map r4 = r2.N()
                if (r4 != 0) goto L_0x01b3
                if (r1 == 0) goto L_0x01b1
                java.util.Map r4 = r1.A()
                goto L_0x01b3
            L_0x01b1:
                r15 = 0
                goto L_0x01b4
            L_0x01b3:
                r15 = r4
            L_0x01b4:
                java.util.Map r4 = r2.T()
                if (r4 == 0) goto L_0x01c0
                java.util.Map r4 = com.sumsub.sns.internal.core.common.i.c((java.util.Map<java.lang.String, ? extends java.lang.Object>) r4)
                if (r4 != 0) goto L_0x01c8
            L_0x01c0:
                if (r1 == 0) goto L_0x01c7
                java.util.Map r4 = r1.D()
                goto L_0x01c8
            L_0x01c7:
                r4 = 0
            L_0x01c8:
                java.util.Map r5 = r2.R()
                if (r5 == 0) goto L_0x0365
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Set r5 = r5.entrySet()
                java.util.Iterator r5 = r5.iterator()
            L_0x01db:
                boolean r7 = r5.hasNext()
                if (r7 == 0) goto L_0x0291
                java.lang.Object r7 = r5.next()
                java.util.Map$Entry r7 = (java.util.Map.Entry) r7
                r25 = r5
                java.lang.Object r5 = r7.getKey()
                boolean r0 = r5 instanceof java.lang.String
                if (r0 != 0) goto L_0x01f2
                r5 = 0
            L_0x01f2:
                java.lang.String r5 = (java.lang.String) r5
                if (r5 != 0) goto L_0x01fc
            L_0x01f6:
                r17 = r4
                r18 = r15
                goto L_0x0281
            L_0x01fc:
                java.lang.Object r0 = r7.getValue()
                boolean r7 = r0 instanceof java.util.Map
                if (r7 == 0) goto L_0x0207
                java.util.Map r0 = (java.util.Map) r0
                goto L_0x0208
            L_0x0207:
                r0 = 0
            L_0x0208:
                if (r0 == 0) goto L_0x01f6
                java.util.Set r7 = r0.keySet()
                if (r7 == 0) goto L_0x01f6
                r17 = r4
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Iterator r7 = r7.iterator()
            L_0x021b:
                boolean r18 = r7.hasNext()
                if (r18 == 0) goto L_0x0235
                r18 = r15
                java.lang.Object r15 = r7.next()
                r19 = r7
                boolean r7 = r15 instanceof java.lang.Object
                if (r7 == 0) goto L_0x0230
                r4.add(r15)
            L_0x0230:
                r15 = r18
                r7 = r19
                goto L_0x021b
            L_0x0235:
                r18 = r15
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                java.util.Iterator r4 = r4.iterator()
            L_0x0240:
                boolean r15 = r4.hasNext()
                if (r15 == 0) goto L_0x026a
                java.lang.Object r15 = r4.next()
                r19 = r4
                java.lang.Object r4 = r0.get(r15)
                r20 = r0
                boolean r0 = r4 instanceof java.lang.Object
                if (r0 == 0) goto L_0x0257
                goto L_0x0258
            L_0x0257:
                r4 = 0
            L_0x0258:
                if (r4 == 0) goto L_0x025f
                kotlin.Pair r0 = kotlin.l.a(r15, r4)
                goto L_0x0260
            L_0x025f:
                r0 = 0
            L_0x0260:
                if (r0 == 0) goto L_0x0265
                r7.add(r0)
            L_0x0265:
                r4 = r19
                r0 = r20
                goto L_0x0240
            L_0x026a:
                boolean r0 = r7.isEmpty()
                r4 = 1
                r0 = r0 ^ r4
                if (r0 == 0) goto L_0x0273
                goto L_0x0274
            L_0x0273:
                r7 = 0
            L_0x0274:
                if (r7 == 0) goto L_0x0281
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r7)
                if (r0 == 0) goto L_0x0281
                kotlin.Pair r0 = kotlin.l.a(r5, r0)
                goto L_0x0282
            L_0x0281:
                r0 = 0
            L_0x0282:
                if (r0 == 0) goto L_0x0287
                r6.add(r0)
            L_0x0287:
                r0 = r24
                r5 = r25
                r4 = r17
                r15 = r18
                goto L_0x01db
            L_0x0291:
                r17 = r4
                r18 = r15
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r6)
                if (r0 == 0) goto L_0x0369
                java.lang.String r4 = "countryStates"
                java.lang.Object r0 = r0.get(r4)
                java.util.Map r0 = (java.util.Map) r0
                if (r0 == 0) goto L_0x0369
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L_0x02b2:
                boolean r5 = r0.hasNext()
                if (r5 == 0) goto L_0x035e
                java.lang.Object r5 = r0.next()
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r6 = r5.getKey()
                boolean r7 = r6 instanceof java.lang.String
                if (r7 != 0) goto L_0x02c7
                r6 = 0
            L_0x02c7:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 != 0) goto L_0x02cf
            L_0x02cb:
                r25 = r0
                goto L_0x0354
            L_0x02cf:
                java.lang.Object r5 = r5.getValue()
                boolean r7 = r5 instanceof java.util.Map
                if (r7 == 0) goto L_0x02da
                java.util.Map r5 = (java.util.Map) r5
                goto L_0x02db
            L_0x02da:
                r5 = 0
            L_0x02db:
                if (r5 == 0) goto L_0x02cb
                java.util.Set r7 = r5.keySet()
                if (r7 == 0) goto L_0x02cb
                java.util.ArrayList r15 = new java.util.ArrayList
                r15.<init>()
                java.util.Iterator r7 = r7.iterator()
            L_0x02ec:
                boolean r19 = r7.hasNext()
                if (r19 == 0) goto L_0x0306
                r25 = r0
                java.lang.Object r0 = r7.next()
                r19 = r7
                boolean r7 = r0 instanceof java.lang.String
                if (r7 == 0) goto L_0x0301
                r15.add(r0)
            L_0x0301:
                r0 = r25
                r7 = r19
                goto L_0x02ec
            L_0x0306:
                r25 = r0
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Iterator r7 = r15.iterator()
            L_0x0311:
                boolean r15 = r7.hasNext()
                if (r15 == 0) goto L_0x033d
                java.lang.Object r15 = r7.next()
                r19 = r7
                java.lang.Object r7 = r5.get(r15)
                r20 = r5
                boolean r5 = r7 instanceof java.lang.String
                if (r5 == 0) goto L_0x0328
                goto L_0x0329
            L_0x0328:
                r7 = 0
            L_0x0329:
                if (r7 == 0) goto L_0x0332
                java.lang.String r7 = (java.lang.String) r7
                kotlin.Pair r5 = kotlin.l.a(r15, r7)
                goto L_0x0333
            L_0x0332:
                r5 = 0
            L_0x0333:
                if (r5 == 0) goto L_0x0338
                r0.add(r5)
            L_0x0338:
                r7 = r19
                r5 = r20
                goto L_0x0311
            L_0x033d:
                boolean r5 = r0.isEmpty()
                r7 = 1
                r5 = r5 ^ r7
                if (r5 == 0) goto L_0x0346
                goto L_0x0347
            L_0x0346:
                r0 = 0
            L_0x0347:
                if (r0 == 0) goto L_0x0354
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r0)
                if (r0 == 0) goto L_0x0354
                kotlin.Pair r0 = kotlin.l.a(r6, r0)
                goto L_0x0355
            L_0x0354:
                r0 = 0
            L_0x0355:
                if (r0 == 0) goto L_0x035a
                r4.add(r0)
            L_0x035a:
                r0 = r25
                goto L_0x02b2
            L_0x035e:
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r4)
                if (r0 != 0) goto L_0x0371
                goto L_0x0369
            L_0x0365:
                r17 = r4
                r18 = r15
            L_0x0369:
                if (r1 == 0) goto L_0x0370
                java.util.Map r0 = r1.u()
                goto L_0x0371
            L_0x0370:
                r0 = 0
            L_0x0371:
                com.sumsub.sns.internal.core.data.model.remote.a r4 = r2.B()
                if (r4 == 0) goto L_0x037d
                java.util.Map r4 = com.sumsub.sns.internal.core.data.model.f.a((com.sumsub.sns.internal.core.data.model.remote.a) r4)
                if (r4 != 0) goto L_0x0385
            L_0x037d:
                if (r1 == 0) goto L_0x0384
                java.util.Map r4 = r1.w()
                goto L_0x0385
            L_0x0384:
                r4 = 0
            L_0x0385:
                java.util.Map r5 = r2.R()
                if (r5 == 0) goto L_0x0521
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Set r5 = r5.entrySet()
                java.util.Iterator r5 = r5.iterator()
            L_0x0398:
                boolean r7 = r5.hasNext()
                if (r7 == 0) goto L_0x044c
                java.lang.Object r7 = r5.next()
                java.util.Map$Entry r7 = (java.util.Map.Entry) r7
                java.lang.Object r15 = r7.getKey()
                r25 = r5
                boolean r5 = r15 instanceof java.lang.String
                if (r5 != 0) goto L_0x03af
                r15 = 0
            L_0x03af:
                java.lang.String r15 = (java.lang.String) r15
                if (r15 != 0) goto L_0x03b9
            L_0x03b3:
                r20 = r0
                r19 = r4
                goto L_0x043e
            L_0x03b9:
                java.lang.Object r5 = r7.getValue()
                boolean r7 = r5 instanceof java.util.Map
                if (r7 == 0) goto L_0x03c4
                java.util.Map r5 = (java.util.Map) r5
                goto L_0x03c5
            L_0x03c4:
                r5 = 0
            L_0x03c5:
                if (r5 == 0) goto L_0x03b3
                java.util.Set r7 = r5.keySet()
                if (r7 == 0) goto L_0x03b3
                r19 = r4
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Iterator r7 = r7.iterator()
            L_0x03d8:
                boolean r20 = r7.hasNext()
                if (r20 == 0) goto L_0x03f2
                r20 = r0
                java.lang.Object r0 = r7.next()
                r21 = r7
                boolean r7 = r0 instanceof java.lang.Object
                if (r7 == 0) goto L_0x03ed
                r4.add(r0)
            L_0x03ed:
                r0 = r20
                r7 = r21
                goto L_0x03d8
            L_0x03f2:
                r20 = r0
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Iterator r4 = r4.iterator()
            L_0x03fd:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto L_0x0427
                java.lang.Object r7 = r4.next()
                r21 = r4
                java.lang.Object r4 = r5.get(r7)
                r22 = r5
                boolean r5 = r4 instanceof java.lang.Object
                if (r5 == 0) goto L_0x0414
                goto L_0x0415
            L_0x0414:
                r4 = 0
            L_0x0415:
                if (r4 == 0) goto L_0x041c
                kotlin.Pair r4 = kotlin.l.a(r7, r4)
                goto L_0x041d
            L_0x041c:
                r4 = 0
            L_0x041d:
                if (r4 == 0) goto L_0x0422
                r0.add(r4)
            L_0x0422:
                r4 = r21
                r5 = r22
                goto L_0x03fd
            L_0x0427:
                boolean r4 = r0.isEmpty()
                r5 = 1
                r4 = r4 ^ r5
                if (r4 == 0) goto L_0x0430
                goto L_0x0431
            L_0x0430:
                r0 = 0
            L_0x0431:
                if (r0 == 0) goto L_0x043e
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r0)
                if (r0 == 0) goto L_0x043e
                kotlin.Pair r0 = kotlin.l.a(r15, r0)
                goto L_0x043f
            L_0x043e:
                r0 = 0
            L_0x043f:
                if (r0 == 0) goto L_0x0444
                r6.add(r0)
            L_0x0444:
                r5 = r25
                r4 = r19
                r0 = r20
                goto L_0x0398
            L_0x044c:
                r20 = r0
                r19 = r4
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r6)
                if (r0 == 0) goto L_0x0525
                java.lang.String r4 = "countryDependingFields"
                java.lang.Object r0 = r0.get(r4)
                java.util.Map r0 = (java.util.Map) r0
                if (r0 == 0) goto L_0x0525
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L_0x046d:
                boolean r5 = r0.hasNext()
                if (r5 == 0) goto L_0x051a
                java.lang.Object r5 = r0.next()
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r6 = r5.getKey()
                boolean r7 = r6 instanceof java.lang.String
                if (r7 != 0) goto L_0x0482
                r6 = 0
            L_0x0482:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 != 0) goto L_0x048b
            L_0x0486:
                r25 = r0
                r7 = 1
                goto L_0x0510
            L_0x048b:
                java.lang.Object r5 = r5.getValue()
                boolean r7 = r5 instanceof java.util.Map
                if (r7 == 0) goto L_0x0496
                java.util.Map r5 = (java.util.Map) r5
                goto L_0x0497
            L_0x0496:
                r5 = 0
            L_0x0497:
                if (r5 == 0) goto L_0x0486
                java.util.Set r7 = r5.keySet()
                if (r7 == 0) goto L_0x0486
                java.util.ArrayList r15 = new java.util.ArrayList
                r15.<init>()
                java.util.Iterator r7 = r7.iterator()
            L_0x04a8:
                boolean r21 = r7.hasNext()
                if (r21 == 0) goto L_0x04c2
                r25 = r0
                java.lang.Object r0 = r7.next()
                r21 = r7
                boolean r7 = r0 instanceof java.lang.String
                if (r7 == 0) goto L_0x04bd
                r15.add(r0)
            L_0x04bd:
                r0 = r25
                r7 = r21
                goto L_0x04a8
            L_0x04c2:
                r25 = r0
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Iterator r7 = r15.iterator()
            L_0x04cd:
                boolean r15 = r7.hasNext()
                if (r15 == 0) goto L_0x04f9
                java.lang.Object r15 = r7.next()
                r21 = r7
                java.lang.Object r7 = r5.get(r15)
                r22 = r5
                boolean r5 = r7 instanceof java.lang.String
                if (r5 == 0) goto L_0x04e4
                goto L_0x04e5
            L_0x04e4:
                r7 = 0
            L_0x04e5:
                if (r7 == 0) goto L_0x04ee
                java.lang.String r7 = (java.lang.String) r7
                kotlin.Pair r5 = kotlin.l.a(r15, r7)
                goto L_0x04ef
            L_0x04ee:
                r5 = 0
            L_0x04ef:
                if (r5 == 0) goto L_0x04f4
                r0.add(r5)
            L_0x04f4:
                r7 = r21
                r5 = r22
                goto L_0x04cd
            L_0x04f9:
                boolean r5 = r0.isEmpty()
                r7 = 1
                r5 = r5 ^ r7
                if (r5 == 0) goto L_0x0502
                goto L_0x0503
            L_0x0502:
                r0 = 0
            L_0x0503:
                if (r0 == 0) goto L_0x0510
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r0)
                if (r0 == 0) goto L_0x0510
                kotlin.Pair r0 = kotlin.l.a(r6, r0)
                goto L_0x0511
            L_0x0510:
                r0 = 0
            L_0x0511:
                if (r0 == 0) goto L_0x0516
                r4.add(r0)
            L_0x0516:
                r0 = r25
                goto L_0x046d
            L_0x051a:
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r4)
                if (r0 == 0) goto L_0x0525
                goto L_0x052d
            L_0x0521:
                r20 = r0
                r19 = r4
            L_0x0525:
                if (r1 == 0) goto L_0x052c
                java.util.Map r0 = r1.t()
                goto L_0x052d
            L_0x052c:
                r0 = 0
            L_0x052d:
                com.sumsub.sns.internal.core.data.model.w$a r4 = com.sumsub.sns.internal.core.data.model.w.f32937c
                java.util.Map r2 = r2.R()
                java.util.Map r2 = r4.b(r2)
                if (r2 != 0) goto L_0x0541
                if (r1 == 0) goto L_0x0540
                java.util.Map r2 = r1.x()
                goto L_0x0541
            L_0x0540:
                r2 = 0
            L_0x0541:
                if (r1 == 0) goto L_0x054a
                java.lang.String r4 = r1.F()
                r21 = r4
                goto L_0x054c
            L_0x054a:
                r21 = 0
            L_0x054c:
                if (r1 == 0) goto L_0x0555
                java.lang.String r4 = r1.q()
                r22 = r4
                goto L_0x0557
            L_0x0555:
                r22 = 0
            L_0x0557:
                com.sumsub.sns.internal.core.data.model.e$a r3 = r3.r()
                if (r3 != 0) goto L_0x0569
                if (r1 == 0) goto L_0x0566
                com.sumsub.sns.internal.core.data.model.e$a r1 = r1.r()
                r23 = r1
                goto L_0x056b
            L_0x0566:
                r23 = 0
                goto L_0x056b
            L_0x0569:
                r23 = r3
            L_0x056b:
                com.sumsub.sns.internal.core.data.model.e r1 = new com.sumsub.sns.internal.core.data.model.e
                r7 = r1
                r15 = r18
                r16 = r17
                r17 = r20
                r18 = r19
                r19 = r0
                r20 = r2
                r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                r0 = r24
                r5 = 0
                goto L_0x05aa
            L_0x0581:
                com.sumsub.sns.internal.core.data.source.dynamic.c r2 = r0.f33357d
                com.sumsub.sns.internal.core.data.source.common.b r2 = r2.f33309c
                com.sumsub.sns.core.data.model.SNSInitConfig r4 = r8.getConf()
                if (r4 != 0) goto L_0x0598
                com.sumsub.sns.core.data.model.SNSInitConfig r4 = new com.sumsub.sns.core.data.model.SNSInitConfig
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 7
                r13 = 0
                r8 = r4
                r8.<init>((java.lang.String) r9, (java.lang.String) r10, (java.util.Map) r11, (int) r12, (kotlin.jvm.internal.r) r13)
            L_0x0598:
                r5 = 0
                r0.f33355b = r5
                r0.f33354a = r3
                java.lang.Object r2 = r2.a((com.sumsub.sns.core.data.model.SNSInitConfig) r4, (java.lang.String) r7, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.i>) r0)
                if (r2 != r1) goto L_0x05a4
                return r1
            L_0x05a4:
                com.sumsub.sns.internal.core.data.model.remote.i r2 = (com.sumsub.sns.internal.core.data.model.remote.i) r2
                com.sumsub.sns.internal.core.data.model.e r1 = com.sumsub.sns.internal.core.data.model.remote.j.a(r2)
            L_0x05aa:
                com.sumsub.sns.internal.core.data.source.dynamic.c r2 = r0.f33357d
                java.lang.String r3 = r1.F()
                if (r3 == 0) goto L_0x05bc
                com.sumsub.sns.internal.core.b r4 = r2.f33313g
                r4.a(r3)
                kotlin.Unit r3 = kotlin.Unit.f56620a
                goto L_0x05bd
            L_0x05bc:
                r3 = r5
            L_0x05bd:
                java.lang.String r4 = ""
                if (r3 != 0) goto L_0x05ea
                com.sumsub.sns.internal.ff.a r3 = com.sumsub.sns.internal.ff.a.f34215a
                com.sumsub.sns.internal.ff.core.a r6 = r3.u()
                boolean r6 = r6.g()
                if (r6 == 0) goto L_0x05ea
                org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x05ea }
                com.sumsub.sns.internal.ff.core.a r3 = r3.u()     // Catch:{ Exception -> 0x05ea }
                java.lang.String r3 = r3.f()     // Catch:{ Exception -> 0x05ea }
                if (r3 != 0) goto L_0x05da
                r3 = r4
            L_0x05da:
                r6.<init>(r3)     // Catch:{ Exception -> 0x05ea }
                java.lang.String r3 = "verificationUrl"
                java.lang.String r3 = r6.optString(r3)     // Catch:{ Exception -> 0x05ea }
                com.sumsub.sns.internal.core.b r6 = r2.f33313g     // Catch:{ Exception -> 0x05ea }
                r6.a(r3)     // Catch:{ Exception -> 0x05ea }
            L_0x05ea:
                java.lang.String r3 = r1.q()
                if (r3 == 0) goto L_0x05f9
                com.sumsub.sns.internal.core.b r5 = r2.f33312f
                r5.a(r3)
                kotlin.Unit r5 = kotlin.Unit.f56620a
            L_0x05f9:
                if (r5 != 0) goto L_0x0625
                com.sumsub.sns.internal.ff.a r3 = com.sumsub.sns.internal.ff.a.f34215a
                com.sumsub.sns.internal.ff.core.a r5 = r3.u()
                boolean r5 = r5.g()
                if (r5 == 0) goto L_0x0625
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0625 }
                com.sumsub.sns.internal.ff.core.a r3 = r3.u()     // Catch:{ Exception -> 0x0625 }
                java.lang.String r3 = r3.f()     // Catch:{ Exception -> 0x0625 }
                if (r3 != 0) goto L_0x0614
                goto L_0x0615
            L_0x0614:
                r4 = r3
            L_0x0615:
                r5.<init>(r4)     // Catch:{ Exception -> 0x0625 }
                java.lang.String r3 = "accessToken"
                java.lang.String r3 = r5.optString(r3)     // Catch:{ Exception -> 0x0625 }
                com.sumsub.sns.internal.core.b r2 = r2.f33312f     // Catch:{ Exception -> 0x0625 }
                r2.a(r3)     // Catch:{ Exception -> 0x0625 }
            L_0x0625:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$socketEventsFlow$2", f = "DataRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class d0 extends SuspendLambda implements d10.p<kotlinx.coroutines.flow.e<? super SNSMessage.ServerMessage>, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33358a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33359b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(c cVar, kotlin.coroutines.c<? super d0> cVar2) {
            super(2, cVar2);
            this.f33359b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super SNSMessage.ServerMessage> eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d0) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d0(this.f33359b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f33358a == 0) {
                kotlin.k.b(obj);
                this.f33359b.i();
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$documentsKeeper$1", f = "DataRepositoryImpl.kt", l = {102, 105, 107}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements d10.q<Unit, com.sumsub.sns.internal.core.data.model.t, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.t>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33360a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33361b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(c cVar, kotlin.coroutines.c<? super e> cVar2) {
            super(3, cVar2);
            this.f33361b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(Unit unit, com.sumsub.sns.internal.core.data.model.t tVar, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.t> cVar) {
            return new e(this.f33361b, cVar).invokeSuspend(Unit.f56620a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c9 A[LOOP:0: B:27:0x00c3->B:29:0x00c9, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0102  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r6.f33360a
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L_0x0026
                if (r1 == r4) goto L_0x0022
                if (r1 == r3) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                kotlin.k.b(r7)
                goto L_0x0074
            L_0x0016:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001e:
                kotlin.k.b(r7)
                goto L_0x005d
            L_0x0022:
                kotlin.k.b(r7)
                goto L_0x003c
            L_0x0026:
                kotlin.k.b(r7)
                com.sumsub.sns.internal.core.data.source.dynamic.c r7 = r6.f33361b
                com.sumsub.sns.internal.core.data.source.dynamic.a r7 = r7.f33319m
                kotlinx.coroutines.flow.f1 r7 = r7.a()
                r6.f33360a = r4
                java.lang.Object r7 = kotlinx.coroutines.flow.f.C(r7, r6)
                if (r7 != r0) goto L_0x003c
                return r0
            L_0x003c:
                com.sumsub.sns.internal.core.data.source.dynamic.e r7 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r7
                if (r7 == 0) goto L_0x0137
                java.lang.Object r7 = r7.d()
                com.sumsub.sns.internal.core.data.model.e r7 = (com.sumsub.sns.internal.core.data.model.e) r7
                if (r7 == 0) goto L_0x0137
                com.sumsub.sns.internal.core.data.model.e$a r7 = r7.r()
                if (r7 != 0) goto L_0x0061
                com.sumsub.sns.internal.core.data.source.dynamic.c r7 = r6.f33361b
                com.sumsub.sns.internal.core.data.source.common.b r7 = r7.f33309c
                r6.f33360a = r3
                java.lang.Object r7 = r7.b(r6)
                if (r7 != r0) goto L_0x005d
                return r0
            L_0x005d:
                com.sumsub.sns.internal.core.data.model.remote.response.f r7 = (com.sumsub.sns.internal.core.data.model.remote.response.f) r7
                goto L_0x00e7
            L_0x0061:
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r6.f33361b
                com.sumsub.sns.internal.core.data.source.common.b r1 = r1.f33309c
                java.lang.String r7 = r7.c()
                r6.f33360a = r2
                java.lang.Object r7 = r1.d(r7, r6)
                if (r7 != r0) goto L_0x0074
                return r0
            L_0x0074:
                kotlinx.serialization.json.JsonObject r7 = (kotlinx.serialization.json.JsonObject) r7
                r0 = 0
                kotlinx.serialization.json.a r0 = com.sumsub.sns.internal.core.common.x.a(r0, r4, r5)
                java.lang.String r7 = r7.toString()
                kotlinx.serialization.modules.d r1 = r0.a()
                kotlin.reflect.q$a r2 = kotlin.reflect.q.f56856c
                java.lang.Class<java.lang.String> r3 = java.lang.String.class
                kotlin.reflect.p r3 = kotlin.jvm.internal.Reflection.n(r3)
                kotlin.reflect.q r3 = r2.a(r3)
                java.lang.Class<com.sumsub.sns.internal.core.data.model.remote.m> r4 = com.sumsub.sns.internal.core.data.model.remote.m.class
                kotlin.reflect.p r4 = kotlin.jvm.internal.Reflection.g(r4)
                kotlin.reflect.q r2 = r2.a(r4)
                java.lang.Class<java.util.Map> r4 = java.util.Map.class
                kotlin.reflect.p r2 = kotlin.jvm.internal.Reflection.p(r4, r3, r2)
                java.lang.String r3 = "kotlinx.serialization.serializer.withModule"
                kotlin.jvm.internal.MagicApiIntrinsics.a(r3)
                kotlinx.serialization.b r1 = kotlinx.serialization.h.d(r1, r2)
                java.lang.Object r7 = r0.c(r1, r7)
                java.util.Map r7 = (java.util.Map) r7
                java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
                int r1 = r7.size()
                int r1 = kotlin.collections.MapsKt__MapsJVMKt.d(r1)
                r0.<init>(r1)
                java.util.Set r7 = r7.entrySet()
                java.util.Iterator r7 = r7.iterator()
            L_0x00c3:
                boolean r1 = r7.hasNext()
                if (r1 == 0) goto L_0x00e2
                java.lang.Object r1 = r7.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                com.sumsub.sns.internal.core.data.model.DocumentType r2 = new com.sumsub.sns.internal.core.data.model.DocumentType
                java.lang.Object r3 = r1.getKey()
                java.lang.String r3 = (java.lang.String) r3
                r2.<init>(r3)
                java.lang.Object r1 = r1.getValue()
                r0.put(r2, r1)
                goto L_0x00c3
            L_0x00e2:
                com.sumsub.sns.internal.core.data.model.remote.response.f r7 = new com.sumsub.sns.internal.core.data.model.remote.response.f
                r7.<init>(r5, r0, r5)
            L_0x00e7:
                java.util.Map r0 = r7.f()
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                r1.<init>(r2)
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L_0x00fc:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0125
                java.lang.Object r2 = r0.next()
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2
                com.sumsub.sns.internal.core.data.model.Document r3 = new com.sumsub.sns.internal.core.data.model.Document
                java.lang.Object r4 = r2.getKey()
                com.sumsub.sns.internal.core.data.model.DocumentType r4 = (com.sumsub.sns.internal.core.data.model.DocumentType) r4
                java.lang.Object r2 = r2.getValue()
                com.sumsub.sns.internal.core.data.model.remote.m r2 = (com.sumsub.sns.internal.core.data.model.remote.m) r2
                if (r2 == 0) goto L_0x011d
                com.sumsub.sns.internal.core.data.model.Document$b r2 = com.sumsub.sns.internal.core.data.model.remote.n.a((com.sumsub.sns.internal.core.data.model.remote.m) r2)
                goto L_0x011e
            L_0x011d:
                r2 = r5
            L_0x011e:
                r3.<init>(r4, r2)
                r1.add(r3)
                goto L_0x00fc
            L_0x0125:
                java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r1)
                com.sumsub.sns.internal.core.data.model.t r1 = new com.sumsub.sns.internal.core.data.model.t
                com.sumsub.sns.internal.core.data.model.remote.response.c r2 = r7.d()
                com.sumsub.sns.internal.core.data.model.remote.response.h r7 = r7.h()
                r1.<init>(r2, r0, r7)
                return r1
            L_0x0137:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "Config missing"
                java.lang.String r0 = r0.toString()
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$socketEventsFlow$3", f = "DataRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class e0 extends SuspendLambda implements d10.q<kotlinx.coroutines.flow.e<? super SNSMessage.ServerMessage>, Throwable, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33362a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33363b;

        public e0(kotlin.coroutines.c<? super e0> cVar) {
            super(3, cVar);
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super SNSMessage.ServerMessage> eVar, Throwable th2, kotlin.coroutines.c<? super Unit> cVar) {
            e0 e0Var = new e0(cVar);
            e0Var.f33363b = th2;
            return e0Var.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f33362a == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                com.sumsub.sns.core.c.a(cVar, d.f33473a, "socket flow exception: " + ((Throwable) this.f33363b).getMessage(), (Throwable) null, 4, (Object) null);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$featureFlagsKeeper$1", f = "DataRepositoryImpl.kt", l = {227}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements d10.q<Unit, b.C0365b, kotlin.coroutines.c<? super b.C0365b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33364a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33365b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(c cVar, kotlin.coroutines.c<? super f> cVar2) {
            super(3, cVar2);
            this.f33365b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(Unit unit, b.C0365b bVar, kotlin.coroutines.c<? super b.C0365b> cVar) {
            return new f(this.f33365b, cVar).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33364a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.core.data.source.common.b c11 = this.f33365b.f33309c;
                com.sumsub.sns.internal.ff.model.a F = com.sumsub.sns.internal.ff.a.f34215a.F();
                this.f33364a = 1;
                obj = c11.a(F, (kotlin.coroutines.c<? super Map<String, com.sumsub.sns.internal.ff.model.b>>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                try {
                    kotlin.k.b(obj);
                } catch (Exception e11) {
                    if (!(e11 instanceof CancellationException)) {
                        com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this.f33365b), "Failed to parse remote FFs", e11);
                    }
                    return new b.C0365b(CollectionsKt__CollectionsKt.k());
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(entrySet, 10));
            for (Map.Entry entry : entrySet) {
                arrayList.add(new b.C0365b.a((String) entry.getKey(), ((com.sumsub.sns.internal.ff.model.b) entry.getValue()).d(), ((com.sumsub.sns.internal.ff.model.b) entry.getValue()).h()));
            }
            b.C0365b bVar = new b.C0365b(arrayList);
            com.sumsub.sns.internal.ff.a.f34215a.a(bVar);
            return bVar;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$socketEventsFlow$4", f = "DataRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class f0 extends SuspendLambda implements d10.q<kotlinx.coroutines.flow.e<? super SNSMessage.ServerMessage>, Throwable, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33366a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33367b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f0(c cVar, kotlin.coroutines.c<? super f0> cVar2) {
            super(3, cVar2);
            this.f33367b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super SNSMessage.ServerMessage> eVar, Throwable th2, kotlin.coroutines.c<? super Unit> cVar) {
            return new f0(this.f33367b, cVar).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f33366a == 0) {
                kotlin.k.b(obj);
                n1 h11 = this.f33367b.f33314h;
                if (h11 != null) {
                    n1.a.a(h11, (CancellationException) null, 1, (Object) null);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {313, 315, 317}, m = "getAll")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33368a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33370c;

        /* renamed from: d  reason: collision with root package name */
        public int f33371d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(c cVar, kotlin.coroutines.c<? super g> cVar2) {
            super(cVar2);
            this.f33370c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33369b = obj;
            this.f33371d |= Integer.MIN_VALUE;
            return this.f33370c.b((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$stringsKeeper$1", f = "DataRepositoryImpl.kt", l = {204, 208, 210}, m = "invokeSuspend")
    public static final class g0 extends SuspendLambda implements d10.q<Unit, b.c, kotlin.coroutines.c<? super b.c>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f33372a;

        /* renamed from: b  reason: collision with root package name */
        public int f33373b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33374c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g0(c cVar, kotlin.coroutines.c<? super g0> cVar2) {
            super(3, cVar2);
            this.f33374c = cVar;
        }

        /* renamed from: a */
        public final Object invoke(Unit unit, b.c cVar, kotlin.coroutines.c<? super b.c> cVar2) {
            return new g0(this.f33374c, cVar2).invokeSuspend(Unit.f56620a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r8.f33373b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x002f
                if (r1 == r4) goto L_0x002b
                if (r1 == r3) goto L_0x0022
                if (r1 != r2) goto L_0x001a
                java.lang.Object r0 = r8.f33372a
                java.util.Map r0 = (java.util.Map) r0
                kotlin.k.b(r9)
                goto L_0x00ea
            L_0x001a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0022:
                java.lang.Object r0 = r8.f33372a
                java.util.Map r0 = (java.util.Map) r0
                kotlin.k.b(r9)
                goto L_0x00d4
            L_0x002b:
                kotlin.k.b(r9)
                goto L_0x004d
            L_0x002f:
                kotlin.k.b(r9)
                com.sumsub.sns.internal.core.common.c0 r9 = com.sumsub.sns.internal.core.common.c0.f32001a
                com.sumsub.sns.internal.core.common.e0 r1 = com.sumsub.sns.internal.core.common.e0.f32018a
                java.util.Locale r1 = r1.getLocale()
                java.lang.String r9 = r9.a((java.util.Locale) r1)
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r8.f33374c
                com.sumsub.sns.internal.core.data.source.common.b r1 = r1.f33309c
                r8.f33373b = r4
                java.lang.Object r9 = r1.c(r9, r8)
                if (r9 != r0) goto L_0x004d
                return r0
            L_0x004d:
                java.util.Map r9 = (java.util.Map) r9
                java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
                r1.<init>()
                java.util.Set r9 = r9.entrySet()
                java.util.Iterator r9 = r9.iterator()
            L_0x005c:
                boolean r4 = r9.hasNext()
                if (r4 == 0) goto L_0x007c
                java.lang.Object r4 = r9.next()
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r5 = r4.getValue()
                boolean r5 = r5 instanceof java.lang.String
                if (r5 == 0) goto L_0x005c
                java.lang.Object r5 = r4.getKey()
                java.lang.Object r4 = r4.getValue()
                r1.put(r5, r4)
                goto L_0x005c
            L_0x007c:
                java.util.ArrayList r9 = new java.util.ArrayList
                int r4 = r1.size()
                r9.<init>(r4)
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x008d:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x00ab
                java.lang.Object r4 = r1.next()
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r5 = r4.getKey()
                java.lang.Object r4 = r4.getValue()
                java.lang.String r4 = (java.lang.String) r4
                kotlin.Pair r4 = kotlin.l.a(r5, r4)
                r9.add(r4)
                goto L_0x008d
            L_0x00ab:
                java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.s(r9)
                java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.y(r9)
                com.sumsub.sns.internal.ff.a r1 = com.sumsub.sns.internal.ff.a.f34215a
                com.sumsub.sns.internal.ff.core.a r1 = r1.a()
                boolean r1 = r1.g()
                if (r1 == 0) goto L_0x00d7
                com.sumsub.sns.internal.core.data.source.dynamic.c$a r1 = com.sumsub.sns.internal.core.data.source.dynamic.c.f33304s
                com.sumsub.sns.internal.core.data.source.dynamic.c r2 = r8.f33374c
                com.sumsub.sns.internal.core.data.source.common.b r2 = r2.f33309c
                r8.f33372a = r9
                r8.f33373b = r3
                java.lang.Object r1 = r1.a(r2, r8)
                if (r1 != r0) goto L_0x00d2
                return r0
            L_0x00d2:
                r0 = r9
                r9 = r1
            L_0x00d4:
                java.util.List r9 = (java.util.List) r9
                goto L_0x00ec
            L_0x00d7:
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r8.f33374c
                com.sumsub.sns.internal.core.data.source.common.b r1 = r1.f33309c
                r8.f33372a = r9
                r8.f33373b = r2
                java.lang.Object r1 = r1.d(r8)
                if (r1 != r0) goto L_0x00e8
                return r0
            L_0x00e8:
                r0 = r9
                r9 = r1
            L_0x00ea:
                java.util.List r9 = (java.util.List) r9
            L_0x00ec:
                com.sumsub.sns.internal.core.common.e0 r1 = com.sumsub.sns.internal.core.common.e0.f32018a
                com.sumsub.sns.core.data.model.SNSInitConfig r1 = r1.getConf()
                if (r1 != 0) goto L_0x00ff
                com.sumsub.sns.core.data.model.SNSInitConfig r1 = new com.sumsub.sns.core.data.model.SNSInitConfig
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 7
                r7 = 0
                r2 = r1
                r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.util.Map) r5, (int) r6, (kotlin.jvm.internal.r) r7)
            L_0x00ff:
                java.util.Map r1 = r1.getStrings()
                if (r1 == 0) goto L_0x0129
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x010d:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0129
                java.lang.Object r2 = r1.next()
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2
                java.lang.Object r3 = r2.getKey()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r2 = r2.getValue()
                java.lang.String r2 = (java.lang.String) r2
                r0.put(r3, r2)
                goto L_0x010d
            L_0x0129:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r1 = new com.sumsub.sns.internal.core.data.source.dynamic.b$c
                r1.<init>(r0, r9)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.g0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getAll$2", f = "DataRepositoryImpl.kt", l = {318}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33375a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33376b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(c cVar, kotlin.coroutines.c<? super h> cVar2) {
            super(2, cVar2);
            this.f33376b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h(this.f33376b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33375a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a b11 = this.f33376b.f33317k;
                this.f33375a = 1;
                if (b11.a((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {394}, m = "updateApplicant")
    public static final class h0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33377a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33378b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33379c;

        /* renamed from: d  reason: collision with root package name */
        public int f33380d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h0(c cVar, kotlin.coroutines.c<? super h0> cVar2) {
            super(cVar2);
            this.f33379c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33378b = obj;
            this.f33380d |= Integer.MIN_VALUE;
            return this.f33379c.a((com.sumsub.sns.internal.core.data.model.g) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getAll$3", f = "DataRepositoryImpl.kt", l = {319}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33381a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33382b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(c cVar, kotlin.coroutines.c<? super i> cVar2) {
            super(2, cVar2);
            this.f33382b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new i(this.f33382b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33381a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a d12 = this.f33382b.f33319m;
                this.f33381a = 1;
                if (d12.a((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {400}, m = "updateApplicantAction")
    public static final class i0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33383a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33384b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33385c;

        /* renamed from: d  reason: collision with root package name */
        public int f33386d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i0(c cVar, kotlin.coroutines.c<? super i0> cVar2) {
            super(cVar2);
            this.f33385c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33384b = obj;
            this.f33386d |= Integer.MIN_VALUE;
            return this.f33385c.c((com.sumsub.sns.internal.core.data.model.g) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getAll$4", f = "DataRepositoryImpl.kt", l = {322}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33387a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33388b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(c cVar, kotlin.coroutines.c<? super j> cVar2) {
            super(2, cVar2);
            this.f33388b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((j) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new j(this.f33388b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33387a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                if (!StringsKt__StringsJVMKt.z(this.f33388b.f33307a.b())) {
                    a a11 = this.f33388b.f33316j;
                    this.f33387a = 1;
                    if (a11.a((kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {433, 434}, m = "updateDataPart")
    public static final class j0<T> extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33389a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33390b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33391c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f33392d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f33393e;

        /* renamed from: f  reason: collision with root package name */
        public int f33394f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j0(c cVar, kotlin.coroutines.c<? super j0> cVar2) {
            super(cVar2);
            this.f33393e = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33392d = obj;
            this.f33394f |= Integer.MIN_VALUE;
            return this.f33393e.a(null, (d10.l) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getAll$5", f = "DataRepositoryImpl.kt", l = {325}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33396b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(c cVar, kotlin.coroutines.c<? super k> cVar2) {
            super(2, cVar2);
            this.f33396b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((k) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new k(this.f33396b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33395a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a k11 = this.f33396b.f33320n;
                this.f33395a = 1;
                if (k11.a((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {483}, m = "updateDocumentStatusAndApplicant")
    public static final class k0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33397a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33398b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33399c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33400d;

        /* renamed from: e  reason: collision with root package name */
        public int f33401e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k0(c cVar, kotlin.coroutines.c<? super k0> cVar2) {
            super(cVar2);
            this.f33400d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33399c = obj;
            this.f33401e |= Integer.MIN_VALUE;
            return this.f33400d.a((kotlinx.coroutines.h0) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getAll$6", f = "DataRepositoryImpl.kt", l = {326}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33402a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33403b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(c cVar, kotlin.coroutines.c<? super l> cVar2) {
            super(2, cVar2);
            this.f33403b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((l) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new l(this.f33403b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33402a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a f11 = this.f33403b.f33318l;
                this.f33402a = 1;
                if (f11.a((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$updateDocumentStatusAndApplicant$2", f = "DataRepositoryImpl.kt", l = {486, 488, 492, 496}, m = "invokeSuspend")
    public static final class l0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f33404a;

        /* renamed from: b  reason: collision with root package name */
        public int f33405b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33406c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.h0 f33407d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$updateDocumentStatusAndApplicant$2$1", f = "DataRepositoryImpl.kt", l = {489}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33408a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f33409b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, kotlin.coroutines.c<? super a> cVar2) {
                super(2, cVar2);
                this.f33409b = cVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f33409b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f33408a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    a b11 = this.f33409b.f33317k;
                    this.f33408a = 1;
                    if (a.a(b11, (Object) null, this, 1, (Object) null) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$updateDocumentStatusAndApplicant$2$2", f = "DataRepositoryImpl.kt", l = {490}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33410a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f33411b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(c cVar, kotlin.coroutines.c<? super b> cVar2) {
                super(2, cVar2);
                this.f33411b = cVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f33411b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f33410a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    a f11 = this.f33411b.f33318l;
                    this.f33410a = 1;
                    if (a.a(f11, (Object) null, this, 1, (Object) null) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l0(c cVar, kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super l0> cVar2) {
            super(2, cVar2);
            this.f33406c = cVar;
            this.f33407d = h0Var;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((l0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new l0(this.f33406c, this.f33407d, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[Catch:{ all -> 0x0040 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0068 A[Catch:{ all -> 0x0040 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5 A[Catch:{ all -> 0x0040 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5 A[Catch:{ all -> 0x0040 }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ca A[Catch:{ all -> 0x0040 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00f1 A[Catch:{ all -> 0x0040 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                r7 = r20
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r7.f33405b
                r8 = 0
                r9 = 4
                r10 = 3
                r11 = 2
                r12 = 0
                r13 = 1
                if (r1 == 0) goto L_0x0043
                if (r1 == r13) goto L_0x003a
                if (r1 == r11) goto L_0x0031
                if (r1 == r10) goto L_0x0025
                if (r1 != r9) goto L_0x001d
                kotlin.k.b(r21)     // Catch:{ all -> 0x0040 }
                goto L_0x0106
            L_0x001d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0025:
                java.lang.Object r1 = r7.f33404a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.k.b(r21)     // Catch:{ all -> 0x0040 }
                r11 = r1
                r1 = r21
                goto L_0x00bd
            L_0x0031:
                java.lang.Object r1 = r7.f33404a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.k.b(r21)     // Catch:{ all -> 0x0040 }
            L_0x0038:
                r11 = r1
                goto L_0x00a6
            L_0x003a:
                kotlin.k.b(r21)     // Catch:{ all -> 0x0040 }
                r1 = r21
                goto L_0x005b
            L_0x0040:
                r0 = move-exception
                goto L_0x010c
            L_0x0043:
                kotlin.k.b(r21)
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r7.f33406c     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.a r1 = r1.f33318l     // Catch:{ all -> 0x0040 }
                r2 = 0
                r3 = 0
                r5 = 2
                r6 = 0
                r7.f33405b = r13     // Catch:{ all -> 0x0040 }
                r4 = r20
                java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.a.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0040 }
                if (r1 != r0) goto L_0x005b
                return r0
            L_0x005b:
                com.sumsub.sns.internal.core.data.model.t r1 = (com.sumsub.sns.internal.core.data.model.t) r1     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.model.remote.response.c r1 = r1.e()     // Catch:{ all -> 0x0040 }
                if (r1 == 0) goto L_0x0068
                java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0040 }
                goto L_0x0069
            L_0x0068:
                r1 = r12
            L_0x0069:
                kotlinx.coroutines.n0[] r2 = new kotlinx.coroutines.n0[r11]     // Catch:{ all -> 0x0040 }
                kotlinx.coroutines.h0 r14 = r7.f33407d     // Catch:{ all -> 0x0040 }
                r15 = 0
                r16 = 0
                com.sumsub.sns.internal.core.data.source.dynamic.c$l0$a r3 = new com.sumsub.sns.internal.core.data.source.dynamic.c$l0$a     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.c r4 = r7.f33406c     // Catch:{ all -> 0x0040 }
                r3.<init>(r4, r12)     // Catch:{ all -> 0x0040 }
                r18 = 3
                r19 = 0
                r17 = r3
                kotlinx.coroutines.n0 r3 = kotlinx.coroutines.i.b(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0040 }
                r2[r8] = r3     // Catch:{ all -> 0x0040 }
                kotlinx.coroutines.h0 r14 = r7.f33407d     // Catch:{ all -> 0x0040 }
                r15 = 0
                r16 = 0
                com.sumsub.sns.internal.core.data.source.dynamic.c$l0$b r3 = new com.sumsub.sns.internal.core.data.source.dynamic.c$l0$b     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.c r4 = r7.f33406c     // Catch:{ all -> 0x0040 }
                r3.<init>(r4, r12)     // Catch:{ all -> 0x0040 }
                r18 = 3
                r19 = 0
                r17 = r3
                kotlinx.coroutines.n0 r3 = kotlinx.coroutines.i.b(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0040 }
                r2[r13] = r3     // Catch:{ all -> 0x0040 }
                r7.f33404a = r1     // Catch:{ all -> 0x0040 }
                r7.f33405b = r11     // Catch:{ all -> 0x0040 }
                java.lang.Object r2 = kotlinx.coroutines.AwaitKt.b(r2, r7)     // Catch:{ all -> 0x0040 }
                if (r2 != r0) goto L_0x0038
                return r0
            L_0x00a6:
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r7.f33406c     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.a r1 = r1.f33318l     // Catch:{ all -> 0x0040 }
                r2 = 0
                r3 = 0
                r5 = 2
                r6 = 0
                r7.f33404a = r11     // Catch:{ all -> 0x0040 }
                r7.f33405b = r10     // Catch:{ all -> 0x0040 }
                r4 = r20
                java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.a.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0040 }
                if (r1 != r0) goto L_0x00bd
                return r0
            L_0x00bd:
                com.sumsub.sns.internal.core.data.model.t r1 = (com.sumsub.sns.internal.core.data.model.t) r1     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.model.remote.response.c r1 = r1.e()     // Catch:{ all -> 0x0040 }
                if (r1 == 0) goto L_0x00ca
                java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0040 }
                goto L_0x00cb
            L_0x00ca:
                r1 = r12
            L_0x00cb:
                boolean r2 = kotlin.jvm.internal.x.b(r1, r11)     // Catch:{ all -> 0x0040 }
                if (r2 != 0) goto L_0x00d4
                if (r1 == 0) goto L_0x00d4
                r8 = r13
            L_0x00d4:
                com.sumsub.sns.core.c r1 = com.sumsub.sns.core.c.f30748a     // Catch:{ all -> 0x0040 }
                java.lang.String r2 = "DataRepository"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
                r3.<init>()     // Catch:{ all -> 0x0040 }
                java.lang.String r4 = "level changed "
                r3.append(r4)     // Catch:{ all -> 0x0040 }
                r3.append(r8)     // Catch:{ all -> 0x0040 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0040 }
                r4 = 0
                r5 = 4
                r6 = 0
                com.sumsub.sns.core.c.b(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0040 }
                if (r8 == 0) goto L_0x0106
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r7.f33406c     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.a r1 = r1.f33319m     // Catch:{ all -> 0x0040 }
                java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.a.a(r13)     // Catch:{ all -> 0x0040 }
                r7.f33404a = r12     // Catch:{ all -> 0x0040 }
                r7.f33405b = r9     // Catch:{ all -> 0x0040 }
                java.lang.Object r1 = r1.a(r2, r7)     // Catch:{ all -> 0x0040 }
                if (r1 != r0) goto L_0x0106
                return r0
            L_0x0106:
                com.sumsub.sns.internal.core.data.source.dynamic.c r0 = r7.f33406c     // Catch:{ all -> 0x0040 }
                r0.j()     // Catch:{ all -> 0x0040 }
                goto L_0x0146
            L_0x010c:
                com.sumsub.sns.core.c r1 = com.sumsub.sns.core.c.f30748a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "updateDocumentStatusAndApplicant: update error "
                r2.append(r3)
                java.lang.String r3 = r0.getMessage()
                r2.append(r3)
                java.lang.String r3 = r2.toString()
                r4 = 0
                r5 = 4
                r6 = 0
                java.lang.String r2 = "DataRepository"
                com.sumsub.sns.core.c.b(r1, r2, r3, r4, r5, r6)
                com.sumsub.sns.internal.log.a r8 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "update exception: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r10 = r1.toString()
                r11 = 0
                r12 = 4
                r13 = 0
                java.lang.String r9 = "DataRepository"
                com.sumsub.log.logger.a.d(r8, r9, r10, r11, r12, r13)
            L_0x0146:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.l0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getAll$7", f = "DataRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class m extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33412a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33413b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(c cVar, kotlin.coroutines.c<? super m> cVar2) {
            super(2, cVar2);
            this.f33413b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((m) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new m(this.f33413b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f33412a == 0) {
                kotlin.k.b(obj);
                this.f33413b.j();
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {457}, m = "updateDocumentStatusAndApplicantAction")
    public static final class m0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33414a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33415b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33416c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33417d;

        /* renamed from: e  reason: collision with root package name */
        public int f33418e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m0(c cVar, kotlin.coroutines.c<? super m0> cVar2) {
            super(cVar2);
            this.f33417d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33416c = obj;
            this.f33418e |= Integer.MIN_VALUE;
            return this.f33417d.b((kotlinx.coroutines.h0) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {368}, m = "getApplicant")
    public static final class n extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33419a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33420b;

        /* renamed from: c  reason: collision with root package name */
        public int f33421c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(c cVar, kotlin.coroutines.c<? super n> cVar2) {
            super(cVar2);
            this.f33420b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33419a = obj;
            this.f33421c |= Integer.MIN_VALUE;
            return this.f33420b.b((String) null, false, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$updateDocumentStatusAndApplicantAction$2", f = "DataRepositoryImpl.kt", l = {460, 462, 466, 471}, m = "invokeSuspend")
    public static final class n0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f33422a;

        /* renamed from: b  reason: collision with root package name */
        public int f33423b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33424c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.h0 f33425d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$updateDocumentStatusAndApplicantAction$2$1", f = "DataRepositoryImpl.kt", l = {463}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33426a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f33427b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, kotlin.coroutines.c<? super a> cVar2) {
                super(2, cVar2);
                this.f33427b = cVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f33427b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f33426a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    a a11 = this.f33427b.f33316j;
                    this.f33426a = 1;
                    if (a.a(a11, (Object) null, this, 1, (Object) null) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$updateDocumentStatusAndApplicantAction$2$2", f = "DataRepositoryImpl.kt", l = {464}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33428a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f33429b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(c cVar, kotlin.coroutines.c<? super b> cVar2) {
                super(2, cVar2);
                this.f33429b = cVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f33429b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f33428a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    a f11 = this.f33429b.f33318l;
                    this.f33428a = 1;
                    if (a.a(f11, (Object) null, this, 1, (Object) null) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n0(c cVar, kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super n0> cVar2) {
            super(2, cVar2);
            this.f33424c = cVar;
            this.f33425d = h0Var;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((n0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n0(this.f33424c, this.f33425d, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[Catch:{ all -> 0x0040 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0068 A[Catch:{ all -> 0x0040 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5 A[Catch:{ all -> 0x0040 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5 A[Catch:{ all -> 0x0040 }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ca A[Catch:{ all -> 0x0040 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00f1 A[Catch:{ all -> 0x0040 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                r7 = r20
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r7.f33423b
                r8 = 0
                r9 = 4
                r10 = 3
                r11 = 2
                r12 = 0
                r13 = 1
                if (r1 == 0) goto L_0x0043
                if (r1 == r13) goto L_0x003a
                if (r1 == r11) goto L_0x0031
                if (r1 == r10) goto L_0x0025
                if (r1 != r9) goto L_0x001d
                kotlin.k.b(r21)     // Catch:{ all -> 0x0040 }
                goto L_0x0106
            L_0x001d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0025:
                java.lang.Object r1 = r7.f33422a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.k.b(r21)     // Catch:{ all -> 0x0040 }
                r11 = r1
                r1 = r21
                goto L_0x00bd
            L_0x0031:
                java.lang.Object r1 = r7.f33422a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.k.b(r21)     // Catch:{ all -> 0x0040 }
            L_0x0038:
                r11 = r1
                goto L_0x00a6
            L_0x003a:
                kotlin.k.b(r21)     // Catch:{ all -> 0x0040 }
                r1 = r21
                goto L_0x005b
            L_0x0040:
                r0 = move-exception
                goto L_0x010c
            L_0x0043:
                kotlin.k.b(r21)
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r7.f33424c     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.a r1 = r1.f33318l     // Catch:{ all -> 0x0040 }
                r2 = 0
                r3 = 0
                r5 = 2
                r6 = 0
                r7.f33423b = r13     // Catch:{ all -> 0x0040 }
                r4 = r20
                java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.a.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0040 }
                if (r1 != r0) goto L_0x005b
                return r0
            L_0x005b:
                com.sumsub.sns.internal.core.data.model.t r1 = (com.sumsub.sns.internal.core.data.model.t) r1     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.model.remote.response.c r1 = r1.e()     // Catch:{ all -> 0x0040 }
                if (r1 == 0) goto L_0x0068
                java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0040 }
                goto L_0x0069
            L_0x0068:
                r1 = r12
            L_0x0069:
                kotlinx.coroutines.n0[] r2 = new kotlinx.coroutines.n0[r11]     // Catch:{ all -> 0x0040 }
                kotlinx.coroutines.h0 r14 = r7.f33425d     // Catch:{ all -> 0x0040 }
                r15 = 0
                r16 = 0
                com.sumsub.sns.internal.core.data.source.dynamic.c$n0$a r3 = new com.sumsub.sns.internal.core.data.source.dynamic.c$n0$a     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.c r4 = r7.f33424c     // Catch:{ all -> 0x0040 }
                r3.<init>(r4, r12)     // Catch:{ all -> 0x0040 }
                r18 = 3
                r19 = 0
                r17 = r3
                kotlinx.coroutines.n0 r3 = kotlinx.coroutines.i.b(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0040 }
                r2[r8] = r3     // Catch:{ all -> 0x0040 }
                kotlinx.coroutines.h0 r14 = r7.f33425d     // Catch:{ all -> 0x0040 }
                r15 = 0
                r16 = 0
                com.sumsub.sns.internal.core.data.source.dynamic.c$n0$b r3 = new com.sumsub.sns.internal.core.data.source.dynamic.c$n0$b     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.c r4 = r7.f33424c     // Catch:{ all -> 0x0040 }
                r3.<init>(r4, r12)     // Catch:{ all -> 0x0040 }
                r18 = 3
                r19 = 0
                r17 = r3
                kotlinx.coroutines.n0 r3 = kotlinx.coroutines.i.b(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0040 }
                r2[r13] = r3     // Catch:{ all -> 0x0040 }
                r7.f33422a = r1     // Catch:{ all -> 0x0040 }
                r7.f33423b = r11     // Catch:{ all -> 0x0040 }
                java.lang.Object r2 = kotlinx.coroutines.AwaitKt.b(r2, r7)     // Catch:{ all -> 0x0040 }
                if (r2 != r0) goto L_0x0038
                return r0
            L_0x00a6:
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r7.f33424c     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.a r1 = r1.f33318l     // Catch:{ all -> 0x0040 }
                r2 = 0
                r3 = 0
                r5 = 2
                r6 = 0
                r7.f33422a = r11     // Catch:{ all -> 0x0040 }
                r7.f33423b = r10     // Catch:{ all -> 0x0040 }
                r4 = r20
                java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.a.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0040 }
                if (r1 != r0) goto L_0x00bd
                return r0
            L_0x00bd:
                com.sumsub.sns.internal.core.data.model.t r1 = (com.sumsub.sns.internal.core.data.model.t) r1     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.model.remote.response.c r1 = r1.e()     // Catch:{ all -> 0x0040 }
                if (r1 == 0) goto L_0x00ca
                java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0040 }
                goto L_0x00cb
            L_0x00ca:
                r1 = r12
            L_0x00cb:
                boolean r2 = kotlin.jvm.internal.x.b(r1, r11)     // Catch:{ all -> 0x0040 }
                if (r2 != 0) goto L_0x00d4
                if (r1 == 0) goto L_0x00d4
                r8 = r13
            L_0x00d4:
                com.sumsub.sns.core.c r1 = com.sumsub.sns.core.c.f30748a     // Catch:{ all -> 0x0040 }
                java.lang.String r2 = "DataRepository"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
                r3.<init>()     // Catch:{ all -> 0x0040 }
                java.lang.String r4 = "level changed "
                r3.append(r4)     // Catch:{ all -> 0x0040 }
                r3.append(r8)     // Catch:{ all -> 0x0040 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0040 }
                r4 = 0
                r5 = 4
                r6 = 0
                com.sumsub.sns.core.c.b(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0040 }
                if (r8 == 0) goto L_0x0106
                com.sumsub.sns.internal.core.data.source.dynamic.c r1 = r7.f33424c     // Catch:{ all -> 0x0040 }
                com.sumsub.sns.internal.core.data.source.dynamic.a r1 = r1.f33319m     // Catch:{ all -> 0x0040 }
                java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.a.a(r13)     // Catch:{ all -> 0x0040 }
                r7.f33422a = r12     // Catch:{ all -> 0x0040 }
                r7.f33423b = r9     // Catch:{ all -> 0x0040 }
                java.lang.Object r1 = r1.a(r2, r7)     // Catch:{ all -> 0x0040 }
                if (r1 != r0) goto L_0x0106
                return r0
            L_0x0106:
                com.sumsub.sns.internal.core.data.source.dynamic.c r0 = r7.f33424c     // Catch:{ all -> 0x0040 }
                r0.j()     // Catch:{ all -> 0x0040 }
                goto L_0x0146
            L_0x010c:
                com.sumsub.sns.core.c r1 = com.sumsub.sns.core.c.f30748a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "updateDocumentStatusAndApplicantAction: update error "
                r2.append(r3)
                java.lang.String r3 = r0.getMessage()
                r2.append(r3)
                java.lang.String r3 = r2.toString()
                r4 = 0
                r5 = 4
                r6 = 0
                java.lang.String r2 = "DataRepository"
                com.sumsub.sns.core.c.b(r1, r2, r3, r4, r5, r6)
                com.sumsub.sns.internal.log.a r8 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "update exception: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r10 = r1.toString()
                r11 = 0
                r12 = 4
                r13 = 0
                java.lang.String r9 = "DataRepository"
                com.sumsub.log.logger.a.d(r8, r9, r10, r11, r12, r13)
            L_0x0146:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.n0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {358}, m = "getApplicantAction")
    public static final class o extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33430a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33431b;

        /* renamed from: c  reason: collision with root package name */
        public int f33432c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(c cVar, kotlin.coroutines.c<? super o> cVar2) {
            super(cVar2);
            this.f33431b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33430a = obj;
            this.f33432c |= Integer.MIN_VALUE;
            return this.f33431b.d((String) null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getApplicantActionAsResult$2", f = "DataRepositoryImpl.kt", l = {364}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.g>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f33435c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f33436d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(c cVar, boolean z11, String str, kotlin.coroutines.c<? super p> cVar2) {
            super(1, cVar2);
            this.f33434b = cVar;
            this.f33435c = z11;
            this.f33436d = str;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.g>> cVar) {
            return ((p) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new p(this.f33434b, this.f33435c, this.f33436d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33433a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a a11 = this.f33434b.f33316j;
                boolean z11 = this.f33435c;
                String str = this.f33436d;
                this.f33433a = 1;
                obj = a11.b(z11, str, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getApplicantAsResult$2", f = "DataRepositoryImpl.kt", l = {374}, m = "invokeSuspend")
    public static final class q extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.g>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33437a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33438b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f33439c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f33440d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(c cVar, boolean z11, String str, kotlin.coroutines.c<? super q> cVar2) {
            super(1, cVar2);
            this.f33438b = cVar;
            this.f33439c = z11;
            this.f33440d = str;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.g>> cVar) {
            return ((q) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new q(this.f33438b, this.f33439c, this.f33440d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33437a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a b11 = this.f33438b.f33317k;
                boolean z11 = this.f33439c;
                String str = this.f33440d;
                this.f33437a = 1;
                obj = b11.b(z11, str, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {335, 337, 340}, m = "getApplicantByFlowType")
    public static final class r extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33441a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f33442b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33443c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33444d;

        /* renamed from: e  reason: collision with root package name */
        public int f33445e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(c cVar, kotlin.coroutines.c<? super r> cVar2) {
            super(cVar2);
            this.f33444d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33443c = obj;
            this.f33445e |= Integer.MIN_VALUE;
            return this.f33444d.e(false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {345, 351, 354}, m = "getApplicantByFlowTypeAsResult")
    public static final class s extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33446a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f33447b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33448c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33449d;

        /* renamed from: e  reason: collision with root package name */
        public int f33450e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(c cVar, kotlin.coroutines.c<? super s> cVar2) {
            super(cVar2);
            this.f33449d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33448c = obj;
            this.f33450e |= Integer.MIN_VALUE;
            return this.f33449d.d(false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {409}, m = "getConfig")
    public static final class t extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33452b;

        /* renamed from: c  reason: collision with root package name */
        public int f33453c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(c cVar, kotlin.coroutines.c<? super t> cVar2) {
            super(cVar2);
            this.f33452b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33451a = obj;
            this.f33453c |= Integer.MIN_VALUE;
            return this.f33452b.a(false, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {411, 412}, m = "getConfigAsResult")
    public static final class u extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33454a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f33455b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33456c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33457d;

        /* renamed from: e  reason: collision with root package name */
        public int f33458e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(c cVar, kotlin.coroutines.c<? super u> cVar2) {
            super(cVar2);
            this.f33457d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33456c = obj;
            this.f33458e |= Integer.MIN_VALUE;
            return this.f33457d.b(false, (kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.e>>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getConfigAsResult$2", f = "DataRepositoryImpl.kt", l = {412}, m = "invokeSuspend")
    public static final class v extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.e>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33459a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33460b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f33461c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(c cVar, boolean z11, kotlin.coroutines.c<? super v> cVar2) {
            super(1, cVar2);
            this.f33460b = cVar;
            this.f33461c = z11;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.e>> cVar) {
            return ((v) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new v(this.f33460b, this.f33461c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33459a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a d12 = this.f33460b.f33319m;
                boolean z11 = this.f33461c;
                this.f33459a = 1;
                obj = a.b(d12, z11, (Object) null, this, 2, (Object) null);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {422}, m = "getFeatureFlags")
    public static final class w extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33462a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33463b;

        /* renamed from: c  reason: collision with root package name */
        public int f33464c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(c cVar, kotlin.coroutines.c<? super w> cVar2) {
            super(cVar2);
            this.f33463b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33462a = obj;
            this.f33464c |= Integer.MIN_VALUE;
            return this.f33463b.e((kotlin.coroutines.c<? super b.C0365b>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getFeatureFlagsAsResult$2", f = "DataRepositoryImpl.kt", l = {426}, m = "invokeSuspend")
    public static final class x extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super e<b.C0365b>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33465a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33466b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(c cVar, kotlin.coroutines.c<? super x> cVar2) {
            super(1, cVar2);
            this.f33466b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super e<b.C0365b>> cVar) {
            return ((x) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new x(this.f33466b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33465a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a g11 = this.f33466b.f33321o;
                this.f33465a = 1;
                obj = a.b(g11, false, (Object) null, this, 2, (Object) null);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl$getRequiredIdDocStatus$2", f = "DataRepositoryImpl.kt", l = {406}, m = "invokeSuspend")
    public static final class y extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.t>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33467a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33468b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f33469c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(c cVar, boolean z11, kotlin.coroutines.c<? super y> cVar2) {
            super(1, cVar2);
            this.f33468b = cVar;
            this.f33469c = z11;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.t>> cVar) {
            return ((y) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new y(this.f33468b, this.f33469c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33467a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a f11 = this.f33468b.f33318l;
                boolean z11 = this.f33469c;
                this.f33467a = 1;
                obj = a.b(f11, z11, (Object) null, this, 2, (Object) null);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataRepositoryImpl", f = "DataRepositoryImpl.kt", l = {415}, m = "getStrings")
    public static final class z extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33470a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f33471b;

        /* renamed from: c  reason: collision with root package name */
        public int f33472c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(c cVar, kotlin.coroutines.c<? super z> cVar2) {
            super(cVar2);
            this.f33471b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33470a = obj;
            this.f33472c |= Integer.MIN_VALUE;
            return this.f33471b.d((kotlin.coroutines.c<? super b.c>) this);
        }
    }

    public c(com.sumsub.sns.internal.core.data.source.settings.b bVar, com.sumsub.sns.internal.core.data.source.applicant.a aVar, com.sumsub.sns.internal.core.data.source.common.b bVar2, kotlinx.coroutines.h0 h0Var, CoroutineDispatcher coroutineDispatcher, com.sumsub.sns.internal.core.b<String> bVar3, com.sumsub.sns.internal.core.b<String> bVar4) {
        this.f33307a = bVar;
        this.f33308b = aVar;
        this.f33309c = bVar2;
        this.f33310d = h0Var;
        this.f33311e = coroutineDispatcher;
        this.f33312f = bVar3;
        this.f33313g = bVar4;
        b bVar5 = new b(this, (kotlin.coroutines.c<? super b>) null);
        this.f33316j = new a<>(h0Var, coroutineDispatcher, bVar5, com.sumsub.sns.internal.log.c.a(this) + " Action");
        C0367c cVar = new C0367c(this, (kotlin.coroutines.c<? super C0367c>) null);
        this.f33317k = new a<>(h0Var, coroutineDispatcher, cVar, com.sumsub.sns.internal.log.c.a(this) + " Applicant");
        e eVar = new e(this, (kotlin.coroutines.c<? super e>) null);
        this.f33318l = new a<>(h0Var, coroutineDispatcher, eVar, com.sumsub.sns.internal.log.c.a(this) + " Documents");
        d dVar = new d(this, (kotlin.coroutines.c<? super d>) null);
        this.f33319m = new a<>(h0Var, coroutineDispatcher, dVar, com.sumsub.sns.internal.log.c.a(this) + " Config");
        g0 g0Var = new g0(this, (kotlin.coroutines.c<? super g0>) null);
        this.f33320n = new a<>(h0Var, coroutineDispatcher, g0Var, com.sumsub.sns.internal.log.c.a(this) + " Strings");
        f fVar = new f(this, (kotlin.coroutines.c<? super f>) null);
        this.f33321o = new a<>(h0Var, coroutineDispatcher, fVar, com.sumsub.sns.internal.log.c.a(this) + " FeatureFlags");
        this.f33322p = FlowKt__ShareKt.h(kotlinx.coroutines.flow.f.O(kotlinx.coroutines.flow.f.f(kotlinx.coroutines.flow.f.Q(kotlinx.coroutines.flow.f.P(kotlinx.coroutines.flow.f.o(aVar.a(bVar3)), new c0(this, (kotlin.coroutines.c<? super c0>) null)), new d0(this, (kotlin.coroutines.c<? super d0>) null)), new e0((kotlin.coroutines.c<? super e0>) null)), new f0(this, (kotlin.coroutines.c<? super f0>) null)), h0Var, i1.a.b(i1.f57228a, 5000, 0, 2, (Object) null), 0, 4, (Object) null);
        b1<b.a> a11 = k1.a(null);
        this.f33323q = a11;
        this.f33324r = a11;
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.a d() {
        return this.f33308b;
    }

    /* renamed from: e */
    public b1<b.a> b() {
        return this.f33324r;
    }

    /* renamed from: g */
    public f1<SNSMessage.ServerMessage> a() {
        return this.f33322p;
    }

    public final void i() {
        n1 n1Var = this.f33314h;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f33314h = kotlinx.coroutines.i.d(this.f33310d, this.f33311e, (CoroutineStart) null, new b0(this, (kotlin.coroutines.c<? super b0>) null), 2, (Object) null);
    }

    public final void j() {
        e eVar = (e) CollectionsKt___CollectionsKt.c0(this.f33316j.a().a());
        e eVar2 = (e) CollectionsKt___CollectionsKt.c0(this.f33317k.a().a());
        e eVar3 = (e) CollectionsKt___CollectionsKt.c0(this.f33318l.a().a());
        e eVar4 = (e) CollectionsKt___CollectionsKt.c0(this.f33319m.a().a());
        e eVar5 = (e) CollectionsKt___CollectionsKt.c0(this.f33320n.a().a());
        e eVar6 = (e) CollectionsKt___CollectionsKt.c0(this.f33321o.a().a());
        if (eVar2 == null || eVar3 == null || eVar4 == null || eVar5 == null || eVar6 == null) {
            com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.f33473a, "updateDataFlow: skipping ...", (Throwable) null, 4, (Object) null);
        } else {
            b().setValue(new b.a(eVar2, eVar, eVar3, eVar4, eVar5, eVar6));
        }
    }

    public Object c(String str, boolean z11, kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.g>> cVar) {
        return a(CollectionsKt___CollectionsKt.c0(this.f33317k.a().a()), new q(this, z11, str, (kotlin.coroutines.c<? super q>) null), cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(boolean r8, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.g>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.s
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.core.data.source.dynamic.c$s r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.s) r0
            int r1 = r0.f33450e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33450e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$s r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$s
            r0.<init>(r7, r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f33448c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f33450e
            r2 = 3
            r3 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0048
            if (r1 == r5) goto L_0x003e
            if (r1 == r3) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            kotlin.k.b(r9)
            goto L_0x00a5
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            kotlin.k.b(r9)
            goto L_0x0094
        L_0x003e:
            boolean r8 = r4.f33447b
            java.lang.Object r1 = r4.f33446a
            com.sumsub.sns.internal.core.data.source.dynamic.c r1 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r1
            kotlin.k.b(r9)
            goto L_0x005a
        L_0x0048:
            kotlin.k.b(r9)
            r4.f33446a = r7
            r4.f33447b = r8
            r4.f33450e = r5
            r9 = 0
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r7, r9, r4, r5, r6)
            if (r9 != r0) goto L_0x0059
            return r0
        L_0x0059:
            r1 = r7
        L_0x005a:
            com.sumsub.sns.internal.core.data.source.dynamic.e r9 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r9
            java.lang.Object r5 = r9.d()
            com.sumsub.sns.internal.core.data.model.e r5 = (com.sumsub.sns.internal.core.data.model.e) r5
            if (r5 != 0) goto L_0x007d
            com.sumsub.sns.internal.core.data.source.dynamic.e$a r8 = com.sumsub.sns.internal.core.data.source.dynamic.e.f33474a
            java.lang.Throwable r9 = r9.a()
            if (r9 == 0) goto L_0x0071
            com.sumsub.sns.internal.core.data.source.dynamic.e$c r8 = r8.a(r6, r9)
            return r8
        L_0x0071:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Config NOT loaded"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x007d:
            com.sumsub.sns.core.data.model.FlowType r9 = r5.y()
            com.sumsub.sns.core.data.model.FlowType r5 = com.sumsub.sns.core.data.model.FlowType.Actions
            if (r9 != r5) goto L_0x0095
            r2 = 0
            r4.f33446a = r6
            r4.f33450e = r3
            r5 = 1
            r6 = 0
            r3 = r8
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.a(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0094
            return r0
        L_0x0094:
            return r9
        L_0x0095:
            r9 = 0
            r4.f33446a = r6
            r4.f33450e = r2
            r5 = 1
            r6 = 0
            r2 = r9
            r3 = r8
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.g(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x00a5
            return r0
        L_0x00a5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.d(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e(boolean r8, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.r
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.core.data.source.dynamic.c$r r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.r) r0
            int r1 = r0.f33445e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33445e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$r r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$r
            r0.<init>(r7, r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f33443c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f33445e
            r2 = 3
            r3 = 2
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x0047
            if (r1 == r6) goto L_0x003d
            if (r1 == r3) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            kotlin.k.b(r9)
            goto L_0x0083
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            kotlin.k.b(r9)
            goto L_0x0072
        L_0x003d:
            boolean r8 = r4.f33442b
            java.lang.Object r1 = r4.f33441a
            com.sumsub.sns.internal.core.data.source.dynamic.c r1 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r1
            kotlin.k.b(r9)
            goto L_0x0059
        L_0x0047:
            kotlin.k.b(r9)
            r4.f33441a = r7
            r4.f33442b = r8
            r4.f33445e = r6
            r9 = 0
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r7, r9, r4, r6, r5)
            if (r9 != r0) goto L_0x0058
            return r0
        L_0x0058:
            r1 = r7
        L_0x0059:
            com.sumsub.sns.internal.core.data.model.e r9 = (com.sumsub.sns.internal.core.data.model.e) r9
            com.sumsub.sns.core.data.model.FlowType r9 = r9.y()
            com.sumsub.sns.core.data.model.FlowType r6 = com.sumsub.sns.core.data.model.FlowType.Actions
            if (r9 != r6) goto L_0x0073
            r2 = 0
            r4.f33441a = r5
            r4.f33445e = r3
            r5 = 1
            r6 = 0
            r3 = r8
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.c(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0072
            return r0
        L_0x0072:
            return r9
        L_0x0073:
            r9 = 0
            r4.f33441a = r5
            r4.f33445e = r2
            r5 = 1
            r6 = 0
            r2 = r9
            r3 = r8
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0083
            return r0
        L_0x0083:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.e(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(kotlin.coroutines.c<? super kotlin.Unit> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.g
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.core.data.source.dynamic.c$g r2 = (com.sumsub.sns.internal.core.data.source.dynamic.c.g) r2
            int r3 = r2.f33371d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f33371d = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.data.source.dynamic.c$g r2 = new com.sumsub.sns.internal.core.data.source.dynamic.c$g
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f33369b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f33371d
            r5 = 0
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r4 == 0) goto L_0x0052
            if (r4 == r8) goto L_0x004a
            if (r4 == r7) goto L_0x0042
            if (r4 != r6) goto L_0x003a
            java.lang.Object r2 = r2.f33368a
            com.sumsub.sns.internal.core.data.source.dynamic.c r2 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r2
            kotlin.k.b(r1)
            goto L_0x00e2
        L_0x003a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0042:
            java.lang.Object r4 = r2.f33368a
            com.sumsub.sns.internal.core.data.source.dynamic.c r4 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r4
            kotlin.k.b(r1)
            goto L_0x0086
        L_0x004a:
            java.lang.Object r4 = r2.f33368a
            com.sumsub.sns.internal.core.data.source.dynamic.c r4 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r4
            kotlin.k.b(r1)
            goto L_0x0079
        L_0x0052:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.core.data.source.settings.b r1 = r0.f33307a
            java.lang.String r1 = r1.a()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0063
            r1 = r8
            goto L_0x0064
        L_0x0063:
            r1 = r5
        L_0x0064:
            if (r1 == 0) goto L_0x0069
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x0069:
            kotlinx.coroutines.n1 r1 = r0.f33315i
            if (r1 == 0) goto L_0x0078
            r2.f33368a = r0
            r2.f33371d = r8
            java.lang.Object r1 = r1.F(r2)
            if (r1 != r3) goto L_0x0078
            return r3
        L_0x0078:
            r4 = r0
        L_0x0079:
            com.sumsub.sns.internal.core.data.source.dynamic.a<com.sumsub.sns.internal.core.data.source.dynamic.b$b, kotlin.Unit> r1 = r4.f33321o
            r2.f33368a = r4
            r2.f33371d = r7
            java.lang.Object r1 = r1.a((kotlin.coroutines.c<? super kotlin.Unit>) r2)
            if (r1 != r3) goto L_0x0086
            return r3
        L_0x0086:
            r1 = 5
            kotlinx.coroutines.n0[] r1 = new kotlinx.coroutines.n0[r1]
            kotlinx.coroutines.h0 r10 = r4.f33310d
            com.sumsub.sns.internal.core.data.source.dynamic.c$h r13 = new com.sumsub.sns.internal.core.data.source.dynamic.c$h
            r13.<init>(r4, r9)
            r11 = 0
            r12 = 0
            r14 = 3
            r15 = 0
            kotlinx.coroutines.n0 r10 = kotlinx.coroutines.i.b(r10, r11, r12, r13, r14, r15)
            r1[r5] = r10
            kotlinx.coroutines.h0 r11 = r4.f33310d
            com.sumsub.sns.internal.core.data.source.dynamic.c$i r14 = new com.sumsub.sns.internal.core.data.source.dynamic.c$i
            r14.<init>(r4, r9)
            r13 = 0
            r15 = 3
            r16 = 0
            kotlinx.coroutines.n0 r5 = kotlinx.coroutines.i.b(r11, r12, r13, r14, r15, r16)
            r1[r8] = r5
            kotlinx.coroutines.h0 r10 = r4.f33310d
            com.sumsub.sns.internal.core.data.source.dynamic.c$j r13 = new com.sumsub.sns.internal.core.data.source.dynamic.c$j
            r13.<init>(r4, r9)
            r11 = 0
            r14 = 3
            r15 = 0
            kotlinx.coroutines.n0 r5 = kotlinx.coroutines.i.b(r10, r11, r12, r13, r14, r15)
            r1[r7] = r5
            kotlinx.coroutines.h0 r10 = r4.f33310d
            com.sumsub.sns.internal.core.data.source.dynamic.c$k r13 = new com.sumsub.sns.internal.core.data.source.dynamic.c$k
            r13.<init>(r4, r9)
            kotlinx.coroutines.n0 r5 = kotlinx.coroutines.i.b(r10, r11, r12, r13, r14, r15)
            r1[r6] = r5
            kotlinx.coroutines.h0 r10 = r4.f33310d
            com.sumsub.sns.internal.core.data.source.dynamic.c$l r13 = new com.sumsub.sns.internal.core.data.source.dynamic.c$l
            r13.<init>(r4, r9)
            kotlinx.coroutines.n0 r5 = kotlinx.coroutines.i.b(r10, r11, r12, r13, r14, r15)
            r7 = 4
            r1[r7] = r5
            r2.f33368a = r4
            r2.f33371d = r6
            java.lang.Object r1 = kotlinx.coroutines.AwaitKt.b(r1, r2)
            if (r1 != r3) goto L_0x00e1
            return r3
        L_0x00e1:
            r2 = r4
        L_0x00e2:
            kotlinx.coroutines.h0 r3 = r2.f33310d
            com.sumsub.sns.internal.core.data.source.dynamic.c$m r6 = new com.sumsub.sns.internal.core.data.source.dynamic.c$m
            r6.<init>(r2, r9)
            r4 = 0
            r5 = 0
            r7 = 3
            r8 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r3, r4, r5, r6, r7, r8)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.b(kotlin.coroutines.c):java.lang.Object");
    }

    public Object a(String str, boolean z11, kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.g>> cVar) {
        return a(CollectionsKt___CollectionsKt.c0(this.f33316j.a().a()), new p(this, z11, str, (kotlin.coroutines.c<? super p>) null), cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c(com.sumsub.sns.internal.core.data.model.g r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.i0
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.core.data.source.dynamic.c$i0 r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.i0) r0
            int r1 = r0.f33386d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33386d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$i0 r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$i0
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f33384b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33386d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f33383a
            com.sumsub.sns.internal.core.data.source.dynamic.c r5 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r5
            kotlin.k.b(r6)
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.k.b(r6)
            if (r5 == 0) goto L_0x004b
            com.sumsub.sns.internal.core.data.source.dynamic.a<com.sumsub.sns.internal.core.data.model.g, java.lang.String> r6 = r4.f33316j
            r0.f33383a = r4
            r0.f33386d = r3
            java.lang.Object r5 = r6.b(r5, r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = r4
        L_0x0048:
            r5.j()
        L_0x004b:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.c(com.sumsub.sns.internal.core.data.model.g, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.sumsub.sns.internal.core.data.model.g r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.h0
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.core.data.source.dynamic.c$h0 r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.h0) r0
            int r1 = r0.f33380d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33380d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$h0 r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$h0
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f33378b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33380d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f33377a
            com.sumsub.sns.internal.core.data.source.dynamic.c r5 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r5
            kotlin.k.b(r6)
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.k.b(r6)
            if (r5 == 0) goto L_0x004b
            com.sumsub.sns.internal.core.data.source.dynamic.a<com.sumsub.sns.internal.core.data.model.g, java.lang.String> r6 = r4.f33317k
            r0.f33377a = r4
            r0.f33380d = r3
            java.lang.Object r5 = r6.b(r5, r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = r4
        L_0x0048:
            r5.j()
        L_0x004b:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.a(com.sumsub.sns.internal.core.data.model.g, kotlin.coroutines.c):java.lang.Object");
    }

    public Object c(boolean z11, kotlin.coroutines.c<? super e<com.sumsub.sns.internal.core.data.model.t>> cVar) {
        return a(CollectionsKt___CollectionsKt.c0(this.f33318l.a().a()), new y(this, z11, (kotlin.coroutines.c<? super y>) null), cVar);
    }

    public Object c(kotlin.coroutines.c<? super e<b.C0365b>> cVar) {
        return a(CollectionsKt___CollectionsKt.c0(this.f33321o.a().a()), new x(this, (kotlin.coroutines.c<? super x>) null), cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e(kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.C0365b> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.w
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.core.data.source.dynamic.c$w r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.w) r0
            int r1 = r0.f33464c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33464c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$w r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$w
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f33462a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33464c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.k.b(r5)
            r0.f33464c = r3
            java.lang.Object r5 = r4.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.source.dynamic.b.C0365b>>) r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            com.sumsub.sns.internal.core.data.source.dynamic.e r5 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r5
            java.lang.Object r5 = r5.e()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.e(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(boolean r5, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.t
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.core.data.source.dynamic.c$t r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.t) r0
            int r1 = r0.f33453c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33453c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$t r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$t
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f33451a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33453c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r6)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r6)
            r0.f33453c = r3
            java.lang.Object r6 = r4.b((boolean) r5, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.e>>) r0)
            if (r6 != r1) goto L_0x003d
            return r1
        L_0x003d:
            com.sumsub.sns.internal.core.data.source.dynamic.e r6 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r6
            java.lang.Object r5 = r6.e()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.a(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public Object a(kotlin.coroutines.c<? super e<b.c>> cVar) {
        return a(CollectionsKt___CollectionsKt.c0(this.f33320n.a().a()), new a0(this, (kotlin.coroutines.c<? super a0>) null), cVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: d10.l<? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object a(T r6, d10.l<? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object> r7, kotlin.coroutines.c<? super T> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.j0
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.core.data.source.dynamic.c$j0 r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.j0) r0
            int r1 = r0.f33394f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33394f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$j0 r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$j0
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f33392d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33394f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r6 = r0.f33390b
            java.lang.Object r7 = r0.f33389a
            com.sumsub.sns.internal.core.data.source.dynamic.c r7 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r7
            kotlin.k.b(r8)
            goto L_0x0073
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            java.lang.Object r6 = r0.f33391c
            r7 = r6
            d10.l r7 = (d10.l) r7
            java.lang.Object r6 = r0.f33390b
            java.lang.Object r2 = r0.f33389a
            com.sumsub.sns.internal.core.data.source.dynamic.c r2 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r2
            kotlin.k.b(r8)
            r8 = r7
            r7 = r2
            goto L_0x0063
        L_0x004b:
            kotlin.k.b(r8)
            kotlinx.coroutines.n1 r8 = r5.f33315i
            if (r8 == 0) goto L_0x0061
            r0.f33389a = r5
            r0.f33390b = r6
            r0.f33391c = r7
            r0.f33394f = r4
            java.lang.Object r8 = r8.F(r0)
            if (r8 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r8 = r7
            r7 = r5
        L_0x0063:
            r0.f33389a = r7
            r0.f33390b = r6
            r2 = 0
            r0.f33391c = r2
            r0.f33394f = r3
            java.lang.Object r8 = r8.invoke(r0)
            if (r8 != r1) goto L_0x0073
            return r1
        L_0x0073:
            boolean r6 = kotlin.jvm.internal.x.b(r6, r8)
            if (r6 != 0) goto L_0x007c
            r7.j()
        L_0x007c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.a(java.lang.Object, d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(java.lang.String r5, boolean r6, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.o
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.data.source.dynamic.c$o r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.o) r0
            int r1 = r0.f33432c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33432c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$o r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$o
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33430a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33432c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r7)
            r0.f33432c = r3
            java.lang.Object r7 = r4.a((java.lang.String) r5, (boolean) r6, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.g>>) r0)
            if (r7 != r1) goto L_0x003d
            return r1
        L_0x003d:
            com.sumsub.sns.internal.core.data.source.dynamic.e r7 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r7
            java.lang.Object r5 = r7.e()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.d(java.lang.String, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r5, boolean r6, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.n
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.data.source.dynamic.c$n r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.n) r0
            int r1 = r0.f33421c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33421c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$n r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$n
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33419a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33421c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r7)
            r0.f33421c = r3
            java.lang.Object r7 = r4.c(r5, r6, r0)
            if (r7 != r1) goto L_0x003d
            return r1
        L_0x003d:
            com.sumsub.sns.internal.core.data.source.dynamic.e r7 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r7
            java.lang.Object r5 = r7.e()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.b(java.lang.String, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.z
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.core.data.source.dynamic.c$z r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.z) r0
            int r1 = r0.f33472c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33472c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$z r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$z
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f33470a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33472c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.k.b(r5)
            r0.f33472c = r3
            java.lang.Object r5 = r4.a((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.source.dynamic.b.c>>) r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            com.sumsub.sns.internal.core.data.source.dynamic.e r5 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r5
            java.lang.Object r5 = r5.e()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.d(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlinx.coroutines.h0 r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.k0
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.core.data.source.dynamic.c$k0 r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.k0) r0
            int r1 = r0.f33401e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33401e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$k0 r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$k0
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f33399c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33401e
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r9 = r0.f33398b
            kotlinx.coroutines.h0 r9 = (kotlinx.coroutines.h0) r9
            java.lang.Object r0 = r0.f33397a
            com.sumsub.sns.internal.core.data.source.dynamic.c r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r0
            kotlin.k.b(r10)
            goto L_0x004e
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            kotlin.k.b(r10)
            kotlinx.coroutines.n1 r10 = r8.f33315i
            if (r10 == 0) goto L_0x004d
            r0.f33397a = r8
            r0.f33398b = r9
            r0.f33401e = r3
            java.lang.Object r10 = r10.F(r0)
            if (r10 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r8
        L_0x004e:
            r2 = r9
            kotlinx.coroutines.CoroutineDispatcher r3 = r0.f33311e
            com.sumsub.sns.internal.core.data.source.dynamic.c$l0 r5 = new com.sumsub.sns.internal.core.data.source.dynamic.c$l0
            r9 = 0
            r5.<init>(r0, r2, r9)
            r4 = 0
            r6 = 2
            r7 = 0
            kotlinx.coroutines.n1 r9 = kotlinx.coroutines.i.d(r2, r3, r4, r5, r6, r7)
            r0.f33315i = r9
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.a(kotlinx.coroutines.h0, kotlin.coroutines.c):java.lang.Object");
    }

    public Object b(com.sumsub.sns.internal.core.data.model.g gVar, kotlin.coroutines.c<? super Unit> cVar) {
        com.sumsub.sns.internal.core.data.model.e eVar;
        if (gVar == null) {
            return Unit.f56620a;
        }
        e eVar2 = (e) CollectionsKt___CollectionsKt.c0(this.f33319m.a().a());
        if (eVar2 == null || (eVar = (com.sumsub.sns.internal.core.data.model.e) eVar2.d()) == null) {
            return Unit.f56620a;
        }
        if (eVar.y() == FlowType.Actions) {
            Object c11 = c(gVar, cVar);
            if (c11 == IntrinsicsKt__IntrinsicsKt.d()) {
                return c11;
            }
            return Unit.f56620a;
        }
        Object a11 = a(gVar, cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v7 java.lang.Object), (r8v1 java.lang.Object) binds: [B:19:0x006d, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(boolean r7, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.e>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.u
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.core.data.source.dynamic.c$u r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.u) r0
            int r1 = r0.f33458e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33458e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$u r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$u
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f33456c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33458e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r8)
            goto L_0x0070
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            boolean r7 = r0.f33455b
            java.lang.Object r2 = r0.f33454a
            com.sumsub.sns.internal.core.data.source.dynamic.c r2 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r2
            kotlin.k.b(r8)
            goto L_0x0051
        L_0x003e:
            kotlin.k.b(r8)
            com.sumsub.sns.internal.core.data.source.dynamic.a<com.sumsub.sns.internal.core.data.source.dynamic.b$b, kotlin.Unit> r8 = r6.f33321o
            r0.f33454a = r6
            r0.f33455b = r7
            r0.f33458e = r4
            java.lang.Object r8 = r8.a((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r2 = r6
        L_0x0051:
            com.sumsub.sns.internal.core.data.source.dynamic.a<com.sumsub.sns.internal.core.data.model.e, java.lang.Boolean> r8 = r2.f33319m
            kotlinx.coroutines.flow.f1 r8 = r8.a()
            java.util.List r8 = r8.a()
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r8)
            com.sumsub.sns.internal.core.data.source.dynamic.c$v r4 = new com.sumsub.sns.internal.core.data.source.dynamic.c$v
            r5 = 0
            r4.<init>(r2, r7, r5)
            r0.f33454a = r5
            r0.f33458e = r3
            java.lang.Object r8 = r2.a(r8, r4, r0)
            if (r8 != r1) goto L_0x0070
            return r1
        L_0x0070:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.b(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlinx.coroutines.h0 r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.core.data.source.dynamic.c.m0
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.core.data.source.dynamic.c$m0 r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c.m0) r0
            int r1 = r0.f33418e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33418e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.c$m0 r0 = new com.sumsub.sns.internal.core.data.source.dynamic.c$m0
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f33416c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33418e
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r9 = r0.f33415b
            kotlinx.coroutines.h0 r9 = (kotlinx.coroutines.h0) r9
            java.lang.Object r0 = r0.f33414a
            com.sumsub.sns.internal.core.data.source.dynamic.c r0 = (com.sumsub.sns.internal.core.data.source.dynamic.c) r0
            kotlin.k.b(r10)
            goto L_0x004e
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            kotlin.k.b(r10)
            kotlinx.coroutines.n1 r10 = r8.f33315i
            if (r10 == 0) goto L_0x004d
            r0.f33414a = r8
            r0.f33415b = r9
            r0.f33418e = r3
            java.lang.Object r10 = r10.F(r0)
            if (r10 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r8
        L_0x004e:
            r2 = r9
            kotlinx.coroutines.CoroutineDispatcher r3 = r0.f33311e
            com.sumsub.sns.internal.core.data.source.dynamic.c$n0 r5 = new com.sumsub.sns.internal.core.data.source.dynamic.c$n0
            r9 = 0
            r5.<init>(r0, r2, r9)
            r4 = 0
            r6 = 2
            r7 = 0
            kotlinx.coroutines.n1 r9 = kotlinx.coroutines.i.d(r2, r3, r4, r5, r6, r7)
            r0.f33315i = r9
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.c.b(kotlinx.coroutines.h0, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(com.sumsub.sns.internal.core.data.source.settings.b bVar, com.sumsub.sns.internal.core.data.source.applicant.a aVar, com.sumsub.sns.internal.core.data.source.common.b bVar2, kotlinx.coroutines.h0 h0Var, CoroutineDispatcher coroutineDispatcher, com.sumsub.sns.internal.core.b bVar3, com.sumsub.sns.internal.core.b bVar4, int i11, kotlin.jvm.internal.r rVar) {
        this(bVar, aVar, bVar2, h0Var, (i11 & 16) != 0 ? v0.b() : coroutineDispatcher, bVar3, bVar4);
    }
}
