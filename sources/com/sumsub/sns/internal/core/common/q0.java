package com.sumsub.sns.internal.core.common;

import android.content.Context;
import com.sumsub.sns.internal.core.data.model.LogParams;
import d10.p;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public final class q0 implements com.sumsub.sns.internal.log.cacher.a<LogParams> {

    /* renamed from: h  reason: collision with root package name */
    public static final a f32253h = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public static final long f32254i = 30;

    /* renamed from: a  reason: collision with root package name */
    public final Context f32255a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32256b;

    /* renamed from: c  reason: collision with root package name */
    public final kotlinx.serialization.json.a f32257c = x.a(false, 1, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public final kotlin.i f32258d = LazyKt__LazyJVMKt.a(new i(this));

    /* renamed from: e  reason: collision with root package name */
    public final kotlin.i f32259e = LazyKt__LazyJVMKt.a(new b(this));

    /* renamed from: f  reason: collision with root package name */
    public final kotlin.i f32260f = LazyKt__LazyJVMKt.a(new f(this));

    /* renamed from: g  reason: collision with root package name */
    public final kotlin.i f32261g = LazyKt__LazyJVMKt.a(new h(this));

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.SNSExceptionSink$prepareForCache$2", f = "SNSExceptionSink.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32263a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OutputStream f32264b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ q0 f32265c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LogParams f32266d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(OutputStream outputStream, q0 q0Var, LogParams logParams, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f32264b = outputStream;
            this.f32265c = q0Var;
            this.f32266d = logParams;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f32264b, this.f32265c, this.f32266d, cVar);
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
                int r0 = r6.f32263a
                if (r0 != 0) goto L_0x0041
                kotlin.k.b(r7)
                java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter
                java.io.OutputStream r0 = r6.f32264b
                r7.<init>(r0)
                com.sumsub.sns.internal.core.common.q0 r0 = r6.f32265c
                com.sumsub.sns.internal.core.data.model.LogParams r1 = r6.f32266d
                r2 = 0
                kotlinx.serialization.json.a r0 = r0.f32257c     // Catch:{ all -> 0x003a }
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
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.q0.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.SNSExceptionSink", f = "SNSExceptionSink.kt", l = {103, 103}, m = "resendFromCache")
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32267a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f32268b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ q0 f32269c;

        /* renamed from: d  reason: collision with root package name */
        public int f32270d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(q0 q0Var, kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
            this.f32269c = q0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32268b = obj;
            this.f32270d |= Integer.MIN_VALUE;
            return this.f32269c.a((InputStream) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.SNSExceptionSink$restoreParams$2", f = "SNSExceptionSink.kt", l = {}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super LogParams>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32271a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f32272b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InputStream f32273c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ q0 f32274d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(InputStream inputStream, q0 q0Var, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f32273c = inputStream;
            this.f32274d = q0Var;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super LogParams> cVar) {
            return ((e) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e eVar = new e(this.f32273c, this.f32274d, cVar);
            eVar.f32272b = obj;
            return eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
            kotlin.io.b.a(r0, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r7.f32271a
                if (r0 != 0) goto L_0x0053
                kotlin.k.b(r8)
                java.lang.Object r8 = r7.f32272b
                kotlinx.coroutines.h0 r8 = (kotlinx.coroutines.h0) r8
                java.io.InputStreamReader r0 = new java.io.InputStreamReader
                java.io.InputStream r1 = r7.f32273c
                r0.<init>(r1)
                com.sumsub.sns.internal.core.common.q0 r1 = r7.f32274d
                r2 = 0
                kotlinx.serialization.json.a r1 = r1.f32257c     // Catch:{ Exception -> 0x003c }
                java.lang.String r3 = kotlin.io.g.c(r0)     // Catch:{ Exception -> 0x003c }
                kotlinx.serialization.modules.d r4 = r1.a()     // Catch:{ Exception -> 0x003c }
                java.lang.Class<com.sumsub.sns.internal.core.data.model.LogParams> r5 = com.sumsub.sns.internal.core.data.model.LogParams.class
                kotlin.reflect.p r5 = kotlin.jvm.internal.Reflection.n(r5)     // Catch:{ Exception -> 0x003c }
                java.lang.String r6 = "kotlinx.serialization.serializer.withModule"
                kotlin.jvm.internal.MagicApiIntrinsics.a(r6)     // Catch:{ Exception -> 0x003c }
                kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r5)     // Catch:{ Exception -> 0x003c }
                java.lang.Object r1 = r1.c(r4, r3)     // Catch:{ Exception -> 0x003c }
                com.sumsub.sns.internal.core.data.model.LogParams r1 = (com.sumsub.sns.internal.core.data.model.LogParams) r1     // Catch:{ Exception -> 0x003c }
                goto L_0x0049
            L_0x003a:
                r8 = move-exception
                goto L_0x004d
            L_0x003c:
                r1 = move-exception
                com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x003a }
                java.lang.String r8 = com.sumsub.sns.internal.log.c.a(r8)     // Catch:{ all -> 0x003a }
                java.lang.String r4 = "Can't restore params"
                r3.e(r8, r4, r1)     // Catch:{ all -> 0x003a }
                r1 = r2
            L_0x0049:
                kotlin.io.b.a(r0, r2)
                return r1
            L_0x004d:
                throw r8     // Catch:{ all -> 0x004e }
            L_0x004e:
                r1 = move-exception
                kotlin.io.b.a(r0, r8)
                throw r1
            L_0x0053:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.q0.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class f extends Lambda implements d10.a<Retrofit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f32275a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(q0 q0Var) {
            super(0);
            this.f32275a = q0Var;
        }

        /* renamed from: a */
        public final Retrofit invoke() {
            return new Retrofit.Builder().baseUrl(this.f32275a.f()).client(this.f32275a.b()).addConverterFactory(bw.c.a(this.f32275a.f32257c, MediaType.Companion.get("application/json"))).build();
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.SNSExceptionSink", f = "SNSExceptionSink.kt", l = {76}, m = "send")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f32276a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q0 f32277b;

        /* renamed from: c  reason: collision with root package name */
        public int f32278c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(q0 q0Var, kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
            this.f32277b = q0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32276a = obj;
            this.f32278c |= Integer.MIN_VALUE;
            return this.f32277b.send((LogParams) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    public static final class h extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.log.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f32279a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(q0 q0Var) {
            super(0);
            this.f32279a = q0Var;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.log.b invoke() {
            return (com.sumsub.sns.internal.core.data.source.log.b) this.f32279a.c().create(com.sumsub.sns.internal.core.data.source.log.b.class);
        }
    }

    public static final class i extends Lambda implements d10.a<com.sumsub.sns.internal.core.data.source.settings.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f32280a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(q0 q0Var) {
            super(0);
            this.f32280a = q0Var;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.data.source.settings.a invoke() {
            return new com.sumsub.sns.internal.core.data.source.settings.a(this.f32280a.a().getSharedPreferences(n0.f32115c, 0));
        }
    }

    public q0(Context context, String str) {
        this.f32255a = context;
        this.f32256b = str;
    }

    public final com.sumsub.sns.internal.core.data.source.settings.b e() {
        return (com.sumsub.sns.internal.core.data.source.settings.b) this.f32258d.getValue();
    }

    public final String f() {
        return this.f32256b;
    }

    public final OkHttpClient b() {
        return (OkHttpClient) this.f32259e.getValue();
    }

    public final Retrofit c() {
        return (Retrofit) this.f32260f.getValue();
    }

    public final com.sumsub.sns.internal.core.data.source.log.b d() {
        return (com.sumsub.sns.internal.core.data.source.log.b) this.f32261g.getValue();
    }

    public final Object b(InputStream inputStream, kotlin.coroutines.c<? super LogParams> cVar) {
        return kotlinx.coroutines.g.g(v0.b(), new e(inputStream, this, (kotlin.coroutines.c<? super e>) null), cVar);
    }

    public final Context a() {
        return this.f32255a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(com.sumsub.sns.internal.core.data.model.LogParams r5, kotlin.coroutines.c<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.core.common.q0.g
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.core.common.q0$g r0 = (com.sumsub.sns.internal.core.common.q0.g) r0
            int r1 = r0.f32278c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32278c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.common.q0$g r0 = new com.sumsub.sns.internal.core.common.q0$g
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f32276a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32278c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r6)     // Catch:{ Exception -> 0x004b }
            goto L_0x004c
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r6)
            com.sumsub.sns.internal.core.data.source.log.b r6 = r4.d()     // Catch:{ Exception -> 0x004b }
            com.sumsub.sns.internal.core.data.model.LogType r2 = com.sumsub.sns.internal.core.data.model.LogType.Error     // Catch:{ Exception -> 0x004b }
            java.lang.String r2 = r2.getValue()     // Catch:{ Exception -> 0x004b }
            java.util.Map r5 = com.sumsub.sns.internal.core.data.model.r.a(r5)     // Catch:{ Exception -> 0x004b }
            r0.f32278c = r3     // Catch:{ Exception -> 0x004b }
            java.lang.Object r5 = r6.a(r2, r5, r0)     // Catch:{ Exception -> 0x004b }
            if (r5 != r1) goto L_0x004c
            return r1
        L_0x004b:
            r3 = 0
        L_0x004c:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.q0.send(com.sumsub.sns.internal.core.data.model.LogParams, kotlin.coroutines.c):java.lang.Object");
    }

    public static final class b extends Lambda implements d10.a<OkHttpClient> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f32262a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(q0 q0Var) {
            super(0);
            this.f32262a = q0Var;
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder addInterceptor = builder.callTimeout(30, timeUnit).connectTimeout(30, timeUnit).readTimeout(30, timeUnit).writeTimeout(30, timeUnit).addInterceptor(new com.sumsub.sns.internal.core.data.network.interceptor.a(this.f32262a.e()));
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(n1.f32246a);
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            return addInterceptor.addInterceptor(httpLoggingInterceptor).build();
        }

        public static final void a(String str) {
            System.out.println(str);
        }
    }

    public Object a(LogParams logParams, OutputStream outputStream, kotlin.coroutines.c<? super Unit> cVar) {
        Object g11 = kotlinx.coroutines.g.g(v0.b(), new c(outputStream, this, logParams, (kotlin.coroutines.c<? super c>) null), cVar);
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
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.common.q0.d
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.common.q0$d r0 = (com.sumsub.sns.internal.core.common.q0.d) r0
            int r1 = r0.f32270d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32270d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.common.q0$d r0 = new com.sumsub.sns.internal.core.common.q0$d
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f32268b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32270d
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
            java.lang.Object r6 = r0.f32267a
            com.sumsub.sns.internal.core.common.q0 r6 = (com.sumsub.sns.internal.core.common.q0) r6
            kotlin.k.b(r7)
            goto L_0x004b
        L_0x003c:
            kotlin.k.b(r7)
            r0.f32267a = r5
            r0.f32270d = r4
            java.lang.Object r7 = r5.b(r6, r0)
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r5
        L_0x004b:
            com.sumsub.sns.internal.core.data.model.LogParams r7 = (com.sumsub.sns.internal.core.data.model.LogParams) r7
            if (r7 == 0) goto L_0x0062
            r2 = 0
            r0.f32267a = r2
            r0.f32270d = r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.q0.a(java.io.InputStream, kotlin.coroutines.c):java.lang.Object");
    }
}
