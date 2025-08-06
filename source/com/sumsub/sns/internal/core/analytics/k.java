package com.sumsub.sns.internal.core.analytics;

import com.sumsub.sns.core.data.model.SNSTrackEvents;
import com.sumsub.sns.internal.core.common.x;
import d10.p;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.j;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

public final class k implements com.sumsub.sns.internal.log.cacher.a<List<? extends SNSTrackEvents>> {

    /* renamed from: d  reason: collision with root package name */
    public static final b f31903d = new b((r) null);
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final String f31904e = "RealAnalyticsRepository";
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final int f31905f = 400;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public static final int f31906g = 499;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final int f31907h = 16;

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.analythic.b f31908a;

    /* renamed from: b  reason: collision with root package name */
    public final d10.a<UUID> f31909b;

    /* renamed from: c  reason: collision with root package name */
    public final kotlinx.serialization.json.a f31910c = x.a(false, 1, (Object) null);

    @f
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\b\u0011B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017B3\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001cJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R \u0010\u000f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR \u0010\u0015\u001a\u00020\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\b\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/internal/core/analytics/k$a;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getSessionId$annotations", "()V", "sessionId", "", "b", "[B", "()[B", "getData$annotations", "data", "<init>", "(Ljava/lang/String;[B)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;[BLkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        public static final b Companion = new b((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final String f31911a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f31912b;

        /* renamed from: com.sumsub.sns.internal.core.analytics.k$a$a  reason: collision with other inner class name */
        public static final class C0319a implements d0<a> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0319a f31913a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f31914b;

            static {
                C0319a aVar = new C0319a();
                f31913a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.analytics.SNSAnalyticSink.CacheItem", aVar, 2);
                pluginGeneratedSerialDescriptor.k("sessionId", false);
                pluginGeneratedSerialDescriptor.k("data", false);
                f31914b = pluginGeneratedSerialDescriptor;
            }

            /* renamed from: a */
            public a deserialize(kotlinx.serialization.encoding.c cVar) {
                int i11;
                Object obj;
                String str;
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                if (b11.k()) {
                    str = b11.i(descriptor, 0);
                    obj = b11.p(descriptor, 1, j.f57729c, null);
                    i11 = 3;
                } else {
                    str = null;
                    Object obj2 = null;
                    int i12 = 0;
                    boolean z11 = true;
                    while (z11) {
                        int w11 = b11.w(descriptor);
                        if (w11 == -1) {
                            z11 = false;
                        } else if (w11 == 0) {
                            str = b11.i(descriptor, 0);
                            i12 |= 1;
                        } else if (w11 == 1) {
                            obj2 = b11.p(descriptor, 1, j.f57729c, obj2);
                            i12 |= 2;
                        } else {
                            throw new UnknownFieldException(w11);
                        }
                    }
                    obj = obj2;
                    i11 = i12;
                }
                b11.c(descriptor);
                return new a(i11, str, (byte[]) obj, (q1) null);
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                return new kotlinx.serialization.b[]{v1.f57779a, j.f57729c};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f31914b;
            }

            public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }

            /* renamed from: a */
            public void serialize(kotlinx.serialization.encoding.d dVar, a aVar) {
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                a.a(aVar, b11, descriptor);
                b11.c(descriptor);
            }
        }

        public static final class b {
            public /* synthetic */ b(r rVar) {
                this();
            }

            public final kotlinx.serialization.b<a> serializer() {
                return C0319a.f31913a;
            }

            public b() {
            }
        }

        public /* synthetic */ a(int i11, String str, byte[] bArr, q1 q1Var) {
            if (3 != (i11 & 3)) {
                h1.a(i11, 3, C0319a.f31913a.getDescriptor());
            }
            this.f31911a = str;
            this.f31912b = bArr;
        }

        public static final void a(a aVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            bVar.p(fVar, 0, aVar.f31911a);
            bVar.F(fVar, 1, j.f57729c, aVar.f31912b);
        }

        public static /* synthetic */ void b() {
        }

        public static /* synthetic */ void d() {
        }

        public final String c() {
            return this.f31911a;
        }

        public a(String str, byte[] bArr) {
            this.f31911a = str;
            this.f31912b = bArr;
        }

        public final byte[] a() {
            return this.f31912b;
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public b() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.analytics.SNSAnalyticSink$prepareForCache$2", f = "SNSAnalyticSink.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31915a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f31916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List<SNSTrackEvents> f31917c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OutputStream f31918d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(k kVar, List<SNSTrackEvents> list, OutputStream outputStream, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f31916b = kVar;
            this.f31917c = list;
            this.f31918d = outputStream;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f31916b, this.f31917c, this.f31918d, cVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0093, code lost:
            kotlin.io.b.a(r7, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0096, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r6.f31915a
                if (r0 != 0) goto L_0x009a
                kotlin.k.b(r7)
                com.sumsub.sns.internal.core.analytics.k r7 = r6.f31916b
                kotlinx.serialization.json.a r7 = r7.f31910c
                java.util.List<com.sumsub.sns.core.data.model.SNSTrackEvents> r0 = r6.f31917c
                kotlinx.serialization.modules.d r1 = r7.a()
                kotlin.reflect.q$a r2 = kotlin.reflect.q.f56856c
                java.lang.Class<com.sumsub.sns.core.data.model.SNSTrackEvents> r3 = com.sumsub.sns.core.data.model.SNSTrackEvents.class
                kotlin.reflect.p r3 = kotlin.jvm.internal.Reflection.n(r3)
                kotlin.reflect.q r2 = r2.a(r3)
                java.lang.Class<java.util.List> r3 = java.util.List.class
                kotlin.reflect.p r2 = kotlin.jvm.internal.Reflection.o(r3, r2)
                java.lang.String r3 = "kotlinx.serialization.serializer.withModule"
                kotlin.jvm.internal.MagicApiIntrinsics.a(r3)
                kotlinx.serialization.b r1 = kotlinx.serialization.h.d(r1, r2)
                java.lang.String r7 = r7.b(r1, r0)
                com.sumsub.sns.internal.core.analytics.k r0 = r6.f31916b
                d10.a r0 = r0.f31909b
                java.lang.Object r0 = r0.invoke()
                java.util.UUID r0 = (java.util.UUID) r0
                if (r0 == 0) goto L_0x0097
                java.lang.String r0 = r0.toString()
                if (r0 != 0) goto L_0x004a
                goto L_0x0097
            L_0x004a:
                com.sumsub.sns.internal.core.analytics.k r1 = r6.f31916b
                byte[] r1 = r1.a()
                if (r1 != 0) goto L_0x0055
                kotlin.Unit r7 = kotlin.Unit.f56620a
                return r7
            L_0x0055:
                com.sumsub.sns.internal.core.analytics.k$a r2 = new com.sumsub.sns.internal.core.analytics.k$a
                java.nio.charset.Charset r4 = kotlin.text.b.f56908b
                byte[] r7 = r7.getBytes(r4)
                byte[] r7 = com.sumsub.sns.internal.core.common.k.b(r7, r1)
                r2.<init>(r0, r7)
                java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter
                java.io.OutputStream r0 = r6.f31918d
                r7.<init>(r0)
                com.sumsub.sns.internal.core.analytics.k r0 = r6.f31916b
                r1 = 0
                kotlinx.serialization.json.a r0 = r0.f31910c     // Catch:{ all -> 0x0090 }
                kotlinx.serialization.modules.d r4 = r0.a()     // Catch:{ all -> 0x0090 }
                java.lang.Class<com.sumsub.sns.internal.core.analytics.k$a> r5 = com.sumsub.sns.internal.core.analytics.k.a.class
                kotlin.reflect.p r5 = kotlin.jvm.internal.Reflection.n(r5)     // Catch:{ all -> 0x0090 }
                kotlin.jvm.internal.MagicApiIntrinsics.a(r3)     // Catch:{ all -> 0x0090 }
                kotlinx.serialization.b r3 = kotlinx.serialization.h.d(r4, r5)     // Catch:{ all -> 0x0090 }
                java.lang.String r0 = r0.b(r3, r2)     // Catch:{ all -> 0x0090 }
                r7.write(r0)     // Catch:{ all -> 0x0090 }
                kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0090 }
                kotlin.io.b.a(r7, r1)
                return r0
            L_0x0090:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0092 }
            L_0x0092:
                r1 = move-exception
                kotlin.io.b.a(r7, r0)
                throw r1
            L_0x0097:
                kotlin.Unit r7 = kotlin.Unit.f56620a
                return r7
            L_0x009a:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.analytics.k.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.analytics.SNSAnalyticSink", f = "SNSAnalyticSink.kt", l = {83}, m = "resendFromCache")
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31919a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31920b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f31921c;

        /* renamed from: d  reason: collision with root package name */
        public int f31922d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(k kVar, kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
            this.f31921c = kVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31920b = obj;
            this.f31922d |= Integer.MIN_VALUE;
            return this.f31921c.a((InputStream) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.analytics.SNSAnalyticSink", f = "SNSAnalyticSink.kt", l = {43}, m = "send")
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f31923a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f31924b;

        /* renamed from: c  reason: collision with root package name */
        public int f31925c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(k kVar, kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
            this.f31924b = kVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31923a = obj;
            this.f31925c |= Integer.MIN_VALUE;
            return this.f31924b.send((List<SNSTrackEvents>) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    public k(com.sumsub.sns.internal.core.data.source.analythic.b bVar, d10.a<UUID> aVar) {
        this.f31908a = bVar;
        this.f31909b = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a6 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(java.util.List<com.sumsub.sns.core.data.model.SNSTrackEvents> r13, kotlin.coroutines.c<? super java.lang.Boolean> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.core.analytics.k.e
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.core.analytics.k$e r0 = (com.sumsub.sns.internal.core.analytics.k.e) r0
            int r1 = r0.f31925c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31925c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.analytics.k$e r0 = new com.sumsub.sns.internal.core.analytics.k$e
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f31923a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31925c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            kotlin.k.b(r14)     // Catch:{ all -> 0x002a }
            goto L_0x009d
        L_0x002a:
            r13 = move-exception
            goto L_0x00ae
        L_0x002d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0035:
            kotlin.k.b(r14)
            d10.a<java.util.UUID> r14 = r12.f31909b
            java.lang.Object r14 = r14.invoke()
            java.util.UUID r14 = (java.util.UUID) r14
            if (r14 == 0) goto L_0x0047
            java.lang.String r14 = r14.toString()
            goto L_0x0048
        L_0x0047:
            r14 = 0
        L_0x0048:
            byte[] r2 = r12.a()
            if (r14 == 0) goto L_0x00bc
            if (r2 != 0) goto L_0x0051
            goto L_0x00bc
        L_0x0051:
            kotlinx.serialization.json.a r5 = r12.f31910c     // Catch:{ all -> 0x002a }
            kotlinx.serialization.modules.d r6 = r5.a()     // Catch:{ all -> 0x002a }
            java.lang.Class<java.util.List> r7 = java.util.List.class
            kotlin.reflect.q$a r8 = kotlin.reflect.q.f56856c     // Catch:{ all -> 0x002a }
            java.lang.Class<com.sumsub.sns.core.data.model.SNSTrackEvents> r9 = com.sumsub.sns.core.data.model.SNSTrackEvents.class
            kotlin.reflect.p r9 = kotlin.jvm.internal.Reflection.n(r9)     // Catch:{ all -> 0x002a }
            kotlin.reflect.q r8 = r8.a(r9)     // Catch:{ all -> 0x002a }
            kotlin.reflect.p r7 = kotlin.jvm.internal.Reflection.o(r7, r8)     // Catch:{ all -> 0x002a }
            java.lang.String r8 = "kotlinx.serialization.serializer.withModule"
            kotlin.jvm.internal.MagicApiIntrinsics.a(r8)     // Catch:{ all -> 0x002a }
            kotlinx.serialization.b r6 = kotlinx.serialization.h.d(r6, r7)     // Catch:{ all -> 0x002a }
            java.lang.String r13 = r5.b(r6, r13)     // Catch:{ all -> 0x002a }
            java.nio.charset.Charset r5 = kotlin.text.b.f56908b     // Catch:{ all -> 0x002a }
            byte[] r13 = r13.getBytes(r5)     // Catch:{ all -> 0x002a }
            byte[] r6 = com.sumsub.sns.internal.core.common.k.b(r13, r2)     // Catch:{ all -> 0x002a }
            okhttp3.RequestBody$Companion r5 = okhttp3.RequestBody.Companion     // Catch:{ all -> 0x002a }
            okhttp3.MediaType$Companion r13 = okhttp3.MediaType.Companion     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "application/octet-stream"
            okhttp3.MediaType r7 = r13.get(r2)     // Catch:{ all -> 0x002a }
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            okhttp3.RequestBody r13 = okhttp3.RequestBody.Companion.create$default((okhttp3.RequestBody.Companion) r5, (byte[]) r6, (okhttp3.MediaType) r7, (int) r8, (int) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x002a }
            com.sumsub.sns.internal.core.data.source.analythic.b r2 = r12.f31908a     // Catch:{ all -> 0x002a }
            r0.f31925c = r4     // Catch:{ all -> 0x002a }
            java.lang.Object r14 = r2.a(r14, r13, r0)     // Catch:{ all -> 0x002a }
            if (r14 != r1) goto L_0x009d
            return r1
        L_0x009d:
            com.sumsub.sns.internal.core.data.source.applicant.remote.g r14 = (com.sumsub.sns.internal.core.data.source.applicant.remote.g) r14     // Catch:{ all -> 0x002a }
            java.lang.Integer r13 = r14.k()     // Catch:{ all -> 0x002a }
            if (r13 != 0) goto L_0x00a6
            goto L_0x00b7
        L_0x00a6:
            int r13 = r13.intValue()     // Catch:{ all -> 0x002a }
            if (r13 != r4) goto L_0x00b7
            r3 = r4
            goto L_0x00b7
        L_0x00ae:
            com.sumsub.sns.internal.log.a r14 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r0 = "RealAnalyticsRepository"
            java.lang.String r1 = "send failed "
            r14.w(r0, r1, r13)
        L_0x00b7:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r13
        L_0x00bc:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.analytics.k.send(java.util.List, kotlin.coroutines.c):java.lang.Object");
    }

    public Object a(List<SNSTrackEvents> list, OutputStream outputStream, kotlin.coroutines.c<? super Unit> cVar) {
        Object g11 = g.g(v0.b(), new c(this, list, outputStream, (kotlin.coroutines.c<? super c>) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.io.Closeable} */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.io.Closeable, java.lang.Object, java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v37 */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a9, code lost:
        if (r0.intValue() == 1) goto L_0x00e2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4 A[Catch:{ Api -> 0x003e, Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5 A[Catch:{ Api -> 0x003e, Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.io.InputStream r19, kotlin.coroutines.c<? super java.lang.Boolean> r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            boolean r2 = r0 instanceof com.sumsub.sns.internal.core.analytics.k.d
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.sumsub.sns.internal.core.analytics.k$d r2 = (com.sumsub.sns.internal.core.analytics.k.d) r2
            int r3 = r2.f31922d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f31922d = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.analytics.k$d r2 = new com.sumsub.sns.internal.core.analytics.k$d
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f31920b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f31922d
            java.lang.String r5 = "resendFromCache failed "
            r6 = 0
            r7 = 0
            java.lang.String r8 = "RealAnalyticsRepository"
            r9 = 1
            if (r4 == 0) goto L_0x0049
            if (r4 != r9) goto L_0x0041
            java.lang.Object r2 = r2.f31919a
            java.io.Closeable r2 = (java.io.Closeable) r2
            kotlin.k.b(r0)     // Catch:{ Api -> 0x003e, Exception -> 0x003b }
            goto L_0x009c
        L_0x0037:
            r0 = move-exception
            r3 = r0
            goto L_0x0124
        L_0x003b:
            r0 = move-exception
            goto L_0x00ae
        L_0x003e:
            r0 = move-exception
            goto L_0x00b6
        L_0x0041:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0049:
            kotlin.k.b(r0)
            java.io.InputStreamReader r4 = new java.io.InputStreamReader
            r0 = r19
            r4.<init>(r0)
            kotlinx.serialization.json.a r0 = r1.f31910c     // Catch:{ SerializationException -> 0x0105, Exception -> 0x00f5 }
            java.lang.String r10 = kotlin.io.g.c(r4)     // Catch:{ SerializationException -> 0x0105, Exception -> 0x00f5 }
            kotlinx.serialization.modules.d r11 = r0.a()     // Catch:{ SerializationException -> 0x0105, Exception -> 0x00f5 }
            java.lang.Class<com.sumsub.sns.internal.core.analytics.k$a> r12 = com.sumsub.sns.internal.core.analytics.k.a.class
            kotlin.reflect.p r12 = kotlin.jvm.internal.Reflection.n(r12)     // Catch:{ SerializationException -> 0x0105, Exception -> 0x00f5 }
            java.lang.String r13 = "kotlinx.serialization.serializer.withModule"
            kotlin.jvm.internal.MagicApiIntrinsics.a(r13)     // Catch:{ SerializationException -> 0x0105, Exception -> 0x00f5 }
            kotlinx.serialization.b r11 = kotlinx.serialization.h.d(r11, r12)     // Catch:{ SerializationException -> 0x0105, Exception -> 0x00f5 }
            java.lang.Object r0 = r0.c(r11, r10)     // Catch:{ SerializationException -> 0x0105, Exception -> 0x00f5 }
            com.sumsub.sns.internal.core.analytics.k$a r0 = (com.sumsub.sns.internal.core.analytics.k.a) r0     // Catch:{ SerializationException -> 0x0105, Exception -> 0x00f5 }
            java.lang.String r10 = r0.c()     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            byte[] r12 = r0.a()     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            okhttp3.RequestBody$Companion r11 = okhttp3.RequestBody.Companion     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            okhttp3.MediaType$Companion r0 = okhttp3.MediaType.Companion     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            java.lang.String r13 = "application/octet-stream"
            okhttp3.MediaType r13 = r0.get(r13)     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            okhttp3.RequestBody r0 = okhttp3.RequestBody.Companion.create$default((okhttp3.RequestBody.Companion) r11, (byte[]) r12, (okhttp3.MediaType) r13, (int) r14, (int) r15, (int) r16, (java.lang.Object) r17)     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            com.sumsub.sns.internal.core.data.source.analythic.b r11 = r1.f31908a     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            r2.f31919a = r4     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            r2.f31922d = r9     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            java.lang.Object r0 = r11.a(r10, r0, r2)     // Catch:{ Api -> 0x00b4, Exception -> 0x00ac }
            if (r0 != r3) goto L_0x009b
            return r3
        L_0x009b:
            r2 = r4
        L_0x009c:
            com.sumsub.sns.internal.core.data.source.applicant.remote.g r0 = (com.sumsub.sns.internal.core.data.source.applicant.remote.g) r0     // Catch:{ Api -> 0x003e, Exception -> 0x003b }
            java.lang.Integer r0 = r0.k()     // Catch:{ Api -> 0x003e, Exception -> 0x003b }
            if (r0 != 0) goto L_0x00a5
            goto L_0x00e9
        L_0x00a5:
            int r0 = r0.intValue()     // Catch:{ Api -> 0x003e, Exception -> 0x003b }
            if (r0 != r9) goto L_0x00e9
            goto L_0x00e2
        L_0x00ac:
            r0 = move-exception
            r2 = r4
        L_0x00ae:
            com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x0037 }
            r3.w(r8, r5, r0)     // Catch:{ all -> 0x0037 }
            goto L_0x00e9
        L_0x00b4:
            r0 = move-exception
            r2 = r4
        L_0x00b6:
            java.lang.Integer r3 = r0.getCode()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x00c1
            int r3 = r3.intValue()     // Catch:{ all -> 0x0037 }
            goto L_0x00c2
        L_0x00c1:
            r3 = r7
        L_0x00c2:
            r4 = 400(0x190, float:5.6E-43)
            if (r3 < r4) goto L_0x00e4
            java.lang.Integer r3 = r0.getCode()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x00d1
            int r3 = r3.intValue()     // Catch:{ all -> 0x0037 }
            goto L_0x00d2
        L_0x00d1:
            r3 = r7
        L_0x00d2:
            r4 = 499(0x1f3, float:6.99E-43)
            if (r3 > r4) goto L_0x00e4
            com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x0037 }
            java.lang.String r11 = "RealAnalyticsRepository"
            java.lang.String r12 = "Unauthorized, drop packet"
            r13 = 0
            r14 = 4
            r15 = 0
            com.sumsub.log.logger.a.c(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0037 }
        L_0x00e2:
            r7 = r9
            goto L_0x00e9
        L_0x00e4:
            com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x0037 }
            r3.w(r8, r5, r0)     // Catch:{ all -> 0x0037 }
        L_0x00e9:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.a.a(r7)     // Catch:{ all -> 0x0037 }
            kotlin.io.b.a(r2, r6)
            return r0
        L_0x00f1:
            r0 = move-exception
            r3 = r0
            r2 = r4
            goto L_0x0124
        L_0x00f5:
            r0 = move-exception
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x00f1 }
            java.lang.String r3 = "resendFromCache parsing cache failed"
            r2.w(r8, r3, r0)     // Catch:{ all -> 0x00f1 }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.a.a(r7)     // Catch:{ all -> 0x00f1 }
            kotlin.io.b.a(r4, r6)
            return r0
        L_0x0105:
            r0 = move-exception
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x00f1 }
            java.lang.String r3 = "resendFromCache: parsing cache failed. This data won't be sent"
            r2.w(r8, r3, r0)     // Catch:{ all -> 0x00f1 }
            com.sumsub.sns.internal.log.LoggerType[] r3 = new com.sumsub.sns.internal.log.LoggerType[r9]     // Catch:{ all -> 0x00f1 }
            com.sumsub.sns.internal.log.LoggerType r5 = com.sumsub.sns.internal.log.LoggerType.KIBANA     // Catch:{ all -> 0x00f1 }
            r3[r7] = r5     // Catch:{ all -> 0x00f1 }
            com.sumsub.log.logger.Logger r2 = r2.a((com.sumsub.sns.internal.log.LoggerType[]) r3)     // Catch:{ all -> 0x00f1 }
            java.lang.String r3 = "resendFromCache parsing cache failed. This data won't be sent"
            r2.w(r8, r3, r0)     // Catch:{ all -> 0x00f1 }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.a.a(r9)     // Catch:{ all -> 0x00f1 }
            kotlin.io.b.a(r4, r6)
            return r0
        L_0x0124:
            throw r3     // Catch:{ all -> 0x0125 }
        L_0x0125:
            r0 = move-exception
            r4 = r0
            kotlin.io.b.a(r2, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.analytics.k.a(java.io.InputStream, kotlin.coroutines.c):java.lang.Object");
    }

    public final byte[] a() {
        UUID invoke = this.f31909b.invoke();
        String uuid = invoke != null ? invoke.toString() : null;
        if (!(uuid == null || uuid.length() == 0)) {
            return ArraysKt___ArraysKt.m0(Arrays.copyOf(uuid.getBytes(kotlin.text.b.f56908b), 16));
        }
        com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, f31904e, "Got empty session id", (Throwable) null, 4, (Object) null);
        return null;
    }
}
