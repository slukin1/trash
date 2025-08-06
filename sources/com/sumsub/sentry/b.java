package com.sumsub.sentry;

import com.alibaba.verificationsdk.BuildConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sentry.SentryLevel;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 52\u00020\u0001:\u0002\b\u0011BW\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001c\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010%¢\u0006\u0004\b,\u0010-B\u0011\b\u0010\u0012\u0006\u0010.\u001a\u00020\u0000¢\u0006\u0004\b,\u0010/B\u0011\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b,\u0010\u0015Bo\b\u0017\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\u0016\b\u0001\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010%\u0012\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b,\u00104J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R \u0010\u000f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR*\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0011\u0010\u0015R*\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0012\u0012\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u0018\u0010\u0015R,\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001c8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b \u0010\u000e\u001a\u0004\b\u0018\u0010\u001fR*\u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\"\u0010\u0012\u0012\u0004\b#\u0010\u000e\u001a\u0004\b\b\u0010\u0014\"\u0004\b\b\u0010\u0015R*\u0010+\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b&\u0010'\u0012\u0004\b*\u0010\u000e\u001a\u0004\b\"\u0010(\"\u0004\b\b\u0010)¨\u00066"}, d2 = {"Lcom/sumsub/sentry/b;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Ljava/util/Date;", "Ljava/util/Date;", "i", "()Ljava/util/Date;", "getTimestamp$annotations", "()V", "timestamp", "", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getMessage$annotations", "message", "c", "k", "getType$annotations", "type", "", "d", "Ljava/util/Map;", "()Ljava/util/Map;", "getData$annotations", "data", "e", "getCategory$annotations", "category", "Lcom/sumsub/sentry/SentryLevel;", "f", "Lcom/sumsub/sentry/SentryLevel;", "()Lcom/sumsub/sentry/SentryLevel;", "(Lcom/sumsub/sentry/SentryLevel;)V", "getLevel$annotations", "level", "<init>", "(Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/sumsub/sentry/SentryLevel;)V", "breadcrumb", "(Lcom/sumsub/sentry/b;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/sumsub/sentry/SentryLevel;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class b {
    public static final C0269b Companion = new C0269b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Date f30289a;

    /* renamed from: b  reason: collision with root package name */
    public String f30290b;

    /* renamed from: c  reason: collision with root package name */
    public String f30291c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Object> f30292d;

    /* renamed from: e  reason: collision with root package name */
    public String f30293e;

    /* renamed from: f  reason: collision with root package name */
    public SentryLevel f30294f;

    public static final class a implements d0<b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30295a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30296b;

        static {
            a aVar = new a();
            f30295a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.Breadcrumb", aVar, 6);
            pluginGeneratedSerialDescriptor.k("timestamp", true);
            pluginGeneratedSerialDescriptor.k("message", true);
            pluginGeneratedSerialDescriptor.k("type", true);
            pluginGeneratedSerialDescriptor.k("data", true);
            pluginGeneratedSerialDescriptor.k("category", true);
            pluginGeneratedSerialDescriptor.k(FirebaseAnalytics.Param.LEVEL, true);
            f30296b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00bf, code lost:
            r7 = r5;
            r4 = 5;
            r6 = 4;
            r5 = r0;
            r0 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.b deserialize(kotlinx.serialization.encoding.c r19) {
            /*
                r18 = this;
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                kotlinx.serialization.descriptors.f r1 = r18.getDescriptor()
                r2 = r19
                kotlinx.serialization.encoding.a r2 = r2.b(r1)
                boolean r3 = r2.k()
                r4 = 5
                r5 = 3
                r6 = 4
                r7 = 2
                r8 = 1
                r9 = 0
                r10 = 0
                if (r3 == 0) goto L_0x0058
                kotlinx.serialization.ContextualSerializer r3 = new kotlinx.serialization.ContextualSerializer
                java.lang.Class<java.util.Date> r11 = java.util.Date.class
                kotlin.reflect.c r11 = kotlin.jvm.internal.Reflection.b(r11)
                kotlinx.serialization.b[] r12 = new kotlinx.serialization.b[r9]
                r3.<init>(r11, r10, r12)
                java.lang.Object r3 = r2.p(r1, r9, r3, r10)
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r2.j(r1, r8, r11, r10)
                java.lang.Object r7 = r2.j(r1, r7, r11, r10)
                kotlinx.serialization.internal.r0 r12 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.ContextualSerializer r13 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
                kotlinx.serialization.b[] r9 = new kotlinx.serialization.b[r9]
                r13.<init>(r0, r10, r9)
                r12.<init>(r11, r13)
                java.lang.Object r0 = r2.p(r1, r5, r12, r10)
                java.lang.Object r5 = r2.j(r1, r6, r11, r10)
                com.sumsub.sentry.SentryLevel$a r6 = com.sumsub.sentry.SentryLevel.a.f30237a
                java.lang.Object r4 = r2.j(r1, r4, r6, r10)
                r6 = 63
                r15 = r7
                r7 = r6
                goto L_0x00f0
            L_0x0058:
                r16 = r8
                r14 = r9
                r3 = r10
                r8 = r3
                r11 = r8
                r12 = r11
                r13 = r12
                r15 = r13
            L_0x0061:
                if (r16 == 0) goto L_0x00eb
                int r7 = r2.w(r1)
                switch(r7) {
                    case -1: goto L_0x00e6;
                    case 0: goto L_0x00c6;
                    case 1: goto L_0x00b2;
                    case 2: goto L_0x00a5;
                    case 3: goto L_0x0084;
                    case 4: goto L_0x007a;
                    case 5: goto L_0x0070;
                    default: goto L_0x006a;
                }
            L_0x006a:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r7)
                throw r0
            L_0x0070:
                com.sumsub.sentry.SentryLevel$a r7 = com.sumsub.sentry.SentryLevel.a.f30237a
                java.lang.Object r12 = r2.j(r1, r4, r7, r12)
                r14 = r14 | 32
                goto L_0x00e8
            L_0x007a:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r13 = r2.j(r1, r6, r7, r13)
                r14 = r14 | 16
                goto L_0x00e8
            L_0x0084:
                kotlinx.serialization.internal.r0 r7 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                kotlinx.serialization.ContextualSerializer r6 = new kotlinx.serialization.ContextualSerializer
                kotlin.reflect.c r5 = kotlin.jvm.internal.Reflection.b(r0)
                r17 = r0
                kotlinx.serialization.b[] r0 = new kotlinx.serialization.b[r9]
                r6.<init>(r5, r10, r0)
                r7.<init>(r4, r6)
                r0 = 3
                java.lang.Object r3 = r2.p(r1, r0, r7, r3)
                r14 = r14 | 8
                r5 = r0
                r0 = r17
                r4 = 5
                r6 = 4
                goto L_0x00e8
            L_0x00a5:
                r17 = r0
                r0 = r5
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r5 = 2
                java.lang.Object r15 = r2.j(r1, r5, r4, r15)
                r14 = r14 | 4
                goto L_0x00bf
            L_0x00b2:
                r17 = r0
                r0 = r5
                r5 = 2
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r6 = 1
                java.lang.Object r8 = r2.j(r1, r6, r4, r8)
                r14 = r14 | 2
            L_0x00bf:
                r7 = r5
                r4 = 5
                r6 = 4
                r5 = r0
                r0 = r17
                goto L_0x0061
            L_0x00c6:
                r17 = r0
                r0 = r5
                r5 = 2
                r6 = 1
                kotlinx.serialization.ContextualSerializer r4 = new kotlinx.serialization.ContextualSerializer
                java.lang.Class<java.util.Date> r7 = java.util.Date.class
                kotlin.reflect.c r7 = kotlin.jvm.internal.Reflection.b(r7)
                kotlinx.serialization.b[] r0 = new kotlinx.serialization.b[r9]
                r4.<init>(r7, r10, r0)
                java.lang.Object r11 = r2.p(r1, r9, r4, r11)
                r14 = r14 | 1
                r7 = r5
                r0 = r17
                r4 = 5
                r5 = 3
                r6 = 4
                goto L_0x0061
            L_0x00e6:
                r16 = r9
            L_0x00e8:
                r7 = 2
                goto L_0x0061
            L_0x00eb:
                r0 = r3
                r3 = r11
                r4 = r12
                r5 = r13
                r7 = r14
            L_0x00f0:
                r2.c(r1)
                com.sumsub.sentry.b r1 = new com.sumsub.sentry.b
                r2 = r3
                java.util.Date r2 = (java.util.Date) r2
                r9 = r8
                java.lang.String r9 = (java.lang.String) r9
                r10 = r15
                java.lang.String r10 = (java.lang.String) r10
                r11 = r0
                java.util.Map r11 = (java.util.Map) r11
                r12 = r5
                java.lang.String r12 = (java.lang.String) r12
                r13 = r4
                com.sumsub.sentry.SentryLevel r13 = (com.sumsub.sentry.SentryLevel) r13
                r14 = 0
                r6 = r1
                r8 = r2
                r6.<init>((int) r7, (java.util.Date) r8, (java.lang.String) r9, (java.lang.String) r10, (java.util.Map) r11, (java.lang.String) r12, (com.sumsub.sentry.SentryLevel) r13, (kotlinx.serialization.internal.q1) r14)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.b.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.b");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{new ContextualSerializer(Reflection.b(Date.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]), h10.a.u(v1Var), h10.a.u(v1Var), new r0(v1Var, new ContextualSerializer(Reflection.b(Object.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), h10.a.u(v1Var), h10.a.u(SentryLevel.a.f30237a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30296b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, b bVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            b.a(bVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    /* renamed from: com.sumsub.sentry.b$b  reason: collision with other inner class name */
    public static final class C0269b {
        public /* synthetic */ C0269b(r rVar) {
            this();
        }

        public final b a(String str, String str2, String str3) {
            return a(this, str, str2, str3, (Map) null, 8, (Object) null);
        }

        public final b b(String str, String str2) {
            b bVar = new b((Date) null, (String) null, "navigation", (Map) null, "navigation", (SentryLevel) null, 43, (r) null);
            bVar.c().put("from", str);
            bVar.c().put("to", str2);
            return bVar;
        }

        public final b c(String str) {
            return new b((Date) null, str, "info", (Map) null, (String) null, SentryLevel.INFO, 25, (r) null);
        }

        public final b d(String str) {
            return new b((Date) null, str, "query", (Map) null, (String) null, (SentryLevel) null, 57, (r) null);
        }

        public final b e(String str) {
            return new b((Date) null, str, "default", (Map) null, "sentry.transaction", (SentryLevel) null, 41, (r) null);
        }

        public final kotlinx.serialization.b<b> serializer() {
            return a.f30295a;
        }

        public C0269b() {
        }

        public final b a(String str, String str2) {
            b bVar = new b((Date) null, (String) null, "http", (Map) null, "http", (SentryLevel) null, 43, (r) null);
            bVar.c().put("url", str);
            bVar.c().put("method", str2.toUpperCase(Locale.ROOT));
            return bVar;
        }

        public final b d(String str, String str2) {
            return new b((Date) null, str2, "user", (Map) null, str, (SentryLevel) null, 41, (r) null);
        }

        public final b c(String str, String str2) {
            return new b((Date) null, str2, "default", (Map) null, "ui." + str, (SentryLevel) null, 41, (r) null);
        }

        public final b b(String str) {
            return new b((Date) null, str, "error", (Map) null, (String) null, SentryLevel.ERROR, 25, (r) null);
        }

        public final b a(String str, String str2, Integer num) {
            b a11 = a(str, str2);
            if (num != null) {
                a11.c().put("status_code", num);
            }
            return a11;
        }

        public final b a(String str) {
            return new b((Date) null, str, BuildConfig.BUILD_TYPE, (Map) null, (String) null, SentryLevel.DEBUG, 25, (r) null);
        }

        public static /* synthetic */ b a(C0269b bVar, String str, String str2, String str3, Map map, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                map = MapsKt__MapsKt.h();
            }
            return bVar.a(str, str2, str3, map);
        }

        public final b a(String str, String str2, String str3, Map<String, ? extends Object> map) {
            b bVar = new b((Date) null, (String) null, "user", (Map) null, "ui." + str, SentryLevel.INFO, 11, (r) null);
            if (str2 != null) {
                bVar.c().put("view.id", str2);
            }
            if (str3 != null) {
                bVar.c().put("view.class", str3);
            }
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                bVar.c().put((String) entry.getKey(), value);
            }
            return bVar;
        }
    }

    public b() {
        this((Date) null, (String) null, (String) null, (Map) null, (String) null, (SentryLevel) null, 63, (r) null);
    }

    public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar2.q(fVar, 0) || !x.b(bVar.f30289a, e.f30319a.a())) {
            bVar2.F(fVar, 0, new ContextualSerializer(Reflection.b(Date.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]), bVar.f30289a);
        }
        if (bVar2.q(fVar, 1) || bVar.f30290b != null) {
            bVar2.y(fVar, 1, v1.f57779a, bVar.f30290b);
        }
        if (bVar2.q(fVar, 2) || bVar.f30291c != null) {
            bVar2.y(fVar, 2, v1.f57779a, bVar.f30291c);
        }
        if (bVar2.q(fVar, 3) || !x.b(bVar.f30292d, new ConcurrentHashMap())) {
            bVar2.F(fVar, 3, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(Object.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])), bVar.f30292d);
        }
        if (bVar2.q(fVar, 4) || bVar.f30293e != null) {
            bVar2.y(fVar, 4, v1.f57779a, bVar.f30293e);
        }
        if (bVar2.q(fVar, 5) || bVar.f30294f != null) {
            z11 = true;
        }
        if (z11) {
            bVar2.y(fVar, 5, SentryLevel.a.f30237a, bVar.f30294f);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public final void b(String str) {
        this.f30290b = str;
    }

    public final void c(String str) {
        this.f30291c = str;
    }

    public final SentryLevel e() {
        return this.f30294f;
    }

    public final String g() {
        return this.f30290b;
    }

    public final Date i() {
        return this.f30289a;
    }

    public final String k() {
        return this.f30291c;
    }

    public /* synthetic */ b(int i11, Date date, String str, String str2, Map map, String str3, SentryLevel sentryLevel, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30295a.getDescriptor());
        }
        this.f30289a = (i11 & 1) == 0 ? e.f30319a.a() : date;
        if ((i11 & 2) == 0) {
            this.f30290b = null;
        } else {
            this.f30290b = str;
        }
        if ((i11 & 4) == 0) {
            this.f30291c = null;
        } else {
            this.f30291c = str2;
        }
        if ((i11 & 8) == 0) {
            this.f30292d = new ConcurrentHashMap();
        } else {
            this.f30292d = map;
        }
        if ((i11 & 16) == 0) {
            this.f30293e = null;
        } else {
            this.f30293e = str3;
        }
        if ((i11 & 32) == 0) {
            this.f30294f = null;
        } else {
            this.f30294f = sentryLevel;
        }
    }

    public final Map<String, Object> c() {
        return this.f30292d;
    }

    public final String a() {
        return this.f30293e;
    }

    public b(Date date, String str, String str2, Map<String, Object> map, String str3, SentryLevel sentryLevel) {
        this.f30289a = date;
        this.f30290b = str;
        this.f30291c = str2;
        this.f30292d = map;
        this.f30293e = str3;
        this.f30294f = sentryLevel;
    }

    public final void a(String str) {
        this.f30293e = str;
    }

    public final void a(SentryLevel sentryLevel) {
        this.f30294f = sentryLevel;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.util.Date r5, java.lang.String r6, java.lang.String r7, java.util.Map r8, java.lang.String r9, com.sumsub.sentry.SentryLevel r10, int r11, kotlin.jvm.internal.r r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x000a
            com.sumsub.sentry.e r5 = com.sumsub.sentry.e.f30319a
            java.util.Date r5 = r5.a()
        L_0x000a:
            r12 = r11 & 2
            r0 = 0
            if (r12 == 0) goto L_0x0011
            r12 = r0
            goto L_0x0012
        L_0x0011:
            r12 = r6
        L_0x0012:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0018
            r1 = r0
            goto L_0x0019
        L_0x0018:
            r1 = r7
        L_0x0019:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0022
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r8.<init>()
        L_0x0022:
            r2 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0029
            r3 = r0
            goto L_0x002a
        L_0x0029:
            r3 = r9
        L_0x002a:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r0 = r10
        L_0x0030:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.b.<init>(java.util.Date, java.lang.String, java.lang.String, java.util.Map, java.lang.String, com.sumsub.sentry.SentryLevel, int, kotlin.jvm.internal.r):void");
    }

    public b(b bVar) {
        this(bVar.f30289a, bVar.f30290b, bVar.f30291c, new ConcurrentHashMap(bVar.f30292d), bVar.f30293e, bVar.f30294f);
    }

    public b(String str) {
        this(e.f30319a.a(), str, (String) null, (Map) null, (String) null, (SentryLevel) null, 60, (r) null);
    }
}
