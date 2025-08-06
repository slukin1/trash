package com.sumsub.sns.internal.core.common;

import android.util.Log;
import com.sumsub.log.logger.Logger;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.internal.core.data.model.LogParams;
import com.sumsub.sns.internal.core.data.model.LogType;
import com.sumsub.sns.internal.log.cacher.e;
import d10.p;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class y implements Logger {

    /* renamed from: c  reason: collision with root package name */
    public static final a f32292c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final String f32293d = "KibanaLogger";

    /* renamed from: e  reason: collision with root package name */
    public static final h0 f32294e = i0.a(f1.b(Executors.newSingleThreadExecutor()));

    /* renamed from: f  reason: collision with root package name */
    public static final int f32295f = 400;

    /* renamed from: g  reason: collision with root package name */
    public static final int f32296g = 499;

    /* renamed from: a  reason: collision with root package name */
    public String f32297a;

    /* renamed from: b  reason: collision with root package name */
    public final e<LogParams> f32298b;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements com.sumsub.sns.internal.log.cacher.a<LogParams> {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.log.a f32299a;

        /* renamed from: b  reason: collision with root package name */
        public final kotlinx.serialization.json.a f32300b = x.a(false, 1, (Object) null);

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.KibanaLogger$KibanaSink$prepareForCache$2", f = "KibanaLogger.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f32301a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ OutputStream f32302b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f32303c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ LogParams f32304d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(OutputStream outputStream, b bVar, LogParams logParams, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f32302b = outputStream;
                this.f32303c = bVar;
                this.f32304d = logParams;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f32302b, this.f32303c, this.f32304d, cVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
                kotlin.io.b.a(r7, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
                throw r1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r0 = r6.f32301a
                    if (r0 != 0) goto L_0x0041
                    kotlin.k.b(r7)
                    java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter
                    java.io.OutputStream r0 = r6.f32302b
                    r7.<init>(r0)
                    com.sumsub.sns.internal.core.common.y$b r0 = r6.f32303c
                    com.sumsub.sns.internal.core.data.model.LogParams r1 = r6.f32304d
                    r2 = 0
                    kotlinx.serialization.json.a r0 = r0.f32300b     // Catch:{ all -> 0x003a }
                    kotlinx.serialization.modules.d r3 = r0.a()     // Catch:{ all -> 0x003a }
                    java.lang.Class<com.sumsub.sns.internal.core.data.model.LogParams> r4 = com.sumsub.sns.internal.core.data.model.LogParams.class
                    kotlin.reflect.p r4 = kotlin.jvm.internal.Reflection.n(r4)     // Catch:{ all -> 0x003a }
                    java.lang.String r5 = "kotlinx.serialization.serializer.withModule"
                    kotlin.jvm.internal.MagicApiIntrinsics.a(r5)     // Catch:{ all -> 0x003a }
                    kotlinx.serialization.b r3 = kotlinx.serialization.h.d(r3, r4)     // Catch:{ all -> 0x003a }
                    java.lang.String r0 = r0.b(r3, r1)     // Catch:{ all -> 0x003a }
                    r7.write(r0)     // Catch:{ all -> 0x003a }
                    kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x003a }
                    kotlin.io.b.a(r7, r2)
                    return r0
                L_0x003a:
                    r0 = move-exception
                    throw r0     // Catch:{ all -> 0x003c }
                L_0x003c:
                    r1 = move-exception
                    kotlin.io.b.a(r7, r0)
                    throw r1
                L_0x0041:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.y.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.KibanaLogger$KibanaSink", f = "KibanaLogger.kt", l = {134, 134}, m = "resendFromCache")
        /* renamed from: com.sumsub.sns.internal.core.common.y$b$b  reason: collision with other inner class name */
        public static final class C0328b extends ContinuationImpl {

            /* renamed from: a  reason: collision with root package name */
            public Object f32305a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f32306b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f32307c;

            /* renamed from: d  reason: collision with root package name */
            public int f32308d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0328b(b bVar, kotlin.coroutines.c<? super C0328b> cVar) {
                super(cVar);
                this.f32307c = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f32306b = obj;
                this.f32308d |= Integer.MIN_VALUE;
                return this.f32307c.a((InputStream) null, (kotlin.coroutines.c<? super Boolean>) this);
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.KibanaLogger$KibanaSink$restoreParams$2", f = "KibanaLogger.kt", l = {}, m = "invokeSuspend")
        public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super LogParams>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f32309a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ InputStream f32310b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f32311c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(InputStream inputStream, b bVar, kotlin.coroutines.c<? super c> cVar) {
                super(2, cVar);
                this.f32310b = inputStream;
                this.f32311c = bVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super LogParams> cVar) {
                return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new c(this.f32310b, this.f32311c, cVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
                kotlin.io.b.a(r7, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
                throw r1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r0 = r6.f32309a
                    if (r0 != 0) goto L_0x004d
                    kotlin.k.b(r7)
                    java.io.InputStreamReader r7 = new java.io.InputStreamReader
                    java.io.InputStream r0 = r6.f32310b
                    r7.<init>(r0)
                    com.sumsub.sns.internal.core.common.y$b r0 = r6.f32311c
                    r1 = 0
                    kotlinx.serialization.json.a r0 = r0.f32300b     // Catch:{ Exception -> 0x0038 }
                    java.lang.String r2 = kotlin.io.g.c(r7)     // Catch:{ Exception -> 0x0038 }
                    kotlinx.serialization.modules.d r3 = r0.a()     // Catch:{ Exception -> 0x0038 }
                    java.lang.Class<com.sumsub.sns.internal.core.data.model.LogParams> r4 = com.sumsub.sns.internal.core.data.model.LogParams.class
                    kotlin.reflect.p r4 = kotlin.jvm.internal.Reflection.n(r4)     // Catch:{ Exception -> 0x0038 }
                    java.lang.String r5 = "kotlinx.serialization.serializer.withModule"
                    kotlin.jvm.internal.MagicApiIntrinsics.a(r5)     // Catch:{ Exception -> 0x0038 }
                    kotlinx.serialization.b r3 = kotlinx.serialization.h.d(r3, r4)     // Catch:{ Exception -> 0x0038 }
                    java.lang.Object r0 = r0.c(r3, r2)     // Catch:{ Exception -> 0x0038 }
                    com.sumsub.sns.internal.core.data.model.LogParams r0 = (com.sumsub.sns.internal.core.data.model.LogParams) r0     // Catch:{ Exception -> 0x0038 }
                    goto L_0x0043
                L_0x0036:
                    r0 = move-exception
                    goto L_0x0047
                L_0x0038:
                    r0 = move-exception
                    com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x0036 }
                    java.lang.String r3 = "KibanaLogger"
                    java.lang.String r4 = "Can't restore params"
                    r2.e(r3, r4, r0)     // Catch:{ all -> 0x0036 }
                    r0 = r1
                L_0x0043:
                    kotlin.io.b.a(r7, r1)
                    return r0
                L_0x0047:
                    throw r0     // Catch:{ all -> 0x0048 }
                L_0x0048:
                    r1 = move-exception
                    kotlin.io.b.a(r7, r0)
                    throw r1
                L_0x004d:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.y.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.KibanaLogger$KibanaSink$send$2", f = "KibanaLogger.kt", l = {98}, m = "invokeSuspend")
        public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Boolean>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f32312a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f32313b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LogParams f32314c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(b bVar, LogParams logParams, kotlin.coroutines.c<? super d> cVar) {
                super(2, cVar);
                this.f32313b = bVar;
                this.f32314c = logParams;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Boolean> cVar) {
                return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new d(this.f32313b, this.f32314c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f32312a;
                boolean z11 = false;
                if (i11 == 0) {
                    k.b(obj);
                    com.sumsub.sns.internal.core.data.source.log.a b11 = this.f32313b.f32299a;
                    LogType logType = LogType.Warn;
                    LogParams logParams = this.f32314c;
                    this.f32312a = 1;
                    if (b11.a(logType, logParams, this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    try {
                        k.b(obj);
                    } catch (SNSException.Api e11) {
                        Integer code = e11.getCode();
                        if ((code != null ? code.intValue() : 0) >= 400) {
                            Integer code2 = e11.getCode();
                            if ((code2 != null ? code2.intValue() : 0) <= 499) {
                                com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, y.f32293d, "Unauthorized, drop packet", (Throwable) null, 4, (Object) null);
                            }
                        }
                        com.sumsub.sns.internal.log.a.f34862a.e(y.f32293d, "Failed to send logs", e11);
                    } catch (Exception e12) {
                        com.sumsub.sns.internal.log.a.f34862a.e(y.f32293d, "Failed to send logs", e12);
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z11 = true;
                return kotlin.coroutines.jvm.internal.a.a(z11);
            }
        }

        public b(com.sumsub.sns.internal.core.data.source.log.a aVar) {
            this.f32299a = aVar;
        }

        public final Object b(InputStream inputStream, kotlin.coroutines.c<? super LogParams> cVar) {
            return g.g(v0.b(), new c(inputStream, this, (kotlin.coroutines.c<? super c>) null), cVar);
        }

        /* renamed from: a */
        public Object send(LogParams logParams, kotlin.coroutines.c<? super Boolean> cVar) {
            return g.g(v0.b(), new d(this, logParams, (kotlin.coroutines.c<? super d>) null), cVar);
        }

        public Object a(LogParams logParams, OutputStream outputStream, kotlin.coroutines.c<? super Unit> cVar) {
            Object g11 = g.g(v0.b(), new a(outputStream, this, logParams, (kotlin.coroutines.c<? super a>) null), cVar);
            return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(java.io.InputStream r6, kotlin.coroutines.c<? super java.lang.Boolean> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.sumsub.sns.internal.core.common.y.b.C0328b
                if (r0 == 0) goto L_0x0013
                r0 = r7
                com.sumsub.sns.internal.core.common.y$b$b r0 = (com.sumsub.sns.internal.core.common.y.b.C0328b) r0
                int r1 = r0.f32308d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f32308d = r1
                goto L_0x0018
            L_0x0013:
                com.sumsub.sns.internal.core.common.y$b$b r0 = new com.sumsub.sns.internal.core.common.y$b$b
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f32306b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f32308d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x003c
                if (r2 == r4) goto L_0x0034
                if (r2 != r3) goto L_0x002c
                kotlin.k.b(r7)
                goto L_0x005b
            L_0x002c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0034:
                java.lang.Object r6 = r0.f32305a
                com.sumsub.sns.internal.core.common.y$b r6 = (com.sumsub.sns.internal.core.common.y.b) r6
                kotlin.k.b(r7)
                goto L_0x004b
            L_0x003c:
                kotlin.k.b(r7)
                r0.f32305a = r5
                r0.f32308d = r4
                java.lang.Object r7 = r5.b(r6, r0)
                if (r7 != r1) goto L_0x004a
                return r1
            L_0x004a:
                r6 = r5
            L_0x004b:
                com.sumsub.sns.internal.core.data.model.LogParams r7 = (com.sumsub.sns.internal.core.data.model.LogParams) r7
                if (r7 == 0) goto L_0x0062
                r2 = 0
                r0.f32305a = r2
                r0.f32308d = r3
                java.lang.Object r7 = r6.send((com.sumsub.sns.internal.core.data.model.LogParams) r7, (kotlin.coroutines.c<? super java.lang.Boolean>) r0)
                if (r7 != r1) goto L_0x005b
                return r1
            L_0x005b:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r6 = r7.booleanValue()
                goto L_0x0063
            L_0x0062:
                r6 = 0
            L_0x0063:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.a.a(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.y.b.a(java.io.InputStream, kotlin.coroutines.c):java.lang.Object");
        }
    }

    @d(c = "com.sumsub.sns.internal.core.common.KibanaLogger$log$1", f = "KibanaLogger.kt", l = {67}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32315a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f32316b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f32317c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f32318d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f32319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Throwable f32320f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(y yVar, int i11, String str, String str2, Throwable th2, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f32316b = yVar;
            this.f32317c = i11;
            this.f32318d = str;
            this.f32319e = str2;
            this.f32320f = th2;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f32316b, this.f32317c, this.f32318d, this.f32319e, this.f32320f, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f32315a;
            if (i11 == 0) {
                k.b(obj);
                e a11 = this.f32316b.f32298b;
                LogParams a12 = this.f32316b.b(this.f32317c, this.f32318d, this.f32319e, this.f32320f);
                this.f32315a = 1;
                if (a11.send(a12, this) == d11) {
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

    public y(com.sumsub.sns.internal.core.data.source.log.a aVar, String str, File file, e<LogParams> eVar) {
        this.f32297a = str;
        this.f32298b = eVar;
    }

    public final LogParams b(int i11, String str, String str2, Throwable th2) {
        String str3;
        String str4 = this.f32297a;
        String str5 = com.sumsub.sns.internal.log.b.a().get(Integer.valueOf(i11)) + '/' + str2;
        if (th2 == null || (str3 = Log.getStackTraceString(th2)) == null) {
            str3 = "";
        }
        return new LogParams((String) null, str, (String) null, "KibanaLogger.kt", str4, str5, (String) null, str3, 65, (r) null);
    }

    public final String c() {
        return this.f32297a;
    }

    public void d(String str, String str2, Throwable th2) {
        a(3, str, str2, th2);
    }

    public void e(String str, String str2, Throwable th2) {
        a(6, str, str2, th2);
    }

    public void i(String str, String str2, Throwable th2) {
        a(4, str, str2, th2);
    }

    public void v(String str, String str2, Throwable th2) {
        a(2, str, str2, th2);
    }

    public void w(String str, String str2, Throwable th2) {
        a(5, str, str2, th2);
    }

    public final void a(String str) {
        this.f32297a = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ y(com.sumsub.sns.internal.core.data.source.log.a r1, java.lang.String r2, java.io.File r3, com.sumsub.sns.internal.log.cacher.e r4, int r5, kotlin.jvm.internal.r r6) {
        /*
            r0 = this;
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0018
            com.sumsub.sns.internal.log.cacher.e r4 = new com.sumsub.sns.internal.log.cacher.e
            com.sumsub.sns.internal.core.common.y$b r5 = new com.sumsub.sns.internal.core.common.y$b
            r5.<init>(r1)
            r4.<init>(r5, r3)
            java.lang.String r5 = "_KibanaLogger"
            r4.a((java.lang.String) r5)
            com.sumsub.sns.internal.log.cacher.d r5 = com.sumsub.sns.internal.log.cacher.d.f34872a
            r5.a(r4)
        L_0x0018:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.y.<init>(com.sumsub.sns.internal.core.data.source.log.a, java.lang.String, java.io.File, com.sumsub.sns.internal.log.cacher.e, int, kotlin.jvm.internal.r):void");
    }

    public final void a(int i11, String str, String str2, Throwable th2) {
        n1 unused = i.d(f32294e, (CoroutineContext) null, (CoroutineStart) null, new c(this, i11, str, str2, th2, (kotlin.coroutines.c<? super c>) null), 3, (Object) null);
    }
}
