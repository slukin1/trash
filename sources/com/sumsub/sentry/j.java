package com.sumsub.sentry;

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

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 92\u00020\u0001:\u0002\b\u0011Bs\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b1\u00102B\u0011\b\u0010\u0012\u0006\u00103\u001a\u00020\u0000¢\u0006\u0004\b1\u00104B\u0001\b\u0017\u0012\u0006\u00105\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010)\u001a\u0004\u0018\u00010$\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\t\u0012\b\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b1\u00108J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0017\u0010\u0014R\"\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\n\u0012\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001b\u0010\fR\"\u0010 \u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u0012\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001e\u0010\u0014R\"\u0010#\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b!\u0010\n\u0012\u0004\b\"\u0010\u000e\u001a\u0004\b\b\u0010\fR\"\u0010)\u001a\u0004\u0018\u00010$8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010%\u0012\u0004\b(\u0010\u000e\u001a\u0004\b&\u0010'R\"\u0010-\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b*\u0010\n\u0012\u0004\b,\u0010\u000e\u001a\u0004\b+\u0010\fR\"\u00100\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b.\u0010\n\u0012\u0004\b/\u0010\u000e\u001a\u0004\b.\u0010\f¨\u0006:"}, d2 = {"Lcom/sumsub/sentry/j;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "", "b", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "getId$annotations", "id", "k", "getVendorId$annotations", "vendorId", "d", "m", "getVendorName$annotations", "vendorName", "e", "getMemorySize$annotations", "memorySize", "f", "getApiType$annotations", "apiType", "", "Ljava/lang/Boolean;", "q", "()Ljava/lang/Boolean;", "isMultiThreadedRendering$annotations", "isMultiThreadedRendering", "h", "o", "getVersion$annotations", "version", "i", "getNpotSupport$annotations", "npotSupport", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "gpu", "(Lcom/sumsub/sentry/j;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class j {
    public static final b Companion = new b((r) null);

    /* renamed from: j  reason: collision with root package name */
    public static final String f30387j = "gpu";

    /* renamed from: a  reason: collision with root package name */
    public final String f30388a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f30389b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f30390c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30391d;

    /* renamed from: e  reason: collision with root package name */
    public final Integer f30392e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30393f;

    /* renamed from: g  reason: collision with root package name */
    public final Boolean f30394g;

    /* renamed from: h  reason: collision with root package name */
    public final String f30395h;

    /* renamed from: i  reason: collision with root package name */
    public final String f30396i;

    public static final class a implements d0<j> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30397a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30398b;

        static {
            a aVar = new a();
            f30397a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.Gpu", aVar, 9);
            pluginGeneratedSerialDescriptor.k("name", true);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("vendor_id", true);
            pluginGeneratedSerialDescriptor.k("vendor_name", true);
            pluginGeneratedSerialDescriptor.k("memory_size", true);
            pluginGeneratedSerialDescriptor.k("api_type", true);
            pluginGeneratedSerialDescriptor.k("multi_threaded_rendering", true);
            pluginGeneratedSerialDescriptor.k("version", true);
            pluginGeneratedSerialDescriptor.k("npot_support", true);
            f30398b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.j deserialize(kotlinx.serialization.encoding.c r22) {
            /*
                r21 = this;
                kotlinx.serialization.descriptors.f r0 = r21.getDescriptor()
                r1 = r22
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 7
                r4 = 6
                r5 = 5
                r6 = 3
                r7 = 8
                r8 = 4
                r9 = 2
                r10 = 0
                r11 = 1
                r12 = 0
                if (r2 == 0) goto L_0x004c
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r10, r2, r12)
                kotlinx.serialization.internal.m0 r13 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r11 = r1.j(r0, r11, r13, r12)
                java.lang.Object r9 = r1.j(r0, r9, r13, r12)
                java.lang.Object r6 = r1.j(r0, r6, r2, r12)
                java.lang.Object r8 = r1.j(r0, r8, r13, r12)
                java.lang.Object r5 = r1.j(r0, r5, r2, r12)
                kotlinx.serialization.internal.h r13 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r4 = r1.j(r0, r4, r13, r12)
                java.lang.Object r3 = r1.j(r0, r3, r2, r12)
                java.lang.Object r2 = r1.j(r0, r7, r2, r12)
                r7 = 511(0x1ff, float:7.16E-43)
                r12 = r10
                r10 = r8
                r8 = r7
                goto L_0x00d5
            L_0x004c:
                r2 = r10
                r19 = r11
                r6 = r12
                r8 = r6
                r9 = r8
                r10 = r9
                r11 = r10
                r13 = r11
                r14 = r13
                r15 = r14
            L_0x0057:
                if (r19 == 0) goto L_0x00ca
                int r5 = r1.w(r0)
                switch(r5) {
                    case -1: goto L_0x00c4;
                    case 0: goto L_0x00b9;
                    case 1: goto L_0x00ae;
                    case 2: goto L_0x00a3;
                    case 3: goto L_0x0098;
                    case 4: goto L_0x008d;
                    case 5: goto L_0x0081;
                    case 6: goto L_0x0078;
                    case 7: goto L_0x006f;
                    case 8: goto L_0x0066;
                    default: goto L_0x0060;
                }
            L_0x0060:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r5)
                throw r0
            L_0x0066:
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r7, r5, r8)
                r2 = r2 | 256(0x100, float:3.59E-43)
                goto L_0x00c8
            L_0x006f:
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r6 = r1.j(r0, r3, r5, r6)
                r2 = r2 | 128(0x80, float:1.794E-43)
                goto L_0x00c8
            L_0x0078:
                kotlinx.serialization.internal.h r5 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r9 = r1.j(r0, r4, r5, r9)
                r2 = r2 | 64
                goto L_0x00c8
            L_0x0081:
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 5
                java.lang.Object r11 = r1.j(r0, r3, r5, r11)
                r2 = r2 | 32
                r5 = r3
                r3 = 7
                goto L_0x0057
            L_0x008d:
                r3 = 5
                kotlinx.serialization.internal.m0 r5 = kotlinx.serialization.internal.m0.f57742a
                r3 = 4
                java.lang.Object r10 = r1.j(r0, r3, r5, r10)
                r2 = r2 | 16
                goto L_0x00c7
            L_0x0098:
                r3 = 4
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 3
                java.lang.Object r15 = r1.j(r0, r3, r5, r15)
                r2 = r2 | 8
                goto L_0x00c7
            L_0x00a3:
                r3 = 3
                kotlinx.serialization.internal.m0 r5 = kotlinx.serialization.internal.m0.f57742a
                r3 = 2
                java.lang.Object r14 = r1.j(r0, r3, r5, r14)
                r2 = r2 | 4
                goto L_0x00c7
            L_0x00ae:
                r3 = 2
                kotlinx.serialization.internal.m0 r5 = kotlinx.serialization.internal.m0.f57742a
                r3 = 1
                java.lang.Object r13 = r1.j(r0, r3, r5, r13)
                r2 = r2 | 2
                goto L_0x00c7
            L_0x00b9:
                r3 = 1
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r12 = r1.j(r0, r3, r5, r12)
                r2 = r2 | 1
                goto L_0x00c7
            L_0x00c4:
                r3 = 0
                r19 = r3
            L_0x00c7:
                r3 = 7
            L_0x00c8:
                r5 = 5
                goto L_0x0057
            L_0x00ca:
                r3 = r6
                r4 = r9
                r5 = r11
                r11 = r13
                r9 = r14
                r6 = r15
                r20 = r8
                r8 = r2
                r2 = r20
            L_0x00d5:
                r1.c(r0)
                com.sumsub.sentry.j r0 = new com.sumsub.sentry.j
                r1 = r12
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Integer r11 = (java.lang.Integer) r11
                r12 = r9
                java.lang.Integer r12 = (java.lang.Integer) r12
                java.lang.String r6 = (java.lang.String) r6
                r13 = r10
                java.lang.Integer r13 = (java.lang.Integer) r13
                r14 = r5
                java.lang.String r14 = (java.lang.String) r14
                r15 = r4
                java.lang.Boolean r15 = (java.lang.Boolean) r15
                r16 = r3
                java.lang.String r16 = (java.lang.String) r16
                r17 = r2
                java.lang.String r17 = (java.lang.String) r17
                r18 = 0
                r7 = r0
                r9 = r1
                r10 = r11
                r11 = r12
                r12 = r6
                r7.<init>((int) r8, (java.lang.String) r9, (java.lang.Integer) r10, (java.lang.Integer) r11, (java.lang.String) r12, (java.lang.Integer) r13, (java.lang.String) r14, (java.lang.Boolean) r15, (java.lang.String) r16, (java.lang.String) r17, (kotlinx.serialization.internal.q1) r18)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.j.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.j");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            m0 m0Var = m0.f57742a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(m0Var), h10.a.u(m0Var), h10.a.u(v1Var), h10.a.u(m0Var), h10.a.u(v1Var), h10.a.u(h.f57720a), h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30398b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, j jVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            j.a(jVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<j> serializer() {
            return a.f30397a;
        }

        public b() {
        }
    }

    public j() {
        this((String) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, (Boolean) null, (String) null, (String) null, 511, (r) null);
    }

    public static final void a(j jVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || jVar.f30388a != null) {
            bVar.y(fVar, 0, v1.f57779a, jVar.f30388a);
        }
        if (bVar.q(fVar, 1) || jVar.f30389b != null) {
            bVar.y(fVar, 1, m0.f57742a, jVar.f30389b);
        }
        if (bVar.q(fVar, 2) || jVar.f30390c != null) {
            bVar.y(fVar, 2, m0.f57742a, jVar.f30390c);
        }
        if (bVar.q(fVar, 3) || jVar.f30391d != null) {
            bVar.y(fVar, 3, v1.f57779a, jVar.f30391d);
        }
        if (bVar.q(fVar, 4) || jVar.f30392e != null) {
            bVar.y(fVar, 4, m0.f57742a, jVar.f30392e);
        }
        if (bVar.q(fVar, 5) || jVar.f30393f != null) {
            bVar.y(fVar, 5, v1.f57779a, jVar.f30393f);
        }
        if (bVar.q(fVar, 6) || jVar.f30394g != null) {
            bVar.y(fVar, 6, h.f57720a, jVar.f30394g);
        }
        if (bVar.q(fVar, 7) || jVar.f30395h != null) {
            bVar.y(fVar, 7, v1.f57779a, jVar.f30395h);
        }
        if (bVar.q(fVar, 8) || jVar.f30396i != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 8, v1.f57779a, jVar.f30396i);
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

    public static /* synthetic */ void r() {
    }

    public final Integer c() {
        return this.f30389b;
    }

    public final Integer e() {
        return this.f30392e;
    }

    public final String g() {
        return this.f30388a;
    }

    public final String i() {
        return this.f30396i;
    }

    public final Integer k() {
        return this.f30390c;
    }

    public final String m() {
        return this.f30391d;
    }

    public final String o() {
        return this.f30395h;
    }

    public final Boolean q() {
        return this.f30394g;
    }

    public /* synthetic */ j(int i11, String str, Integer num, Integer num2, String str2, Integer num3, String str3, Boolean bool, String str4, String str5, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30397a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30388a = null;
        } else {
            this.f30388a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30389b = null;
        } else {
            this.f30389b = num;
        }
        if ((i11 & 4) == 0) {
            this.f30390c = null;
        } else {
            this.f30390c = num2;
        }
        if ((i11 & 8) == 0) {
            this.f30391d = null;
        } else {
            this.f30391d = str2;
        }
        if ((i11 & 16) == 0) {
            this.f30392e = null;
        } else {
            this.f30392e = num3;
        }
        if ((i11 & 32) == 0) {
            this.f30393f = null;
        } else {
            this.f30393f = str3;
        }
        if ((i11 & 64) == 0) {
            this.f30394g = null;
        } else {
            this.f30394g = bool;
        }
        if ((i11 & 128) == 0) {
            this.f30395h = null;
        } else {
            this.f30395h = str4;
        }
        if ((i11 & 256) == 0) {
            this.f30396i = null;
        } else {
            this.f30396i = str5;
        }
    }

    public final String a() {
        return this.f30393f;
    }

    public j(String str, Integer num, Integer num2, String str2, Integer num3, String str3, Boolean bool, String str4, String str5) {
        this.f30388a = str;
        this.f30389b = num;
        this.f30390c = num2;
        this.f30391d = str2;
        this.f30392e = num3;
        this.f30393f = str3;
        this.f30394g = bool;
        this.f30395h = str4;
        this.f30396i = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ j(java.lang.String r11, java.lang.Integer r12, java.lang.Integer r13, java.lang.String r14, java.lang.Integer r15, java.lang.String r16, java.lang.Boolean r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.r r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.j.<init>(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }

    public j(j jVar) {
        this(jVar.f30388a, jVar.f30389b, jVar.f30390c, jVar.f30391d, jVar.f30392e, jVar.f30393f, jVar.f30394g, jVar.f30395h, jVar.f30396i);
    }
}
