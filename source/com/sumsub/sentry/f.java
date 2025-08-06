package com.sumsub.sentry;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.x0;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 62\u00020\u0001:\u0002\b\rBs\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b/\u00100B\u0001\b\u0017\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010&\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\t\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b/\u00105J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R*\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\b\u0010\n\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\r\u0010\n\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\b\u0010\u000eR\"\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\n\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0016\u0010\fR\"\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\n\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001a\u0010\fR\"\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010\n\u0012\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\fR\"\u0010\"\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b \u0010\n\u0012\u0004\b!\u0010\u0010\u001a\u0004\b\u0015\u0010\fR\"\u0010%\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\n\u0012\u0004\b$\u0010\u0010\u001a\u0004\b#\u0010\fR\"\u0010,\u001a\u0004\u0018\u00010&8\u0006X\u0004¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010\u0010\u001a\u0004\b)\u0010*R\"\u0010.\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\n\u0012\u0004\b-\u0010\u0010\u001a\u0004\b\b\u0010\f¨\u00067"}, d2 = {"Lcom/sumsub/sentry/f;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "getUuid$annotations", "()V", "uuid", "o", "getType$annotations", "type", "c", "i", "getDebugId$annotations", "debugId", "d", "g", "getDebugFile$annotations", "debugFile", "e", "getCodeId$annotations", "codeId", "f", "getCodeFile$annotations", "codeFile", "k", "getImageAddr$annotations", "imageAddr", "", "h", "Ljava/lang/Long;", "m", "()Ljava/lang/Long;", "getImageSize$annotations", "imageSize", "getArch$annotations", "arch", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@kotlinx.serialization.f
public final class f {
    public static final b Companion = new b((r) null);

    /* renamed from: j  reason: collision with root package name */
    public static final String f30328j = "proguard";

    /* renamed from: a  reason: collision with root package name */
    public String f30329a;

    /* renamed from: b  reason: collision with root package name */
    public String f30330b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30331c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30332d;

    /* renamed from: e  reason: collision with root package name */
    public final String f30333e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30334f;

    /* renamed from: g  reason: collision with root package name */
    public final String f30335g;

    /* renamed from: h  reason: collision with root package name */
    public final Long f30336h;

    /* renamed from: i  reason: collision with root package name */
    public final String f30337i;

    public static final class a implements d0<f> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30338a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30339b;

        static {
            a aVar = new a();
            f30338a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.DebugImage", aVar, 9);
            pluginGeneratedSerialDescriptor.k(ZendeskIdentityStorage.UUID_KEY, true);
            pluginGeneratedSerialDescriptor.k("type", true);
            pluginGeneratedSerialDescriptor.k("debug_id", true);
            pluginGeneratedSerialDescriptor.k("debug_file", true);
            pluginGeneratedSerialDescriptor.k("code_id", true);
            pluginGeneratedSerialDescriptor.k("code_file", true);
            pluginGeneratedSerialDescriptor.k("image_addr", true);
            pluginGeneratedSerialDescriptor.k("image_size", true);
            pluginGeneratedSerialDescriptor.k("arch", true);
            f30339b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.f deserialize(kotlinx.serialization.encoding.c r22) {
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
                if (r2 == 0) goto L_0x004a
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r10, r2, r12)
                java.lang.Object r11 = r1.j(r0, r11, r2, r12)
                java.lang.Object r9 = r1.j(r0, r9, r2, r12)
                java.lang.Object r6 = r1.j(r0, r6, r2, r12)
                java.lang.Object r8 = r1.j(r0, r8, r2, r12)
                java.lang.Object r5 = r1.j(r0, r5, r2, r12)
                java.lang.Object r4 = r1.j(r0, r4, r2, r12)
                kotlinx.serialization.internal.x0 r13 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r3 = r1.j(r0, r3, r13, r12)
                java.lang.Object r2 = r1.j(r0, r7, r2, r12)
                r7 = 511(0x1ff, float:7.16E-43)
                r12 = r10
                r10 = r8
                r8 = r7
                goto L_0x00d3
            L_0x004a:
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
            L_0x0055:
                if (r19 == 0) goto L_0x00c8
                int r5 = r1.w(r0)
                switch(r5) {
                    case -1: goto L_0x00c2;
                    case 0: goto L_0x00b7;
                    case 1: goto L_0x00ac;
                    case 2: goto L_0x00a1;
                    case 3: goto L_0x0096;
                    case 4: goto L_0x008b;
                    case 5: goto L_0x007f;
                    case 6: goto L_0x0076;
                    case 7: goto L_0x006d;
                    case 8: goto L_0x0064;
                    default: goto L_0x005e;
                }
            L_0x005e:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r5)
                throw r0
            L_0x0064:
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r7, r5, r8)
                r2 = r2 | 256(0x100, float:3.59E-43)
                goto L_0x00c6
            L_0x006d:
                kotlinx.serialization.internal.x0 r5 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r6 = r1.j(r0, r3, r5, r6)
                r2 = r2 | 128(0x80, float:1.794E-43)
                goto L_0x00c6
            L_0x0076:
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r1.j(r0, r4, r5, r9)
                r2 = r2 | 64
                goto L_0x00c6
            L_0x007f:
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 5
                java.lang.Object r11 = r1.j(r0, r3, r5, r11)
                r2 = r2 | 32
                r5 = r3
                r3 = 7
                goto L_0x0055
            L_0x008b:
                r3 = 5
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 4
                java.lang.Object r10 = r1.j(r0, r3, r5, r10)
                r2 = r2 | 16
                goto L_0x00c5
            L_0x0096:
                r3 = 4
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 3
                java.lang.Object r15 = r1.j(r0, r3, r5, r15)
                r2 = r2 | 8
                goto L_0x00c5
            L_0x00a1:
                r3 = 3
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 2
                java.lang.Object r14 = r1.j(r0, r3, r5, r14)
                r2 = r2 | 4
                goto L_0x00c5
            L_0x00ac:
                r3 = 2
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 1
                java.lang.Object r13 = r1.j(r0, r3, r5, r13)
                r2 = r2 | 2
                goto L_0x00c5
            L_0x00b7:
                r3 = 1
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r12 = r1.j(r0, r3, r5, r12)
                r2 = r2 | 1
                goto L_0x00c5
            L_0x00c2:
                r3 = 0
                r19 = r3
            L_0x00c5:
                r3 = 7
            L_0x00c6:
                r5 = 5
                goto L_0x0055
            L_0x00c8:
                r3 = r6
                r4 = r9
                r5 = r11
                r11 = r13
                r9 = r14
                r6 = r15
                r20 = r8
                r8 = r2
                r2 = r20
            L_0x00d3:
                r1.c(r0)
                com.sumsub.sentry.f r0 = new com.sumsub.sentry.f
                r1 = r12
                java.lang.String r1 = (java.lang.String) r1
                java.lang.String r11 = (java.lang.String) r11
                r12 = r9
                java.lang.String r12 = (java.lang.String) r12
                java.lang.String r6 = (java.lang.String) r6
                r13 = r10
                java.lang.String r13 = (java.lang.String) r13
                r14 = r5
                java.lang.String r14 = (java.lang.String) r14
                r15 = r4
                java.lang.String r15 = (java.lang.String) r15
                r16 = r3
                java.lang.Long r16 = (java.lang.Long) r16
                r17 = r2
                java.lang.String r17 = (java.lang.String) r17
                r18 = 0
                r7 = r0
                r9 = r1
                r10 = r11
                r11 = r12
                r12 = r6
                r7.<init>((int) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.Long) r16, (java.lang.String) r17, (kotlinx.serialization.internal.q1) r18)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.f.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.f");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(x0.f57786a), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30339b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, f fVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            f.a(fVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<f> serializer() {
            return a.f30338a;
        }

        public b() {
        }
    }

    public f() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, 511, (r) null);
    }

    public static final void a(f fVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar2) {
        boolean z11 = false;
        if (bVar.q(fVar2, 0) || fVar.f30329a != null) {
            bVar.y(fVar2, 0, v1.f57779a, fVar.f30329a);
        }
        if (bVar.q(fVar2, 1) || fVar.f30330b != null) {
            bVar.y(fVar2, 1, v1.f57779a, fVar.f30330b);
        }
        if (bVar.q(fVar2, 2) || fVar.f30331c != null) {
            bVar.y(fVar2, 2, v1.f57779a, fVar.f30331c);
        }
        if (bVar.q(fVar2, 3) || fVar.f30332d != null) {
            bVar.y(fVar2, 3, v1.f57779a, fVar.f30332d);
        }
        if (bVar.q(fVar2, 4) || fVar.f30333e != null) {
            bVar.y(fVar2, 4, v1.f57779a, fVar.f30333e);
        }
        if (bVar.q(fVar2, 5) || fVar.f30334f != null) {
            bVar.y(fVar2, 5, v1.f57779a, fVar.f30334f);
        }
        if (bVar.q(fVar2, 6) || fVar.f30335g != null) {
            bVar.y(fVar2, 6, v1.f57779a, fVar.f30335g);
        }
        if (bVar.q(fVar2, 7) || fVar.f30336h != null) {
            bVar.y(fVar2, 7, x0.f57786a, fVar.f30336h);
        }
        if (bVar.q(fVar2, 8) || fVar.f30337i != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar2, 8, v1.f57779a, fVar.f30337i);
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

    public final void b(String str) {
        this.f30329a = str;
    }

    public final String c() {
        return this.f30334f;
    }

    public final String e() {
        return this.f30333e;
    }

    public final String g() {
        return this.f30332d;
    }

    public final String i() {
        return this.f30331c;
    }

    public final String k() {
        return this.f30335g;
    }

    public final Long m() {
        return this.f30336h;
    }

    public final String o() {
        return this.f30330b;
    }

    public final String q() {
        return this.f30329a;
    }

    public /* synthetic */ f(int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l11, String str8, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30338a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30329a = null;
        } else {
            this.f30329a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30330b = null;
        } else {
            this.f30330b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30331c = null;
        } else {
            this.f30331c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f30332d = null;
        } else {
            this.f30332d = str4;
        }
        if ((i11 & 16) == 0) {
            this.f30333e = null;
        } else {
            this.f30333e = str5;
        }
        if ((i11 & 32) == 0) {
            this.f30334f = null;
        } else {
            this.f30334f = str6;
        }
        if ((i11 & 64) == 0) {
            this.f30335g = null;
        } else {
            this.f30335g = str7;
        }
        if ((i11 & 128) == 0) {
            this.f30336h = null;
        } else {
            this.f30336h = l11;
        }
        if ((i11 & 256) == 0) {
            this.f30337i = null;
        } else {
            this.f30337i = str8;
        }
    }

    public final void a(String str) {
        this.f30330b = str;
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l11, String str8) {
        this.f30329a = str;
        this.f30330b = str2;
        this.f30331c = str3;
        this.f30332d = str4;
        this.f30333e = str5;
        this.f30334f = str6;
        this.f30335g = str7;
        this.f30336h = l11;
        this.f30337i = str8;
    }

    public final String a() {
        return this.f30337i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Long r18, java.lang.String r19, int r20, kotlin.jvm.internal.r r21) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.f.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
