package com.sumsub.sentry;

import com.sumsub.sentry.android.c;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 /2\u00020\u0001:\u0002\b\u0012BO\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b&\u0010'B\u0011\b\u0010\u0012\u0006\u0010(\u001a\u00020\u0000¢\u0006\u0004\b&\u0010)Bc\b\u0017\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b&\u0010.J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R*\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\b\u0010\n\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0012\u0010\n\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u000b\u0010\u000eR*\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\r\u0010\n\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR*\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0017\u0010\n\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\b\u0010\f\"\u0004\b\b\u0010\u000eR*\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\n\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\r\u0010\f\"\u0004\b\u0012\u0010\u000eR*\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u001f\u0010 \u0012\u0004\b$\u0010\u0010\u001a\u0004\b!\u0010\"\"\u0004\b\b\u0010#¨\u00060"}, d2 = {"Lcom/sumsub/sentry/q;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "getName$annotations", "()V", "name", "b", "i", "getVersion$annotations", "version", "g", "d", "getRawDescription$annotations", "rawDescription", "getBuild$annotations", "build", "getKernelVersion$annotations", "kernelVersion", "", "f", "Ljava/lang/Boolean;", "k", "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "isRooted$annotations", "isRooted", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "operatingSystem", "(Lcom/sumsub/sentry/q;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class q {
    public static final b Companion = new b((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final String f30469g = "os";

    /* renamed from: a  reason: collision with root package name */
    public String f30470a;

    /* renamed from: b  reason: collision with root package name */
    public String f30471b;

    /* renamed from: c  reason: collision with root package name */
    public String f30472c;

    /* renamed from: d  reason: collision with root package name */
    public String f30473d;

    /* renamed from: e  reason: collision with root package name */
    public String f30474e;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f30475f;

    public static final class a implements d0<q> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30476a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30477b;

        static {
            a aVar = new a();
            f30476a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.OperatingSystem", aVar, 6);
            pluginGeneratedSerialDescriptor.k("name", true);
            pluginGeneratedSerialDescriptor.k("version", true);
            pluginGeneratedSerialDescriptor.k("raw_description", true);
            pluginGeneratedSerialDescriptor.k("build", true);
            pluginGeneratedSerialDescriptor.k("kernel_version", true);
            pluginGeneratedSerialDescriptor.k(c.f30262i, true);
            f30477b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x008b, code lost:
            r3 = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r11 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
            r11 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
            r11 = r11;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.q deserialize(kotlinx.serialization.encoding.c r17) {
            /*
                r16 = this;
                kotlinx.serialization.descriptors.f r0 = r16.getDescriptor()
                r1 = r17
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 5
                r4 = 3
                r5 = 4
                r6 = 2
                r7 = 0
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x0039
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r1.j(r0, r7, r2, r9)
                java.lang.Object r8 = r1.j(r0, r8, r2, r9)
                java.lang.Object r6 = r1.j(r0, r6, r2, r9)
                java.lang.Object r4 = r1.j(r0, r4, r2, r9)
                java.lang.Object r2 = r1.j(r0, r5, r2, r9)
                kotlinx.serialization.internal.h r5 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r3 = r1.j(r0, r3, r5, r9)
                r5 = 63
                r11 = r6
                r6 = r5
                goto L_0x0093
            L_0x0039:
                r2 = r7
                r15 = r8
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r14 = r13
            L_0x0040:
                if (r15 == 0) goto L_0x008d
                int r7 = r1.w(r0)
                switch(r7) {
                    case -1: goto L_0x0088;
                    case 0: goto L_0x007d;
                    case 1: goto L_0x0073;
                    case 2: goto L_0x006a;
                    case 3: goto L_0x0061;
                    case 4: goto L_0x0058;
                    case 5: goto L_0x004f;
                    default: goto L_0x0049;
                }
            L_0x0049:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r7)
                throw r0
            L_0x004f:
                kotlinx.serialization.internal.h r7 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r14 = r1.j(r0, r3, r7, r14)
                r2 = r2 | 32
                goto L_0x007b
            L_0x0058:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r13 = r1.j(r0, r5, r7, r13)
                r2 = r2 | 16
                goto L_0x007b
            L_0x0061:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r12 = r1.j(r0, r4, r7, r12)
                r2 = r2 | 8
                goto L_0x007b
            L_0x006a:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r11 = r1.j(r0, r6, r7, r11)
                r2 = r2 | 4
                goto L_0x007b
            L_0x0073:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r8, r7, r10)
                r2 = r2 | 2
            L_0x007b:
                r7 = 0
                goto L_0x0040
            L_0x007d:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r9 = r1.j(r0, r3, r7, r9)
                r2 = r2 | 1
                r7 = r3
                goto L_0x008b
            L_0x0088:
                r3 = 0
                r7 = r3
                r15 = r7
            L_0x008b:
                r3 = 5
                goto L_0x0040
            L_0x008d:
                r6 = r2
                r7 = r9
                r8 = r10
                r4 = r12
                r2 = r13
                r3 = r14
            L_0x0093:
                r1.c(r0)
                com.sumsub.sentry.q r0 = new com.sumsub.sentry.q
                java.lang.String r7 = (java.lang.String) r7
                java.lang.String r8 = (java.lang.String) r8
                r9 = r11
                java.lang.String r9 = (java.lang.String) r9
                r10 = r4
                java.lang.String r10 = (java.lang.String) r10
                r11 = r2
                java.lang.String r11 = (java.lang.String) r11
                r12 = r3
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                r13 = 0
                r5 = r0
                r5.<init>((int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.Boolean) r12, (kotlinx.serialization.internal.q1) r13)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.q.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.q");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(h.f57720a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30477b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, q qVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            q.a(qVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<q> serializer() {
            return a.f30476a;
        }

        public b() {
        }
    }

    public q() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 63, (r) null);
    }

    public static final void a(q qVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || qVar.f30470a != null) {
            bVar.y(fVar, 0, v1.f57779a, qVar.f30470a);
        }
        if (bVar.q(fVar, 1) || qVar.f30471b != null) {
            bVar.y(fVar, 1, v1.f57779a, qVar.f30471b);
        }
        if (bVar.q(fVar, 2) || qVar.f30472c != null) {
            bVar.y(fVar, 2, v1.f57779a, qVar.f30472c);
        }
        if (bVar.q(fVar, 3) || qVar.f30473d != null) {
            bVar.y(fVar, 3, v1.f57779a, qVar.f30473d);
        }
        if (bVar.q(fVar, 4) || qVar.f30474e != null) {
            bVar.y(fVar, 4, v1.f57779a, qVar.f30474e);
        }
        if (bVar.q(fVar, 5) || qVar.f30475f != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 5, h.f57720a, qVar.f30475f);
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
        this.f30474e = str;
    }

    public final void c(String str) {
        this.f30470a = str;
    }

    public final void d(String str) {
        this.f30472c = str;
    }

    public final String e() {
        return this.f30470a;
    }

    public final String g() {
        return this.f30472c;
    }

    public final String i() {
        return this.f30471b;
    }

    public final Boolean k() {
        return this.f30475f;
    }

    public /* synthetic */ q(int i11, String str, String str2, String str3, String str4, String str5, Boolean bool, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30476a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30470a = null;
        } else {
            this.f30470a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30471b = null;
        } else {
            this.f30471b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30472c = null;
        } else {
            this.f30472c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f30473d = null;
        } else {
            this.f30473d = str4;
        }
        if ((i11 & 16) == 0) {
            this.f30474e = null;
        } else {
            this.f30474e = str5;
        }
        if ((i11 & 32) == 0) {
            this.f30475f = null;
        } else {
            this.f30475f = bool;
        }
    }

    public final String a() {
        return this.f30473d;
    }

    public final String c() {
        return this.f30474e;
    }

    public final void e(String str) {
        this.f30471b = str;
    }

    public q(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        this.f30470a = str;
        this.f30471b = str2;
        this.f30472c = str3;
        this.f30473d = str4;
        this.f30474e = str5;
        this.f30475f = bool;
    }

    public final void a(String str) {
        this.f30473d = str;
    }

    public final void a(Boolean bool) {
        this.f30475f = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ q(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Boolean r11, int r12, kotlin.jvm.internal.r r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.q.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.r):void");
    }

    public q(q qVar) {
        this(qVar.f30470a, qVar.f30471b, qVar.f30472c, qVar.f30473d, qVar.f30474e, qVar.f30475f);
    }
}
