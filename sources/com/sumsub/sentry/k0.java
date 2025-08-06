package com.sumsub.sentry;

import com.sumsub.sentry.i0;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.x0;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 <2\u00020\u0001:\u0002\b\u0012Bg\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010/¢\u0006\u0004\b6\u00107B{\b\u0017\u0012\u0006\u00108\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010#\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010#\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010#\u0012\n\b\u0001\u00105\u001a\u0004\u0018\u00010/\u0012\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b6\u0010;J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R*\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\b\u0010\n\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\b\u0010\rR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\"\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u0012\u0004\b!\u0010\u000f\u001a\u0004\b \u0010\u001cR\"\u0010(\u001a\u0004\u0018\u00010#8\u0006X\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b'\u0010\u000f\u001a\u0004\b\b\u0010&R*\u0010,\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b)\u0010%\u0012\u0004\b+\u0010\u000f\u001a\u0004\b\u0019\u0010&\"\u0004\b\b\u0010*R\"\u0010.\u001a\u0004\u0018\u00010#8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010%\u0012\u0004\b-\u0010\u000f\u001a\u0004\b$\u0010&R\"\u00105\u001a\u0004\u0018\u00010/8\u0006X\u0004¢\u0006\u0012\n\u0004\b0\u00101\u0012\u0004\b4\u0010\u000f\u001a\u0004\b2\u00103¨\u0006="}, d2 = {"Lcom/sumsub/sentry/k0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/Long;", "g", "()Ljava/lang/Long;", "(Ljava/lang/Long;)V", "getId$annotations", "()V", "id", "", "b", "Ljava/lang/Integer;", "k", "()Ljava/lang/Integer;", "getPriority$annotations", "priority", "", "c", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "getName$annotations", "name", "d", "o", "getState$annotations", "state", "", "e", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "getCrashed$annotations", "crashed", "f", "(Ljava/lang/Boolean;)V", "getCurrent$annotations", "current", "getDaemon$annotations", "daemon", "Lcom/sumsub/sentry/i0;", "h", "Lcom/sumsub/sentry/i0;", "m", "()Lcom/sumsub/sentry/i0;", "getStacktrace$annotations", "stacktrace", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sumsub/sentry/i0;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sumsub/sentry/i0;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class k0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public Long f30415a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f30416b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30417c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30418d;

    /* renamed from: e  reason: collision with root package name */
    public final Boolean f30419e;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f30420f;

    /* renamed from: g  reason: collision with root package name */
    public final Boolean f30421g;

    /* renamed from: h  reason: collision with root package name */
    public final i0 f30422h;

    public static final class a implements d0<k0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30423a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30424b;

        static {
            a aVar = new a();
            f30423a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryThread", aVar, 8);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("priority", true);
            pluginGeneratedSerialDescriptor.k("name", true);
            pluginGeneratedSerialDescriptor.k("state", true);
            pluginGeneratedSerialDescriptor.k("crashed", true);
            pluginGeneratedSerialDescriptor.k("current", true);
            pluginGeneratedSerialDescriptor.k("daemon", true);
            pluginGeneratedSerialDescriptor.k("stacktrace", true);
            f30424b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.k0 deserialize(kotlinx.serialization.encoding.c r23) {
            /*
                r22 = this;
                kotlinx.serialization.descriptors.f r0 = r22.getDescriptor()
                r1 = r23
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 7
                r4 = 6
                r5 = 5
                r6 = 3
                r7 = 4
                r8 = 2
                r9 = 0
                r10 = 1
                r11 = 0
                if (r2 == 0) goto L_0x0048
                kotlinx.serialization.internal.x0 r2 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r2 = r1.j(r0, r9, r2, r11)
                kotlinx.serialization.internal.m0 r9 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r9 = r1.j(r0, r10, r9, r11)
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r8, r10, r11)
                java.lang.Object r6 = r1.j(r0, r6, r10, r11)
                kotlinx.serialization.internal.h r10 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r7 = r1.j(r0, r7, r10, r11)
                java.lang.Object r5 = r1.j(r0, r5, r10, r11)
                java.lang.Object r4 = r1.j(r0, r4, r10, r11)
                com.sumsub.sentry.i0$a r10 = com.sumsub.sentry.i0.a.f30385a
                java.lang.Object r3 = r1.j(r0, r3, r10, r11)
                r10 = 255(0xff, float:3.57E-43)
                r11 = r10
                goto L_0x00c4
            L_0x0048:
                r2 = r9
                r18 = r10
                r8 = r11
                r9 = r8
                r10 = r9
                r12 = r10
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x0052:
                if (r18 == 0) goto L_0x00b8
                int r6 = r1.w(r0)
                switch(r6) {
                    case -1: goto L_0x00b2;
                    case 0: goto L_0x00a7;
                    case 1: goto L_0x009c;
                    case 2: goto L_0x0091;
                    case 3: goto L_0x0085;
                    case 4: goto L_0x007c;
                    case 5: goto L_0x0073;
                    case 6: goto L_0x006a;
                    case 7: goto L_0x0061;
                    default: goto L_0x005b;
                }
            L_0x005b:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r6)
                throw r0
            L_0x0061:
                com.sumsub.sentry.i0$a r6 = com.sumsub.sentry.i0.a.f30385a
                java.lang.Object r8 = r1.j(r0, r3, r6, r8)
                r2 = r2 | 128(0x80, float:1.794E-43)
                goto L_0x00b6
            L_0x006a:
                kotlinx.serialization.internal.h r6 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r10 = r1.j(r0, r4, r6, r10)
                r2 = r2 | 64
                goto L_0x00b6
            L_0x0073:
                kotlinx.serialization.internal.h r6 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r9 = r1.j(r0, r5, r6, r9)
                r2 = r2 | 32
                goto L_0x00b6
            L_0x007c:
                kotlinx.serialization.internal.h r6 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r15 = r1.j(r0, r7, r6, r15)
                r2 = r2 | 16
                goto L_0x00b6
            L_0x0085:
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r3 = 3
                java.lang.Object r14 = r1.j(r0, r3, r6, r14)
                r2 = r2 | 8
                r6 = r3
                r3 = 7
                goto L_0x0052
            L_0x0091:
                r3 = 3
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r3 = 2
                java.lang.Object r13 = r1.j(r0, r3, r6, r13)
                r2 = r2 | 4
                goto L_0x00b5
            L_0x009c:
                r3 = 2
                kotlinx.serialization.internal.m0 r6 = kotlinx.serialization.internal.m0.f57742a
                r3 = 1
                java.lang.Object r12 = r1.j(r0, r3, r6, r12)
                r2 = r2 | 2
                goto L_0x00b5
            L_0x00a7:
                r3 = 1
                kotlinx.serialization.internal.x0 r6 = kotlinx.serialization.internal.x0.f57786a
                r3 = 0
                java.lang.Object r11 = r1.j(r0, r3, r6, r11)
                r2 = r2 | 1
                goto L_0x00b5
            L_0x00b2:
                r3 = 0
                r18 = r3
            L_0x00b5:
                r3 = 7
            L_0x00b6:
                r6 = 3
                goto L_0x0052
            L_0x00b8:
                r3 = r8
                r5 = r9
                r4 = r10
                r9 = r12
                r8 = r13
                r6 = r14
                r7 = r15
                r21 = r11
                r11 = r2
                r2 = r21
            L_0x00c4:
                r1.c(r0)
                com.sumsub.sentry.k0 r0 = new com.sumsub.sentry.k0
                r12 = r2
                java.lang.Long r12 = (java.lang.Long) r12
                r13 = r9
                java.lang.Integer r13 = (java.lang.Integer) r13
                r14 = r8
                java.lang.String r14 = (java.lang.String) r14
                r15 = r6
                java.lang.String r15 = (java.lang.String) r15
                r16 = r7
                java.lang.Boolean r16 = (java.lang.Boolean) r16
                r17 = r5
                java.lang.Boolean r17 = (java.lang.Boolean) r17
                r18 = r4
                java.lang.Boolean r18 = (java.lang.Boolean) r18
                r19 = r3
                com.sumsub.sentry.i0 r19 = (com.sumsub.sentry.i0) r19
                r20 = 0
                r10 = r0
                r10.<init>((int) r11, (java.lang.Long) r12, (java.lang.Integer) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.Boolean) r16, (java.lang.Boolean) r17, (java.lang.Boolean) r18, (com.sumsub.sentry.i0) r19, (kotlinx.serialization.internal.q1) r20)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.k0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.k0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            h hVar = h.f57720a;
            return new kotlinx.serialization.b[]{h10.a.u(x0.f57786a), h10.a.u(m0.f57742a), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(hVar), h10.a.u(hVar), h10.a.u(hVar), h10.a.u(i0.a.f30385a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30424b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, k0 k0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            k0.a(k0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<k0> serializer() {
            return a.f30423a;
        }

        public b() {
        }
    }

    public k0() {
        this((Long) null, (Integer) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (i0) null, 255, (r) null);
    }

    public static final void a(k0 k0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || k0Var.f30415a != null) {
            bVar.y(fVar, 0, x0.f57786a, k0Var.f30415a);
        }
        if (bVar.q(fVar, 1) || k0Var.f30416b != null) {
            bVar.y(fVar, 1, m0.f57742a, k0Var.f30416b);
        }
        if (bVar.q(fVar, 2) || k0Var.f30417c != null) {
            bVar.y(fVar, 2, v1.f57779a, k0Var.f30417c);
        }
        if (bVar.q(fVar, 3) || k0Var.f30418d != null) {
            bVar.y(fVar, 3, v1.f57779a, k0Var.f30418d);
        }
        if (bVar.q(fVar, 4) || k0Var.f30419e != null) {
            bVar.y(fVar, 4, h.f57720a, k0Var.f30419e);
        }
        if (bVar.q(fVar, 5) || k0Var.f30420f != null) {
            bVar.y(fVar, 5, h.f57720a, k0Var.f30420f);
        }
        if (bVar.q(fVar, 6) || k0Var.f30421g != null) {
            bVar.y(fVar, 6, h.f57720a, k0Var.f30421g);
        }
        if (bVar.q(fVar, 7) || k0Var.f30422h != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 7, i0.a.f30385a, k0Var.f30422h);
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

    public final Boolean c() {
        return this.f30420f;
    }

    public final Boolean e() {
        return this.f30421g;
    }

    public final Long g() {
        return this.f30415a;
    }

    public final String i() {
        return this.f30417c;
    }

    public final Integer k() {
        return this.f30416b;
    }

    public final i0 m() {
        return this.f30422h;
    }

    public final String o() {
        return this.f30418d;
    }

    public /* synthetic */ k0(int i11, Long l11, Integer num, String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, i0 i0Var, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30423a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30415a = null;
        } else {
            this.f30415a = l11;
        }
        if ((i11 & 2) == 0) {
            this.f30416b = null;
        } else {
            this.f30416b = num;
        }
        if ((i11 & 4) == 0) {
            this.f30417c = null;
        } else {
            this.f30417c = str;
        }
        if ((i11 & 8) == 0) {
            this.f30418d = null;
        } else {
            this.f30418d = str2;
        }
        if ((i11 & 16) == 0) {
            this.f30419e = null;
        } else {
            this.f30419e = bool;
        }
        if ((i11 & 32) == 0) {
            this.f30420f = null;
        } else {
            this.f30420f = bool2;
        }
        if ((i11 & 64) == 0) {
            this.f30421g = null;
        } else {
            this.f30421g = bool3;
        }
        if ((i11 & 128) == 0) {
            this.f30422h = null;
        } else {
            this.f30422h = i0Var;
        }
    }

    public final void a(Long l11) {
        this.f30415a = l11;
    }

    public k0(Long l11, Integer num, String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, i0 i0Var) {
        this.f30415a = l11;
        this.f30416b = num;
        this.f30417c = str;
        this.f30418d = str2;
        this.f30419e = bool;
        this.f30420f = bool2;
        this.f30421g = bool3;
        this.f30422h = i0Var;
    }

    public final Boolean a() {
        return this.f30419e;
    }

    public final void a(Boolean bool) {
        this.f30420f = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ k0(java.lang.Long r10, java.lang.Integer r11, java.lang.String r12, java.lang.String r13, java.lang.Boolean r14, java.lang.Boolean r15, java.lang.Boolean r16, com.sumsub.sentry.i0 r17, int r18, kotlin.jvm.internal.r r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.k0.<init>(java.lang.Long, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, com.sumsub.sentry.i0, int, kotlin.jvm.internal.r):void");
    }
}
