package com.sumsub.sentry;

import cn.sharesdk.framework.InnerShareParams;
import com.sumsub.sentry.SpanStatus;
import com.sumsub.sentry.d0;
import com.sumsub.sentry.o0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 A2\u00020\u0001:\u0002\b\u0013B\u0011\b\u0016\u0012\u0006\u00107\u001a\u00020\u0000¢\u0006\u0004\b8\u00109B\u0011\b\u0016\u0012\u0006\u0010:\u001a\u00020\u001e¢\u0006\u0004\b8\u0010\"Bf\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010%\u0012\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0,ø\u0001\u0000¢\u0006\u0004\b8\u0010;B~\b\u0017\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010%\u0012\u0016\b\u0001\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0018\u00010,\u0012\b\u0010?\u001a\u0004\u0018\u00010>ø\u0001\u0000¢\u0006\u0004\b8\u0010@J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tR)\u0010\u0011\u001a\u00020\u000b8\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\b\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR)\u0010\u0016\u001a\u00020\u00128\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0014\u0010\u000eR+\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0018\u0010\u000eR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u0010R \u0010 \u001a\u00020\u001e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\f\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u0017\u0010\u000eR*\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b!\u0010\f\u0012\u0004\b#\u0010\u0010\u001a\u0004\b\b\u0010\u000e\"\u0004\b\b\u0010\"R\"\u0010+\u001a\u0004\u0018\u00010%8\u0006X\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)R,\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0,8\u0006X\u0004¢\u0006\u0012\n\u0004\b-\u0010.\u0012\u0004\b1\u0010\u0010\u001a\u0004\b/\u00100R(\u00104\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001038F@FX\u000e¢\u0006\f\u001a\u0004\b&\u00105\"\u0004\b\b\u00106\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Lcom/sumsub/sentry/n0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sentry/p0;", "samplingDecision", "Lcom/sumsub/sentry/d0;", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "getTraceId-uFNw5ug$annotations", "()V", "traceId", "Lcom/sumsub/sentry/o0;", "b", "i", "getSpanId-L6urO5c$annotations", "spanId", "c", "e", "getParentSpanId-CrewFg8$annotations", "parentSpanId", "d", "Lcom/sumsub/sentry/p0;", "getSamplingDecision$annotations", "", "getOp$annotations", "op", "f", "(Ljava/lang/String;)V", "getDescription$annotations", "description", "Lcom/sumsub/sentry/SpanStatus;", "g", "Lcom/sumsub/sentry/SpanStatus;", "k", "()Lcom/sumsub/sentry/SpanStatus;", "getStatus$annotations", "status", "", "h", "Ljava/util/Map;", "m", "()Ljava/util/Map;", "getTags$annotations", "tags", "", "sampled", "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "spanContext", "<init>", "(Lcom/sumsub/sentry/n0;)V", "operation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/p0;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/SpanStatus;Ljava/util/Map;Lkotlin/jvm/internal/r;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/SpanStatus;Ljava/util/Map;Lkotlinx/serialization/internal/q1;Lkotlin/jvm/internal/r;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class n0 {
    public static final b Companion = new b((r) null);

    /* renamed from: i  reason: collision with root package name */
    public static final String f30437i = "trace";

    /* renamed from: a  reason: collision with root package name */
    public final String f30438a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30439b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30440c;

    /* renamed from: d  reason: collision with root package name */
    public p0 f30441d;

    /* renamed from: e  reason: collision with root package name */
    public final String f30442e;

    /* renamed from: f  reason: collision with root package name */
    public String f30443f;

    /* renamed from: g  reason: collision with root package name */
    public final SpanStatus f30444g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, String> f30445h;

    public static final class a implements d0<n0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30446a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30447b;

        static {
            a aVar = new a();
            f30446a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SpanContext", aVar, 7);
            pluginGeneratedSerialDescriptor.k("trace_id", false);
            pluginGeneratedSerialDescriptor.k("span_id", false);
            pluginGeneratedSerialDescriptor.k("parent_span_id", false);
            pluginGeneratedSerialDescriptor.k("op", false);
            pluginGeneratedSerialDescriptor.k("description", true);
            pluginGeneratedSerialDescriptor.k("status", true);
            pluginGeneratedSerialDescriptor.k(InnerShareParams.TAGS, true);
            f30447b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ad, code lost:
            r3 = 6;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.n0 deserialize(kotlinx.serialization.encoding.c r19) {
            /*
                r18 = this;
                kotlinx.serialization.descriptors.f r0 = r18.getDescriptor()
                r1 = r19
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 6
                r4 = 5
                r5 = 3
                r6 = 4
                r7 = 2
                r8 = 0
                r9 = 1
                r10 = 0
                if (r2 == 0) goto L_0x0048
                com.sumsub.sentry.d0$a r2 = com.sumsub.sentry.d0.a.f30317a
                java.lang.Object r2 = r1.p(r0, r8, r2, r10)
                com.sumsub.sentry.o0$a r8 = com.sumsub.sentry.o0.a.f30460a
                java.lang.Object r9 = r1.p(r0, r9, r8, r10)
                java.lang.Object r7 = r1.j(r0, r7, r8, r10)
                java.lang.String r5 = r1.i(r0, r5)
                kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r6 = r1.j(r0, r6, r8, r10)
                com.sumsub.sentry.SpanStatus$a r11 = com.sumsub.sentry.SpanStatus.a.f30239a
                java.lang.Object r4 = r1.j(r0, r4, r11, r10)
                kotlinx.serialization.internal.r0 r11 = new kotlinx.serialization.internal.r0
                r11.<init>(r8, r8)
                java.lang.Object r3 = r1.p(r0, r3, r11, r10)
                r8 = 127(0x7f, float:1.78E-43)
                r10 = r5
                r16 = r8
                goto L_0x00b5
            L_0x0048:
                r16 = r8
                r17 = r9
                r2 = r10
                r11 = r2
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x0052:
                if (r17 == 0) goto L_0x00af
                int r8 = r1.w(r0)
                switch(r8) {
                    case -1: goto L_0x00a9;
                    case 0: goto L_0x009e;
                    case 1: goto L_0x0093;
                    case 2: goto L_0x0088;
                    case 3: goto L_0x0081;
                    case 4: goto L_0x0078;
                    case 5: goto L_0x006f;
                    case 6: goto L_0x0061;
                    default: goto L_0x005b;
                }
            L_0x005b:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r8)
                throw r0
            L_0x0061:
                kotlinx.serialization.internal.r0 r8 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                r8.<init>(r9, r9)
                java.lang.Object r11 = r1.p(r0, r3, r8, r11)
                r16 = r16 | 64
                goto L_0x0090
            L_0x006f:
                com.sumsub.sentry.SpanStatus$a r8 = com.sumsub.sentry.SpanStatus.a.f30239a
                java.lang.Object r12 = r1.j(r0, r4, r8, r12)
                r16 = r16 | 32
                goto L_0x0090
            L_0x0078:
                kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r14 = r1.j(r0, r6, r8, r14)
                r16 = r16 | 16
                goto L_0x0090
            L_0x0081:
                java.lang.String r13 = r1.i(r0, r5)
                r16 = r16 | 8
                goto L_0x0090
            L_0x0088:
                com.sumsub.sentry.o0$a r8 = com.sumsub.sentry.o0.a.f30460a
                java.lang.Object r15 = r1.j(r0, r7, r8, r15)
                r16 = r16 | 4
            L_0x0090:
                r8 = 0
                r9 = 1
                goto L_0x0052
            L_0x0093:
                com.sumsub.sentry.o0$a r8 = com.sumsub.sentry.o0.a.f30460a
                r9 = 1
                java.lang.Object r10 = r1.p(r0, r9, r8, r10)
                r16 = r16 | 2
                r8 = 0
                goto L_0x0052
            L_0x009e:
                com.sumsub.sentry.d0$a r8 = com.sumsub.sentry.d0.a.f30317a
                r3 = 0
                java.lang.Object r2 = r1.p(r0, r3, r8, r2)
                r16 = r16 | 1
                r8 = r3
                goto L_0x00ad
            L_0x00a9:
                r3 = 0
                r8 = r3
                r17 = r8
            L_0x00ad:
                r3 = 6
                goto L_0x0052
            L_0x00af:
                r9 = r10
                r3 = r11
                r4 = r12
                r10 = r13
                r6 = r14
                r7 = r15
            L_0x00b5:
                r1.c(r0)
                com.sumsub.sentry.n0 r0 = new com.sumsub.sentry.n0
                com.sumsub.sentry.d0 r2 = (com.sumsub.sentry.d0) r2
                if (r2 == 0) goto L_0x00c3
                java.lang.String r1 = r2.b()
                goto L_0x00c4
            L_0x00c3:
                r1 = 0
            L_0x00c4:
                com.sumsub.sentry.o0 r9 = (com.sumsub.sentry.o0) r9
                if (r9 == 0) goto L_0x00ce
                java.lang.String r2 = r9.c()
                r8 = r2
                goto L_0x00cf
            L_0x00ce:
                r8 = 0
            L_0x00cf:
                com.sumsub.sentry.o0 r7 = (com.sumsub.sentry.o0) r7
                if (r7 == 0) goto L_0x00d9
                java.lang.String r2 = r7.c()
                r9 = r2
                goto L_0x00da
            L_0x00d9:
                r9 = 0
            L_0x00da:
                r11 = r6
                java.lang.String r11 = (java.lang.String) r11
                r12 = r4
                com.sumsub.sentry.SpanStatus r12 = (com.sumsub.sentry.SpanStatus) r12
                r13 = r3
                java.util.Map r13 = (java.util.Map) r13
                r14 = 0
                r15 = 0
                r5 = r0
                r6 = r16
                r7 = r1
                r5.<init>((int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (com.sumsub.sentry.SpanStatus) r12, (java.util.Map) r13, (kotlinx.serialization.internal.q1) r14, (kotlin.jvm.internal.r) r15)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.n0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.n0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            o0.a aVar = o0.a.f30460a;
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{d0.a.f30317a, aVar, h10.a.u(aVar), v1Var, h10.a.u(v1Var), h10.a.u(SpanStatus.a.f30239a), new r0(v1Var, v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30447b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, n0 n0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            n0.a(n0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<n0> serializer() {
            return a.f30446a;
        }

        public b() {
        }
    }

    public /* synthetic */ n0(int i11, String str, String str2, String str3, String str4, String str5, SpanStatus spanStatus, Map map, q1 q1Var, r rVar) {
        this(i11, str, str2, str3, str4, str5, spanStatus, (Map<String, String>) map, q1Var);
    }

    public static final void a(n0 n0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        bVar.F(fVar, 0, d0.a.f30317a, d0.a(n0Var.f30438a));
        o0.a aVar = o0.a.f30460a;
        bVar.F(fVar, 1, aVar, o0.a(n0Var.f30439b));
        String str = n0Var.f30440c;
        bVar.y(fVar, 2, aVar, str != null ? o0.a(str) : null);
        bVar.p(fVar, 3, n0Var.f30442e);
        if (bVar.q(fVar, 4) || n0Var.f30443f != null) {
            bVar.y(fVar, 4, v1.f57779a, n0Var.f30443f);
        }
        if (bVar.q(fVar, 5) || n0Var.f30444g != null) {
            bVar.y(fVar, 5, SpanStatus.a.f30239a, n0Var.f30444g);
        }
        if (bVar.q(fVar, 6) || !x.b(n0Var.f30445h, new ConcurrentHashMap())) {
            z11 = true;
        }
        if (z11) {
            v1 v1Var = v1.f57779a;
            bVar.F(fVar, 6, new r0(v1Var, v1Var), n0Var.f30445h);
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

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void p() {
    }

    public final String c() {
        return this.f30442e;
    }

    public final String e() {
        return this.f30440c;
    }

    public final Boolean g() {
        p0 p0Var = this.f30441d;
        if (p0Var != null) {
            return Boolean.valueOf(p0Var.b());
        }
        return null;
    }

    public final String i() {
        return this.f30439b;
    }

    public final SpanStatus k() {
        return this.f30444g;
    }

    public final Map<String, String> m() {
        return this.f30445h;
    }

    public final String o() {
        return this.f30438a;
    }

    public /* synthetic */ n0(String str, String str2, String str3, p0 p0Var, String str4, String str5, SpanStatus spanStatus, Map map, r rVar) {
        this(str, str2, str3, p0Var, str4, str5, spanStatus, map);
    }

    public n0(int i11, String str, String str2, String str3, String str4, String str5, SpanStatus spanStatus, Map<String, String> map, q1 q1Var) {
        if (15 != (i11 & 15)) {
            h1.a(i11, 15, a.f30446a.getDescriptor());
        }
        this.f30438a = str;
        this.f30439b = str2;
        this.f30440c = str3;
        this.f30441d = null;
        this.f30442e = str4;
        if ((i11 & 16) == 0) {
            this.f30443f = null;
        } else {
            this.f30443f = str5;
        }
        if ((i11 & 32) == 0) {
            this.f30444g = null;
        } else {
            this.f30444g = spanStatus;
        }
        if ((i11 & 64) == 0) {
            this.f30445h = new ConcurrentHashMap();
        } else {
            this.f30445h = map;
        }
    }

    public final String a() {
        return this.f30443f;
    }

    public final void a(String str) {
        this.f30443f = str;
    }

    public n0(String str, String str2, String str3, p0 p0Var, String str4, String str5, SpanStatus spanStatus, Map<String, String> map) {
        this.f30438a = str;
        this.f30439b = str2;
        this.f30440c = str3;
        this.f30441d = p0Var;
        this.f30442e = str4;
        this.f30443f = str5;
        this.f30444g = spanStatus;
        this.f30445h = map;
    }

    public final void a(Boolean bool) {
        if (bool == null) {
            a((p0) null);
        } else {
            a(new p0(bool.booleanValue(), (Double) null, 2, (r) null));
        }
    }

    public final void a(p0 p0Var) {
        this.f30441d = p0Var;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ n0(java.lang.String r14, java.lang.String r15, java.lang.String r16, com.sumsub.sentry.p0 r17, java.lang.String r18, java.lang.String r19, com.sumsub.sentry.SpanStatus r20, java.util.Map r21, int r22, kotlin.jvm.internal.r r23) {
        /*
            r13 = this;
            r0 = r22
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r17
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r19
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r10 = r2
            goto L_0x001b
        L_0x0019:
            r10 = r20
        L_0x001b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0026
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r11 = r0
            goto L_0x0028
        L_0x0026:
            r11 = r21
        L_0x0028:
            r12 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r8 = r18
            r3.<init>((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (com.sumsub.sentry.p0) r7, (java.lang.String) r8, (java.lang.String) r9, (com.sumsub.sentry.SpanStatus) r10, (java.util.Map) r11, (kotlin.jvm.internal.r) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.n0.<init>(java.lang.String, java.lang.String, java.lang.String, com.sumsub.sentry.p0, java.lang.String, java.lang.String, com.sumsub.sentry.SpanStatus, java.util.Map, int, kotlin.jvm.internal.r):void");
    }

    public n0(n0 n0Var) {
        this(n0Var.f30438a, n0Var.f30439b, n0Var.f30440c, (p0) null, n0Var.f30442e, n0Var.f30443f, n0Var.f30444g, (Map) new ConcurrentHashMap(n0Var.f30445h), 8, (r) null);
    }

    public n0(String str) {
        this(d0.a((String) null, 1, (r) null), o0.a((String) null, 1, (r) null), (String) null, (p0) null, str, (String) null, (SpanStatus) null, (Map) null, 224, (r) null);
    }
}
